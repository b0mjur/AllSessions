package Session7;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reversed("Portnov"));
    }
    static String reversed(String original) {
        String result = "";
        for (int i = original.length() -1; i >= 0; i--) {
            result += (original.charAt(i));
        }
        return "";
    }
}
