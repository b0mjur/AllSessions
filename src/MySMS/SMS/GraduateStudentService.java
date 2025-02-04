package MySMS.SMS;

public class GraduateStudentService {
    private StudentService studentService;

    public GraduateStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public String graduateStudent(int id, double gpa) {
        Student student = studentService.getStudents()
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        if (student == null) {
            return "Student not found.";
        }

        if (student instanceof GraduateStudent) {
            return "Student is already graduated.";
        }

        GraduateStudent graduateStudent = new GraduateStudent(student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.getMajor());
        try {
            graduateStudent.setGPA(gpa);
        } catch (IllegalGpaException e) {
            return "Invalid GPA: " + e.getMessage();
        }

        studentService.deleteStudent(id);
        studentService.addStudent(graduateStudent);
        studentService.saveStudents();
        return "Student graduated successfully.";
    }
}