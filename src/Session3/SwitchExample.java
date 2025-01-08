package Session3;

public class SwitchExample {
    public static void main(String[] args) {

        int NumberToWord = 2;
        switch (NumberToWord) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            default:
                System.out.println("Number is not 1, 2 or 3");
        }

        String WordToNumber = "two";
        switch (WordToNumber) {
            case "one":
                System.out.println("1");
                break;
            case "two":
                System.out.println("2");
                break;
            case "three":
                System.out.println("3");
                break;
            default:
                System.out.println("Number is not 1, 2 or 3");
        }
    }
}
