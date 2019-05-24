
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
        int chance = (int) Math.random() * 100;
        System.out.println("You have the oppertunity to invest you money with a " + chance
                + "chance of success, do you want to invest? Type '1' for yes, and '0' for no: ");
        String answer = Answers.next();
        if (answer.equals("1")) {
            System.out.println("How much would you like to invest, you have $" + p.getBal() + " in you bank account");
            int amt = Answers.nextInt();

            invest(amt, chance);

        }

        // Once an adult it will ask you if you want to go to college untill you say yes
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
     * * Run.inBetween(.05, .10); p.removeMoney(moneyStolen);
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

    // Provides person with 2 choice to repair health
    // Either go to a safe hopistal (more expensive) or a sketchy hospital (less expensive)
    // If they choose sketchy hospital they have a chance for it go wrong and lose more health
    public void goToHospital()
    {
        int healthNeeded = 100 - p.getHealth();
        double cashNormal = healthNeeded * 100.0 * Run.inBetween(1, 10);
        System.out.println("It will cost $" + cashNormal + "to choose a safe hospital");
        double cashGhetto = healthNeeded * 10.0 * Run.inBetween(1, 10) * (chanceItsBad/100.0);         
        System.out.println("or");
        double chanceItsBad = 100.0 *Math.random();
        System.out.println("It will cost $" + cashGhetto + "to choose a sketchy hospital, BUT things may not go as planned... /n There is a" + chanceItsBad + "% chance it will go wrong");
        Scanner hospitalChoice = new Scanner(System.in);
        System.out.println("Please type: safe or sketchy or none");
        String choice = hospitalChoice.next();
        hospitalChoice.close();
        if(choice.equals("safe"))
        {
            p.removeMoney(cashNormal);
            System.out.println("Your health has been fully repaired!")
            p.addHealth(healthNeeded);
        }
        else if(choice.equals("sketchy"))
        {
            p.removeMoney(cashGhetto);
            if((100.0 * Math.Random()) <= chanceItsBad)
            {
                p.removeHealth(p.getHealth() /2);
                System.out.println("Oh no! The procedure did not go as expected!");
            }
            else
            {
                p.addHealth(healthNeeded);
                System.out.println("You got lucky! Everything went alright");
            }
             
        }
        else
        {
            System.out.println("You chose not to go to the hospital this year");
        }
    }
}