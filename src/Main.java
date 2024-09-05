class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running using Thread class.");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
