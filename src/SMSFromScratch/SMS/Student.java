package SMSFromScratch.SMS;

public class Student {
        private int studentId;
        private String firstName;
        private String lastName;
        private int studentAge;
        private String major;
        private static int studentCount = 0;
        private static int studentIdGenerator = 1;

    Student(int id, String fName, String lName, int Age, String major) {
        this.studentId = id;
        this.firstName = fName;
        this.lastName = lName;
        this.studentAge = Age;
        this.major = major;
        studentCount++;
        ageValidation();
        majorValidation();
    }

        public String toString() {
            return String.format("ID: %d, First name: %s, Last name: %s, Age: %d, Major: %s",
                        studentId,
                        firstName,
                        lastName,
                        studentAge,
                        major);
        }

        public void ageValidation() {
            if (studentAge < 18 || studentAge > 150) {
                throw new IllegalArgumentException("Age must be between 18 and 150");
            }
        }

        public void majorValidation() {
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
        this.studentAge = studentAge;
        ageValidation();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
        majorValidation();
    }

    public static int getStudentCount() {
        return studentCount;
    }
}
