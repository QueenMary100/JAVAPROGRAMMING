import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args) {
        //create a server object
       

        try( ServerSocket servSocket = new ServerSocket(8080);) 
            {
            System.out.println("Waiting for connection...");
            Socket link = servSocket.accept();
            System.out.println("Connection established!");

            DataInputStream dis = new DataInputStream(link.getInputStream());
            DataOutputStream dos = new DataOutputStream(link.getOutputStream());

            //Sending and receiving messages
            String message = dis.readUTF();
            System.out.println("The client says : " + message);

            //sending to the client
            String Clientsms = "Hello , Client";
            dos.writeUTF(Clientsms);
            System.out.println("Message to client " + Clientsms);

            servSocket.close();
            link.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}