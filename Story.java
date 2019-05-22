
/**
 * Story
 */

import java.lang.Math;

public class Story {

    private static int    age      = 0;
    private static String ageGroup = "CHILD";
    private Person        p;

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

        // Prints out needed info
        System.out.println("Your age is " + age);
        System.out.println("Your age group is " + ageGroup);
        System.out.println("Your health is " + p.getHealth());
        System.out.println("Your Balance is " + p.getBal());
    }

    // Year End Function
    public void yearEnd() {

        // Get Yearly Income Pay
        p.payday();
        // Adds a year to your age
        age++;
        // Sets your proper age group
        this.setAgeGroup();
        p.jobChange();

        // All of the Random Chances

    }
    private void jobChange()
    {
        double chance1 = Math.Random() * 100.0;
        if(chance1 <= 10)
        {
            p.changeIncome(p.getIncome += (p.getIncome/10.0));
            System.out.println("You got a raise for doing well!");

        }
        else if(chance1 >= 95)
        {
            p.changeIncome(0.0);
            System.out.println("You got fired!");
        }
        else if(chance1 >10 && chance1 < 15)
        {
            p.changeIncome(p.getIncome -= (p.getIncome/10.0));
            System.out.println("You made a bad call at work, and your pay has been docked");
        }
    }

    private void accidentChance()
    {
        double chance2 = Math.Random() * 100.0;
        if(chance2 <= 1)
        {
            p.removeMoney(50000.0);
            System.out.println("Oh no! Your house burned down, spend $50,000 on a down payment on a new one");
        }
        if(chance2 <= 5 && chance2 > 1)
        {
            double moneyStolen = p.getBal * inBetween();       
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
}