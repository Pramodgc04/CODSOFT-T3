import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }
}

class ATM {
    private final BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> checkBalance();
                case 2 -> performDeposit(scanner);
                case 3 -> performWithdrawal(scanner);
                case 4 -> {
                    exit = true;
                    System.out.println("Thank you for using the ATM. Visit Again!");
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    private void performDeposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void performWithdrawal(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}

public class ATMinterface{
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(500.00); 
        ATM atmMachine = new ATM(userAccount);

        atmMachine.showMenu();
    }
}
