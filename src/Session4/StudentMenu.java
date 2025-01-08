package Session4;

import java.util.Scanner;

public class StudentMenu {
    public static void main(String[] args) {
        //take user input
        //build multiplication table for that number from 1 to 10
        //output result in console

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();


        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + number * i);
        }
        scanner.close();

    }
}
