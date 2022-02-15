package problem2;

public class MediaMail extends Mail {

	private static final double DISCOUNT = 0.25;
	
	PriorityMail PM;
	
	public MediaMail(double Weight, int Zone)
	{
		this.PM = new PriorityMail(Weight, Zone); //composition to use this.PM as a container for weight and zone later on
	}
	
	@Override
	public double calculatePostage() //cost is "flat-rate Priority postage + zone * weight * flat-rate box postage * 25%"
	{
		FlatRateBox FRB = new FlatRateBox();
		return PriorityMail.FLAT_PRICE + this.PM.getZone() * this.PM.getWeight() * FRB.calculatePostage() * DISCOUNT;
	}
	
	//auto generated getters and setters
	public PriorityMail getPM() {
		return PM;
	}

	public void setPM(PriorityMail PM) {
		this.PM = PM;
	}
}
