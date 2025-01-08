package Session4;

import java.util.Scanner;

public class WhileExample {
    public static void main(String[] args) throws InterruptedException {

        //take user input with scanner
        //use while loop to print all even numbers from 1 to 10

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        while (number <= 10) {
            if (number % 2 == 0) {
                System.out.println(number);
            }
            number++;
            scanner.close();

        }
    }
}
