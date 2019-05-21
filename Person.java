/**
 * Person
 */
public class Person {

    // Declares the Variables
    private double     income;
    private String     name;
    private double     bal;
    private static int health = 100;

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

    // Adds Health
    public void addHealth(int x) {
        health += x;
    }

    // Removes Health
    public void removeHealth(int x) {
        health -= x;
    }

    // Changes the Income
    public void changeIncome(double x) {
        income = x;
    }

    // Adds the Income value to the Balance
    public void payday() {
        bal += income;
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
}
