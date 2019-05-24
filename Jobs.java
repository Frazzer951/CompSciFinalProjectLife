/**
 * Jobs
 */

public class Jobs {

    private Person         p;
    private static double  jobIncome;
    private static boolean employed = false;

    String[] jobList = new String["Carpenter", "Zoologist", "Mason", "Librarian", "Farmer","Teacher", "Therapist", "IT Manager", "Painter", "Receptionist"];

    public Jobs(Person p) {
        this.p = p;
    }

    public void jobOptions() {

    }

    public void randomJobChance() {

    }

    public boolean hasJob() {
        return employed;
    }

    private void jobChange() {
        double chance1 = Math.random() * 100.0;
        double inc     = p.getIncome();
        if (chance1 <= 10) {
            p.changeIncome(inc += (inc / 10.0));
            System.out.println("You got a raise for doing well!");
        } else if (chance1 >= 95) {
            p.changeIncome(0.0);
            System.out.println("You got fired!");
        } else if (chance1 > 10 && chance1 < 15) {
            p.changeIncome(inc -= (inc / 10.0));
            System.out.println("You made a bad call at work, and your pay has been docked");
        }
    }

}
