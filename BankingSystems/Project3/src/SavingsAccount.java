import javax.swing.JOptionPane;

public class SavingsAccount extends BankAccount 
{
	
	private double interestRate;
	
	public SavingsAccount()
	{
		super();
		interestRate = .05;
	}
	
	public SavingsAccount(double balance, 
	          String firstName,
	          String lastName,
	          String accountNumber,
	          String email,double interestRate)
	{
		
		super(balance, firstName, lastName, accountNumber, email);
		this.interestRate = interestRate;
	}
	
	
	
	public double getInterestRate()
	{
		return this.interestRate;
	}
	
	
	public void setInterestRate(double interestRate)
	{
		this.interestRate = interestRate;
	}
	
	public String toString()
	{
		return  super.toString() +
				"\nInterest rate: " + this.getInterestRate();
	}
	
	//deposit and withdraw methods
	
	//deposit - only deposit amounts less than 5000 without 
	//the manager's approval
	
	//withdraw - only withdraw if amount < balance
	//If amount == balance ask the user if he/she wants to close
	//the account.  If yes, then withdraw all of the funds. 
	//If not, then do not withdraw any money (void the transaction)
	
	//precondition: amount > 0
	//postcondition: the updated balance is returned
	public double deposit(double amount)
	{
		if(amount < 5000)
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
	
	
	
	public double withdraw(double amount)
	{
		if(amount < super.getBalance())
			super.withdraw(amount);
		else
		{
			if(amount == super.getBalance())
			{
				String ans = JOptionPane.showInputDialog(null, "Close Account?: yes/no");
				if(ans.equals("yes"))
					super.withdraw(amount);
				else
					super.withdraw(0);
			}
		}
		return super.getBalance();
	}
	


}
