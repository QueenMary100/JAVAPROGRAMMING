import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class MYConnection {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Load MySQL JDBC driver (optional in newer versions of JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Define the connection parameters
            String url = "jdbc:mysql://localhost:3306/bank"; 
            String username = "root"; 
            String password = "root"; 

            // Establish connection
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("Connection established successfully!");
            }

            // Create statement to execute SQL query
            Statement statement = connection.createStatement();
            
            // Executing a simple query
            String custQuery = "SELECT * FROM customer";
            ResultSet rs1 = statement.executeQuery(custQuery);

            // Create JFrame to display the JTable
            JFrame frame = new JFrame("Customer Data");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            
            // Create the JTable and DefaultTableModel
            String[] columnNames = {"Customer Name", "Customer City", "Customer Street"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            JTable table = new JTable(model);
            
            // Process ResultSet and add rows to the table model
            while (rs1.next()) {
                String customerName = rs1.getString("customer_name");
                String customerCity = rs1.getString("customer_city");
                String customerStreet = rs1.getString("customer_street");
                model.addRow(new Object[]{customerName, customerCity, customerStreet});
            }
            
            // Add JTable to JScrollPane
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane);

            // Display the JFrame
            frame.setVisible(true);

            // Close the ResultSet and statement
            rs1.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            }
        }
}
