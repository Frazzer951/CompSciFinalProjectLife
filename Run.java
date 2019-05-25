
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
        Story  life = new Story(p, work, input);

        life.yearStart();
        life.yearEnd();
        life.yearStart();

        input.close();
    }

    public static double inBetween(double min, double max) {
        return (Math.random() * ((max - min) + 1)) + min;
    }
}
