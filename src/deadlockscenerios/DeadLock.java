package deadlockscenerios;

public class DeadLock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            System.out.println("Lock1 acquired by method1");
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            synchronized (lock2) {
                System.out.println("Lock2 acquired by method1");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println("Lock2 acquired by method2");
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            synchronized (lock1) {
                System.out.println("Lock1 acquired by method2");
            }
        }
    }

    public static void main(String[] args) {
        DeadLock example = new DeadLock();
        Thread t1 = new Thread(example::method1);
        Thread t2 = new Thread(example::method2);

        t1.start();
        t2.start();
    }
}

