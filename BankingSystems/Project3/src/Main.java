public class Main 
{

    public static void main(String[] args) 
    {
        BankAccount account = new BankAccount(1000, "Larry", "Johnson", "2834887483", "LarryJohnson@gmail.com");
        FileManager manager = new FileManager(account);
        
        manager.saveTransaction("deposit", 1000);
    }
}