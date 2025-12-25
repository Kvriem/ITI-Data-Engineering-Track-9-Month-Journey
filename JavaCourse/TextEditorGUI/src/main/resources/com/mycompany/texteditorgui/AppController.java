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

    // -------- File Menu --------

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
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                textArea.clear();
                String line;
                while ((line = br.readLine()) != null) {
                    textArea.appendText(line + "\n");
                }
                currentFile = file;
            } catch (IOException e) {
                showError("Cannot open file");
            }
        }
    }

    @FXML
    public void handleSave() {
        if (currentFile == null) {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Save File");
            currentFile = chooser.showSaveDialog(null);
        }

        if (currentFile != null) {
            try (FileOutputStream fos = new FileOutputStream(currentFile)) {
                fos.write(textArea.getText().getBytes());
            } catch (IOException e) {
                showError("Cannot save file");
            }
        }
    }

    @FXML
    public void handleExit() {
        System.exit(0);
    }

    // -------- Edit Menu --------

    @FXML public void handleCut() { textArea.cut(); }
    @FXML public void handleCopy() { textArea.copy(); }
    @FXML public void handlePaste() { textArea.paste(); }
    @FXML public void handleDelete() { textArea.replaceSelection(""); }
    @FXML public void handleSelectAll() { textArea.selectAll(); }

    // -------- Help Menu --------

    @FXML
    public void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Simple Text Editor");
        alert.setContentText(
                "Version 1.0\n" +
                "JavaFX Text Editor\n" +
                "ITI – JETS"
        );
        alert.showAndWait();
    }

    private void showError(String msg) {
        new Alert(Alert.AlertType.ERROR, msg).show();
    }
}
