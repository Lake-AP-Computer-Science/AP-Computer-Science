package problem2;

public class PriorityMail extends Mail {
	
	public PriorityMail(double Weight, int Zone)
	{
		this.Weight = Weight;
		this.Zone = Zone;
	}

	@Override
	public double calculatePostage() {
		return FlatPrice * Zone / Weight;
	}
	
}
