public class PrimeCheckingAccount extends CheckingAccount 
{

	public PrimeCheckingAccount()
	{
		super();
    }

    private int rewardsCount = 0;
    private static double REWARD = 100.0;
    
    public  PrimeCheckingAccount(double balance,
                            String firstName,
                            String lastName,
                            String accountNumber,
                            String email,
                            int numChecks,
                            String typeOfChecks,
                            int rewardsCount,
                            double reward)
    {
        super(balance, firstName, lastName, accountNumber, email, numChecks, typeOfChecks);
        this.rewardsCount = rewardsCount;
        PrimeCheckingAccount.REWARD = reward;
    }   
      
    
    public String toString()
    {
        return super.toString() + "\nRewards Count: " + this.rewardsCount + "\n Rewards: " + PrimeCheckingAccount.REWARD;
    }
    
    
    
    public double deposit(double amount)
	{
    	if(amount >= 5000)
    	{
    		this.rewardsCount += 1;
    		
    		if(this.rewardsCount == 5)
    		{
    			super.deposit(PrimeCheckingAccount.REWARD);
    			this.rewardsCount = 0;
    		}
    	}
    	return super.deposit(amount);	
	}
    
    
    
	//Rewriting Code or Not?	
	public double withdraw(double amount)
	{
		
		if(amount <= getBalance())
			this.setBalance(this.getBalance() - amount);
		
		return getBalance();
	} 
	
	
	
}