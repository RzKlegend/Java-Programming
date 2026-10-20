// Renamed to Q1NumberPrinter to avoid duplicate class conflict in Assignment 25
class Q1NumberPrinter extends Thread {
    private String threadName;

    public Q1NumberPrinter(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " is printing number: " + i);
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }
        System.out.println(threadName + " has finished execution.");
    }
}

public class q1 {
    public static void main(String[] args) {
        System.out.println("Main thread started.");

        // Creating multiple threads
        Q1NumberPrinter thread1 = new Q1NumberPrinter("Thread-1");
        Q1NumberPrinter thread2 = new Q1NumberPrinter("Thread-2");
        Q1NumberPrinter thread3 = new Q1NumberPrinter("Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread ended.");
    }
}