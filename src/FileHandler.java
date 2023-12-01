import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileHandler {

    // Method to open a file chooser dialog and return the selected file's absolute path
    public static String chooseFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(" Choose json or csv file ", "csv", "json");
        fileChooser.setFileFilter(filter);

        // Show the open file dialog
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            // Return null if the user canceled the file selection
            return null;
        }
    }
}