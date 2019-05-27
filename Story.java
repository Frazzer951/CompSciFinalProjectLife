
/**
 * Story
 */

import java.util.Scanner;
import java.lang.Math;

public class Story {

    private Person        p;
    private Jobs          career;
    private Scanner       input;
    private static int    age      = 0;
    private static String ageGroup = "CHILD";

    // Constructor for the Person Class
    public Story(Person p, Jobs career, Scanner input) {
        this.p      = p;
        this.career = career;
        this.input  = input;
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

    // Game over check
    public boolean gameOver() {
        if (age >= 100 || p.getHealth() <= 0) {
            return true;
        }
        return false;
    }

    public void yearStart() {
        // Prints Out Needed Information
        System.out.println(p.getName() + "\'s health is at " + p.getHealth() + ". \n" + "Your bank balance is "
                + p.getBal() + ", \n" + "and your age is " + age);

        System.out.println("Would You like to do anything this year? Type \'Yes\' or \'No\'");

        while (true) {
            String choice = input.next();

            if (choice.equals("Yes")) {
                boolean done = false;
                while (!done) {
                    done = choices();
                }
                break;
            } else if (choice.equals("No")) {
                break;
            }
            System.out.println("You must type \'Yes\' or \'No\'");
        }
    }

    public boolean choices() {

        boolean choiceMade = false;

        while(choiceMade == false){
        if (ageGroup.equals("CHILD")) {
            // Child Choices
            System.out.println("If you want to play with friends type \'Friends\'");
            System.out.println("If you want to spend your allowance on candy type \'Candy\'");

        } else if (ageGroup.equals("Teen")) {
            // Ten Choices
            System.out.println("If you want to hang out with friends type \'Friends\'");
            System.out.println("If you want to go to lunch with your friends type \'Lunch\'");

            if (career.hasJob() == false) {
                System.out.println("If you want to get a job type \'Job\'");
            }

        } else if (ageGroup.equals("Adult")) {
            // Adult Choices
            System.out.println();

            if (career.hasJob() == false) {
                System.out.println("If you want to get a job type \'Job\'");
            }

        } else {
            // Elder Choices
            System.out.println();

        }

        System.out.println("If you do not want to do anything else type \'Done\'");

        String dec = input.next();
        if (dec.equals("Yes")) {
            return false;
        }

        if (dec.equals("Done")) {
            return true;
        }
        System.out.println("You either didnt enter the proper text, or you entered something that is not a choice, try again.");
    }
    return true;
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

    // Function for the investment option in yearStart function
    private void invest(double amt, double chance) {

        double rate = 100.0 / chance;

        double check = Math.random() * 100.0;

        if (chance <= check) {
            p.addMoney(amt * rate);
            System.out.println("Your investment has succeded, and you have earned $" + amt / chance + "!");
        }
    }

    // Provides person with 2 choice to repair health
    // Either go to a safe hopistal (more expensive) or a sketchy hospital (less
    // expensive)
    // If they choose sketchy hospital they have a chance for it go wrong and lose
    // more health
    public void goToHospital() {
        int    healthNeeded = 100 - p.getHealth();
        double cashNormal   = healthNeeded * 100.0 * Run.inBetween(1, 10);
        System.out.println("It will cost $" + cashNormal + "to choose a safe hospital");
        double chanceItsBad = 100.0 * Math.random();
        double cashGhetto   = healthNeeded * 10.0 * Run.inBetween(1, 10) * (chanceItsBad / 100.0);
        System.out.println("or");
        System.out.println("It will cost $" + cashGhetto
                + "to choose a sketchy hospital, BUT things may not go as planned... \n There is a" + chanceItsBad
                + "% chance it will go wrong");
        System.out.println("Please type: \'safe\' or \'sketchy\' or \'none\'");
        String choice = input.next();
        if (choice.equals("safe")) {
            p.removeMoney(cashNormal);
            System.out.println("Your health has been fully repaired!");
            p.addHealth(healthNeeded);
        } else if (choice.equals("sketchy")) {
            p.removeMoney(cashGhetto);
            if ((100.0 * Math.random() <= chanceItsBad)) {
                p.removeHealth(p.getHealth() / 2);
                System.out.println("Oh no! The procedure did not go as expected!");
            } else {
                p.addHealth(healthNeeded);
                System.out.println("You got lucky! Everything went alright");
            }

        } else {
            System.out.println("You chose not to go to the hospital this year");
        }
    }
}