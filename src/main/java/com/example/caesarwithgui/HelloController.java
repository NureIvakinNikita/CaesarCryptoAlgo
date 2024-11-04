package com.example.caesarwithgui;

import com.example.caesarwithgui.dto.BruteForceResponse;
import com.example.caesarwithgui.dto.DecryptionResponse;
import com.example.caesarwithgui.service.CaesarCypherService;
import com.example.caesarwithgui.dto.EncryptionResponse;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    public TitledPane caesarMain;
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
    private TextArea resultAreaOutput;


    @FXML
    protected void onEncryptButtonClick() {
        String filePath = filePathInput.getText();
        String key = keyInput.getText();

        if (!filePath.isEmpty() && !key.isEmpty()) {
            EncryptionResponse response = CaesarCypherService.encrypt(filePath, key);
            resultAreaOutput.setText(response.toString());
        } else {
            resultAreaOutput.setText("Please provide both file path and key.");
        }
    }

    @FXML
    protected void onDecryptButtonClick() {
        String filePath = filePathInput.getText();
        String key = keyInput.getText();

        if (!filePath.isEmpty() && !key.isEmpty()) {
            DecryptionResponse response = CaesarCypherService.decrypt(filePath, key);
            resultAreaOutput.setText(response.toString());
        } else {
            resultAreaOutput.setText("Please provide both file path and key.");
        }
    }

    @FXML
    protected void onBruteForceButtonClick() {
        String filePath = filePathInput.getText();
        if (!filePath.isEmpty()) {
            BruteForceResponse response = CaesarCypherService.bruteForceDecrypt(filePath);
            resultAreaOutput.setText(response.toString());
        } else {
            resultAreaOutput.setText("Please provide file path.");
        }
    }

    @FXML
    protected void onExitButtonClick() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}