import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    private final BlockingQueue<Integer> taskQueue;

    public Producer(BlockingQueue<Integer> sharedQueue) {
        this.taskQueue = sharedQueue;
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter < 10) {
            try {
                taskQueue.put(counter);
                System.out.println("Produced: " + counter);
                if (counter == 9) {
                    taskQueue.put(-1);
                }
                counter++;
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> taskQueue;

    public Consumer(BlockingQueue<Integer> sharedQueue) {
        this.taskQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int item = taskQueue.take();
                if(item == -1){
                    System.out.println("Done!!");
                    break;
                }
                System.out.println("Consumed: " + item);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ProducerConsumerPattern {
    public static void main(String[] args) {
        BlockingQueue<Integer> taskQueue = new ArrayBlockingQueue<>(5);
        Thread tProducer = new Thread(new Producer(taskQueue), "Producer");
        Thread tConsumer = new Thread(new Consumer(taskQueue), "Consumer");
        tProducer.start();
        tConsumer.start();
    }
}
