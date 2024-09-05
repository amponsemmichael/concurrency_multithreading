class MyThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is in RUNNABLE state.");
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " woke up from sleep.");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }
}

public class ThreadLifeCycle {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        System.out.println("Thread1 state before start: " + thread1.getState()); // NEW
        thread1.start();
        thread2.start();

        System.out.println("Thread1 state after start: " + thread1.getState()); // RUNNABLE

        try {
            thread1.join(); // Main thread waits for thread1 to finish
            System.out.println("Thread1 state after join: " + thread1.getState()); // TERMINATED
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.interrupt();
    }
}

