import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FileManager 
{
	//Composition
	private BankAccount account;
	private String fileName;
	private ReadFile reader;
	private FileWrite writer;
	
	public FileManager(BankAccount account)
	{
		this.account = account;
		this.fileName = this.account.getAccountNumber();
		reader = new ReadFile(this.fileName);
		writer = new FileWrite(this.fileName);
	}
	
	public String getFileName()
	{
		return this.fileName;
	}
	
	public boolean createAccountFile()
    {
        try 
        {
        	String writeString = "Bank Of Cowland\n" + account.toString() + "\n-------Transaction History-------\n   [Date]   [Type] [Amount]";
            writer.writeToFile(writeString);
            return true;
        }
        catch(Exception error)
        {

            JOptionPane.showConfirmDialog(null, 
            "File Failed To Create", ""
                , JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
	
	public boolean saveTransaction(String transactionType, double amount)
	{
		try 
        {
			ArrayList<String> currentContents = this.reader.getList();
			String withdrawOrDeposit = (transactionType.equals("withdraw")) ? "-" : "+";
			String oneLine = java.time.LocalDate.now() + " $" + withdrawOrDeposit + amount + " Balance: $" + this.account.getBalance();
			currentContents.add(oneLine);
			String writeString = String.join("\n", currentContents);
			writer.writeToFile(writeString);
			currentContents.set(Double.parseDouble(currentContents.get(3).replace("Balance: ", "")) + Double.parseDouble(withdrawOrDeposit + amount));
			
	        return true;
        }
		catch(Exception error)
        {
			JOptionPane.showConfirmDialog(null, 
            "No File Exists", ""
                , JOptionPane.ERROR_MESSAGE);
            return false;
        }
	}
	
	//print the account statement in the proper format
	//This format should mimic that of an actual bank account statement
	public void printStatement()
	{
		try {
			ArrayList<String> currentContents = this.reader.getList();
			String writeString = String.join("\n", currentContents);
			System.out.println(writeString);
		} 
		catch (Exception e) {
			JOptionPane.showConfirmDialog(null, 
		            "No File Exists", ""
		                , JOptionPane.ERROR_MESSAGE);
		    return;
		}
	}
	
	
	//Prints the statements for all BankAccount objects in accounts
	public void printStatement(BankAccount[] accounts)
	{
		for (BankAccount a : accounts)
		{
			FileManager tempFileManager = new FileManager(a);
			tempFileManager.printStatement();
		}
	}
	
}
