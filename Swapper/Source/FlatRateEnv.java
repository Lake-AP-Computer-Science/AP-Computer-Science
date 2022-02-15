package problem2;

public class FlatRateEnv extends PriorityMail {

	//constructor
	public FlatRateEnv(double Weight, int Zone)
	{
		super(Weight, Zone);
	}
	
	public FlatRateEnv()
	{
		super(1.0, 1); //default constructor
	}
	
	@Override
	public double calculatePostage() //calculates postage as it is "same cost of one box at 1 kg and zone 1" 
	{
		PriorityMail PM = new PriorityMail(1.0, 1);
		return PM.calculatePostage();
	}
}