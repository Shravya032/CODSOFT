import java.util.Scanner;

class BankAccount {
    private double balance;

    
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    
    public double getBalance() {
        return balance;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("deposit has to be positive. Try again.");
        }
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("insufficient balance");
        }
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;


    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }


    public void displayMenu() {
        System.out.println("\n====== Welcome to the ATM ======");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Exit");
    }


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
