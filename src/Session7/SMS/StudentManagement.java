package Session7.SMS;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("===== Student Menu =====");
            System.out.println("1. Enter student details");
            System.out.println("2. Display student details");
            System.out.println("3. Display number of students");
            System.out.println("4. Delete student");
            System.out.println("5. Edit student");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter student first name: ");
                    String firstName = scanner.next();

                    System.out.println("Enter student last name: ");
                    String lastName = scanner.next();

                    int studentAge;
                    while (true) {
                        System.out.println("Enter student age: ");
                        studentAge = scanner.nextInt();
                        try {
                            Student.validateAge(studentAge);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    scanner.nextLine();

                    String major;
                    while (true) {
                        System.out.println("Enter student major: ");
                        major = scanner.nextLine();
                        try {
                            Student.validateMajor(major);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    Student student = new Student(firstName, lastName, studentAge, major);

                    students.add(student);

                    System.out.println(" Information saved successfully " + student.toString());
                    break;
                case 2:
                    System.out.println("===== Student List =====");
                    System.out.printf("%-10s %-20s %-20s %-5s %-20s\n", " ID", "First Name", "Last Name", "Age", "Major");
                    System.out.println("---------------------------------------------------------");
                    for (int i = 0; i < students.size(); i++) {
                        Student s = students.get(i);
                        System.out.printf("%-10d %-20s %-20s %-5d %-20s\n",
                                s.getStudentId(),
                                s.getFirstName(),
                                s.getLastName(),
                                s.getStudentAge(),
                                s.getMajor());
                    }
                    System.out.println("--------------------------------------------------------");
                    break;
                case 3:
                    System.out.println("Number of students: " + Student.getStudentCount());
                    break;
                case 4:
                    System.out.println("Enter student id to delete: ");
                    int id = scanner.nextInt();
                    boolean studentFound = false;
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getStudentId() == id) {
                            students.remove(i);
                            studentFound = true;
                            System.out.println("Student deleted successfully");
                            break;
                        }
                    }
                    if (!studentFound) {
                        System.out.println("Student with id " + id + " does not exist");
                    }
                    break;
                case 5:
                    System.out.println("Enter student id: ");
                    int idToEdit = scanner.nextInt();
                    scanner.nextLine();

                    boolean found = false;
                    for (Student s : students) {
                        if (s.getStudentId() == idToEdit) {
                            System.out.println("Enter new first name: ");
                            s.setFirstName(scanner.next());
                            System.out.println("Enter new last name: ");
                            s.setLastName(scanner.next());
                            System.out.println("Enter new age: ");
                            while (true) {
                                try {
                                    s.setStudentAge(scanner.nextInt());
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            scanner.nextLine();
                            System.out.println("Enter new major: ");
                            while (true) {
                                try {
                                    s.setMajor(scanner.nextLine());
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            System.out.println("Student edited successfully");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student with id " + idToEdit + " not found");
                    }
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}