
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
        input.close();

        // Creates Person with name starting with 0 cash and 0 income
        Person p    = new Person(s, 0.0, 0.0);
        Story  life = new Story(p);
        System.out.println("Your Health is at " + p.getHealth());
        life.yearStart();
        life.yearEnd();
        life.yearStart();
    }

    public double inBetween(double min, double max) {
        return (Math.random() * ((max - min) + 1)) + min;
    }
}
