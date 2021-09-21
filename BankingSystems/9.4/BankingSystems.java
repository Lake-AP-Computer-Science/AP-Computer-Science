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

	//deposit and withdraw functions
	public double Deposit(double Amount)
    {
        this.SetBalance(this.GetBalance() + amount);
        return this.GetBalance();
    }

    public double Withdraw(double Amount)
    {
        this.SetBalance(this.GetBalance() - amount);
        return this.GetBalance();
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

	//method overriding: overriding the parent's method (in this case overriding the Object's toString() method).
	// this is a FULL OVERRIDE: a full override has nothing to do in the parent's original function
	public String toString()
	{
		return "Name: " + this.GetFirstName() + " " + this.GetLastName() + 
			"\nBalance: " + this.GetBalance() +
			"\nAccount Number: " + this.GetAccountNumber()
			"\nEmail: " + this.GetEmail();
	}

	/* Partial override, you still need the parent's override
	public String toString()
	{
		return super.toString() + "...";
	}
	*/

	/*
	If the child class's need is exactly like its parent: don't override
	If the child class's need is somewhat like its parent: override with super
	If the child class's need is nothing like its parent: full override
	*/

	public boolean equals(Object OtherAccount)
	{
		BankingSystems OtherAccount = (BankingSystems)OtherAccount; //cast the other object to a bankaccount
		
		/*
		What is casting?

		Its essencially making something of type Object into a type you want.

		The parameter passed in is a type of Object, and therefore it is the "god".
		It doesn't have the methods GetBalance() built into it, since it is the toplevel
		What we want is an OtherAccount of BankingSystems, so we ensure that the
		object passed in is one of BankingSystems before calling its getBalance()
		*/
		
		if (OtherAccount == null) //ensure the object didn't fail cast and is not null
			return false;

		return this.GetBalance() == OtherAccount.GetBalance(); //if it is true return true else return false
	}

}