package Session12.BankingSystem;

import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        System.out.println("Choose an account");
        System.out.println("1. Checking ");
        System.out.println("2. Savings");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter holder's name");
        String accountHolderName = scanner.nextLine();
        System.out.println("Enter initial balance");
        double balance = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter overdraft limit: ");
            double overdraftLimit = scanner.nextDouble();
            account = new CheckingAccount(accountNumber, accountHolderName, balance, overdraftLimit);
        } else if (choice == 2) {

        }
        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.println("Choose an option");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 4:
                    account.displayAccountData();
                    break;
                case 5:
                    break;

            }
        }
    }
}
