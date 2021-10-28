import javax.swing.JOptionPane;

public class CheckingAccount extends BankAccount 
{
	
	//ALL
	private int numChecks;
	private String typeOfChecks;
	private static final double WITHDRAW_LIMIT = 10000.0;
	private static double FEE = 5.0;
	
	public CheckingAccount()
	{
		super();
		numChecks = 10;
		typeOfChecks = "original";
	}
	
	public CheckingAccount(double balance, 
	          String firstName,
	          String lastName,
	          String accountNumber,
	          String email, int numChecks, String typeOfChecks)
	{
		super(balance, firstName, lastName, accountNumber, email);
		this.numChecks = numChecks;
		this.typeOfChecks = typeOfChecks;
		
	}
	
	public String toString()
	{
		return super.toString() 
				+ "\nNumber of Checks: " + this.numChecks 
				+ "\nType Of Checks: " + this.typeOfChecks;
	}
	
	public int getNumChecks()
	{
		return this.numChecks;
	}
	public void setNumChecks(int numChecks)
	{
		this.numChecks = numChecks;
	}
	
	public String getTypeOfChecks()
	{
		return this.typeOfChecks;
	}
	
	public void setTypeOfChecks(String typeOfChecks)
	{
		this.typeOfChecks = typeOfChecks;
	}
	
	//precondition: amount > 0
	//postcondition: the updated balance is returned
	public double deposit(double amount)
	{
			if(amount <= 15000)
				super.deposit(amount);
			else
			{
				//get approval
				String ans = JOptionPane.showInputDialog(null, 
						   "Type approve if it is approved");
				if(ans.equals("approve"))
					super.deposit(amount);
				else
					super.deposit(0);
			}
			
			return super.getBalance(); 
	}
		
	//precondition: amount > 0
	//postcondition: the updated balance is returned
	public double withdraw(double amount)
	{
		if(amount < super.getBalance() - CheckingAccount.FEE) 
		{
			if(amount <= CheckingAccount.WITHDRAW_LIMIT)
				super.withdraw(amount);
			else
			{
				//need approval
				String ans = JOptionPane.showInputDialog(null, 
						   "Type approve if it is approved");
				if(ans.equals("approve"))
				{  
					super.withdraw(amount);
					super.withdraw(CheckingAccount.FEE);
				}
			}
		
		}
		return super.getBalance();
	}
    
	
	


}
