/**
 * Run
 */
import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        //Gets User Input for Name
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name : ");
        String s = input.next(); // getting a String value

        //Creates Person with name starting with 0 cash and 0 income
        Person p = new Person(s, 0.0, 0.0);
    }
}
