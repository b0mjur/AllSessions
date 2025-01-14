package Session7.SMS;

public class GraduateStudent extends Student {
    private double gpa;

    public GraduateStudent(String fName, String lName, int Age, String major, double gpa) {
        super(fName, lName, Age, major);
        this.gpa = gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() + ", GPA: " + gpa;
    }
}