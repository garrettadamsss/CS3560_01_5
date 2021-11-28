
package com.example.loginform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;
import java.io.IOException;

public class Promotion {
    @FXML
    private Button button;
    @FXML
    private Label priceLabel;
    @FXML
    private Label itemNotFoundlabel;
    @FXML
    private Label productNameLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label invalidFormat;
    @FXML
    private TextField itemUPC;
   // @FXML
  //  private TextField changeQuantity;
    @FXML
    private TextField regularPrice;
    @FXML
    private TextField promoPrice;
    @FXML
    private Label regLabel;
    @FXML
    private Label promoLabel;


    @FXML
    public void onEnter(ActionEvent event) {
        try {
            Integer.parseInt(itemUPC.getText());
           if (connectButton(event))
                regularPrice.requestFocus();
        }
        catch (NumberFormatException e) {
            itemNotFoundlabel.setText("Not a valid UPC format");
        }
    }

    @FXML
    public void onEnter1(ActionEvent event) {
        promoPrice.requestFocus();
    }

    @FXML
    public void onPress(ActionEvent event) throws SQLException {
        updateRegularPrice();
    }


    public boolean connectButton(ActionEvent event) {

        boolean itemExists = true;

        String upc = itemUPC.getText();
        InventoryDataAccessor connectNow = new InventoryDataAccessor();
        Connection connectDB = connectNow.getConnection();


        String connectQuery = "SELECT * FROM grocery_store_inventory_subsystem.product WHERE upc =" + upc;
        //String connectQuery2 = "SELECT * FROM grocery_store_inventory_subsystem.managerpromo WHERE productUpc =" + upc;
        try {

            Statement statement = connectDB.createStatement();
            Statement statement1 = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            if (queryOutput.next()) {
                ResultSet queryOutput1 = statement.executeQuery(connectQuery);

                if (queryOutput1.next())
                    productNameLabel.setText(queryOutput1.getString("name"));

                priceLabel.setText(queryOutput1.getString("price"));

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




    public int currentInventory(ActionEvent event) {

        int itemQuantity = 0;
        String upc = itemUPC.getText();
        InventoryDataAccessor connectNow = new InventoryDataAccessor();
        Connection connectDB = connectNow.getConnection();

        try {
            String connectQuery = "SELECT * FROM grocery_store_inventory_subsystem.inventory WHERE upc=" + upc;
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                itemQuantity = queryOutput.getInt("quantity");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemQuantity;
    }

    public void updateRegularPrice()throws SQLException {
        String productUpc = itemUPC.getText();
        InventoryDataAccessor connectNow = new InventoryDataAccessor();
        Connection connectDB = connectNow.getConnection();
        PreparedStatement recordPromoInfo = null;
        String query = "INSERT INTO grocery_store_inventory_subsystem.managerpromo(productUpc, regularPrice, promoPrice)"
                + "VALUES (?, ?, ?)";

        recordPromoInfo = connectDB.prepareStatement(query);


        String query2 = "SELECT * FROM grocery_store_inventory_subsystem.managerpromo WHERE productUpc=" + productUpc;
        Statement statement = connectDB.createStatement();
        ResultSet queryOutput = statement.executeQuery(query2);

        String inputRegPrice = regularPrice.getText();
        String inputpromoPrice = promoPrice.getText();

        recordPromoInfo.setString(1, String.valueOf(productUpc));
        recordPromoInfo.setString(2, String.valueOf(inputRegPrice));
        recordPromoInfo.setString(3, String.valueOf(inputpromoPrice));
        recordPromoInfo.executeUpdate();

    }

    public void returnToMenu(ActionEvent event) throws IOException {
        GroceryApp m = new GroceryApp();
        m.changeScene("mainMenu.fxml");
    }

}
