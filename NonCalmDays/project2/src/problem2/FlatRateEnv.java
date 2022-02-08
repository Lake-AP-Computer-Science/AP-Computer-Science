package problem2;

public class FlatRateEnv extends PriorityMail {

	public FlatRateEnv(double Weight, int Zone) {
		super(Weight, Zone);
		// TODO Auto-generated constructor stub
	}
	
	public FlatRateEnv()
	{
		super(1.0, 1); //default constructor
	}
	
	@Override
	public double calculatePostage() {
		PriorityMail m = new PriorityMail(1.0, 1);
		return m.calculatePostage();
	}

}
