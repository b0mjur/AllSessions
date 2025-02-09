//package SMSFromScratch.SMS;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class Student {
//    private int studentId;
//    private String firstName;
//    private String lastName;
//    private int studentAge;
//    private String major;
//    private static int studentCount = 0;
//    private static int studentIdGenerator = 1;
//    private static final List<String> VALID_MAJORS = Arrays.asList("Art", "Math", "Computer Science");
//
//    public Student(int id, String fName, String lName, int Age, String major) {
//        this.studentId = id;
//        this.firstName = fName;
//        this.lastName = lName;
//        this.studentAge = Age;
//        this.major = major;
//        studentCount++;
//    }
//
//    public String toString() {
//        return String.format("ID: %d, First name: %s, Last name: %s, Age: %d, Major: %s",
//                studentId,
//                firstName,
//                lastName,
//                studentAge,
//                major);
//    }
//
//    public int getStudentId() {
//        return studentId;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public int getStudentAge() {
//        return studentAge;
//    }
//
//    public void setStudentAge(int studentAge) {
//        if (studentAge < 18 || studentAge > 150) {
//            throw new IllegalArgumentException("Age must be between 18 and 150");
//        }
//        this.studentAge = studentAge;
//    }
//
//    public String getMajor() {
//        return major;
//    }
//
//    public void setMajor(String major) {
//        if (!major.equals("Art") && !major.equals("Economics") && !major.equals("Math")) {
//            throw new IllegalArgumentException("Major must be Art, Economics, or Math");
//        }
//        this.major = major;
//    }
//
//    public static int getStudentCount() {
//        return studentCount;
//    }
//}