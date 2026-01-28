import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) {
        try {
            // Server listens on port > 1024
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            // Wait for client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Read from client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Write to client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message = in.readLine();
            System.out.println("Client says: " + message);

            out.println("Hello Client, message received");

            // Close resources
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}