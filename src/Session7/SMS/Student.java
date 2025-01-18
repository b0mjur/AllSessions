package Session7.SMS;

public abstract class Student {
    private String firstName;
    private String lastName;
    private int studentAge;
    private String major;
    private int studentId;
    private static int studentCount = 0;

    public Student(String firstName, String lastName, int studentAge, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentAge = studentAge;
        this.major = major;
        this.studentId = ++studentCount;
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
        this.studentAge = studentAge;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getStudentId() {
        return studentId;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public static void validateAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age");
        }
    }

    public static void validateMajor(String major) {
        if (major == null || major.isEmpty()) {
            throw new IllegalArgumentException("Invalid major");
        }
    }

    public abstract void printDetails();
}