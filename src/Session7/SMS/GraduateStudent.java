//package Session7.SMS;
//
//public class GraduateStudent extends Student implements Printable {
//    private double gpa;
//
//    public GraduateStudent(String firstName, String lastName, int studentAge, String major, String email, double gpa) {
//        super(firstName, lastName, studentAge, major, email);
//        this.gpa = gpa;
//    }
//
//    public double getGpa() {
//        return gpa;
//    }
//
//    public void setGpa(double gpa) {
//        this.gpa = gpa;
//    }
//
//    @Override
//    public void printDetails() {
//        System.out.println("Graduate Student: " + getFirstName() + " " + getLastName() + ", Age: " + getStudentAge() + ", Major: " + getMajor() + ", Email: " + getEmail() + ", GPA: " + gpa);
//    }
//}