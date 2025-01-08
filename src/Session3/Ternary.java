package Session3;

public class Ternary {
    public static void main(String[] args) {
        int num1 = 25;
        int num2 = 20;
        int result;

        //add some explanation of the line 10
        // If num1 is less than num2, then add num1 and num2, otherwise subtract num2 from num1
        result = (num1 < num2) ? (num1 + num2) : (num1 - num2);
        System.out.println("Result: " + result);
    }
}
