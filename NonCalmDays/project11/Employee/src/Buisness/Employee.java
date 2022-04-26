package Buisness;

public class Employee
{
	private String name;
	private int ID;
	private int yearsWorked;
	private final int BASE_SALARY = 40000;
	private final int BASE_RATE = 1000;
	
	public Employee(String name, int ID, int yearsWorked)
	{
		this.name = name;
		this.ID = ID;
		this.yearsWorked = yearsWorked;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getID()
	{
		return this.ID;
	}
	
	public int getYearsWorked()
	{
		return this.yearsWorked;
	}
	
	public int calculateSalary()
	{
		return BASE_SALARY + this.yearsWorked * BASE_RATE;
	}
	
}