import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class bankConnection{

    //private static  Connection conn = DriverManager.getConnection("jdbc://locahost:3306/bank", "root", "root");
    public static Connection getConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/bank";
            String user = "root";
            String passwoord = "root";

            conn = DriverManager.getConnection(url, user, passwoord);
            System.out.println("Connection Successful");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Connecting to the database");
            e.printStackTrace();
            System.out.println("Error connecting to the database");
        }

        return conn;
    }

    public static void main(String[] args) {
        bankConnection app1 = new bankConnection();
        
        

    }

}
