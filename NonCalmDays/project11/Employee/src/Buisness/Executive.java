package Buisness;

public class Executive extends Employee {
	
	private int bonus;

	public Executive(String name, int ID, int yearsWorked, int bonus) {
		super(name, ID, yearsWorked);
		this.bonus = bonus;
	}
	
	public int getBonus()
	{
		return this.bonus;
	}
	
	public int calculateSalary()
	{
		return super.calculateSalary() * 3 + this.bonus;
	}
	
}
