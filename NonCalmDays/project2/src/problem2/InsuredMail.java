package problem2;

public class InsuredMail extends Mail
{
	//variables
	private Mail NestedMail;
	private int Value;
	
	//constructor
	public InsuredMail(Mail NestedMail, int Value)
	{
		this.NestedMail = NestedMail;
		this.Value = Value;
	}
	
	@Override
	public double calculatePostage()
	{
		return NestedMail.calculatePostage() + (Math.ceil((double)Value / 100) * 0.5);
	}
	
	public String toString() //add insurance after the toString()
	{
		return super.toString() + " Insured of: " + Value;
		//return NestedMail.toString() + " Insured of: " + Value;
	}
	
	//auto generated getters and setters
	public Mail getNestedMail()
	{
		return this.NestedMail;
	}

	public void setNestedMail(Mail NestedMail)
	{
		this.NestedMail = NestedMail;
	}

	public int getValue()
	{
		return Value;
	}

	public void setValue(int Value) 
	{
		this.Value = Value;
	}
}