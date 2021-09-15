public class BankingSystems {
	//All bank account must have:
	private double Balance; //every bank account needs a balance
 	private String FirstName, LastName; //every bank account needs a name
	private String AccountNumber; //every bank account also needs an AccountNumberentification--like credit card code
	private String Email; //you need contact informaton in every bank

	//default constructor, for when no values are passed in
	public BankingSystems() 
	{
		this.SetBalance(0.f);
		this.SetFirstName(null);
		this.SetLastName(null);
		this.SetAccountNumber(null);
		this.SetEmail(null);
	}

	//constructor overloading, for when you pass in values for the bank account
	public BankingSystems(
		double Balance, 
		String FirstName,
		String LastName,
		String AccountNumber,
		String Email,
	) 
	{
		// Balance = Balance is not right, because you're setting a dummy to a dummy.
		this.SetBalance(Balance);
		this.SetFirstName(FirstName);
		this.SetLastName(LastName);
		this.SetAccountNumber(AccountNumber);
		this.SetEmail(Email);
	}	
	//method

	//Getters
	public double GetBalance()
	{
		return this.Balance;
	}
	public String GetFirstName()
	{
		return this.FirstName;
	}
	public String GetLastName()
	{
		return this.LastName;
	}
	public String GetAccountNumber()
	{
		return this.Account;
	}
	public String GetEmail()
	{
		return this.Email;
	}

	//Setters
	public void SetBalance(double Balance)
	{
		this.Balance = Balance;
	}
	public void SetFirstName(String FirstName)
	{
		this.FirstName = FirstName;
	}
	public void SetLastName(String LastName)
	{
		this.LastName = LastName;
	}
	public void SetAccountNumber(String AccountNumber)
	{
		this.AccountNumber = AccountNumber;
	}
	public void SetEmail(String Email)
	{
		this.Email = Email;
	}
}