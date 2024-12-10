import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        try (ATM atm = new ATM(); Scanner sc = new Scanner(System.in)) {
            atm.start();
            boolean exit = false;
            while (!exit) {
                System.out.println("Choose an option: 1. Deposit 2. Withdraw 3. Check Balance 4. Exit");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        atm.deposit(depositAmount);
                    }
                    case 2 -> {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        atm.withdraw(withdrawAmount);
                    }
                    case 3 -> atm.checkBalance();
                    case 4 -> exit = true;
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            System.out.println("An error occurred. Exiting...");
            System.exit(1);
        }
    }
}

class ATM implements AutoCloseable {
    private double balance;

    public void start() {
        System.out.println("ATM started.");
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    @Override
    public void close() {
        System.out.println("ATM closed.");
    }
}
