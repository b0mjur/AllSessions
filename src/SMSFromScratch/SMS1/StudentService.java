package SMSFromScratch.SMS1;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void saveStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> loadStudents() {
        return students;
    }
}