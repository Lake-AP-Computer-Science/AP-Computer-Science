import javax.swing.JOptionPane;

public class CheckingAccount extends BankingSystems {
    private int NumberOfChecks;
    private String TypeOfChecks;

    static final int WITHDRAW_LIMIT = 10000;
    static final int DEPOSIT_LIMIT = 15000;
    static int FEE;

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
    public void setNumberOfChecks(int NumberOfChecks)
    {
        this.NumberOfChecks = NumberOfChecks;
    }

    //Get TypeOfChecks
    public String GetTypeOfChecks()
    {
        return this.TypeOfChecks;
    }

    public double Deposit(double Amount)
    {	
    	if(Amount > DEPOSIT_LIMIT)
        {
    		int ans = JOptionPane.showConfirmDialog(null, "Woah there! Slow down buckaroo. Your deposit needs an approval.", "Action needed", JOptionPane.YES_OPTION);
            
            if (ans == 1) //clicked cancel
                Amount = 0; //setting dummy to 0 so it doens't deposit anything
        }

        return super.Deposit(Amount);
    }

    public double Withdraw(double Amount)
    {
    	//10k is withdraw limit make sure it is sufficient funds and don't exceed withdraw limit else ask approval. If the approval is granted then take away a surcharge for fee, else if it is not approved withdraw no money

    	if (Amount > this.GetBalance()) //withdrawing more than you have handled here
    	{
    		int Answer = JOptionPane.showConfirmDialog(null, "You are too broke. Not enough to withdraw... Would you like to withdraw all your balance?", "Uh oh", JOptionPane.YES_OPTION);
    		
    		if (Answer == 0)//clicked yes
    			return this.Withdraw(this.GetBalance()); //recursion ahhhh
    		Amount = 0;
    	}
    	
        if (Amount > WITHDRAW_LIMIT)
        {
        	int ans = JOptionPane.showConfirmDialog(null, "Woah there! Slow down buckaroo. Your withdraw needs an approval.", "Action needed", JOptionPane.YES_OPTION);
            
            if (ans == 0) {
	            super.Withdraw(FEE);
	            return super.Withdraw(Amount - FEE);
            }
            Amount = 0;
        }
        
    	return super.Withdraw(Amount);
    }

    //Set TypeOfChecks
    public void SetTypeOfChecks(String TypeOfChecks)
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
        return this.getNumberOfChecks() == OtherAccount.getNumberOfChecks();
    }

}