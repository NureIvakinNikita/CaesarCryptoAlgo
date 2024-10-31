package com.example.caesarwithgui;

import com.example.caesarwithgui.service.CaesarCypherService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label filePath;
    @FXML
    private Label key;

    @FXML
    private TextField filePathInput;
    @FXML
    private TextField keyInput;

    @FXML
    private Button encryptButton;
    @FXML
    private Button decryptButton;
    @FXML
    private Button bruteForceButton;
    @FXML
    private Button exitButton;

    @FXML
    private TextArea resultArea;


    @FXML
    protected void onEncryptButtonClick() {
        String filePath = filePathInput.getText();
        String key = keyInput.getText();

        if (!filePath.isEmpty() && !key.isEmpty()) {
            CaesarCypherService.encrypt(filePath, key);
            resultArea.setText("Decryption completed.");
        } else {
            resultArea.setText("Please provide both file path and key.");
        }
    }

    @FXML
    protected void onDecryptButtonClick() {

    }

    @FXML
    protected void onBruteForceButtonClick() {

    }

    @FXML
    protected void onExitButtonClick() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}