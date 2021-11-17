package com.example.loginform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;
import java.io.IOException;

/**
 * This class is where users  view inventory status and the quantity.
 * They also can change inventory by adding positive or negative values.
 */
public class Inventory {

    @FXML
    private Button button;
    @FXML
    private Label inventoryStatusLabel;
    @FXML
    private Label quantityLabel;
    @FXML
    private Label itemNotFoundlabel;
    @FXML
    private TextField itemUPC;
    @FXML
    private TextField changeQuantity;

    @FXML
    public void onEnter(ActionEvent event) {

        if (connectButton(event))
            changeQuantity.requestFocus();
    }

    @FXML
    public void onEnter1(ActionEvent event) {
        updateQuantity(event);
        itemUPC.requestFocus();
    }

    public boolean connectButton(ActionEvent event) {

        boolean itemExists = true;

        String upc = itemUPC.getText();
        InventoryDataAccessor connectNow = new InventoryDataAccessor();
        Connection connectDB = connectNow.getConnection();

        String connectQuery = "SELECT * FROM grocery_store_inventory_subsystem.inventory WHERE upc=" + upc;
        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            if (queryOutput.next()) {
                inventoryStatusLabel.setText(queryOutput.getString("inventory_status"));
                quantityLabel.setText(queryOutput.getString("quantity"));
                itemNotFoundlabel.setText("");
                itemExists = true;
            } else if (!(queryOutput.next())) {
                itemNotFoundlabel.setText("Item Not Found");
                itemExists = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemExists;
    }

    public void updateQuantity(ActionEvent event) {

        String upc = itemUPC.getText();
        InventoryDataAccessor connectNow = new InventoryDataAccessor();
        Connection connectDB = connectNow.getConnection();

        try {
            String newQuantity = changeQuantity.getText();
            PreparedStatement updatedStatement = connectDB.prepareStatement("update grocery_store_inventory_subsystem.inventory"
                    + " set quantity=quantity+?"
                    + "where upc =" + upc);

            updatedStatement.setString(1, newQuantity);
            updatedStatement.executeUpdate();

            String connectQuery = "SELECT * FROM grocery_store_inventory_subsystem.inventory WHERE upc=" + upc;
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                quantityLabel.setText(queryOutput.getString("quantity"));
            }
            inventoryStatusLabel.setText("");

            changeQuantity.clear();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void returnToMenu(ActionEvent event) throws IOException {
        GroceryApp m = new GroceryApp();
        m.changeScene("mainMenu.fxml");
    }
}
