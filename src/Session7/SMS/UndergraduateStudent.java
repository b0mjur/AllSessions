package Session7.SMS;

import Session7.SMS.Printable;

public class UndergraduateStudent extends Student implements Printable {
    private int undergraduateYear;

    public UndergraduateStudent(String firstName, String lastName, int studentAge, String major, int undergraduateYear) {
        super(firstName, lastName, studentAge, major);
        this.undergraduateYear = undergraduateYear;
    }

    public int getUndergraduateYear() {
        return undergraduateYear;
    }

    public void setUndergraduateYear(int undergraduateYear) {
        this.undergraduateYear = undergraduateYear;
    }

    @Override
    public void printDetails() {
        System.out.println("Undergraduate Student: " + getFirstName() + " " + getLastName() + ", Age: " + getStudentAge() + ", Major: " + getMajor() + ", Year: " + undergraduateYear);
    }
}