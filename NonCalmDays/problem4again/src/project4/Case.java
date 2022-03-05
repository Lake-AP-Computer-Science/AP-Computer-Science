package project4;

import java.util.Date;

public class Case {
	
	//A Case “has-a” crime and a court Date when the case should be tried
	private Crime crime;
	private Date date; //all cases are constructed without a date – the value is null
	
	public Case(Crime crime)//[1 point]
	{
		setCrime(crime);
	}
	public Crime getCrime() //[1 point]
	{
		return this.crime;
	}
	public void setCrime(Crime crime) //[1 point]
	{
		this.crime = crime;
	}
	public Date getDate() //[1 point]
	{
		return this.date;
	}
	public void setDate(Date date) //[1 point]
	{
		this.date = date;
	}
	
	public String toString()
	{
		return getCrime().toString() + "; Date: " + this.getDate().toString();
	}
}
