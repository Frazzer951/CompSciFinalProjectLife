
/**
 * House
 */

import java.util.Scanner;

public class House {

    // Declares all variables
    private Person     p;
    private Scanner    input;
    private int        buyValue;
    private int        yearlyHousePayment;
    private int        amountPayed;
    private String     houseType;
    private boolean    house                 = false;
    private boolean    apartment             = false;
    private static int initialDeposit        = 1800;
    private static int yearlyApartmentCharge = 18000;
    String[]           totalHouseList        = { "Mansion", "Beach House", "Cottage", "Farm House", "Villa", "Castle",
            "Igloo", "Condominium", "Town House", "Log Cabin", "Manor" };
    String[]           expensiveHouseList    = { "Mansion", "Manor", "Castle", "Beach House" };
    String[]           regularHouseList      = { "Villa", "Condominium", "Town House", "Cottage", "Log Cabin" };
    String[]           cheapHouseList        = { "Farm House", "Igloo" };

    // Constructor for house class
    public House(Person p, Scanner input) {
        this.p     = p;
        this.input = input;
    }

    // Provides house options if 18+ with 3 homes, each at a different tier of
    // prices, and checks if they can afford it and if they can, they buy the house
    // with responsibilities
    // Called upon at year end
    public void houseOptions() {
        if (p.getAge() >= 18) {
            int option1 = (int) Run.inBetween(0.0, expensiveHouseList.length - 1);
            int option2 = (int) Run.inBetween(0.0, regularHouseList.length - 1);
            int option3 = (int) Run.inBetween(0.0, cheapHouseList.length - 1);

            int price1 = ((int) (Run.inBetween(1000000.0, 1500000.0)));
            int price2 = ((int) (Run.inBetween(500000.0, 1000000.0)));
            int price3 = ((int) (Run.inBetween(200000.0, 500000.0)));

            System.out.println("Here are your house options.");
            System.out.println("Choice 1: " + expensiveHouseList[option1] + " for $" + price1
                    + " with an initial down payment of " + price1 / 10.0 + " and a fixed yearly mortgage of "
                    + ((price1 - price1 / 10) / 30) + " due at the end of each year");
            System.out.println("Choice 2: " + regularHouseList[option2] + " for $" + price2
                    + " with an initial down payment of " + price2 / 10.0 + " and a fixed yearly mortgage of "
                    + ((price2 - price2 / 10) / 30) + " due at the end of each year");
            System.out.println("Choice 3: " + cheapHouseList[option3] + " for $" + price3
                    + " with an initial down payment of " + price3 / 10.0 + " and a fixed yearly mortgage of "
                    + ((price3 - price3 / 10) / 30) + " due at the end of each year");

            System.out.println("Input the number for your choice 1-3 : ");

            boolean madeChoice = false;

            while (!madeChoice) {
                int choice = input.nextInt();
                if (choice == 1) {
                    if (p.getBal() > (price1 / 10)) {
                        buyValue           = price1;
                        yearlyHousePayment = ((price1 - (price1 / 10)) / 30);
                        houseType          = expensiveHouseList[option1];
                        buyHouse(price1 / 10);
                        madeChoice = true;

                    } else {
                        System.out.println("You can't afford the down payment on this house, try again another time");
                        madeChoice = true;
                    }
                } else if (choice == 2) {
                    if (p.getBal() > (price2 / 10)) {
                        buyValue           = price2;
                        yearlyHousePayment = ((price2 - price2 / 10) / 30);
                        houseType          = regularHouseList[option2];
                        buyHouse(price1 / 10);
                        madeChoice = true;
                    } else {
                        System.out.println("You can't afford the down payment on this house, try again another time");
                        madeChoice = true;
                    }
                } else if (choice == 3) {
                    if (p.getBal() > (price3 / 10)) {
                        buyValue           = price3;
                        yearlyHousePayment = ((price3 - price3 / 10) / 30);
                        houseType          = regularHouseList[option3];
                        buyHouse(price1 / 10);
                        madeChoice = true;
                    } else {
                        System.out.println("You can't afford the down payment on this house, try again another time");
                        madeChoice = true;
                    }
                } else if (choice == 4) {
                    System.out.println("You have chosen to look at the apartment options");
                    apartmentOptions();
                    madeChoice = true;
                }

                else {
                    System.out.println("You must put a number between 1 and 4");
                }
            }

        }

    }

    // Similar to house option, but it is cheaper.
    // Instead of paying a yearly mortgage you pay a cheaper renting cost.
    // You cant sell your apartment like you can your house
    public void apartmentOptions() {
        System.out.println("There is an apartment offered at a price of $" + yearlyApartmentCharge + " annually");
        System.out.println(
                "Choose 1 to rent this apartment or 2 to wait till next year or 3 to go back to house options");
        boolean madeChoice = false;

        while (!madeChoice) {
            int choice = input.nextInt();
            if (choice == 1) {
                rentApartment();
                madeChoice = true;
            } else if (choice == 2) {
                madeChoice = true;

            } else if (choice == 3) {
                System.out.println("You've decided to go back to the house options");
                houseOptions();
                madeChoice = true;
            } else {
                System.out.println("You must choose between 1 and 3");
            }
        }
    }

    // Adds amount of money until you have paid off your house
    public void downPayment(int amt) {
        amountPayed += amt;
    }

    // Calculates how much you pay for your apartment/house
    public void payYearly() {
        if (house == true) {
            if (amountPayed == buyValue) {
                System.out.println("Congratulations! You have successfully paid off your home!");
            } else {
                p.removeMoney(yearlyHousePayment);
                amountPayed += yearlyHousePayment;
                System.out.println("You payed $" + yearlyHousePayment + " towards your home and you still have :"
                        + (buyValue - amountPayed) + "left to pay on the mortgage");
            }
        } else if (apartment == true) {
            p.removeMoney(yearlyApartmentCharge);
            System.out.println("You payed your yearly fee of $" + yearlyApartmentCharge + " to stay in your apartment");
        }

    }

    // Called upon when asked if they want a house/apartment at the end of each year
    // and chose house
    public void buyHouse(int payment) {
        p.removeMoney(payment);
        downPayment(payment);
        System.out.println(
                "Congratulations! You bought a house and put a down payment of :$" + payment + "down on the house.");
        house = true;
    }

    // Called upon when asked if they want a house/apartment at the end of each year
    // and chose apartment
    public void rentApartment() {
        p.removeMoney(initialDeposit);
        System.out.println("Congratulations! You rented an apartment and put in a non-refundable deposit of : $"
                + initialDeposit + "down on the apartment");
        apartment = true;
    }

    // If they wish to sell the house they own they'll receive 90% of the initial
    // value
    public void sellHouse() {
        if (house == true) {
            p.addMoney((amountPayed * .9));
            System.out.println("You gained $" + (amountPayed * .9) + " for selling your house");
            house = false;
        } else {
            System.out.println("You don't own a house");
        }
    }

    // Ends apartment payments
    public void stopApartment() {
        if (apartment == true) {
            apartment = false;
            System.out.println("You got out of your apartment contract.");
        } else {
            System.out.println("You don't own an apartment");
        }
    }

    // Checks if they own a house
    public boolean hasHouse() {
        return house;
    }

    // Checks if they own an apartment
    public boolean hasApartment() {
        return apartment;
    }

    // Checks at end of year for living situations and adds to health based on what
    // sleeping arrangements they have (scaled)
    public void checkHousing() {
        if (house == true) {
            p.addHealth(2);
            System.out.println("You gained 5 health for owning a house this year");
        } else if (apartment == true) {
            p.addHealth(1);
            System.out.println("You gained 3 health for owning an apartment this year");
        } else {
            p.removeHealth(2);
            System.out.println(
                    "You lost 2 health for not owning any property this year and are forced to live on the streets");
        }
    }

    // Returns your house type
    public String getHouseType() {
        return houseType;
    }

    // Tells the user how much they have paid for their home
    public void howMuchPaidOff() {
        System.out.println("You have paid $" + amountPayed + " out of " + buyValue + " on your house.");

    }

}