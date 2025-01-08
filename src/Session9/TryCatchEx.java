package Session9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter a num1 ");
            int number1 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter a num2 ");
            int number2 = scanner.nextInt();
            scanner.nextLine();

            int result = number1 / number2;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Division by zero is not allowed.");
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        finally {
            System.out.println("Application completed");
            scanner.close();
        }
    }
}
