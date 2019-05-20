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

        //Creates Person with name
        Person p = new Person(s, 100.0, 0.0);
    }
}