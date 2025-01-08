package Session3;

import java.util.Scanner;

public class ifSample {
    public static void main(String[] args) {
        //A == 90+
        //B == 80+
        //C == 70+
        //D == 60+
        //F == 0-59
        // scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your score: ");
        int score = scanner.nextInt();
        scanner.close();

        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
