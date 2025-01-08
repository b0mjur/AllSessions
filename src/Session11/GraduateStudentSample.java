package Session11;

public class GraduateStudentSample {
    static void describeStudent(Student student) {
        if (student instanceof GraduateStudent) {
            System.out.println("This is a graduate student");
        } else {
            System.out.println("This is a student");
        }
    }


    public static void main(String[] args) {
        Student student = new Student();
        student.name = "Jane";
        student.age = 20;
        student.studentID = "123456";

        GraduateStudent graduateStudent = new GraduateStudent();
        graduateStudent.name = "John";
        graduateStudent.age = 30;
        graduateStudent.studentID = "654321";
        graduateStudent.researchTopic = "Machine Learning";

        student.introduce();
        graduateStudent.introduce();
    }
}
