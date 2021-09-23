import javax.swing.JOptionPane;

public class SavingAccount extends BankingSystems {
    private double InterestRate;

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
        this.InterestRate = 0.5;
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
            String ans = JOptionPane.showInputDialog(null, "Type approve if it gets approved!");

            if (ans.equals("approve")) //if approved go deposit again. Using .equals because string is an object
                super.Deposit(Amount); 
        }

        return this.GetBalance(); //inherited from parent
    }

    public double Withdraw(double Amount)
    {
        if (Amount < this.GetBalance())
        {
            super.Withdraw(Amount); //early return, the rest won't run
        }
        else if (Amount == this.GetBalance())
        {
            //close account cause you broke
            String ans = JOptionPane.showInputDialog(null, "Type close to close the account because you are now broke");
            if (ans.equals("close"))
                super.Withdraw(Amount);
        }
        
        return this.GetBalance();
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