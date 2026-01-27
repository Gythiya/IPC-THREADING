import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AsyncManualCommunication {

    // Message queue (mailbox)
    private static final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    private static volatile boolean running = true;

    public static void main(String[] args) {

        // Receiver thread (background)
        Thread receiver = new Thread(() -> receiveMessages());
        receiver.start();

        // Sender (user input)
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Sender: Enter message (type 'exit' to stop): ");
            String msg = sc.nextLine();

            if (msg.equalsIgnoreCase("exit")) {
                running = false;
                break;
            }

            sendMessage(msg);
        }

        sc.close();
        System.out.println("Sender stopped.");
    }

    // Non-blocking send
    static void sendMessage(String msg) {
        queue.add(msg);
        System.out.println("Sender: Message added to queue");
    }

    // Receiver checks whenever it is interested
    static void receiveMessages() {
        while (running || !queue.isEmpty()) {

            String msg = queue.poll();
            if (msg != null) {
                System.out.println("Receiver: Message received -> " + msg);
            }

            try {
                Thread.sleep(3000); // receiver checks periodically
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Receiver stopped.");
    }
}