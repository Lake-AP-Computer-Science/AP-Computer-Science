
public class PrimeSavingsAccount extends SavingsAccount 
{
	
	//no data
	//twice the set rate (0.05) of a SavingsAccount
	 /*
	   * 1. Composition - using an instance of a class to create another class - "has-a"
	   * 2. Composition versus Inheritance: SOME versus ALL
	   * 3. Create PrimeSavingsAccountC using Composition
	   * 4. Review Checking Account Solution
	   * 5. Assign Prime Checking Account Project
	   * 
	   * 6. Prime Checking Account Questions? Redesign?
	   * 7. Exception Hierarchy
	   * 8. Throwing Exceptions - example in main
	   * 9. Method overloading
	   * 10. Build File Management System - Using Composition
	   */
		
	
	public PrimeSavingsAccount()
	{
		super();
		super.setInterestRate(getInterestRate() * 2); 
	}
	
	
	public  PrimeSavingsAccount(double balance, 
	          String firstName,
	          String lastName,
	          String accountNumber,
	          String email)
	{
		
		super();
		super.setBalance(balance);
		super.setFirstName(firstName);
		setLastName(lastName);
		setAccountNumber(accountNumber);
		setEmail(email);
		super.setInterestRate(getInterestRate() * 2); 

	}
	
 
	

}
