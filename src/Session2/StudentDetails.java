package Session2;

import java.util.Scanner;

public class StudentDetails {
    public static void main(String[] args) {
        //Student ID
        //Student first name
        //Student last name
        //Student age
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Student ID: ");
        int studentID = scanner.nextInt();
        System.out.println("Enter your first name: ");
        String firstName = scanner.next();
        System.out.println("Enter your last name: ");
        String lastName = scanner.next();
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        System.out.println("Student ID: " + studentID + ", First Name: " + firstName + ", Last Name: " + lastName + ", Age: " + age);
        scanner.close();


    }
}
