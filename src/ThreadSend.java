class ThreadedSend extends Thread {
    private final String msg;
    final Sender sender;

    ThreadedSend(String m, Sender obj) {
        msg = m;
        sender = obj;
    }

    public void run() {
        synchronized (sender) {
            sender.send(msg);
        }
    }
}
