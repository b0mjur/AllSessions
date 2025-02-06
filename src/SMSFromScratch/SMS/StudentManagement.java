package SMSFromScratch.SMS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        Gson gson = new Gson();

        while (true) {
            System.out.println("===== Student Menu =====");
            System.out.println("1. Enter student details");
            System.out.println("2. Display student details");
            System.out.println("3. Delete student");
            System.out.println("4. Edit Student");
            System.out.println("5. Save to JSON file");
            System.out.println("6. Load from JSON file");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    boolean idExists = false;
                    System.out.println("Enter student id: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        students.get(studentId);
                        idExists = true;
                        break;
                    } catch (IndexOutOfBoundsException e) {

                    }
                    if (idExists) {
                        System.out.println("Student with id " + studentId + " already exists");
                        break;
                    }

                    System.out.println("Enter student first name: ");
                    String firstName = scanner.next();

                    System.out.println("Enter student last name: ");
                    String lastName = scanner.next();

                    int studentAge;
                    while (true) {
                        System.out.println("Enter student age: ");
                        studentAge = scanner.nextInt();
                        try {
                            Student tempStudent = new Student(studentId, firstName, lastName, studentAge, "Art"); // Temporary student to validate age
                            tempStudent.ageValidation(); // Validate age
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    String major;
                    while (true) {
                        System.out.println("Enter student major: ");
                        major = scanner.next();
                        try {
                            Student tempStudent = new Student(studentId, firstName, lastName, studentAge, major); // Temporary student to validate major
                            tempStudent.majorValidation(); // Validate major
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    Student student = new Student(studentId, firstName, lastName, studentAge, major);
                    students.add(student);

                    System.out.println("Information saved successfully: " + student.toString());
                    break;
                case 2:
                    System.out.println("===== Student List =====");
                    System.out.printf("| %-10s | %-20s | %-20s | %-5s | %-20s |%n", "ID", "First Name", "Last Name", "Age", "Major");
                    System.out.println("——————————————————————————————————————————————————————————————————————————————————————————————");
                    for (Student s : students) {
                        System.out.printf("| %-10d | %-20s | %-20s | %-5d | %-20s |%n",
                                s.getStudentId(),
                                s.getFirstName(),
                                s.getLastName(),
                                s.getStudentAge(),
                                s.getMajor());
                    }
                    System.out.println("——————————————————————————————————————————————————————————————————————————————————————————————");
                    break;

                case 3:
                    System.out.println("Enter student id to delete: ");
                    int id = scanner.nextInt();
                    Student studentToRemove = null;
                    for (Student s : students) {
                        if (s.getStudentId() == id) {
                            studentToRemove = s;
                            break;
                        }
                    }
                    if (studentToRemove != null) {
                        students.remove(studentToRemove);
                        System.out.println("Student deleted successfully");
                    } else {
                        System.out.println("Student with id " + id + " does not exist");
                    }
                    break;
                case 4:
                    System.out.println("Enter student ID: ");
                    int idToEdit = scanner.nextInt();
                    scanner.nextLine();

                    boolean found = false;
                    for (Student s : students) {
                        if (s.getStudentId() == idToEdit) {
                            System.out.println("Enter new first name: ");
                            s.setFirstName(scanner.nextLine());
                            System.out.println("Enter new last name: ");
                            s.setLastName(scanner.nextLine());
                            System.out.println("Enter new age: ");
                            s.setStudentAge(scanner.nextInt());
                            scanner.nextLine();
                            String newMajor;
                            while (true) {
                                System.out.println("Enter new major: ");
                                newMajor = scanner.nextLine();
                                try {
                                    s.setMajor(newMajor);
                                    s.majorValidation();
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            System.out.println("Student updated");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student with ID: " + idToEdit + " not found");
                    }
                    break;
                case 5:
                    System.out.println("Enter file name to save: ");
                    String fileName = scanner.next();
                    saveToJson(students, gson, fileName);
                    break;
                case 6:
                    System.out.println("Enter file name to load: ");
                    String loadFileName = scanner.next();
                    students = loadFromJson(gson, loadFileName);
                    break;
                case 7:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void saveToJson(List<Student> students, Gson gson, String fileName) {
        String filePath = "C:\\Users\\vital\\FullStackPortnov\\JavaCode\\" + fileName; // Construct the file path
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(students, writer);
            System.out.println("Students saved to JSON file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Student> loadFromJson(Gson gson, String fileName) {
        String filePath = "C:\\Users\\vital\\FullStackPortnov\\JavaCode\\" + fileName; // Construct the file path
        System.out.println("Loading from file: " + filePath); // Print the file path
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, new TypeToken<ArrayList<Student>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}