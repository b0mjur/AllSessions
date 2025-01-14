package Session7.SMS;

public class UndergraduateStudent extends Student {
    private int undergraduateYear;

    public UndergraduateStudent(String fName, String lName, int Age, String major, int undergraduateYear) {
        super(fName, lName, Age, major);
        this.undergraduateYear = undergraduateYear;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Undergraduate Year: %d", undergraduateYear);
    }
}