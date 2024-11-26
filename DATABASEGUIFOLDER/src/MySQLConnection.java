
// import java.lang.*;
// import java.sql.Connection;
// import java.sql.Driver;
// import java.sql.SQLException;
// import java.sql.DriverManager;
import java.sql.*;

public class   MySQLConnection {

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

            //creating statement to execute sql query
            Statement statement = connection.createStatement();
            
            //executing a simple query
            String custquery = "SELECT * FROM customer";
            ResultSet rs1 = statement.executeQuery(custquery);

            //processing resultset

            System.out.println("The list of available customers is:");
                System.out.println("customer_name\t cucustomer_city\tcustomer_street");

            while(rs1.next()){
                String customername = rs1.getString("customer_name");
                String customercity = rs1.getString("customer_city");
                String customerstreet = rs1.getString("customer_street");

                System.out.println(customername + "\t\t" + customercity +"\t\t" + customerstreet );
            }

            //close the result
            rs1.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }

}
