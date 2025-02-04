package MySMS.SMS.Menu;

import MySMS.SMS.GraduateStudentService;
import MySMS.SMS.StudentService;

import java.util.Scanner;

public class GraduateStudentMenu {
    private GraduateStudentService graduateStudentService;
    private Scanner scanner;

    public GraduateStudentMenu(StudentService studentService, Scanner scanner) {
        this.graduateStudentService = new GraduateStudentService(studentService);
        this.scanner = scanner;
    }

    public void execute() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter GPA: ");
        double gpa = scanner.nextDouble();
        scanner.nextLine();

        String result = graduateStudentService.graduateStudent(id, gpa);
        System.out.println(result);
    }
}