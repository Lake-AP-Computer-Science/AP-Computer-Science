package problem2;

public class FlatRateBox extends PriorityMail
{
	//constructor
	public FlatRateBox(double weight, int zone)
	{
		super(weight, zone);
	}

	public FlatRateBox()
	{
		super(1.0, 1); //default constructor
	}
	
	@Override
	public double calculatePostage()
	{
		FlatRateEnv FRE = new FlatRateEnv();
		return FRE.calculatePostage() * 2;
	}
}