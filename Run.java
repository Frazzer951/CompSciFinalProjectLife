
/**
 * Run
 */

import java.util.Scanner;
import java.lang.Math;

public class Run {

    public static void main(String[] args) {
        // Gets User Input for Name
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name : ");
        String s = input.next(); // getting a String value

        // Creates Person with name starting with 0 cash and 100 income
        // Your income is $100 because that is your allowance from your parents
        Person p    = new Person(s, 0.0, 100.0);
        Jobs   work = new Jobs(p, input);
        House home = new House(p, input);
        Story  life = new Story(p, work, home, input);

        while (!life.gameOver()) {
            life.yearStart();

            clearConsole();

            life.yearEnd();
        }

        System.out.println("You have lost the game");

        input.close();
    }

    //Returns A Random Number In a Range
    public static double inBetween(double min, double max) {
        return (Math.random() * ((max - min) + 1.0)) + min;
    }

    //Takes a double and takes it to only 2 decimal places
    public static double moneySimplify(double x) {
        return (int) (x * 100) / 100.0;
    }

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
