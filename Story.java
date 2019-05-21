/**
 * Story
 */

public class Story {

    private static int yearsOld = 0;

    private boolean gameOver(int health) {
        if (yearsOld >= 100 || health <= 0) {
            return true;
        }
        return false;
    }

}