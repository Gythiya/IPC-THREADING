public class SynchronousCommunication {

    private static String message = null;
    private static boolean messageAvailable = false;

    // 🔴 Shared lock object
    private static final Object lock = new Object();

    public static void main(String[] args) {

        Thread receiver = new Thread(() -> receive());
        Thread sender = new Thread(() -> send("Hello from Sender"));

        receiver.start();

        try {
            Thread.sleep(1000); // ensure receiver waits first
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        sender.start();
    }

    // Blocking send
    static void send(String msg) {
        synchronized (lock) {
            while (messageAvailable) {
                try {
                    lock.wait(); // ✅ correct
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            message = msg;
            messageAvailable = true;
            System.out.println("Sender sent: " + msg);
            lock.notify(); // ✅ correct
        }
    }

    // Blocking receive
    static void receive() {
        synchronized (lock) {
            while (!messageAvailable) {
                try {
                    lock.wait(); // ✅ correct
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println("Receiver received: " + message);
            messageAvailable = false;
            lock.notify(); // ✅ correct
        }
    }
}