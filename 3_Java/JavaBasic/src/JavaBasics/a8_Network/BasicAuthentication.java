package JavaBasics.a8_Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

public class BasicAuthentication {
    public static void main(String[] args) {
        String username = "your_username";
        String password = "your_password";
        String credentials = username + ":" + password;              // Encode the username and password in Base64
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        String authorizationHeader = "Basic " + encodedCredentials;     // Set the "Authorization" header with the encoded credentials
        String url = "https://api.example.com/data";
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("curl", "-X", "GET", url, "-H", "Authorization: " + authorizationHeader);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
