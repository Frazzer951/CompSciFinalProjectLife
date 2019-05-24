/**
 * Jobs
 */

public class Jobs {

    private Person         p;
    private static double  jobIncome;
    private static String  jobTitle;
    private static boolean employed = false;

    String[] jobList = { "Carpenter", "Zoologist", "Mason", "Librarian", "Farmer", "Teacher", "Therapist", "IT Manager",
            "Painter", "Receptionist" };

    public Jobs(Person p) {
        this.p = p;
    }

    public void jobOptions() {
        double mul = 1.0;
        if (p.getCollege == true) {
            mul = 3.0;
        }

        int choice1 = Run.inBetween(0.0, jobList.length);
        int choice2 = Run.inBetween(0.0, jobList.length);
        int choice3 = Run.inBetween(0.0, jobList.length);

        double price1 = Run.inBetween(20000.0, 50000.0) * mul;
        double price2 = Run.inBetween(20000.0, 50000.0) * mul;
        double price3 = Run.inBetween(20000.0, 50000.0) * mul;

        System.out.println("Here are your job choices.");
        System.out.println("Choice 1: " + choice1 + " for $" + price1 + " a year");
        System.out.println("Choice 2: " + choice2 + " for $" + price2 + " a year");
        System.out.println("Choice 3: " + choice3 + " for $" + price3 + " a year");

        Scanner input = new Scanner(System.in);
        System.out.println("Input the number for your choice 1-3 : ");

        boolean madeChoice = false;

        while (!madeChoice) {
            int choice = input.nextInt();
            if (choice == 1) {
                jobIncome  = price1;
                jobTitle   = choice1;
                madeChoice = true;
            } else if (choice == 2) {
                jobIncome  = price2;
                jobTitle   = choice2;
                madeChoice = true;
            } else if (choice == 3) {
                jobIncome  = price3;
                jobTitle   = choice3;
                madeChoice = true;
            } else {
                System.out.println("You must put a number between 1 and 3");
            }
        }
        input.close();

        p.changeIncome(jobIncome);

    }

    public void randomJobChance() {

    }

    public Strict jobName() {
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

}
