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

    public MyAppGUI() {
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        panelSouth.add(buttonPanel);

        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.add(panelCenter, BorderLayout.CENTER);
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        openButton.addActionListener(e -> openFile());

    }

    private void openFile() {
        String filePath = FileHandler.chooseFile();
        if (filePath != null) {
            try {
                ArrayList<Order> orders;

                if (Files.getFileExtension(filePath).equals("json")) {
                    orders = dataHandler.createListOfOrderFromJsonFile(filePath);
                     dataHandler.sortRegionAlpabetically(orders);
                } else if (Files.getFileExtension(filePath).equals("csv")) {
                    orders = dataHandler.createListOfOrderFromCsvFile(filePath);
                    dataHandler.sortRegionAlpabetically(orders);
                } else {
                    JOptionPane.showMessageDialog(frame, "Unsupported file type");
                    return;
                }

                OrderTableModel model = new OrderTableModel(orders);
                JTable jt = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(jt);

                panelCenter.removeAll();
                panelCenter.add(scrollPane, BorderLayout.CENTER);
                panelCenter.revalidate();

            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error reading file: " + ex.getMessage());
            }
        }
    }
}
