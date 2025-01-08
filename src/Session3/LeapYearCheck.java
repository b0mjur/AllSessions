package Session3;

import java.util.Scanner;

public class LeapYearCheck {
    public static void main(String[] args) {
        //using scanner check if it's leap or not make it easy way with && and || operator

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a year: ");
        int year = scanner.nextInt();
        scanner.close();

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("Leap year");
        } else {
            System.out.println("Not a leap year");
        }
    }
}
