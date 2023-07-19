package JavaBasics.a8_Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        try {
            System.out.println("TCP SERVER");
            ServerSocket serverSocket = new ServerSocket(12345); // Port number for communication
            System.out.println("Server started. Waiting for a client to connect...");

            Socket clientSocket = serverSocket.accept(); // Wait for a client to connect
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Server continuously listens for messages from the client
            while (true) {
                String message = in.readLine();
                if (message == null) {
                    System.out.println("Client disconnected.");
                    break;
                }
                System.out.println("Client: " + message);

                // Echo the message back to the client
                out.println("server received message - " + message);
            }

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
