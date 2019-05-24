
/**
 * Story
 */

import java.util.Scanner;
import java.lang.Math;

public class Story {

    private Person         p;
    private static int     age       = 0;
    private static String  ageGroup  = "CHILD";
    private static boolean inCollege = false;

    // Constructor for the Person Class
    public Story(Person p) {
        this.p = p;
    }

    // Game over check
    public boolean gameOver() {
        if (age >= 100 || p.getHealth() <= 0) {
            return true;
        }
        return false;
    }

    // Year Start Function
    public void yearStart() {

        // Makes new Scanner Class
        Scanner Answers = new Scanner(System.in);

        // Prints out needed info
        System.out.println("Your age is " + age);
        System.out.println("Your age group is " + ageGroup);
        System.out.println("Your health is " + p.getHealth());
        System.out.println("Your Balance is " + p.getBal());

        // Investment Choice
        if (age >= 16) {
            int chance = (int) Math.random() * 100;
            System.out.println("You have the opportunity to invest your money with a " + chance
                    + "chance of success, do you want to invest? Type '1' for yes, and '0' for no: ");
            String answer = Answers.next();
            if (answer.equals("1")) {
                System.out.println("How much would you like to invest, you have $" + p.getBal() + " in your bank account");
                int amt = Answers.nextInt();

                invest(amt, chance);

            }
        }

        // Once an adult it will ask you if you want to go to college until you say yes
        if (age >= 18 && inCollege == false) {
            System.out.println("Do you want to go to college? Type '1' for yes, and '0' for no: ");
            String school = Answers.next();
            if (school.equals("1")) {
                inCollege = true;
            }
        }
        // Closes the scanner class
        Answers.close();
    }

    // Year End Function
    public void yearEnd() {

        // Get Yearly Income Pay
        p.payday();

        // Adds a year to your age
        age++;

        // Sets your proper age group
        this.setAgeGroup();
    }

    /*
     * Hold off till we finish the job class private void jobChange() { double
     * chance1 = Math.random() * 100.0; double inc = p.getIncome(); if (chance1 <=
     * 10) { p.changeIncome(inc += (inc / 10.0));
     * System.out.println("You got a raise for doing well!"); } else if (chance1 >=
     * 95) { p.changeIncome(0.0); System.out.println("You got fired!"); } else if
     * (chance1 > 10 && chance1 < 15) { p.changeIncome(inc -= (inc / 10.0));
     * System.out.
     * println("You made a bad call at work, and your pay has been docked"); } }
     */

    /*
     * Redo Acciend Stuff for age based stuff private void accidentChance() { double
     * chance2 = Math.random() * 100.0; if (chance2 <= 1) { p.removeMoney(50000.0);
     * System.out.
     * println("Oh no! Your house burned down, spend $50,000 on a down payment on a new one"
     * ); } else if (chance2 <= 5 && chance2 > 1) { double moneyStolen = p.getBal()
     * * Run.inBetween(.5, .10); p.removeMoney(moneyStolen);
     * System.out.println("You were robbed! They took" + moneyStolen + " dollars");
     * } else if (chance2 > 5 && chance2 <= 10) { p.addMoney(500.0);
     * System.out.println("Today was your lucky day! You found $500 on the floor!");
     * } }
     */

    // Function for the investment option in yearStart function
    private void invest(double amt, double chance) {

        double rate = 100.0 / chance;

        double check = Math.random() * 100.0;

        if (chance <= check) {
            p.addMoney(amt * rate);
            System.out.println("Your investment has succeded, and you have earned $" + amt / chance + "!");
        }
    }

    // Sets persons age group to the proper age group depending on age
    private void setAgeGroup() {
        if (age >= 12 && age < 18) {
            Story.ageGroup = "TEEN";
        } else if (age >= 18 && age < 50) {
            Story.ageGroup = "ADULT";
        } else if (age >= 50) {
            Story.ageGroup = "ELDER";
        }
    }
}