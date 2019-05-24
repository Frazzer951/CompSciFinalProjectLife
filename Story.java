
/**
 * Story
 */

import java.util.Scanner;
import java.lang.Math;

public class Story {

    private Person        p;
    private Jobs          career;
    private static int    age      = 0;
    private static String ageGroup = "CHILD";

    // Constructor for the Person Class
    public Story(Person p, Jobs career) {
        this.p      = p;
        this.career = career;
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
                System.out.println(
                        "How much would you like to invest, you have $" + p.getBal() + " in your bank account");
                int amt = Answers.nextInt();

                invest(amt, chance);

            }
        }
        if (age >= 18) {
            System.out.println("Would you like to go to the club? '1' for yes, and '0' for no: ");
            String club = Answers.next();
            if (club.equals('1')) {
                System.out.println("You went to the club with your friends and drank " + Run.inBetween(1, 20)
                        + " bottles of beer and threw up in the bathroom.");
            }
        }

        // Suicide Option
        if (p.getHappiness() <= 20) {
            System.out.println(
                    "You are reaching a state of depression. Would you like to kill yourself? '1' for yes, and '0' for no: ");
            String suicide = Answers.next();
            if (suicide.equals('1')) {
                int suicideOption = Run.inBetween(0.0, 4.0);
                if (suicideOption == 1) {
                    System.out.println(
                            "You couldn't take the pain anymore. You have decided to go outside and walk into oncoming traffic and get hit by a double-decker bus. You were sent to the hospital but didn't survive.");
                } else if (suicideOption == 2) {
                    System.out.println(
                            "You have decided to take the easy way out. You go to a local Walmart store and buy 10 feet of rope. You come back home and tie a noose on your ceiling fan. You kick off the chair you stand on and then suddenly everything goes black.");
                } else if (suicideOption == 3) {
                    System.out.println(
                            "You have made the choice to take the easy way out. You go to your kitchen and grab a chef knife from the drawer. You walk to your bathroom and sit in the tub. Tears fill your eyes as you do the deed of slitting your wrists until you are no more.");
                }
            }
        }

        // Applying for a job
        if (!career.hasJob()) {
            System.out.println("Would you like to apply for a job? '1' for yes, and '0' for no: ");
            String apply = Answers.next();
            if (apply.equals("1")) {
                career.jobOptions();
            }
        }

        // Once an adult it will ask you if you want to go to college untill you say yes
        // Todo Give price amount option
        if (age >= 18 && p.getCollege() == false) {

            System.out.println("Do you want to go to college? Type '1' for yes, and '0' for no: ");
            String school = Answers.next();
            if (school.equals("1")) {
                p.wentToCollege(0.0);
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

    private void accidentChance() {
        double chance2 = Math.random() * 100.0;
        if (chance2 <= 1) {
            p.removeMoney(50000.0);
            System.out.println("Oh no! Your house burned down, spend $50,000 on a down payment on a new one");
        } else if (chance2 <= 5 && chance2 > 1) {
            double moneyStolen = p.getBal() * Run.inBetween(.5, .10);
            p.removeMoney(moneyStolen);
            System.out.println("You were robbed! They took" + moneyStolen + " dollars");
        } else if (chance2 > 5 && chance2 <= 10) {
            p.addMoney(500.0);
            System.out.println("Today was your lucky day! You found $500 on the floor!");
        }
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
    // Either go to a safe hopistal (more expensive) or a sketchy hospital (less
    // expensive)
    // If they choose sketchy hospital they have a chance for it go wrong and lose
    // more health
    public void goToHospital() {
        int    healthNeeded = 100 - p.getHealth();
        double cashNormal   = healthNeeded * 100.0 * Run.inBetween(1, 10);
        System.out.println("It will cost $" + cashNormal + "to choose a safe hospital");
        double cashGhetto = healthNeeded * 10.0 * Run.inBetween(1, 10) * (chanceItsBad / 100.0);
        System.out.println("or");
        double chanceItsBad = 100.0 * Math.random();
        System.out.println("It will cost $" + cashGhetto
                + "to choose a sketchy hospital, BUT things may not go as planned... /n There is a" + chanceItsBad
                + "% chance it will go wrong");
        Scanner hospitalChoice = new Scanner(System.in);
        System.out.println("Please type: 'safe' or 'sketchy' or 'none'");
        String choice = hospitalChoice.next();
        hospitalChoice.close();
        if (choice.equals("safe")) {
            p.removeMoney(cashNormal);
            System.out.println("Your health has been fully repaired!");
            p.addHealth(healthNeeded);
        } else if (choice.equals("sketchy")) {
            p.removeMoney(cashGhetto);
            if ((100.0 * Math.Random()) <= chanceItsBad) {
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