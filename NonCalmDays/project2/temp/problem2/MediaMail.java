package problem2;

public class MediaMail extends Mail
{
	private final double DISCOUNT = 0.25;
	PriorityMail PM;
	
	public MediaMail(double weight, int zone)
	{
		this.PM = new PriorityMail(weight, zone);
	}
	
	public PriorityMail getPM() {
		return PM;
	}

	public void setPM(PriorityMail pM) {
		PM = pM;
	}

	public double getDISCOUNT() {
		return DISCOUNT;
	}

	@Override
	public double calculatePostage()
	{
		PriorityMail PM = new PriorityMail(this.PM.getWeight(), this.PM.getZone());
		FlatRateBox FRB = new FlatRateBox(this.PM.getWeight(), this.PM.getZone());
		return PM.calculatePostage() + this.PM.getWeight() * this.PM.getZone() * FRB.calculatePostage() * DISCOUNT;
	}
}