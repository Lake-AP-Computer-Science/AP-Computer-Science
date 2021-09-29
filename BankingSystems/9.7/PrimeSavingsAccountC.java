
public class PrimeSavingsAccountC {
	
	private SavingAccount Save;

	public PrimeSavingsAccountC()
    {
		this.Save = new SavingAccount();
		this.ApplyMultiplier(2);
    }
	
	private void ApplyMultiplier(int multiplier)
	{
		this.Save.SetInterestRate(this.Save.GetInterestRate() * multiplier);
	}
}
