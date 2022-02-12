package problem1;

public class Signal
{
	private String signalData;
	private int strength, count;
	
	public Signal(String data, int s)
	{
		signalData = data;
		strength = s;
		count = 1;
	}
	
	public int getStrength()
	{
		return this.strength;
	}
	
	public void setStrength(int s)
	{
		this.strength = s;
	}
	
	public String getSignalData()
	{
		return this.signalData;
	}
	
	public void setSignalData(String data)
	{
		this.signalData = data;
	}
	
	public int getCount()
	{
		return this.count;
	}
	
	public void setCount(int c)
	{
		this.count = c;
	}
	
	public void incrementCount()
	{
		this.count += 1;
	}
	
	public void decrementCount()
	{
		this.count -= 1;
	}
	
	public String toString()
	{
		return "Signal: "+ signalData + ", Strength: " + this.strength + ", Count: " + this.count + " ";
	}
	
	public boolean equals(Object other)
	{
		Signal otherSignal = (Signal)other;
		return this.strength == otherSignal.strength && this.signalData.equals(otherSignal.signalData);
	}
}