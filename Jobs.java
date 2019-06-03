
/**
 * Jobs
 */

import java.util.Scanner;
import java.lang.Math;

public class Jobs {

    // Declares all of the variables
    private Person         p;
    private Scanner        input;
    private static double  jobIncome;
    private static String  jobTitle;
    private static boolean employed = false;

    // All of the possible jobs
    String[] jobList = { "Carpenter", "Zoologist", "Mason", "Librarian", "Farmer", "Teacher", "Therapist", "IT Manager",
            "Painter", "Receptionist", "Programmer", "Firefighter", "Judge", "Chef" };

    // Constructor for jobs class
    public Jobs(Person p, Scanner input) {
        this.p     = p;
        this.input = input;
    }

    // When called it randomly generates jobs and gives the player a choice
    // There is a random percent chance of getting a job
    public void jobOptions() {
        double mul = 1.0;
        if (p.getCollege() == true) {
            mul = 3.0;
        }

        int choice1 = (int) Run.inBetween(0.0, jobList.length - 1);
        int choice2 = (int) Run.inBetween(0.0, jobList.length - 1);
        int choice3 = (int) Run.inBetween(0.0, jobList.length - 1);

        double price1 = ((int) (Run.inBetween(20000.0, 50000.0) * mul * 100) / 100.0);
        double price2 = ((int) (Run.inBetween(20000.0, 50000.0) * mul * 100) / 100.0);
        double price3 = ((int) (Run.inBetween(20000.0, 50000.0) * mul * 100) / 100.0);

        System.out.println("Here are your job choices.");
        System.out.println("Choice 1: " + jobList[choice1] + " for $" + price1 + " a year");
        System.out.println("Choice 2: " + jobList[choice2] + " for $" + price2 + " a year");
        System.out.println("Choice 3: " + jobList[choice3] + " for $" + price3 + " a year");

        System.out.println("Input the number for your choice 1-3 : ");

        boolean madeChoice = false;

        while (!madeChoice) {
            int choice = input.nextInt();
            if (choice == 1) {
                double chance1 = jobInterviewChance(price1);
                if ((Math.random() * 100.00) < chance1) {
                    System.out.println("You got the job!");
                    jobIncome  = price1;
                    jobTitle   = jobList[choice1];
                    employed   = true;
                    madeChoice = true;
                } else {
                    System.out.println("You didn't get the job");
                    madeChoice = true;
                }
            } else if (choice == 2) {
                double chance2 = jobInterviewChance(price2);
                if ((Math.random() * 100.00) < chance2) {
                    System.out.println("You got the job!");
                    jobIncome  = price2;
                    jobTitle   = jobList[choice2];
                    employed   = true;
                    madeChoice = true;
                } else {
                    System.out.println("You didn't get the job");
                    madeChoice = true;
                }
            } else if (choice == 3) {
                double chance3 = jobInterviewChance(price3);
                if ((Math.random() * 100.00) < chance3) {
                    System.out.println("You got the job!");
                    jobIncome  = price3;
                    jobTitle   = jobList[choice3];
                    employed   = true;
                    madeChoice = true;
                } else {
                    System.out.println("You didn't get the job");
                    madeChoice = true;
                }
            } else {
                System.out.println("You must put a number between 1 and 3");
            }
        }

        p.changeIncome(jobIncome);

    }

    // Returns your job's title
    public String jobName() {
        return jobTitle;
    }

    // Returns if you have a job
    public boolean hasJob() {
        return employed;
    }

    // Sets if you are employed or not
    public void setEmployed(boolean x) {
        employed = x;
    }

    // Random chances for if you have a job
    public void jobRandom() {
        int choice = (int) Run.inBetween(1, 3);

        if (choice == 1) {
            int possibility = (int) Run.inBetween(1, 20);
            if (possibility == 1) {
                System.out.println("You got a raise and your pay goes up by 5%");
                double newPay = (jobIncome * .05) + jobIncome;
                jobIncome = newPay;
                p.changeIncome(newPay);
            }
        } else if (choice == 2) {
            int possibility = (int) Run.inBetween(1, 40);
            if (possibility == 1) {
                System.out.println("You made a bad call at work and your pay goes down by 5%");
                double newPay = jobIncome - (jobIncome * .05);
                jobIncome = newPay;
                p.changeIncome(newPay);
            }
        } else if (choice == 3) {
            int possibility = (int) Run.inBetween(1, 50);
            if (possibility == 1) {
                System.out.println("Oh no Gamer, you boss caught you play farmvill at work and fired you!");
                jobIncome = 0;
                jobTitle  = "";
                p.changeIncome(0);
                setEmployed(false);
            }
        }
    }

    /*
     * Calculates the chance someone has when they choose a job. The higher the pay,
     * the less of a chance to get the job. Work experience increases chance to get
     * a job. With 20+ years work experience being the max affecting your job.
     * College degree affects chances too Min: 0 work experience, no college and
     * lowest pay: ~ 72% chance Max: 20 years work experience, college degree,
     * highest pay: ~ 92% chance.
     */
    public double jobInterviewChance(double pay) {
        double workE = (p.getWorkExperience() / 50.0);
        if (workE >= .40) {
            workE = .40;
        }
        double mult = 0.0;
        if (p.getCollege()) {
            mult = .30;
        } else {
            mult = 1.0;
        }
        double chance = ((1 / (1 + (pay / 50000.0) * mult)) + workE) * 100.0;
        return chance;
    }

    // If you chose to quit your job it removes all of your job info
    public void quitJob() {
        p.changeIncome(0);
        jobIncome = 0;
        jobTitle  = "";
        setEmployed(false);
        System.out.println("You have quit your job.");
    }
}
