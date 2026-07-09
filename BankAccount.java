import java.util.Scanner;
// Bank Account Class
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
            System.out.println("Deposit Successful!");
            System.out.println("Current Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful!");
            System.out.println("Current Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance or Invalid Amount!");
        }
    }
}
// ATM Class
class ATM {
    private BankAccount account;
    private Scanner scanner;
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }
    public void showMenu() {
        System.out.println("\n========== ATM MENU ==========");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
    public void run() {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid Choice! Please Try Again.");
            }
        } while (choice != 4);
    }
    private void checkBalance() {
        System.out.println("Current Balance: " + account.getBalance());
    }
    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }
    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}

// Main Class
class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int correctPin = 1234;
        System.out.println("==================================");
        System.out.println("      WELCOME TO ATM SYSTEM");
        System.out.println("==================================");
        System.out.print("Enter your 4-digit PIN: ");
        int enteredPin = sc.nextInt();
        if (enteredPin == correctPin) {
            BankAccount userAccount = new BankAccount(1000.0); // Initial Balance
            ATM atm = new ATM(userAccount);
            atm.run();
        } else {
            System.out.println("Incorrect PIN! Access Denied.");
        }
        sc.close();
    }
}