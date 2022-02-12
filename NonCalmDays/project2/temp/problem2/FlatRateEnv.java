package problem2;

public class FlatRateEnv extends PriorityMail {

	//constructor
	public FlatRateEnv(double weight, int zone)
	{
		super(weight, zone);
	}
	
	public FlatRateEnv()
	{
		super(1.0, 1); //default constructor
	}
	
	@Override
	public double calculatePostage()
	{
		PriorityMail PM = new PriorityMail(1.0, 1);
		return PM.calculatePostage();
	}
}