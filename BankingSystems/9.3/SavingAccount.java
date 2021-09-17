
public class SavingAccount extends BankingSystems {
    private double InterestRate;

    //Constructors
    public SavingsAccount()
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
    public BankingSystems(
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

    //Getters
    public double GetInterestRate()
    {
        return this.InterestRate;
    }

    //Setters
    public void SetInterestRate(InterestRate)
    {
        self.InterestRate = InterestRate;
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