import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) {
        try {
            // Connect to server using IP and port
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server");

            // Write to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Hello Server");

            String response = in.readLine();
            System.out.println("Server says: " + response);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}