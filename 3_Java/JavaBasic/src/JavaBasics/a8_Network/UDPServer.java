package JavaBasics.a8_Network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(8888);
            byte[] receiveBuffer = new byte[1024];                      // Create a buffer to hold incoming data

            // Create a DatagramPacket to receive data from the client
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            System.out.println("UDP Server is running. Waiting for incoming data...");
            while (true) {
                serverSocket.receive(receivePacket);        // Receive data from the client
                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                if(receivedMessage.isEmpty()) {
                    break;
                }
                System.out.println("Received message from client: " + receivedMessage);
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
