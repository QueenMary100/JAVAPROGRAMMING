import java.net.ServerSocket;

public class SocketServer {
public static void main(String[] args) {
    try (ServerSocket servSocket = new ServerSocket(12345);) {
        System.out.println("Waiting for connection...");
        SocketClient clientSocket = servSocket.accept()
        System.out.println("Connection established!");
        
    } catch (Exception e) {
        // TODO: handle exception
    }
}
}
