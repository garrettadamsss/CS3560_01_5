package com.example.loginform;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.sql.*;

/**
 * This class is used to login to the inventory app.
 */

public class  Login {
    
    @FXML
    private Button button;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    public void onEnter(ActionEvent ae) {
        password.requestFocus();
    }

    @FXML
    public void onEnter1(ActionEvent ae) throws IOException {
        userLogin(ae);
    }
    @FXML
    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }
    @FXML
    private AnchorPane anchorPane;



    private void checkLogin() throws IOException {
        GroceryApp m = new GroceryApp();

        InventoryDataAccessor connectNow = new InventoryDataAccessor();
        Connection connectDB = connectNow.getConnection();

        String employeeUsername = username.getText();
        String employeePassword = password.getText();

        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement("SELECT * FROM grocery_store_inventory_subsystem.employee WHERE username=?");
            preparedStatement.setString(1, employeeUsername);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                button.setText("User not found");
                button.setTextFill(Color.RED);

            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    if (retrievedPassword.equals(employeePassword)) {
                        m.changeScene("mainMenu.fxml");
                    } else {
                        button.setText("Incorrect Password");
                        button.setTextFill(Color.RED);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}