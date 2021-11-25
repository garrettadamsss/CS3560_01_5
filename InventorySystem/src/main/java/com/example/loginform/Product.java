package com.example.loginform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.xml.transform.Result;
import java.sql.*;
import java.io.IOException;

public class Product {

    @FXML
    private TextField itemUPC;
    @FXML
    private Label itemNotFound, nameLabel, priceLabel, departmentLabel, sizeLabel;
    @FXML
    private Button Menu;

    @FXML
    public void onEnter(ActionEvent event){
        try{
            Integer.parseInt(itemUPC.getText());
            connectButton(event);


        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public void connectButton(ActionEvent event){
       InventoryDataAccessor connectNow = new InventoryDataAccessor();
       Connection connectDB = connectNow.getConnection();
       String upc = itemUPC.getText();
       String connectQuery = "SELECT * FROM grocery_store_inventory_subsystem.product WHERE upc = " + upc;
       try {
           Statement statement = connectDB.createStatement();
           ResultSet queryOutput = statement.executeQuery(connectQuery);
           if(queryOutput.next()){
               nameLabel.setText(queryOutput.getString("name"));
               priceLabel.setText(queryOutput.getString("price"));
               departmentLabel.setText(queryOutput.getString("department"));
               sizeLabel.setText(queryOutput.getString("size_l_w_h"));
               itemNotFound.setText("");
           } else{
               itemNotFound.setText("Item not found!");
           }
       } catch(Exception e) {
           e.printStackTrace();

       }
    }

    public void returnToMenu(ActionEvent event) throws IOException {
        GroceryApp m = new GroceryApp();
        m.changeScene("mainMenu.fxml");
    }

}
