/**
 * Person
 */

public class Person {

    // Declares the Variables
    private double         income;
    private String         name;
    private double         bal;
    private static int     workExperience;
    private static int     health      = 100;
    private static int     happiness   = 100;
    private static boolean isMarried   = false;
    private static int     numChildren = 0;
    private static boolean college     = false;
    private static int     age         = 0;

    // Constructor for the Person Class
    public Person(String name, double bal, double income) {
        this.name   = name;
        this.bal    = bal;
        this.income = income;
    }

    // Adds Money to Balance
    public void addMoney(double x) {
        bal += Run.moneySimplify(x);
    }

    // Removes Money from Balance
    public void removeMoney(double x) {
        bal -= Run.moneySimplify(x);
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
    public void setHealth(int x) {
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

    // Sets Happiness
    public void setHap(int x) {
        happiness = x;
    }

    // When you chose to go to college is will set that you have gone and will take
    // the cost out of your wallet
    public void wentToCollege(double price) {
        bal     -= price;
        college  = true;
    }

    // Adds X amount of years to your age
    public void addAge(int x) {
        age += x;
    }

    // Sets you age to equal x
    public void setAge(int x) {
        age = x;
    }

    // Returns your age
    public int getAge() {
        return age;
    }

    // Returns if you have gone to college
    public boolean getCollege() {
        return college;
    }

    // Returns the Balance
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

    // Adds a year to your work experience
    public void addWorkExperience(int ad) {
        workExperience += ad;
    }

    // Returns your amount of years worked
    public int getWorkExperience() {
        return workExperience;
    }
}
