package SMSFromScratch.SMS1.Menu;

import SMSFromScratch.SMS1.GraduationService;
import java.util.Scanner;

public class GraduateStudentMenu {
    private GraduationService graduationService;
    private Scanner scanner;

    public GraduateStudentMenu(GraduationService graduationService, Scanner scanner) {
        this.graduationService = graduationService;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.print("Enter student ID to graduate: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        graduationService.graduateStudent(studentId);
    }
}