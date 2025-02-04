package SMSFromScratch.SMS;

public class Student {
        int studentId;
        String firstName;
        String lastName;
        int studentAge;
        String major;

        Student(int id, String fName, String lName, int Age, String major) {
            this.studentId = id;
            this.firstName = fName;
            this.lastName = lName;
            this.studentAge = Age;
            this.major = major;
        }

        public String toString() {
            return String.format("ID: %d, First name: %s, Last name: %s, Age: %d, major: %s",
                        studentId,
                        firstName,
                        lastName,
                        studentAge,
                        major);
        }
}
