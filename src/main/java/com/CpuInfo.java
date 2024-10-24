package com;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CpuInfo {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
