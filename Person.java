/**
 * Person
 */

public class Person {

    // Declares the Variables
    private double         income;
    private String         name;
    private double         bal;
    private static int     health      = 100;
    private static int     happiness   = 100;
    private static boolean isMarried   = false;
    private static int     numChildren = 0;
    private static boolean college     = false;

    // Constructor for the Person Class
    public Person(String name, double bal, double income) {
        this.name   = name;
        this.bal    = bal;
        this.income = income;
    }

    // Adds Money to Balance
    public void addMoney(double x) {
        bal += x;
    }

    // Removes Money from Balance
    public void removeMoney(double x) {
        bal -= x;
    }

    // Adds Health and makes sure it's not over 100
    public void addHealth(int x) {
        health += x;
        if (health > 100) {
            health = 100;
        }
    }

    // Removes Health and checks if game over
    public void removeHealth(int x) {
        health -= x;
    }

    // Sets the Health to a value
    public voic setHealth(int x) {
        health = x;
    }

    // Changes the Income
    public void changeIncome(double x) {
        income = x;
    }

    // Adds the Income value to the Balance
    public void payday() {
        bal += income;
    }

    // Adds Happiness
    public void addHappiness(int x) {
        happiness += x;

        if (happiness > 100) {
            happiness = 100;
        }
    }

    // Remove Happiness
    public void removeHappiness(int x) {
        happiness -= x;
    }

    public void wentToCollege(double price) {
        bal     -= price;
        college  = true;
    }

    public boolean getCollege() {
        return college;
    }

    // Returnes the Balance
    public double getBal() {
        return bal;
    }

    // Returns the Health
    public int getHealth() {
        return health;
    }

    // Returns the Income
    public double getIncome() {
        return income;
    }

    // Returns Name
    public String getName() {
        return name;
    }

    // Returns Happiness
    public int getHappiness() {
        return happiness;
    }

    // Returns marriage status
    public boolean marriageStatus() {
        return isMarried;
    }

    // Returns the number of children
    public int getChildren() {
        return numChildren;
    }

}
