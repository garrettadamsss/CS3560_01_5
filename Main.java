//Skeleton for Group Project
//Grocery Store Inventory Subsystem
/*
    Group Members
---------------------
    David Sarkisian
    Garrett Adams
    Michael Hessler
    Chris Tcherkezian
    Nachiket Patel
*/


public class Main{

    public static void main(String args[]){
        
    }

    //method accepts a product ID and returns productInfo data.
    public static int view_Product_Information(int productID){
        
        return productInfo;
    }
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
     /*method validates that manager = true; when called and assigns a start date and end date.
    Also, a short description must be added to describe the special.*/
    public static boolean create_Special(Boolean IsManager){
        //if user is validated as manager then create_Special can be implemented.
        if (isManager == true){
        return true;
        }
        else if(isManager) == false){
            return false;
        }

        else{
            System.out.println("User does not have a valid employee ID");
        }

        return createSpecial;
    }
    //Method accepts username and passcode and compares these values with username and passcode in the database.
    public static boolean system_Log_In(Boolean systemLogIn){
        boolean validEmployee = true;
        //returns true if username and passcode match. 
        if (validEmployee){
            return true;
        } else {
            return false;
        }
        

    }


}
