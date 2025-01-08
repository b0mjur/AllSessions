package Session4;

import java.util.Scanner;

public class NestedLoop {
    public static void main(String[] args) {
        //take an int form user with scanner
        //dependind on the number build a pyramid of stars
        //for example if user enters 5
        //output should be:
        //  *
        //  **
        // ***
        // ****
        //make it start from the middle of the console

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}
