package Session4;

import java.util.Scanner;

public class DoWhileEx {
    public static void main(String[] args) {

        //use do while to repeatedly ask for user input
        //if user enter negative number ask again
        //print confirmation in case positive number is entered

        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.println("Enter a number: ");
            number = scanner.nextInt();
            if (number < 0) {
                System.out.println("Please enter a positive number");
            } else {
                System.out.println("Thank you for entering a positive number " + number);
            }
        } while (number < 0);

        scanner.close();
    }
}
