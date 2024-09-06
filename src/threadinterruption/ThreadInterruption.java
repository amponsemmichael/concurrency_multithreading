package threadinterruption;

public class ThreadInterruption {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is running...");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            }
        });

        thread.start();

        try {
            Thread.sleep(3000); // Let the thread run for a while
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt(); // Interrupt the thread
    }
}

