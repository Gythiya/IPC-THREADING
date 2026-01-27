public class WaitNotifyDemo {

    // Shared resource
    static class Message {
        private String msg;
        private boolean available = false;

        synchronized void write(String message) throws InterruptedException {
            while (available) {
                wait(); // wait until message is read
            }
            msg = message;
            available = true;
            notify(); // notify reader
        }

        synchronized void read() throws InterruptedException {
            while (!available) {
                wait(); // wait until message is written
            }
            System.out.println("Received: " + msg);
            available = false;
            notify(); // notify writer
        }
    }

    // Writer task
    static class Sender implements Runnable {
        private final Message message;

        Sender(Message message) {
            this.message = message;
        }

        @Override
        public void run() {
            try {
                String[] msgs = {
                    "Hello",
                    "How are you?",
                    "wait notify demo",
                    "End"
                };

                for (String m : msgs) {
                    message.write(m);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Reader task
    static class Receiver implements Runnable {
        private final Message message;

        Receiver(Message message) {
            this.message = message;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 4; i++) {
                    message.read();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        Message sharedMessage = new Message();

        Thread senderThread = new Thread(new Sender(sharedMessage), "Sender");
        Thread receiverThread = new Thread(new Receiver(sharedMessage), "Receiver");

        senderThread.start();
        receiverThread.start();
    }
}
