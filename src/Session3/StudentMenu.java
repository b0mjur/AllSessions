package Session3;

import java.util.Scanner;

public class StudentMenu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int studentId = 0;
        String firstName = "";
        String lastName = "";
        int studentAge = 0;


        while (true) {
            System.out.println("===== Student Menu =====");
            System.out.println("1. Enter student details");
            System.out.println("2. Display student details");
            System.out.println("3. Exit");
            System.out.println("4. Reset user details");
            System.out.println("Enter your choice: ");


            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter student id: ");
                    studentId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter student first name: ");
                    firstName = scanner.next();

                    System.out.println("Enter student last name: ");
                    lastName = scanner.next();

                    System.out.println("Enter student age: ");
                    studentAge = scanner.nextInt();

                    System.out.println("Information saved successfully");
                    break;
                case 2:
                    System.out.println("===== Student Details =====");
                    System.out.println("Student ID: " + studentId);
                    System.out.println("First Name: " + firstName);
                    System.out.println("Last Name: " + lastName);
                    System.out.println("Age: " + studentAge);
                    System.out.println("===== End of Student Details =====");
                    break;

                case 3:
                    studentId = 0;
                    firstName = "";
                    lastName = "";
                    studentAge = 0;
                    System.out.println("User details reset successfully");
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        }
    }
}
