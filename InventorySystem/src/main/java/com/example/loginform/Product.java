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
<<<<<<< HEAD
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
                sizeLabel.setText(queryOutput.getString("weight"));
                itemNotFound.setText("");
            } else{
                itemNotFound.setText("Item not found!");
            }
        } catch(Exception e) {
            e.printStackTrace();

        }
=======
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
               sizeLabel.setText(queryOutput.getString("weight"));
               itemNotFound.setText("");
           } else{
               itemNotFound.setText("Item not found!");
           }
       } catch(Exception e) {
           e.printStackTrace();

       }
>>>>>>> 6bb24728d82c53999fbe6601dc3a6e031bf8a193
    }

    public void returnToMenu(ActionEvent event) throws IOException {
        GroceryApp m = new GroceryApp();
        if(Login.positionID == 11) {
            m.changeScene("mainMenu.fxml");
        } else {
            m.changeScene("mainEmployeeMenu.fxml");
        }

    }

}