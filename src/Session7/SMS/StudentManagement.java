//package Session7.SMS;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class StudentManagement {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        SMS_JSON smsJson = new SMS_JSON();
//        List<Student> students = new ArrayList<>();
//        smsJson.setStudents(students);
//
//        while (true) {
//            System.out.println("===== Student Menu =====");
//            System.out.println("1. Enter student details");
//            System.out.println("2. Display student details");
//            System.out.println("3. Display number of students");
//            System.out.println("4. Delete student");
//            System.out.println("5. Edit student");
//            System.out.println("6. Save to JSON");
//            System.out.println("7. Load from JSON");
//            System.out.println("8. Exit");
//            System.out.println("Enter your choice: ");
//
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case 1:
//                    System.out.println("Enter student type (1 for Graduate, 2 for Undergraduate): ");
//                    int type = scanner.nextInt();
//                    scanner.nextLine();
//
//                    String firstName;
//                    while (true) {
//                        System.out.println("Enter student first name: ");
//                        firstName = scanner.nextLine();
//                        try {
//                            Student.validateName(firstName);
//                            break;
//                        } catch (IllegalArgumentException e) {
//                            System.out.println(e.getMessage());
//                        }
//                    }
//
//                    String lastName;
//                    while (true) {
//                        System.out.println("Enter student last name: ");
//                        lastName = scanner.nextLine();
//                        try {
//                            Student.validateName(lastName);
//                            break;
//                        } catch (IllegalArgumentException e) {
//                            System.out.println(e.getMessage());
//                        }
//                    }
//
//                    int studentAge;
//                    while (true) {
//                        System.out.println("Enter student age: ");
//                        studentAge = scanner.nextInt();
//                        try {
//                            Student.validateAge(studentAge);
//                            break;
//                        } catch (IllegalArgumentException e) {
//                            System.out.println(e.getMessage());
//                        }
//                    }
//                    scanner.nextLine();
//
//                    String major;
//                    while (true) {
//                        System.out.println("Enter student major: ");
//                        major = scanner.nextLine();
//                        try {
//                            Student.validateMajor(major);
//                            break;
//                        } catch (IllegalArgumentException e) {
//                            System.out.println(e.getMessage());
//                        }
//                    }
//
//                    String email;
//                    while (true) {
//                        System.out.println("Enter student email: ");
//                        email = scanner.nextLine();
//                        try {
//                            Student.validateEmail(email);
//                            break;
//                        } catch (IllegalArgumentException e) {
//                            System.out.println(e.getMessage());
//                        }
//                    }
//
//                    addStudent(students, scanner, type, firstName, lastName, studentAge, major, email);
//                    break;
//                case 2:
//                    System.out.println("===== Student List =====");
//                    System.out.printf("%-5s | %-15s | %-15s | %-3s | %-20s | %-30s | %-15s\n", "ID", "First Name", "Last Name", "Age", "Major", "Email", "Graduation Year");
//                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//                    for (Student s : students) {
//                        if (s instanceof UndergraduateStudent) {
//                            UndergraduateStudent u = (UndergraduateStudent) s;
//                            System.out.printf("%-5d | %-15s | %-15s | %-3d | %-20s | %-30s | %-15d\n",
//                                    u.getStudentId(),
//                                    u.getFirstName(),
//                                    u.getLastName(),
//                                    u.getStudentAge(),
//                                    u.getMajor(),
//                                    u.getEmail(),
//                                    u.getUndergraduateYear());
//                        } else {
//                            System.out.printf("%-5d | %-15s | %-15s | %-3d | %-20s | %-30s | %-15s\n",
//                                    s.getStudentId(),
//                                    s.getFirstName(),
//                                    s.getLastName(),
//                                    s.getStudentAge(),
//                                    s.getMajor(),
//                                    s.getEmail(),
//                                    "N/A");
//                        }
//                    }
//                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//                    break;
//                case 3:
//                    System.out.println("Number of students: " + Student.getStudentCount());
//                    break;
//                case 4:
//                    System.out.println("Enter student id to delete: ");
//                    int id = scanner.nextInt();
//                    boolean studentFound = false;
//                    for (int i = 0; i < students.size(); i++) {
//                        if (students.get(i).getStudentId() == id) {
//                            students.remove(i);
//                            studentFound = true;
//                            System.out.println("Student deleted successfully");
//                            break;
//                        }
//                    }
//                    if (!studentFound) {
//                        System.out.println("Student with id " + id + " does not exist");
//                    }
//                    break;
//                case 5:
//                    System.out.println("Enter student id: ");
//                    int idToEdit = scanner.nextInt();
//                    scanner.nextLine();
//
//                    boolean found = false;
//                    for (Student s : students) {
//                        if (s.getStudentId() == idToEdit) {
//                            String newFirstName;
//                            while (true) {
//                                System.out.println("Enter new first name: ");
//                                newFirstName = scanner.nextLine();
//                                try {
//                                    Student.validateName(newFirstName);
//                                    s.setFirstName(newFirstName);
//                                    break;
//                                } catch (IllegalArgumentException e) {
//                                    System.out.println(e.getMessage());
//                                }
//                            }
//
//                            String newLastName;
//                            while (true) {
//                                System.out.println("Enter new last name: ");
//                                newLastName = scanner.nextLine();
//                                try {
//                                    Student.validateName(newLastName);
//                                    s.setLastName(newLastName);
//                                    break;
//                                } catch (IllegalArgumentException e) {
//                                    System.out.println(e.getMessage());
//                                }
//                            }
//
//                            System.out.println("Enter new age: ");
//                            while (true) {
//                                try {
//                                    s.setStudentAge(scanner.nextInt());
//                                    break;
//                                } catch (IllegalArgumentException e) {
//                                    System.out.println(e.getMessage());
//                                }
//                            }
//                            scanner.nextLine();
//
//                            System.out.println("Enter new major: ");
//                            while (true) {
//                                try {
//                                    s.setMajor(scanner.nextLine());
//                                    break;
//                                } catch (IllegalArgumentException e) {
//                                    System.out.println(e.getMessage());
//                                }
//                            }
//
//                            System.out.println("Enter new email: ");
//                            while (true) {
//                                try {
//                                    s.setEmail(scanner.nextLine());
//                                    break;
//                                } catch (IllegalArgumentException e) {
//                                    System.out.println(e.getMessage());
//                                }
//                            }
//
//                            if (s instanceof GraduateStudent) {
//                                System.out.println("Enter new GPA: ");
//                                ((GraduateStudent) s).setGpa(scanner.nextDouble());
//                            }
//                            System.out.println("Student edited successfully");
//                            found = true;
//                            break;
//                        }
//                    }
//                    if (!found) {
//                        System.out.println("Student with id " + idToEdit + " not found");
//                    }
//                    break;
//                case 6:
//                    smsJson.saveToJson("students.json");
//                    System.out.println("Students saved to JSON file successfully");
//                    break;
//                case 7:
//                    smsJson.loadFromJson("students.json");
//                    students = (ArrayList<Student>) smsJson.getStudents();
//                    System.out.println("Students loaded from JSON file successfully");
//                    break;
//                case 8:
//                    scanner.close();
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Invalid choice");
//            }
//        }
//    }
//
//    private static void addStudent(List<Student> students, Scanner scanner, int type, String firstName, String lastName, int studentAge, String major, String email) {
//        if (type == 1) {
//            System.out.println("Enter GPA: ");
//            double gpa = scanner.nextDouble();
//            GraduateStudent gradStudent = new GraduateStudent(firstName, lastName, studentAge, major, email, gpa);
//            students.add(gradStudent);
//            System.out.println("Information saved successfully " + gradStudent);
//        } else if (type == 2) {
//            int undergraduateYear;
//            while (true) {
//                System.out.println("Enter undergraduate year: ");
//                undergraduateYear = scanner.nextInt();
//                try {
//                    UndergraduateStudent.validateUndergraduateYear(undergraduateYear);
//                    break;
//                } catch (IllegalArgumentException e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//            UndergraduateStudent undergradStudent = new UndergraduateStudent(firstName, lastName, studentAge, major, email, undergraduateYear);
//            students.add(undergradStudent);
//            System.out.println("Information saved successfully " + undergradStudent);
//        } else {
//            System.out.println("Invalid student type");
//        }
//    }
//}