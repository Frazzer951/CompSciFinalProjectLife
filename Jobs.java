
/**
 * Jobs
 */

import java.util.Scanner;
import java.lang.Math;

public class Jobs {

    private Person         p;
    private Scanner        input;
    private static double  jobIncome;
    private static String  jobTitle;
    private static boolean employed = false;

    String[] jobList = { "Carpenter", "Zoologist", "Mason", "Librarian", "Farmer", "Teacher", "Therapist", "IT Manager",
            "Painter", "Receptionist", "Programmer", "Firefighter", "Judge", "Chef"};

    public Jobs(Person p, Scanner input) {
        this.p     = p;
        this.input = input;
    }

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

    public void randomJobChance() {

    }

    public String jobName() {
        return jobTitle;
    }

    public boolean hasJob() {
        return employed;
    }

    /*
     * private void jobChange() { double chance1 = Math.random() * 100.0; double inc
     * = p.getIncome(); if (chance1 <= 10) { p.changeIncome(inc += (inc / 10.0));
     * System.out.println("You got a raise for doing well!"); } else if (chance1 >=
     * 95) { p.changeIncome(0.0); System.out.println("You got fired!"); } else if
     * (chance1 > 10 && chance1 < 15) { p.changeIncome(inc -= (inc / 10.0));
     * System.out.
     * println("You made a bad call at work, and your pay has been docked"); } }
     */

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
}
