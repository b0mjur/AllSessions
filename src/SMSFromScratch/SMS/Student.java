package SMSFromScratch.SMS;
public abstract class Student implements Printable {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    protected Major major;

    private static int nextId = 1;

    public Student(int id, String firstName, String lastName, int age, Major major) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.major = major;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public int getAge() { return age; }

    public Major getMajor() { return major; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setAge(int age) { this.age = age; }

    public void setMajor(Major major) { this.major = major; }

    public static void setNextId(int nextId) {
        Student.nextId = nextId;
    }

    @Override
    public abstract void print();
}