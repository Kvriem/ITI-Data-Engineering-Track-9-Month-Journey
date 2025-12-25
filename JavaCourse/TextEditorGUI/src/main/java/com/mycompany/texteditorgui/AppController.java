/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.texteditorgui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.*;

/**
 * FXML Controller class
 *
 * @author COMPUMARTS
 */



public class AppController {

    @FXML
    private TextArea textArea;

    private File currentFile;


    @FXML
    public void handleNew() {
        textArea.clear();
        currentFile = null;
    }

    @FXML
public void handleOpen() {
    FileChooser chooser = new FileChooser();
    chooser.setTitle("Open File");
    File file = chooser.showOpenDialog(null);

    if (file != null) {
        try (FileInputStream fis = new FileInputStream(file)) {

            byte[] data = fis.readAllBytes();
            textArea.setText(new String(data));
            currentFile = file;

        } catch (IOException e) {
            showError("Cannot open file");
        }
    }
}


    @FXML
    public void handleSave() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save As");

        File file = chooser.showSaveDialog(null);

        if (file != null) {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(textArea.getText().getBytes());
                currentFile = file;
            } catch (IOException e) {
                showError("unknown err mr/kariem");
            }
        }
    }
    
    

    @FXML
    public void handleExit() {
        System.exit(0);
    }


    @FXML public void handleCut() { textArea.cut(); }
    @FXML public void handleCopy() { textArea.copy(); }
    @FXML public void handlePaste() { textArea.paste(); }
    @FXML public void handleDelete() { textArea.replaceSelection(""); }
    @FXML public void handleSelectAll() { textArea.selectAll(); }


    @FXML
    public void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setContentText("Kariem's text editor");
        alert.showAndWait();
    }

    private void showError(String msg) {
        new Alert(Alert.AlertType.ERROR, msg).show();
    }
}
