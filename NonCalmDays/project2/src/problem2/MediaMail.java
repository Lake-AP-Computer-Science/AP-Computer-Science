package problem2;

public class MediaMail extends Mail {

	private final double DISCOUNT = 0.25;
	
	public MediaMail(double Weight, int Zone)
	{
		this.Weight = Weight;
		this.Zone = Zone;
	}
	
	@Override
	public double calculatePostage() {
		PriorityMail M = new PriorityMail(Weight, Zone);
		FlatRateBox B = new FlatRateBox(Weight, Zone);
		return M.calculatePostage() + Zone * Weight * B.calculatePostage() * DISCOUNT;
	}

}
