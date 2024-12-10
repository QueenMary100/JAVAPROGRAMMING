import java.util.Scanner;
import java.net.Socket;
import java.nio.Buffer;
import java.io.*;

public class SocketClient {
    public static void main(String[] args) {

        try (Socket clientSocket = new Socket("localhost", 12345)) {

            System.out.println("Connected to server!");//waiting for connection to be established
           
            try {
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                
                String message;
                while (true) {
                    System.out.println("Enter a message to send to the server (or 'exit' to quit):");
                    message = userInput.readLine();
                    System.out.println(message);

                    if(message.trim().equalsIgnoreCase("goodbye")) {
                        System.out.println("Goodbye connection closing");
                        System.out.println("Disconnecting from server...");
                        break;
                    }
                    out.println(message);
                    String serverResponse = in.readLine();
                    System.out.println(serverResponse);
                }
            } catch(IOException e) {
                System.out.println("Error in communication" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Client error"+ e.getMessage());
            e.printStackTrace();
        }
    }
}
