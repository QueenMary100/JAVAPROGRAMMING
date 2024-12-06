import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try (Socket link = new Socket("localhost",8080);){
            
            DataInputStream dis = new DataInputStream(link.getInputStream());
            DataOutputStream dos = new DataOutputStream(link.getOutputStream());

            //sending and recieving messages
            System.out.println("Enter you message: ");
            String note = sc.nextLine();
            dos.writeUTF(note);
            System.out.println("Message to server " + note);

            String Servermessage = dis.readUTF();
            System.out.println("The Server info is: " + Servermessage);

            link.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
