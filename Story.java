/**
 * Story
 */

public class Story {

    private static int    age      = 0;
    private static String ageGroup = "CHILD";
    private Person        p;

    // Constructor for the Person Class
    public Story(Person p) {
        this.p = p;
    }

    public boolean gameOver() {
        if (age >= 100 || p.getHealth() <= 0) {
            return true;
        }
        return false;
    }

    public void yearStart() {
        // All of Your Choices
        System.out.println("Your age is " + age);
        System.out.println("Your age group is " + ageGroup);
        System.out.println("Your health is " + p.getHealth());
        System.out.println("Your Balance is " + p.getBal());
    }

    public void yearEnd() {
        // End of Year

        // Get Yearly Income Pay
        p.payday();
        age++;
        this.setAgeGroup();
        ;

        // All of the Random Chances

    }

    private void invest(double amt) {
        // Investment Function
    }

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