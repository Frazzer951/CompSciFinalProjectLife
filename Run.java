
/**
 * Run
 */

import java.util.Scanner;

import java.lang.Math;

public class Run {

    public static void main(String[] args) {
        // Gets User Input for Name
        // Information used to make the scanner class was found on Stack Overflow
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name : ");
        String name = input.next();

        // Creates Person with name starting with 0 cash and 20 income
        // Your income is $20 because that is your allowance from your parents
        Person p    = new Person(name, 0.0, 20.0);
        Jobs   work = new Jobs(p, input);
        House  home = new House(p, input);
        Story  life = new Story(p, work, home, input);

        // Tells the player of a game mechanic then starts main loop
        // Starts by calling the year start, then it clears the console and calls year
        // end
        System.out.println("Each year you lose 5% of your happiness");
        while (!life.gameOver()) {
            life.yearStart();
            clearConsole();
            life.yearEnd();
        }

        // Tells the player they have lost
        System.out.println("You have lost the game");

        // Closes the input object
        input.close();
    }

    // Returns A Random Number In a Range
    public static double inBetween(double min, double max) {
        return (Math.random() * ((max - min) + 1.0)) + min;
    }

    // Takes a double and takes it to only 2 decimal places
    public static double moneySimplify(double x) {
        return (int) (x * 100) / 100.0;
    }

    // A method used when you want to pause the game so the player can read what
    // happened
    public static void pause(Scanner input) {
        System.out.println("Enter Anything To Continue");
        input.next();
    }

    // Clears the console
    // The way to detect the OS was found on Stack Overflow and the 2 ways of
    // clearing the console were also found on Stack Overflow
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                System.out.println(new String(new char[50]).replace("\0", "\r\n"));
            } else {
                System.out.print("\033[H\033[2J");
            }
        } catch (final Exception e) {
            // Handle any exceptions.
        }
    }
}