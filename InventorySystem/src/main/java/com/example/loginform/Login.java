package com.example.loginform;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

/**
 * This class is used to login to the inventory app.
 */
public class Login {

    public Login() {

    }

    @FXML
    private Button button;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    public void onEnter(ActionEvent ae)  {
        password.requestFocus();
    }

    @FXML
    public void onEnter1(ActionEvent ae) throws IOException {
        userLogin(ae);
    }

    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        GroceryApp m = new GroceryApp();
        if(username.getText().equals("stocker") && password.getText().equals("123")) {
            wrongLogin.setText("Success!");

            m.changeScene("mainMenu.fxml");
        }

        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogin.setText("Please enter your data.");
        }


        else {
            wrongLogin.setText("Wrong username or password!");
        }
    }


}