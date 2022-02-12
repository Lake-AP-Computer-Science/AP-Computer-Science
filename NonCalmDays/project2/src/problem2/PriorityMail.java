package problem2;

public class PriorityMail extends Mail
{
	private double Weight;
	private int Zone;
	static public final double FLAT_PRICE = 4.05;

	//precondition: 1 <= Zone <= 8
	public PriorityMail(double Weight, int Zone) 
	{
		this.Weight = Weight;
		this.Zone = Zone;
	}
	
	public double calculatePostage() //thank you Mike for figuring this out. Apparently the formula only applies if Weight is > 1
	{
		if(Weight > 1)
			return FLAT_PRICE + FLAT_PRICE * Zone;
		return FLAT_PRICE;
	}
	
	//auto generated getters and setters
	public double getWeight() {
		return Weight;
	}

	public void setWeight(double Weight) {
		this.Weight = Weight;
	}

	public int getZone() {
		return Zone;
	}

	public void setZone(int Zone) {
		this.Zone = Zone;
	}

}