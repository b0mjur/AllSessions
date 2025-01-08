package Session8;

public class StaticMethod {
    static class mathUtil {
        public static int calcSquare(int num) {
            return num * num;
        }
    }

    public static void main(String[] args) {
        System.out.println(mathUtil.calcSquare(5));
    }
}
