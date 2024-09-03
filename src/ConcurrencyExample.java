// Concurrency example using Runnable

public class ConcurrencyExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task("Task 1"));
        Thread thread2 = new Thread(new Task("Task 2"));

        thread1.start();
        thread2.start();
    }
}
