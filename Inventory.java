public class Inventory{
    boolean lowInventoryStatus;
    int productId;
    int quantity;

    //method accepts a positive or negative number and changes the product quantity.
    public static int change_Inventory(int changeInventory){

        return changeInventory;

    }
    //method accepts a productID and displays the quantity of the specified product.
    public static int view_Inventory(int viewInventory){

        return viewInventory;

    }
    //When lowInventoryStatus is true, a report is printed alerting low inventory of specified item.
    public static int print_Inventory_Report(int printInventoryReport){

        return printInventoryReport;

    }

}