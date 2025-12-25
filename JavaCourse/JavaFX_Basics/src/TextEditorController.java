import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import java.io.*;

public class TextEditorController {
    @FXML private TextArea textArea;

    // FILE MENU
    @FXML
    protected void handleSave() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(textArea.getScene().getWindow());
        if (file != null) {
            // High-Level Stream (BufferedWriter) wrapping a Low-Level Stream (FileOutputStream)
            try (FileOutputStream fos = new FileOutputStream(file);
                 OutputStreamWriter osw = new OutputStreamWriter(fos);
                 BufferedWriter writer = new BufferedWriter(osw)) {
                writer.write(textArea.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @FXML
    protected void handleOpen() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(textArea.getScene().getWindow());
        if (file != null) {
            // High-Level Stream (BufferedReader) wrapping a Low-Level Stream (FileInputStream)
            try (FileInputStream fis = new FileInputStream(file);
                 InputStreamReader isr = new InputStreamReader(fis);
                 BufferedReader reader = new BufferedReader(isr)) {
                String line;
                textArea.clear();
                while ((line = reader.readLine()) != null) {
                    textArea.appendText(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected void handleNew() { textArea.clear(); }
    @FXML
    protected void handleExit() { Platform.exit(); }


    // EDIT MENU
    @FXML protected void handleCut() { textArea.cut(); }
    @FXML protected void handleCopy() { textArea.copy(); }
    @FXML protected void handlePaste() { textArea.paste(); }
    @FXML protected void handleDelete() { textArea.replaceSelection(""); }
    @FXML protected void handleSelectAll() { textArea.selectAll(); }

    // HELP MENU
    @FXML
    protected void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Text Editor");
        alert.setHeaderText("JavaFX Text Editor v1.0");
        alert.setContentText("This is a simple text editor created for the exercise.\nAuthor: Student\nVersion: 2025");
        alert.showAndWait();
    }

}


