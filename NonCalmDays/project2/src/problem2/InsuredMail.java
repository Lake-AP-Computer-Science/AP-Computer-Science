package problem2;

public class InsuredMail extends Mail{
	
	private Mail Package;
	private int Value;
	
	public InsuredMail(Mail Package, int Value)
	{
		this.Package = Package;
		this.Value = Value;
	}

	@Override
	public double calculatePostage() {
		// TODO Auto-generated method stub
		return Package.calculatePostage() + (Math.ceil((double)Value / 100) * 0.5);
	}
	
	@Override
	public int compareTo(Object o) {
		return Package.compareTo(o);
	}
	
	public String toString()
	{
		return Package.toString() + " Insured of: " + Value;
	}
	
	public Mail getPackage() {
		return Package;
	}

	public void setPackage(Mail package1) {
		Package = package1;
	}

	public int getValue() {
		return Value;
	}

	public void setValue(int value) {
		Value = value;
	}

}
