package JavaBasics.a8_Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try {
            System.out.println("TCP CLIENT");
            Socket clientSocket = new Socket("localhost", 12345); // Connect to the server on localhost:12345
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            // Client continuously listens for console input and sends it to the server
            while (true) {
                System.out.print("You: ");
                String message = consoleInput.readLine();
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                out.println(message);

                String response = in.readLine();
                System.out.println("ServerResponse: " + response);
            }

            in.close();
            out.close();
            consoleInput.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
