
public class PrimeSavingsAccountC extends Object 
{
	
	//Composition
	
	private SavingsAccount save;
	

	public PrimeSavingsAccountC()
	{
		save = new SavingsAccount();
		this.applyMultiplier(2);
	}
	
	
	public  PrimeSavingsAccountC(double balance, 
	          String firstName,
	          String lastName,
	          String accountNumber,
	          String email, double interestRate)
	{
		save = new SavingsAccount(balance, firstName, lastName,
				accountNumber, email, interestRate);
		this.applyMultiplier(2);
		
	}
	
	//helper method no accessible outside this class
	private void applyMultiplier(int multiplier)
	{
		save.setInterestRate(save.getInterestRate() * multiplier);
	}
	
	
	public double deposit(double amount)
	{
		return save.deposit(amount);
	}
	
	public double withdraw(double amount)
	{
		return save.withdraw(amount);
	}
	

	public String toString()
	{
		return save.toString();
	}
	
	public double getBalance()
	{
		return save.getBalance();
	}
	
	public String getFirstName()
	{
		return save.getFirstName();
	}
}
