
/**
 * Story
 */

import java.util.Scanner;
import java.lang.Math;

public class Story {

    private Person        p;
    private Jobs          career;
    private Scanner       input;
    private static String ageGroup  = "CHILD";
    private boolean       chooseDie = false;
    private String        dieString;

    // Constructor for the Person Class
    public Story(Person p, Jobs career, Scanner input) {
        this.p      = p;
        this.career = career;
        this.input  = input;
    }

    // Sets persons age group to the proper age group depending on age
    private void setAgeGroup() {
        if (p.getAge() >= 12 && p.getAge() < 18) {
            Story.ageGroup = "TEEN";
        } else if (p.getAge() >= 18 && p.getAge() < 50) {
            Story.ageGroup = "ADULT";
        } else if (p.getAge() >= 50) {
            Story.ageGroup = "ELDER";
        }
    }

    // Game over check
    public boolean gameOver() {
        if (p.getAge() >= 100 || p.getHealth() <= 0 || p.getHappiness() <= 0) {
            return true;
        }
        return false;
    }

    public void yearStart() {
        // Prints Out Needed Information
        System.out.println(p.getName() + "\'s health is at " + p.getHealth() + ". \n" + "Your bank balance is "
                + p.getBal() + ", \n" + "and your age is " + p.getAge());

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

        while (choiceMade == false) {
            if (ageGroup.equals("CHILD")) {
                // Child Choices
                System.out.println("If you want to play with friends type \'Friends\'");
                System.out.println("If you want to spend your allowance on candy type \'Candy\'");

                if (p.getHealth() < 100) {
                    System.out.println("Your health isn\'t at max, if you want to go to the hospital type \'Health\''");
                }

            } else if (ageGroup.equals("TEEN")) {
                // Teen Choices
                System.out.println("If you want to hang out with friends type \'Friends\'");
                System.out.println("If you want to go to lunch with your friends type \'Lunch\'");
                System.out.println("If you want to invest your money type \'Invest\'");

                if (career.hasJob() == false) {
                    System.out.println("If you want to get a job type \'Job\'");
                }

                if (p.getHealth() < 100) {
                    System.out.println("Your health isn\'t at max, if you want to go to the hospital type \'Health\''");
                }

                if (p.getHappiness() < 15) {
                    System.out.println("you are the big sad do you want to end it all? Type \'Die\'");
                }

            } else if (ageGroup.equals("ADULT")) {
                // Adult Choices
                System.out.println("If you want to invest your money type \'Invest\'");
                System.out.println("Would you like to go to the club? type \'Club\'");

                if (career.hasJob() == false) {
                    System.out.println("If you want to get a job type \'Job\'");
                }

                if (p.getHealth() < 100) {
                    System.out.println("Your health isn\'t at max, if you want to go to the hospital type \'Health\''");
                }

                if (p.getHappiness() < 15) {
                    System.out.println("you are the big sad do you want to end it all? Type \'Die\'");
                }

            } else {
                // Elder Choices
                System.out.println("If you want to invest your money type \'Invest\'");

                if (p.getHealth() < 100) {
                    System.out.println("Your health isn\'t at max, if you want to go to the hospital type \'Health\''");
                }

                if (p.getHappiness() < 15) {
                    System.out.println("you are the big sad do you want to end it all? Type \'Die\'");
                }

            }

            System.out.println("If you do not want to do anything else type \'Done\'");

            String dec = input.next();
            if (dec.equals("Friends")) {
                int hap = (int) (Math.random() * 100);
                System.out.println("You hang out with friends and you happiness goes up by " + hap);
                p.addHappiness(hap);
                return false;
            }

            if (dec.equals("Candy")) {
                if (p.getBal() < 10) {
                    System.out.println("You do not have enough money");
                    return false;
                }
                System.out.println("You spend $10 on candy and you happiness goes up by 10!");
                p.removeMoney(10);
                p.addHappiness(10);
                return false;
            }

            if (dec.equals("Lunch")) {
                if (p.getBal() < 10) {
                    System.out.println("You do not have enough money");
                    return false;
                }
                System.out.println("You go to lunch and spend $10 and your happiness goes up by 10");
                p.removeMoney(10);
                p.addHappiness(10);
                return false;
            }

            if (dec.equals("Job")) {
                career.jobOptions();
                return false;
            }

            if (dec.equals("Health")) {
                goToHospital();
                return false;
            }

            if (dec.equals("Invest")) {
                int chance = (int) Math.random() * 100;
                System.out.println("You have the opportunity to invest your money with a " + chance
                        + "% chance of success, do you want to invest? Type \'1\' for yes, and \'0\' for no: ");
                String answer = input.next();
                if (answer.equals("1")) {
                    System.out.println(
                            "How much would you like to invest, you have $" + p.getBal() + " in your bank account");
                    int amt = input.nextInt();

                    p.removeMoney(amt);
                    invest(amt, chance);
                }
            }

            if (dec.equals("Die")) {

                System.out.println(
                        "You are reaching a state of depression. Would you like to kill yourself? \'1\' for yes, and \'0\' for no: ");
                String suicide = input.next();
                if (suicide.equals("1")) {
                    int suicideOption = (int) Run.inBetween(1, 3);
                    if (suicideOption == 1) {
                        dieString = "You couldn\'t take the pain anymore. You have decided to go outside and walk into oncoming traffic and get hit by a double-decker bus. You were sent to the hospital but didn\'t survive.";
                    } else if (suicideOption == 2) {
                        dieString = "You have decided to take the easy way out. You go to a local Walmart store and buy 10 feet of rope. You come back home and tie a noose on your ceiling fan. You kick off the chair you stand on and then suddenly everything goes black.";
                    } else if (suicideOption == 3) {
                        dieString = "You have made the choice to take the easy way out. You go to your kitchen and grab a chef knife from the drawer. You walk to your bathroom and sit in the tub. Tears fill your eyes as you do the deed of slitting your wrists until you are no more.";
                    }
                    p.removeHealth(100);
                    chooseDie = true;
                    return true;
                }
                return false;
            }

            if (dec.equals("Club")) {
                int numShots = Run.inBetween(7, 20);
                System.out.println("You went to the club with your friends and drank " + numShots
                        + " shot of tequila and threw up in the bathroom.");
                int    hpLost   = (int) (numShots / .75);
                double monSpent = numShots * 6.50;
                int    hapGain  = numShots * (int) Run.inBetween(1, 4);
                System.out.println("You lost " + hpLost + " health and $" + monSpent + ". You also gained " + hapGain
                        + " happiness");
                p.removeHealth(hpLost);
                p.addHappiness(hapGain);
                p.removeMoney(monSpent);
            }

            if (dec.equals("Done")) {
                return true;
            }

            System.out.println(
                    "You either didnt enter the proper text, or you entered something that is not a choice, try again.");
        }

        return true;

    }

    // Year End Function
    public void yearEnd() {

        if (chooseDie) {
            System.out.println(dieString);
        }

        // Get Yearly Income Pay
        p.payday();

        // Adds a year to your age
        p.addAge(1);


        // Sets your proper age group
        this.setAgeGroup();

        // Runs randomChance method
        randomChance(this.ageGroup);
    }

    /*
    *   Random chance of certain events occuring:
    *   finding money on the ground, breaking your hip, getting robbed
    */
    public int randomChance(String ageGroup) {
        double randomMoney = Run.inBetween(1.0, 100.0);
        if(ageGroup.equals("TEEN")) {
            if(Run.inBetween(1.0, 30.0) == 1.0) {
                System.out.println("It is your lucky day! You happened to stumble upon $" + randomMoney + " on the ground");
                Person.addMoney(randomMoney);
            }
            if(Run.inBetween(1.0, 20.0) == 1.0) {
                System.out.println("Ruh roh! You have been caught doing something naughty by your parents and have been grounded");
                Person.removeHappiness(Run.inBetween(1.0, 10.0));
            }
        }
        if(ageGroup.equals("ADULT")) {
            if(Run.inBetween(1.0, 30.0) == 1.0) {
                System.out.println("It is your lucky day! You happened to stumble upon $" + randomMoney + " on the ground");
                Person.addMoney(randomMoney);
            }
            if(Run.inBetween(1.0, 20.0) == 1.0) {
                System.out.println("Oh no gamer! You have been threatened by a man with a weapon to give up $" + randomMoney);
                Person.removeMoney(randomMoney);
                Person.removeHappiness(Run.inBetween(1.0, 10.0));
            }
        }
        if(ageGroup.equals("ELDER")) {
            if(Run.inBetween(1.0, 20.0) == 1.0) {
                System.out.println("Oh no gamer! You have been threatened by a man with a weapon to give up $" + randomMoney);
                Person.removeMoney(randomMoney);
            }
            if(Run.inBetween(1.0, 30.0) == 1.0) {
                System.out.println("It is your lucky day! You happened to stumble upon $" + randomMoney + " on the ground");
                Person.addMoney(randomMoney);
            }
            if(Run.inBetween(1.0, 25.0) == 1.0) {
                System.out.println("You tried reaching something from the top shelf and suddenly you broke your hip and are sent to the hospital immediately.");
                //hospital method
            }
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

    // Provides person with 2 choice to repair health
    // Either go to a safe hopistal (more expensive) or a sketchy hospital (less
    // expensive)
    // If they choose sketchy hospital they have a chance for it go wrong and lose
    // more health
    // Healthy: costs between $100 - $1000 for each "1" health at normal clinic
    // Sketchy: costs between $10 - $100 for each "1" health at sketchy clinic
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