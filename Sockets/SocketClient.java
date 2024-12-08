import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) {
        try (SocketClient client = new SocketClient("localhost", 12345)) {
            
            System.out.println("Connected to server!");
            Scanner scanner = new Scanner(System.in);
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
