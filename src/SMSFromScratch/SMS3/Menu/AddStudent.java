package SMSFromScratch.SMS3.Menu;

import java.util.Scanner;

public class AddStudent {
    private Scanner scanner;

    public void execute() {
        System.out.println("Enter student type (1 for Graduate, 2 for Undergraduate): ");
        int type = scanner.nextInt();
        scanner.nextLine();
    }
}
