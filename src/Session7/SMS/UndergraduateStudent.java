//package Session7.SMS;
//
//public class UndergraduateStudent extends Student implements Printable {
//    private int undergraduateYear;
//
//    public UndergraduateStudent(String firstName, String lastName, int studentAge, String major, String email, int undergraduateYear) {
//        super(firstName, lastName, studentAge, major, email);
//        setUndergraduateYear(undergraduateYear);
//    }
//
//    public int getUndergraduateYear() {
//        return undergraduateYear;
//    }
//
//    public void setUndergraduateYear(int undergraduateYear) {
//        validateUndergraduateYear(undergraduateYear);
//        this.undergraduateYear = undergraduateYear;
//    }
//
//    public static void validateUndergraduateYear(int year) {
//        if (year <= 2024) {
//            throw new IllegalArgumentException("Undergraduate year must be greater than 2024");
//        }
//    }
//
//    @Override
//    public void printDetails() {
//        System.out.println("Undergraduate Student: " + getFirstName() + " " + getLastName() + ", Age: " + getStudentAge() + ", Major: " + getMajor() + ", Email: " + getEmail() + ", Year: " + undergraduateYear);
//    }
//}