package SMSFromScratch.SMS1;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static SMSFromScratch.SMS1.SMS_JSON.loadFromJson;
import static SMSFromScratch.SMS1.SMS_JSON.saveToJson;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("===== Student Menu =====");
            System.out.println("1. Enter student details");
            System.out.println("2. Display student details");
            System.out.println("3. Display number of students");
            System.out.println("4. Sort and display students by name and major");
            System.out.println("5. Delete student");
            System.out.println("6. Edit student");
            System.out.println("7. Save to JSON");
            System.out.println("8. Load from JSON");
            System.out.println("9. Export to CSV");
            System.out.println("10. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter student type (1 for Graduate, 2 for Undergraduate): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    String firstName;
                    while (true) {
                        System.out.println("Enter student first name: ");
                        firstName = scanner.nextLine();
                        try {
                            Student.validateName(firstName);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    String lastName;
                    while (true) {
                        System.out.println("Enter student last name: ");
                        lastName = scanner.nextLine();
                        try {
                            Student.validateName(lastName);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

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

                    String email;
                    while (true) {
                        System.out.println("Enter student email: ");
                        email = scanner.nextLine();
                        try {
                            Student.validateEmail(email);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    addStudent(students, scanner, type, firstName, lastName, studentAge, major, email);
                    break;
                case 2:
                    System.out.println("===== Student List =====");
                    System.out.printf("%-5s | %-15s | %-15s | %-3s | %-20s | %-30s | %-15s\n", "ID", "First Name", "Last Name", "Age", "Major", "Email", "Graduation Year");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    for (Student s : students) {
                        if (s instanceof UndergraduateStudent) {
                            UndergraduateStudent u = (UndergraduateStudent) s;
                            System.out.printf("%-5d | %-15s | %-15s | %-3d | %-20s | %-30s | %-15d\n",
                                    u.getStudentId(),
                                    u.getFirstName(),
                                    u.getLastName(),
                                    u.getStudentAge(),
                                    u.getMajor(),
                                    u.getEmail(),
                                    u.getUndergraduateYear());
                        } else {
                            System.out.printf("%-5d | %-15s | %-15s | %-3d | %-20s | %-30s | %-15s\n",
                                    s.getStudentId(),
                                    s.getFirstName(),
                                    s.getLastName(),
                                    s.getStudentAge(),
                                    s.getMajor(),
                                    s.getEmail(),
                                    "N/A");
                        }
                    }
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case 3:
                    System.out.println("Number of students: " + Student.getStudentCount());
                    break;
                case 4:
                    students.sort(new StudentComparator());
                    System.out.println("===== Sorted Student List =====");
                    System.out.printf("%-5s | %-15s | %-15s | %-3s | %-20s | %-30s | %-15s\n", "ID", "First Name", "Last Name", "Age", "Major", "Email", "Graduation Year");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    for (Student s : students) {
                        if (s instanceof UndergraduateStudent) {
                            UndergraduateStudent u = (UndergraduateStudent) s;
                            System.out.printf("%-5d | %-15s | %-15s | %-3d | %-20s | %-30s | %-15d\n",
                                    u.getStudentId(),
                                    u.getFirstName(),
                                    u.getLastName(),
                                    u.getStudentAge(),
                                    u.getMajor(),
                                    u.getEmail(),
                                    u.getUndergraduateYear());
                        } else {
                            System.out.printf("%-5d | %-15s | %-15s | %-3d | %-20s | %-30s | %-15s\n",
                                    s.getStudentId(),
                                    s.getFirstName(),
                                    s.getLastName(),
                                    s.getStudentAge(),
                                    s.getMajor(),
                                    s.getEmail(),
                                    "N/A");
                        }
                    }
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case 5:
                    System.out.println("Enter student id to delete: ");
                    int id = scanner.nextInt();
                    boolean studentToRemove = false;
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getStudentId() == id) {
                            students.remove(i);
                            studentToRemove = true;
                            System.out.println("Student deleted successfully");
                            break;
                        }
                    }
                    if (!studentToRemove) {
                        System.out.println("Student with id " + id + " does not exist");
                    }
                    break;
                case 6:
                    System.out.println("Enter student id: ");
                    int idToEdit = scanner.nextInt();
                    scanner.nextLine();

                    boolean found = false;
                    for (Student s : students) {
                        if (s.getStudentId() == idToEdit) {
                            String newFirstName;
                            while (true) {
                                System.out.println("Enter new first name: ");
                                newFirstName = scanner.nextLine();
                                try {
                                    Student.validateName(newFirstName);
                                    s.setFirstName(newFirstName);
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            String newLastName;
                            while (true) {
                                System.out.println("Enter new last name: ");
                                newLastName = scanner.nextLine();
                                try {
                                    Student.validateName(newLastName);
                                    s.setLastName(newLastName);
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                            }

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

                            System.out.println("Enter new email: ");
                            while (true) {
                                try {
                                    s.setEmail(scanner.nextLine());
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            if (s instanceof GraduateStudent) {
                                System.out.println("Enter new GPA: ");
                                ((GraduateStudent) s).setGpa(scanner.nextDouble());
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
                case 7:
                    System.out.println("Enter file name to save: ");
                    String fileName = scanner.next();
                    saveToJson(students, gson, fileName);
                    break;
                case 8:
                    System.out.println("Enter file name to load: ");
                    String loadFileName = scanner.next();
                    students = loadFromJson(gson, loadFileName);
                    break;
                case 9:
                    System.out.println("Enter file name to export: ");
                    String exportFileName = scanner.next();
                    exportToCsv(students, exportFileName);
                    break;
                case 10:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void addStudent(List<Student> students, Scanner scanner, int type, String firstName, String lastName, int studentAge, String major, String email) {
        if (type == 1) {
            System.out.println("Enter GPA: ");
            double gpa = scanner.nextDouble();
            GraduateStudent gradStudent = new GraduateStudent(firstName, lastName, studentAge, major, email, gpa);
            students.add(gradStudent);
            System.out.println("Information saved successfully " + gradStudent);
        } else if (type == 2) {
            int undergraduateYear;
            while (true) {
                System.out.println("Enter undergraduate year: ");
                undergraduateYear = scanner.nextInt();
                try {
                    UndergraduateStudent.validateUndergraduateYear(undergraduateYear);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            UndergraduateStudent undergradStudent = new UndergraduateStudent(firstName, lastName, studentAge, major, email, undergraduateYear);
            students.add(undergradStudent);
            System.out.println("Information saved successfully " + undergradStudent);
        } else {
            System.out.println("Invalid student type");
        }
    }

    public static void exportToCsv(List<Student> students, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("ID,First Name,Last Name,Age,Major,Email,Graduation Year,GPA\n");
            for (Student student : students) {
                writer.append(String.valueOf(student.getStudentId())).append(",");
                writer.append(student.getFirstName()).append(",");
                writer.append(student.getLastName()).append(",");
                writer.append(String.valueOf(student.getStudentAge())).append(",");
                writer.append(student.getMajor()).append(",");
                writer.append(student.getEmail()).append(",");
                if (student instanceof GraduateStudent) {
                    writer.append("N/A,");
                    writer.append(String.valueOf(((GraduateStudent) student).getGpa()));
                } else if (student instanceof UndergraduateStudent) {
                    writer.append(String.valueOf(((UndergraduateStudent) student).getUndergraduateYear())).append(",");
                    writer.append("N/A");
                } else {
                    writer.append("N/A,N/A");
                }
                writer.append("\n");
            }
            System.out.println("Students exported to CSV successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}