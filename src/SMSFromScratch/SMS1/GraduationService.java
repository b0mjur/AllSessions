package SMSFromScratch.SMS1;

import java.util.List;

public class GraduationService {
    private StudentService studentService;

    public GraduationService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void graduateStudent(int studentId) {
        List<Student> students = studentService.loadStudents();
        for (Student student : students) {
            if (student.getStudentId() == studentId && student instanceof GraduateStudent) {
                ((GraduateStudent) student).setGraduated(true);
                studentService.saveStudents(students);
                System.out.println("Student with ID " + studentId + " has graduated.");
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found or is not a graduate student.");
    }
}