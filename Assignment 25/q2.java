// Class names prefixed with Q2 to avoid conflicts in the Assignment 25 folder
class Q2BankAccount {
    private double balance = 1000.0;

    // Synchronized deposit method
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of Rs. " + amount + " successful. Current Balance: Rs. " + balance);
        try {
            Thread.sleep(500); // Moves thread to Blocked/Waiting state
        } catch (InterruptedException e) {
            System.out.println("Deposit thread interrupted.");
        }
    }

    // Synchronized withdrawal method
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of Rs. " + amount + " successful. Current Balance: Rs. " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal of Rs. " + amount);
        }
        try {
            Thread.sleep(500); // Moves thread to Blocked/Waiting state
        } catch (InterruptedException e) {
            System.out.println("Withdrawal thread interrupted.");
        }
    }
}

// Deposit Thread
class Q2DepositThread extends Thread {
    private Q2BankAccount account;

    public Q2DepositThread(Q2BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(500.0);
        }
    }
}

// Withdrawal Thread
class Q2WithdrawThread extends Thread {
    private Q2BankAccount account;

    public Q2WithdrawThread(Q2BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.withdraw(300.0);
        }
    }
}

public class q2 {
    public static void main(String[] args) {
        System.out.println("Simulating Bank Transactions...");
        System.out.println("--------------------------------");

        Q2BankAccount account = new Q2BankAccount();

        // Creating threads (New state)
        Q2DepositThread depositTask = new Q2DepositThread(account);
        Q2WithdrawThread withdrawTask = new Q2WithdrawThread(account);

        // Starting threads (Runnable/Running state)
        depositTask.start();
        withdrawTask.start();

        try {
            depositTask.join();
            withdrawTask.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------------");
        System.out.println("All bank transactions completed.");
    }
}