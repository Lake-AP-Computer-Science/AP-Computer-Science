package problem2;

public class FlatRateBox extends PriorityMail {

	public FlatRateBox(double Weight, int Zone) {
		super(Weight, Zone);
		// TODO Auto-generated constructor stub
	}

	public FlatRateBox()
	{
		super(1.0, 1); //default constructor
	}
	
	@Override
	public double calculatePostage() {
		FlatRateEnv e = new FlatRateEnv();
		return e.calculatePostage() * 2;
	}
}
