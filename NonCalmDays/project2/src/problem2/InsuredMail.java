package problem2;

public class InsuredMail extends Mail
{
	//variables
	private Mail iMail;
	private int value;
	
	//constructor
	public InsuredMail(Mail iMail, int value)
	{
		this.iMail = iMail;
		this.value = value;
	}
	
	//getters and setters
	public Mail getIMail()
	{
		return this.iMail;
	}

	public void setIMail(Mail iMail)
	{
		this.iMail = iMail;
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int value) 
	{
		this.value = value;
	}

	@Override
	public double calculatePostage()
	{
		return iMail.calculatePostage() + (Math.ceil((double)value / 100) * 0.5);
	}
	
//	@Override
//	public int compareTo(Object other)
//	{
//		return iMail.compareTo(other);
//	}
	
	public String toString()
	{
		return super.toString() + " Insured of: " + value;
		//return iMail.toString() + " Insured of: " + value;
	}
}