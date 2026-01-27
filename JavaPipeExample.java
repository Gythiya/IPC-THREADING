import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class JavaPipeExample {

    public static void main(String[] args) throws Exception {

        // Create pipe streams
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream(out);

        // Sender thread
        Thread sender = new Thread(() -> {
            try {
                String message = "Hello through Pipe";
                out.write(message.getBytes());
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Receiver thread
        Thread receiver = new Thread(() -> {
            try {
                int data;
                System.out.print("Receiver received: ");
                while ((data = in.read()) != -1) {
                    System.out.print((char) data);
                }
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        sender.start();
        receiver.start();
    }
}