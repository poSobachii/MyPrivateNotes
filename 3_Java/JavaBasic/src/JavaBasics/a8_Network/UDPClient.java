package JavaBasics.a8_Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try {
            System.out.println("UDPClient is running. Waiting for users input...");
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 8888;
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.print("You: ");
                String message = consoleInput.readLine();
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                byte[] sendData = message.getBytes();

                // Create a DatagramPacket to send data to the server
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                clientSocket.send(sendPacket);
                System.out.println("UDP Client sent message to server: " + message);

            }
            // Send empty request to force server shutdown
            clientSocket.send(new DatagramPacket(new byte[0], 0, serverAddress, serverPort));
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
