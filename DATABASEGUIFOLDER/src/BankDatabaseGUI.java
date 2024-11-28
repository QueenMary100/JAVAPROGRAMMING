import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BankDatabaseGUI extends JFrame {

    private JComboBox<String> tableSelector;
    private final  JTable table1;
    private final  DefaultTableModel tableModel;

    // Database connection details
    private final String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/bank";
    private final String username = "root";
    private final String password = "root";  

    public BankDatabaseGUI() {
        setTitle("Bank Database Viewer");
        setSize(800, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a panel for the table selector
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        // Create a JComboBox to select which table to query
        tableSelector = new JComboBox<>(new String[]{"account", "branch", "customer", "depositor", "loan", "borrower", "employee"});
        panel1.add(tableSelector);

        // Create a JButton to trigger the table query
        JButton viewButton = new JButton("View Table");
        panel1.add(viewButton);

        // Add an action listener to the view button
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTable = (String) tableSelector.getSelectedItem();
                retrieveTableData(selectedTable);
            }
        });

        // Create a JTable to display data
        tableModel = new DefaultTableModel();
        table1 = new JTable(tableModel);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(table1);

        // Add components to the JFrame
        add(panel1, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to retrieve data from the selected table
    private void retrieveTableData(String tableName) {
        try {
            // Load MySQL JDBC driver (Optional for modern Java versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
                // Create SQL query to retrieve all data from the selected table
                String query = "SELECT * FROM " + tableName;
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                // Get column names
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                String[] columnNames = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    columnNames[i - 1] = metaData.getColumnName(i);
                }

                // Clear the previous data from the table model
                tableModel.setColumnIdentifiers(columnNames);
                tableModel.setRowCount(0);

                // Populate the table model with the data
                while (resultSet.next()) {
                    Object[] rowData = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        rowData[i - 1] = resultSet.getObject(i);
                    }
                    tableModel.addRow(rowData);
                }

                // Close the statement and result set
                resultSet.close();
                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error retrieving data from table: " + tableName, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "MySQL JDBC Driver not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // SwingUtilities.invokeLater(() -> {
        //     BankDatabaseGUI gui = new BankDatabaseGUI();
        //     gui.setVisible(true);
        // });

        BankDatabaseGUI gui = new BankDatabaseGUI();
        gui.setVisible(true);
    }
}