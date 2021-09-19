
public class CheckingAccount extends BankingSystems {
    private int NumberOfChecks;
    private String TypeOfChecks;

    //default constructor
    public CheckingAccount()
    {
        super();

        this.setNumberOfChecks(10);
        this.SetTypeOfChecks("blank");
    }

    //overloaded constructor
    public CheckingAccount(
		double Balance, 
		String FirstName,
		String LastName,
		String AccountNumber,
		String Email,
        int NumberOfChecks,
        String TypeOfChecks
	) 
	{
		super(Balance, FirstName, LastName, AccountNumber, Email); //passes in the params into the BankingSystem's constructor

        this.setNumberOfChecks(NumberOfChecks);
        this.SetTypeOfChecks(TypeOfChecks);
	}	

    //Get NumberOfChecks
    public int getNumberOfChecks()
    {
        return this.NumberOfChecks;
    }

    //Set NumberOfChecks
    public setNumberOfChecks(int NumberOfChecks)
    {
        this.NumberOfChecks = NumberOfChecks;
    }

    //Get TypeOfChecks
    public String GetTypeOfChecks()
    {
        return this.TypeOfChecks;
    }

    //Set TypeOfChecks
    public SetTypeOfChecks(String TypeOfChecks)
    {
        this.TypeOfChecks = TypeOfChecks;
    }

    public String toString()
    {
        return super.toString() + 
            "\n Number Of Checks: " + this.getNumberOfChecks() +
            "\n Type Of Checks: " + this.GetTypeOfChecks();
    }

    //thanks max
    public boolean equals(Object O)
    {
        CheckingAccount OtherAccount = (CheckingAccount)O;

        return this.getNumChecks() == OtherAccount.getNumChecks();

    }

}