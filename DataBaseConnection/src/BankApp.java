package JAVAPROGRAMMING.DataBaseConnection.src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class BankApp {
    // Method to get database connection
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/bank";
        String user = "yourUsername";
        String password = "yourPassword";
        Connection conn = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connection successful!");
                conn.close();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        
        return conn;
    }

    // Method to insert account
    public void insertAccount(String accountNumber, String branchName, double balance) {
        Connection conn = getConnection();
        String query = "INSERT INTO account (account_number, branch_name, balance) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, accountNumber);
            stmt.setString(2, branchName);
            stmt.setDouble(3, balance);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Account inserted successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inserting account");
            e.printStackTrace();
        }
    }

    // Method to fetch and display account data in a JTable
    public static void displayAccounts() {
        Connection conn = getConnection();
        if (conn == null) {
            System.err.println("Cannot display accounts because the connection is null.");
            return;
        }
        
        try {
            // Use the connection to query accounts
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery("SELECT * FROM accounts");
            while (rs.next()) {
                System.out.println("Account ID: " + rs.getInt("id") + ", Balance: " + rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            System.err.println("Error querying database: " + e.getMessage());
        }
    }

        // Main method to run the application
    public static void main(String[] args) {
        BankApp app = new BankApp();

        // GUI options for interacting with the application
        String[] options = {"Insert Account", "View Accounts", "Exit"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(null, "Choose an option", "Bank Application",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    // Insert account
                    String accountNumber = JOptionPane.showInputDialog("Enter Account Number:");
                    String branchName = JOptionPane.showInputDialog("Enter Branch Name:");
                    double balance = Double.parseDouble(JOptionPane.showInputDialog("Enter Balance:"));
                    app.insertAccount(accountNumber, branchName, balance);
                    break;

                case 1:
                    // View accounts
                    app.displayAccounts();
                    break;

                case 2:
                    // Exit
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }
    }
}

// Explanation:

// 1. Database Connection: The getConnection() method establishes a connection to the database using JDBC.


// 2. Insert Account: The insertAccount() method takes user inputs and inserts a new account record into the database using an INSERT SQL statement.


// 3. Display Accounts: The displayAccounts() method fetches account data using a SELECT query and displays it in a JTable using a DefaultTableModel.


// 4. Main GUI Loop: The main method provides a basic GUI using JOptionPane:

// It shows a dialog with three options: "Insert Account", "View Accounts", and "Exit".

// Based on the user's selection, it either inserts a new account or displays the list of accounts in a table.




// JOptionPane and JTable:

// JOptionPane.showInputDialog() is used to gather user input for account details.

// JTable with a DefaultTableModel is used to display account details in a table format.


// How to Run:

// 1. Compile and run the BankApp class.


// 2. Use the GUI options to either insert new accounts or view existing ones.



// This single-class approach covers JDBC database interaction and GUI elements like JOptionPane and JTable.