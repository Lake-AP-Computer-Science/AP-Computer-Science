import javax.swing.JOptionPane;

public class PrimeCheckingAccount extends CheckingAccount{
	
	private int RewardsCount;
	private static final double REWARD = 100;
	private static final double DEPOSIT_FOR_REWARD = 5000;
	
	
	PrimeCheckingAccount()
	{
		super();

		this.SetRewardsCount(0);
	}
	
	PrimeCheckingAccount(
			double Balance, 
			String FirstName,
			String LastName,
			String AccountNumber,
			String Email,
	        int NumberOfChecks,
	        String TypeOfChecks
	)
	{
		super(Balance, FirstName, LastName, AccountNumber, Email, NumberOfChecks, TypeOfChecks);
		
		this.SetRewardsCount(0);
	}

	public double Deposit(double Amount)
    {	
		if (Amount >= DEPOSIT_FOR_REWARD) //if money bigger than the reward thing 
			this.SetRewardsCount(RewardsCount + 1);
		
		if (RewardsCount >= 5) 
		{
			super.Deposit(REWARD);
			this.SetRewardsCount(0);
		}
			
		return super.Deposit(Amount);
    }

    public double Withdraw(double Amount)
    {
    	if (Amount > this.GetBalance())
    	{
    		int Answer = JOptionPane.showConfirmDialog(null, "You are too broke. Not enough to withdraw... Would you like to withdraw all your balance?", "Uh oh", JOptionPane.YES_OPTION);
    		
    		if (Answer == 0)//clicked yes
    			return this.Withdraw(this.GetBalance()); 
    		Amount = 0;
    	}
    	
    	this.SetBalance(this.GetBalance() - Amount);
    	return this.GetBalance(); //could not find way to do super.super
    }	
    	

	//Get RewardsCount
	public int GetRewardsCount()
	{
	    return this.RewardsCount;
	} 

	//Set RewardsCount
	public void SetRewardsCount(int RewardsCount)
	{
	    this.RewardsCount = RewardsCount;
	}
	
	public String toString() {
        return super.toString() + 
               "\nRewards Count: " + this.GetRewardsCount();
    }
}
