import javax.swing.JOptionPane;

public class SavingAccount extends BankingSystems {
    private double InterestRate = 0.05;

    //Constructors
    public SavingAccount()
    {
        super(); 
        /*
        Super:
        Calls the parent's constructor.
        
        when you make a savings account:
         it gets passed up to the parent with "super()" (in this case BankingSystems)
        you call it's constructor first, which passes it up to Object
        and at Object there's no more super() to go up. it's the "god" of all constructors
        to complete the rest of the code, then it traverses the way down
        note: 
        it is there by default so you dont meed to call it
        it must be the first thing called!!!! very important, else you are 
        making the child classes and everything before the super() before calling
        the parent's constructor
        */
    }

    //extended constructor with refrence to BankingSystems
    public SavingAccount(
		double Balance, 
		String FirstName,
		String LastName,
		String AccountNumber,
		String Email,
        double InterestRate
	) 
	{
		super(Balance, FirstName, LastName, AccountNumber, Email); //passes in the params into the BankingSystem's constructor
        this.SetInterestRate(InterestRate);
	}	

    public SavingAccount(
		double Balance, 
		String FirstName,
		String LastName,
		String AccountNumber,
		String Email
	) 
	{
		super(Balance, FirstName, LastName, AccountNumber, Email); //passes in the params into the BankingSystem's constructor
	}	

    //overwritten child methods
    public double Deposit(double Amount)
    {
        if (Amount < 5000)//precondition for savings account ONLY
        {
            super.Deposit(Amount); //call the deposit in the parent class
            //can't use this.Deposit(Amount)
            //that will be infinate loop of this method calling itself if its amount is less than 5000
        }
        else
        {
        	int Answer = JOptionPane.showConfirmDialog(null, "You are moving big funds. Click ok to approve!", "Confirmation Needed", JOptionPane.YES_OPTION);

            if (Answer == 0) //if approved go deposit again.
                super.Deposit(Amount); 
        }

        return this.GetBalance(); //inherited from parent
    }

    public double Withdraw(double Amount)
    {
        if (Amount == this.GetBalance())
        {
            //close account cause you broke
        	//int Answer = 
        	JOptionPane.showConfirmDialog(null, "You are now broke. Do you want to close the account?", "Uh oh", JOptionPane.YES_OPTION);
            //closing or leaving the account open should have nothing to do with its withdraw
        }
        else if (Amount > this.GetBalance()) //withdrawing more than you have handled here
    	{
    		int Answer = JOptionPane.showConfirmDialog(null, "You are too broke. Not enough to withdraw... Would you like to withdraw all your balance?", "Uh oh", JOptionPane.YES_OPTION);
            
        	if (Answer == 0)//clicked yes
        		return this.Withdraw(this.GetBalance()); //recursion ahhhh
        	Amount = 0;
    	}
        
        return super.Withdraw(Amount);
    } 

    //Getters
    public double GetInterestRate()
    {
        return this.InterestRate;
    }

    //Setters
    public void SetInterestRate(double InterestRate)
    {
        this.InterestRate = InterestRate;
    }

    /*
    partial override of the toString() in the parent (BankAccount), 
    it'll print what was shown in the BankAccount, and the interest rate
    */
    public String toString()
    {
        return super.toString() + 
            "\n Interest: " + this.GetInterestRate();
    }
}