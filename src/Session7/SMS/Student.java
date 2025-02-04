//package Session7.SMS;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.regex.Pattern;
//
//public abstract class Student {
//    private String firstName;
//    private String lastName;
//    private int studentAge;
//    private String major;
//    private String email;
//    private int studentId;
//    private static int studentCount = 0;
//    private static final List<String> VALID_MAJORS = Arrays.asList("Art", "Math", "Computer Science");
//
//    public Student(String firstName, String lastName, int studentAge, String major, String email) {
//        setFirstName(firstName);
//        setLastName(lastName);
//        this.studentAge = studentAge;
//        this.major = major;
//        this.email = email;
//        this.studentId = ++studentCount;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        validateName(firstName);
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        validateName(lastName);
//        this.lastName = lastName;
//    }
//
//    public int getStudentAge() {
//        return studentAge;
//    }
//
//    public void setStudentAge(int studentAge) {
//        validateAge(studentAge);
//        this.studentAge = studentAge;
//    }
//
//    public String getMajor() {
//        return major;
//    }
//
//    public void setMajor(String major) {
//        validateMajor(major);
//        this.major = major;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        validateEmail(email);
//        this.email = email;
//    }
//
//    public int getStudentId() {
//        return studentId;
//    }
//
//    public static int getStudentCount() {
//        return studentCount;
//    }
//
//    public static void validateAge(int age) {
//        if (age < 18 || age > 110) {
//            throw new IllegalArgumentException("Invalid age");
//        }
//    }
//
//    public static void validateMajor(String major) {
//        if (!VALID_MAJORS.contains(major)) {
//            throw new IllegalArgumentException("Invalid major");
//        }
//    }
//
//    public static void validateEmail(String email) {
//        String emailRegex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
//        Pattern pattern = Pattern.compile(emailRegex);
//        if (!pattern.matcher(email).matches()) {
//            throw new IllegalArgumentException("Invalid email");
//        }
//    }
//
//    public static void validateName(String name) {
//        if (name.length() < 4) {
//            throw new IllegalArgumentException("Name must be at least 4 characters long");
//        }
//    }
//
//    public abstract void printDetails();
//}