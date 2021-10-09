abstract class Account{
    
    String username;
    String password;
    int ID; 
    Boolean isManager; 

    public Account(String username, String password, int ID, Boolean isManager){
        this.username = username;
        this.password = password;
        this.ID = ID; 
        this.isManager = isManager; 
    }
    

}