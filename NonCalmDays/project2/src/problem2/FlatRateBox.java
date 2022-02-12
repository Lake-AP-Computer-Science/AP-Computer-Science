package problem2;

public class FlatRateBox extends PriorityMail
{
	//constructor
	public FlatRateBox(double Weight, int Zone)
	{
		super(Weight, Zone);
	}

	public FlatRateBox()
	{
		super(1.0, 1); //default constructor
	}
	
	@Override
	public double calculatePostage() //calculates postage as it is "2x FRE cost"
	{
		FlatRateEnv FRE = new FlatRateEnv();
		return FRE.calculatePostage() * 2;
	}
}