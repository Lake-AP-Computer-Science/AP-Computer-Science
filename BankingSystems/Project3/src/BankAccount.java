
public class BankAccount extends Object 
{
	//ALL
	
	//data
	private double balance;
	private String firstName, lastName;
	private String accountNumber;
	private String email;
	
	//constructor
	public BankAccount()//default
	{
		super();
		
		this.setBalance(0.0);
		this.setFirstName(null);
		this.setLastName(null);
		this.setAccountNumber(null);
		this.setEmail(null);
		
	}
	
	
	 public BankAccount(double balance, 
			          String firstName,
			          String lastName,
			          String accountNumber,
			          String email)
	{
		super();
		this.setBalance(balance);
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.email = email;
	}
	
	
	//methods
	public double getBalance()
	{
		return this.balance;
	}
	
	
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getAccountNumber()
	{
		return this.accountNumber;
	}
	
	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	
	public String toString()
	{
		return super.toString()+
				"\nName: " + this.getFirstName() + " " + this.getLastName()+
				"\nBalance: " + this.getBalance() +
				"\nAccount Number: " + this.getAccountNumber()+
				"\nEmail: " + this.getEmail();
	}
	
	
	public boolean equals(Object o)
	{
		BankAccount other = (BankAccount)o;
		
		return this.getBalance() == other.getBalance();
	
	}
	
	
	//deposit and withdraw methods
	
	//precondition: amount > 0
	//postcondition: the updated balance is returned
	
	public double deposit(double amount)
	{
		this.setBalance(this.getBalance() + amount);
		return this.getBalance();
	}
	
	public double withdraw(double amount)
	{
		this.setBalance(this.getBalance() - amount);
		return this.getBalance();
	}

}
