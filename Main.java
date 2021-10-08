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

    public static int view_Product_Information(int productInfo){
        
        return productInfo;
    }

    public static int change_Inventory(int changeInventory){

        return changeInventory;

    }

    public static int view_Inventory(int viewInventory){

        return viewInventory;

    }

    public static int print_Inventory_Report(int printInventoryReport){

        return printInventoryReport;

    }

    public static boolean create_Special(Boolean createSpecial){
        boolean manager = true;
        boolean employee = false;

        if (manager){
        return true;
        }
        else if (employee){
            return false;
        }

        else{
            System.out.println("User does not have a valid employee ID");
        }

        return createSpecial;
    }

    public static boolean system_Log_In(Boolean systemLogIn){
        boolean validEmployee = true;

        if (validEmployee){
            return true;
        } else {
            return false;
        }
        

    }


}
