// performed on 1.10.26
/*q.2 Create a Java program using multiple threads to simulate bank transactions. 
One thread performs deposit operations, and another performs withdrawal operations, 
both printing transaction details simultaneously. */

class Account {
    int balance = 1000;

    synchronized void deposit(int amount){
        balance = balance + amount;
        System.out.println("Deposited:" + amount + " | Balance: " + balance);
    }

    synchronized void withdraw(int amount){
        if(balance >= amount){
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount + " | Balance: " + balance);
        }else{
            System.out.println("Insufficent Balance ");
        }
    }
}

class DepositThread extends Thread {
    Account account;

    public DepositThread(Account account) {
        this.account = account;
    }

    public void run(){
        for(int i=1; i<=5 ; i++){
            account.deposit(566);
        }
    }
}

class WithdrawThread extends Thread {
    Account account;

    WithdrawThread(Account account){
        this.account = account;
    }

    public void run(){
        for(int i=1; i<=5; i++){
            account.withdraw(689);
        }
    }
}

public class BankAccount{
    public static void main(String[] args) {
        Account account = new Account();

        DepositThread depositThread = new DepositThread(account);
        WithdrawThread withdrawThread = new WithdrawThread(account);

        depositThread.start();
        withdrawThread.start();
    }
}
