package Buisness;

public class Main {

	public static void main(String[] args)
    {
        Employee e = new Employee("Michael", 2, 2);
        System.out.println("Your Output: Name: " + e.getName() + ", ID: " + e.getID() + ", Years Worked: " + e.getYearsWorked() + ", Salary: $" + e.calculateSalary());
        System.out.println("Expected Output: Name: Michael, ID: 2, Years Worked: 2, Salary = $42000\n");

        Executive ex = new Executive("Michael", 2, 2, 2);
        System.out.println("Your Output: Name: " + ex.getName() + ", ID: " + ex.getID() + ", Years Worked: " + ex.getYearsWorked() + ", Bonus: $" + ex.getBonus() + ", Salary: $" + ex.calculateSalary());
        System.out.println("Expected Output: Name: Michael, ID: 2, Years Worked: 2, Bonus = $2; Salary = $126002\n");

        Manager m = new Manager("Michael", 2, 2, 2);
        System.out.println("Your Output: Name: " + m.getName() + ", ID: " + m.getID() + ", Years Worked: " + m.getYearsWorked() + ", Bonus: $" + m.getBonus() + ", Salary: $" + m.calculateSalary());
        System.out.println("Expected Output: Name: Michael, ID: 2, Years Worked: 2, Bonus = $2; Salary = $84002\n");

        StoreClerk sc = new StoreClerk("Michael", 2, 2);
        System.out.println("Your Output: Name: " + sc.getName() + ", ID: " + sc.getID() + ", Years Worked: " + sc.getYearsWorked() + ", Salary: $" + sc.calculateSalary());
        System.out.println("Expected Output: Name: Michael, ID: 2, Years Worked: 2, Salary = $42000\n");

        Cashier c = new Cashier("Michael", 2, 2);
        System.out.println("Your Output: Name: " + c.getName() + ", ID: " + c.getID() + ", Years Worked: " + c.getYearsWorked() + ", Salary: $" + c.calculateSalary());
        System.out.println("Expected Output: Name: Michael, ID: 2, Years Worked: 2, Salary = $42000\n");
    }
}
