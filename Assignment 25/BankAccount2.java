class BankAccount2 {
    static class Account2 {
        private int balance = 1000;
        private boolean depositTurn = true;

        synchronized void deposit(int amount) {
            while (!depositTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            balance += amount;
            System.out.println("Deposited: " + amount + " | Balance: " + balance);
            depositTurn = false;
            notifyAll();
        }

        synchronized void withdraw(int amount) {
            while (depositTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount + " | Balance: " + balance);
            } else {
                System.out.println("Insufficient Balance");
            }

            depositTurn = true;
            notifyAll();
        }
    }

    static class DepositThread2 extends Thread {
        private final Account2 account;

        DepositThread2(Account2 account) {
            this.account = account;
        }

        
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                account.deposit(500);
            }
        }
    }

    static class WithdrawThread2 extends Thread {
        private final Account2 account;

        WithdrawThread2(Account2 account) {
            this.account = account;
        }

        
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                account.withdraw(300);
            }
        }
    }

    public static void main(String[] args) {
        Account2 account = new Account2();

        DepositThread2 depositThread = new DepositThread2(account);
        WithdrawThread2 withdrawThread = new WithdrawThread2(account);

        depositThread.start();
        withdrawThread.start();
    }
}