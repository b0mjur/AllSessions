package Session7.SMS;

public class Student {
    public int studentId;
    private String firstName;
    private String lastName;
    private int studentAge;
    private String major;

    private static int studentCount = 0;
    private static int newStudentId = 1;

    public Student(String fName, String lName, int Age, String major) {
        validateAge(Age);
        validateMajor(major);
        this.studentId = newStudentId++;
        this.firstName = fName;
        this.lastName = lName;
        this.studentAge = Age;
        this.major = major;
        studentCount++;
    }

    public static void validateAge(int age) {
        if (age < 18 || age > 150) {
            throw new IllegalArgumentException("Age must be between 18 and 150");
        }
    }

    public static void validateMajor(String major) {
        if (!major.equals("Art") && !major.equals("Economics") && !major.equals("Math")) {
            throw new IllegalArgumentException("Major must be Art, Economics, or Math");
        }
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        validateAge(studentAge);
        this.studentAge = studentAge;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        validateMajor(major);
        this.major = major;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, First Name: %s, Last Name: %s, Major: %s",
                studentId, firstName, lastName, major);
    }

    public static int getStudentCount() {
        return studentCount;
    }
}