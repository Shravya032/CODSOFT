import java.util.Scanner;

class BankAccount {
    private double balance;

    
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Wanna see how much dough you got?
    public double getBalance() {
        return balance;
    }

    // Throwing more money in your account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("deposit has to be positive. Try again.");
        }
    }

    // Time to take some cash out
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("insufficeint balance");
        }
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    // ATM needs to know whose cash it's messin' with
    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    // The oh-so-fancy menu
    public void displayMenu() {
        System.out.println("\n====== Welcome to the ATM ======");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Exit");
    }

    // The main loop - it's like Groundhog Day until you bail
    public void run() {
        int option;
        do {
            displayMenu();
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    showBalance();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleWithdrawal();
                    break;
                case 4:
                    System.out.println("Thanks for using the ATM. Peace out!");
                    break;
                default:
                    System.out.println(" Try again.");
            }
        } while (option != 4);
    }

    private void showBalance() {
        System.out.println("Current Balance: ₹" + account.getBalance());
    }

    private void handleDeposit() {
        System.out.print("How much you wanna deposit? ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void handleWithdrawal() {
        System.out.print("How much you wanna withdraw? ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}