package Session10;

public class EncapsulationBankAccount {
    private double balance;

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    //deposit (>0, balance + amount)
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(amount);
            System.out.println("Deposit successfully! " + amount);
        } else {
            System.out.println("Amount must be greater than 0!");
        }
    }

    //withdraw (<= balance && amount>0, balance - amount)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            setBalance(balance - amount);
            System.out.println("Withdraw successfully! " + amount);
        } else {
            System.out.println("Amount must be greater than 0 and less than balance!");
        }
    }

    public static void main(String[] args) {
        EncapsulationBankAccount ba = new EncapsulationBankAccount();
        ba.deposit(100);
        ba.withdraw(50);
    }
}
