
/**
 * House
 */

import java.util.Scanner;

public class House {
    private Person     p;
    private Scanner    input;
    private int        buyValue;
    private int        yearlyHousePayment;
    private int        amountPayed;
    private String     houseType;
    private boolean    house                 = false;
    private boolean    apartment             = false;
    private int        initialPayment        = buyValue / 10;
    private static int initialDeposit        = 1800;
    private static int yearlyApartmentCharge = 18000;
    String[]           totalHouseList        = { "Mansion", "Beach House", "Cottage", "Farm House", "Villa", "Castle",
            "Igloo", "Condominium", "Town House", "Log Cabin", "Manor" };
    String[]           expensiveHouseList    = { "Mansion", "Manor", "Castle", "Beach House" };
    String[]           regularHouseList      = { "Villa", "Condominium", "Town House", "Cottage", "Log Cabin" };
    String[]           cheapHouseList        = { "Farm House", "Igloo" };

    public House(Person p, Scanner input) {
        this.p     = p;
        this.input = input;
    }

    /*
     * public House(int bValue, int mortgage) { this.buyValue = bValue;
     * this.yearlyHousePayment = mortgage; } public Apartment(int deposit, int
     * yCharge) { this.initialDeposit = deposit; this.yearlyApartmentCharge =
     * yCharge; }
     */

    // Provides house options if 18+ with 3 homes, each at a different tier of
    // prices, and checks if they can afford it and if they can, they buy the house
    // with responsibilties
    // Called upon at year end
    public void houseOptions() {
        if (p.getAge() > 18) {
            int option1 = (int) Run.inBetween(0.0, expensiveHouseList.length - 1);
            int option2 = (int) Run.inBetween(0.0, regularHouseList.length - 1);
            int option3 = (int) Run.inBetween(0.0, cheapHouseList.length - 1);

            int price1 = ((int) (Run.inBetween(1000000.0, 1500000.0)));
            int price2 = ((int) (Run.inBetween(500000.0, 1000000.0)));
            int price3 = ((int) (Run.inBetween(200000.0, 500000.0)));

            System.out.println("Here are your house options.");
            System.out.println("Choice 1: " + expensiveHouseList[option1] + " for $" + price1
                    + " with an initial downpayment of " + price1 / 10 + " and a fixed yearly mortgage of "
                    + ((price1 - price1 / 10) / 30) + " due at the end of each year");
            System.out.println("Choice 2: " + regularHouseList[option2] + " for $" + price2
                    + " with an initial downpayment of " + price2 / 10 + " and a fixed yearly mortgage of "
                    + ((price2 - price2 / 10) / 30) + " due at the end of each year");
            System.out.println("Choice 3: " + cheapHouseList[option3] + " for $" + price3
                    + " with an initial downpayment of " + price3 / 10 + " and a fixed yearly mortgage of "
                    + ((price3 - price3 / 10) / 30) + " due at the end of each year");

            System.out.println("Input the number for your choice 1-3 : ");

            boolean madeChoice = false;

            while (!madeChoice) {
                int choice = input.nextInt();
                if (choice == 1) {
                    if (p.getBal() > (price1 / 10)) {
                        buyValue           = price1;
                        yearlyHousePayment = ((price1 - price1 / 10) / 30);
                        houseType          = expensiveHouseList[option1];
                        buyHouse();
                        madeChoice = true;

                    } else {
                        System.out.println("You can't afford the downpayment on this house, try again another time");
                        madeChoice = true;
                    }
                } else if (choice == 2) {
                    if (p.getBal() > (price2 / 10)) {
                        buyValue           = price2;
                        yearlyHousePayment = ((price2 - price2 / 10) / 30);
                        houseType          = regularHouseList[option2];
                        buyHouse();
                        madeChoice = true;
                    } else {
                        System.out.println("You can't afford the downpayment on this house, try again another time");
                        madeChoice = true;
                    }
                } else if (choice == 3) {
                    if (p.getBal() > (price3 / 10)) {
                        buyValue           = price3;
                        yearlyHousePayment = ((price3 - price3 / 10) / 30);
                        houseType          = regularHouseList[option3];
                        buyHouse();
                        madeChoice = true;
                    } else {
                        System.out.println("You can't afford the downpayment on this house, try again another time");
                        madeChoice = true;
                    }
                } else if(choice == 4) {
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

    public void apartmentOptions() {
        System.out.println("There is an apartment offered at a price of $" + yearlyApartmentCharge + " annually");
        System.out.println("Choose 1 to rent this apartment or 2 to wait till next year or 3 to go back to house options");
        boolean madeChoice = false;

        while (!madeChoice) {
            int choice = input.nextInt();
            if (choice == 1) {
                rentApartment();
                madeChoice = true;
            } else if (choice == 2) {
                madeChoice = true;

            } else if(choice == 3) {
                System.out.println("You've decided to go back to the house options");
                houseOptions();
                madeChoice = true;
            }
             else {
                System.out.println("You must choose between 1 and 3");
            }
        }
    }

    public void downPayment(int amt) {
        amountPayed += amt;
    }

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
    public void buyHouse() {
        p.removeMoney(initialPayment);
        downPayment(initialPayment);
        System.out.println("Congratulations! You bought a house and put a downpayment of :$" + initialPayment
                + "down on the house.");
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

    // If they wish to sell the house they own they'll recieve 90% of the initial
    // value
    public void sellHouse() {
        if (house == true) {
            p.addMoney((amountPayed * .9));
            System.out.println("You gained $" + (amountPayed*.9) + " for selling your house");
            house = false;
        } else {
            System.out.println("You don't own a house");
        }
    }

    public void stopApartment()
    {
        if(apartment == true)
        {
            apartment == false;
            System.out.println("You got out of your apartment contract.");
        }
        else
        {
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
            p.addHealth(5);
            System.out.println("You gained 5 health for owning a house this year");
        } else if (apartment == true) {
            p.addHealth(3);
            System.out.println("You gained 3 health for owning an apartment this year");
        } else {
            p.removeHealth(2);
            System.out.println("You lost 2 health for not owning any property this year and are forced to live on the streets");
        }
    }

    public void howMuchPaidOff()
    {
        System.out.println("You have paid $" + amountPayed + " out of " + buyValue + " on your house.");
        
    }

}