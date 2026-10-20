class MyTask implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyTask task1 = new MyTask();
        Thread t1 = new Thread(task1, "Thread 1");
        Thread t2 = new Thread(task1, "Thread 2");
        Thread t3 = new Thread(task1, "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}

