package Buisness;

public class Manager extends Employee {
	
	private int bonus;

	public Manager(String name, int ID, int yearsWorked, int bonus) {
		super(name, ID, yearsWorked);
		this.bonus = bonus;
		// TODO Auto-generated constructor stub
	}
	
	public int getBonus()
	{
		return this.bonus;
	}

	public int calculateSalary()
	{
		return super.calculateSalary() * 2 + this.bonus;
	}

}
