import com.google.common.io.Files;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MyAppGUI {

    private DataHandler dataHandler = new DataHandler();
    private JFrame frame = new JFrame("Data Handling App");
    private JButton openButton = new JButton("Open File");
    private JPanel panelSouth = new JPanel();
    private JPanel panelCenter = new JPanel(new BorderLayout());

    // Constructor for initializing the GUI
    public MyAppGUI() {
        frame.setLayout(new BorderLayout());

        // Create a panel for the "Open File" button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        panelSouth.add(buttonPanel);

        // Add panels to the main frame
        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.add(panelCenter, BorderLayout.CENTER);
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Add ActionListener to the "Open File" button
        openButton.addActionListener(e -> openFile());

    }

    // Method to handle opening a file
    private void openFile() {
        String filePath = FileHandler.chooseFile();
        if (filePath != null) {
            try {
                ArrayList<Order> orders;
                // Check file extension and process accordingly
                if (Files.getFileExtension(filePath).equals("json")) {
                    orders = dataHandler.createListOfOrderFromJsonFile(filePath);
                     dataHandler.sortRegionAlpabetically(orders);
                } else if (Files.getFileExtension(filePath).equals("csv")) {
                    orders = dataHandler.createListOfOrderFromCsvFile(filePath);
                    dataHandler.sortRegionAlpabetically(orders);
                } else {
                    // Display a message for unsupported file types
                    JOptionPane.showMessageDialog(frame, "Unsupported file type");
                    return;
                }

                // Create a table model with the list of orders
                OrderTableModel model = new OrderTableModel(orders);
                JTable jt = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(jt);

                // Update the center panel to display the table
                panelCenter.removeAll();
                panelCenter.add(scrollPane, BorderLayout.CENTER);
                panelCenter.revalidate();

            } catch (IOException ex) {
                // Handles error messages
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error reading file: " + ex.getMessage());
            }
        }
    }
}
