package com.mycompany.chatclient;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {

    private ChatClient client;
    private TextArea chatArea;
    private TextField inputField;

    @Override
    public void start(Stage stage) {

        chatArea = new TextArea();
        chatArea.setEditable(false);

        inputField = new TextField();
        inputField.setPromptText("Type your message...");

        Button sendButton = new Button("Send");

        HBox bottom = new HBox(10, inputField, sendButton);
        bottom.setPadding(new Insets(5));

        VBox root = new VBox(10, chatArea, bottom);
        root.setPadding(new Insets(10));

        try {
            client = new ChatClient("localhost", 5000);
        } catch (Exception e) {
            showError("Cannot connect to server");
            return;
        }

        sendButton.setOnAction(e -> sendMessage());
        inputField.setOnAction(e -> sendMessage());

        new Thread(this::receiveMessages).start();

        stage.setTitle("Chat Room");
        stage.setScene(new Scene(root, 400, 300));
        stage.show();
    }

    private void sendMessage() {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            client.sendMessage(message);
            inputField.clear();
        }
    }

    private void receiveMessages() {
        try {
            String msg;
            while ((msg = client.receiveMessage()) != null) {
                String finalMsg = msg;
                Platform.runLater(() ->
                        chatArea.appendText(finalMsg + "\n"));
            }
        } catch (Exception e) {
            Platform.runLater(() ->
                    chatArea.appendText("Disconnected from server\n"));
        }
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR, msg);
        alert.showAndWait();
        Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}
