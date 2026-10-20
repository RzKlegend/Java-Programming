// Shared bank account resource
class Q26BankAccount {
    private double balance = 1000.0;

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: Rs. " + amount + " | Current Balance: Rs. " + balance);
        try { Thread.sleep(500); } catch (InterruptedException e) {}
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: Rs. " + amount + " | Current Balance: Rs. " + balance);
        } else {
            System.out.println("Insufficient funds for Rs. " + amount);
        }
        try { Thread.sleep(500); } catch (InterruptedException e) {}
    }
}

// Deposit operation implementing Runnable[cite: 13]
class DepositOperation implements Runnable {
    private Q26BankAccount account;

    public DepositOperation(Q26BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(500.0);
        }
    }
}

// Withdrawal operation implementing Runnable[cite: 13]
class WithdrawOperation implements Runnable {
    private Q26BankAccount account;

    public WithdrawOperation(Q26BankAccount account) {
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
        System.out.println("Simulating Bank Transactions using Runnable...");
        System.out.println("---------------------------------------------");

        Q26BankAccount account = new Q26BankAccount();

        // Passing Runnable tasks to Thread objects[cite: 13]
        Thread depositThread = new Thread(new DepositOperation(account));
        Thread withdrawThread = new Thread(new WithdrawOperation(account));

        // Starting execution[cite: 13]
        depositThread.start();
        withdrawThread.start();
    }
}