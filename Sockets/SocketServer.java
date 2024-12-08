import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
public static void main(String[] args) {
    try (ServerSocket servSocket = new ServerSocket(12345)) {
        System.out.println("Waiting for connection...");

        Socket clientSocket = servSocket.accept();
        System.out.println("Connection established!");

        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        } {
            String clientMessage;
            while(clientMessage = in.readline() != null){

                System.out.println("Client says: " + clientMessage);
               
                if((clientMessage.trim().equalsIgnoreCase("goodbye"))){
                    System.out.println("Goodbye connection closing");
                    System.out.println("client disconnected");
                    break;
                }
                System.out.println("Server"+clientMessage);
            }
        }catch(IOException e){
            System.out.println("Error in communication from client: " + e.getMessage());
        }
    } catch (Exception e) {
        // TODO: handle exception
        System.out.println(" Server error"+ e.getMessage());
    }
}
}
