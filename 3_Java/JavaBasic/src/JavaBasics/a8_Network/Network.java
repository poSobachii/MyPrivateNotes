package JavaBasics.a8_Network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Network {

    public static void main(String[] args) {
        getIpAddress();
        getSpecificPort();
    }


    private static void getIpAddress() {
        try {
            InetAddress googleAddress = InetAddress.getByName("www.google.com");
            System.out.println("Host Name: " + googleAddress.getHostName());
            System.out.println("IP Address: " + googleAddress.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Unable to resolve host");
        }
    }

    private static void getSpecificPort() {
        String serverName = "example.com";
        int portNumber = 80;

        try (Socket socket = new Socket(serverName, portNumber)) {
            // Connection established
            // Perform further operations
        } catch (IOException e) {
            // Handle exception
        }

    }
}
