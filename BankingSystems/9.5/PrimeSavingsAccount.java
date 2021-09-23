import javax.swing.JOptionPane;

public class PrimeSavingsAccount extends SavingAccount {

    //no data needed
    //can't inherit the constructor

    //Constructors
    public PrimeSavingsAccount()
    {
        super();
        //write dynamic code, don't hardcode the 0.1 value
        this.SetInterestRate(this.GetInterestRate() * 2); //the only difference between prime savings account and savings account
    }

    public PrimeSavingsAccount(
		double Balance, 
		String FirstName,
		String LastName,
		String AccountNumber,
		String Email
	) 
	{
		super(Balance, FirstName, LastName, AccountNumber, Email);
        this.SetInterestRate(this.GetInterestRate() * 2);
    }
}