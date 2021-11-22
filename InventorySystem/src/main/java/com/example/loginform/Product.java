package com.example.loginform;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Product {

    public void returnToMenu(ActionEvent event) throws IOException {
        GroceryApp m = new GroceryApp();
        m.changeScene("mainMenu.fxml");
    }

}
