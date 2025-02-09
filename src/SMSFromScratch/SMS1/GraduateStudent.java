package SMSFromScratch.SMS1;

public class GraduateStudent extends Student implements Printable {
    private double gpa;
    private boolean graduated;

    public GraduateStudent(String firstName, String lastName, int studentAge, String major, String email, double gpa) {
        super(firstName, lastName, studentAge, major, email);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public boolean isGraduated() {
        return graduated;
    }

    @Override
    public void printDetails() {
        System.out.println("Graduate Student: " + getFirstName() + " " + getLastName() + ", Age: " + getStudentAge() + ", Major: " + getMajor() + ", Email: " + getEmail() + ", GPA: " + gpa);
    }
}