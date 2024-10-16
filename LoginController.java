package com.example.test1b;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    private static final int MAX_ATTEMPTS = 5;
    public TextField usernameField;
    public TextField passwordField;
    private int failedAttempts =0;

    public void Login(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Implement authentication logic here

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Please Provide Username or Password");

        }
        if (failedAttempts >= MAX_ATTEMPTS){
            showAlert("Sorry, Your Account is Locked!!!");
            return;
        }else if (username.equals("YOUR_FIRST_NAME") && password.equals("456")) {
            showAlert("Success!!!");
            failedAttempts = 0;
        } else {
            failedAttempts++;
            int MAX_ATTEMPTS = 5;
            int remainingAttempts = MAX_ATTEMPTS - failedAttempts; // Calculate remaining attempts
            if (remainingAttempts > 0) {
                showAlert("Sorry, Invalid Username or Password. You have " + remainingAttempts + " attempts left.");
            } else {
                showAlert("Sorry, Invalid Username or Password");
            }

            // Implement account locking logic if needed
        }}

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }
}

