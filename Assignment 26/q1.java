// First task implementing Runnable
class TaskOne implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Task One executing step: " + i);
            try { Thread.sleep(400); } catch (InterruptedException e) {}
        }
    }
}

// Second task implementing Runnable
class TaskTwo implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Task Two executing step: " + i);
            try { Thread.sleep(600); } catch (InterruptedException e) {}
        }
    }
}

public class q1 {
    public static void main(String[] args) {
        System.out.println("Starting simultaneous tasks...");
        
        // The Runnable object is passed to a Thread object
        Thread thread1 = new Thread(new TaskOne());
        Thread thread2 = new Thread(new TaskTwo());
        
        // Starts execution using the start() method
        thread1.start();
        thread2.start();
    }
}