package Session7;

public class MethodOverloading {
    public static void main(String[] args) {
        message(2, 3);
        Test t = new Test();
        System.out.println(t.toString());

    }
    public static void message(String message) {
        System.out.println(message);
    }

    public static void message (int a, int b) {
        System.out.println(a + b);
    }


}
class Test {
    public String text = "text";
    public int x = 0;

    @Override
    public String toString() {
        return text + " " + x;
    }
}
