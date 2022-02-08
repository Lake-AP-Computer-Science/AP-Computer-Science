package problem2;

import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class Mail implements Comparable {
	
	protected double Weight = 0.f;
	
	protected int Zone;
	protected double FlatPrice = 4.05;

	public abstract double calculatePostage();
	
	public String toString()
	{
		DecimalFormat Dollars = new DecimalFormat("$0.00");
		return Dollars.format(calculatePostage());
		
		//debug line
		//return "Calculated: " + Dollars.format(calculatePostage()) + " Weight: " + Weight + " At zone: " + Zone;
	}
	
	@Override
	public int compareTo(Object o) {
		
		Mail o1 = (Mail)o;
		
		if (o1.calculatePostage() > calculatePostage())
			return 1;
		else if (o1.calculatePostage() < calculatePostage())
			return -1;
		
		if (o1.getWeight() == getWeight())
			return 0;
		else if (o1.getWeight() > getWeight())
			return 1;
		
		return -1;
	}
	
	public boolean equals(Object o)
	{
		return compareTo(o) == 0;
	}

	//getters and setters
	public int getZone() {
		return Zone;
	}

	public void setZone(int zone) {
		Zone = zone;
	}

	public double getFlatPrice() {
		return FlatPrice;
	}

	public void setFlatPrice(double flatPrice) {
		FlatPrice = flatPrice;
	}

	public double getWeight() {
		return Weight;
	}

	public void setWeight(double weight) {
		Weight = weight;
	}

	public static void main(String[] args) {
		
/* 
 * Test cases - Select in bulk the commented ones and press Ctrl/Command + '/' key to uncomment 
 * 
 * 1. Modify your code so that it matches mine in casing.
 * 2. Your code should be able to reproduce somewhat similar to the "expected output", if you think there's something wrong with the expected output, please contact me ASAP.
 * 3. If you would like to reproduce the exact same expected output, use my toString() methods for the Node and Signal classes.
 * 
 * */

// Test case #1 - display for Priority mail and flat rate envelope and boxes
		
//		PriorityMail PM = new PriorityMail(1.0, 1);
//		
//		FlatRateEnv FE = new FlatRateEnv(1.0, 1);
//		
//		FlatRateBox FB = new FlatRateBox(1.0, 1);
//		
//		System.out.println(PM);
//		
//		System.out.println(FE);
//		
//		System.out.println(FB);
		
/*
 * Expected Output:
 * $4.05
 * $4.05
 * $8.10
 * */

// Test case 2 - test default constructors of flat rate env/boxes
		
//		FlatRateEnv FE = new FlatRateEnv(1.0, 1);
//		
//		FlatRateBox FB = new FlatRateBox(1.0, 1);
//		
//		System.out.println(FE);
//		
//		System.out.println(FB);
		
/*
 * Expected Output:
 * $4.05
 * $8.10
 * */

// Test case 3 - test Media mail (make sure it's cost is 25% of others)
		
//		PriorityMail PM = new PriorityMail(1.0, 1);
//		MediaMail MM = new MediaMail(1.0, 1);
//		
//		System.out.println(PM);
//		System.out.println(MM);
		
/*
 * Expected Output:
 * $4.05
 * $6.07
 * */
		
// Test case 4 - Insured mail
		
//		PriorityMail PM = new PriorityMail(1.0, 1);
//		InsuredMail IM = new InsuredMail(PM, 350);
//		
//		System.out.println(PM);
//		System.out.println(IM);
		
/*
 * Expected output:
 * $4.05
 * $6.05
 * */
		
// Test case 5 - Test comparisons
		
//		PriorityMail PM = new PriorityMail(1.0, 1);
//		InsuredMail IM = new InsuredMail(PM, 350);
//		FlatRateEnv EM = new FlatRateEnv(2.0, 1);
//		FlatRateBox BM = new FlatRateBox(1.5, 2);
//		
//		ArrayList<Mail> All = new ArrayList<Mail>();
//		
//		All.add(PM);
//		All.add(IM);
//		All.add(EM);
//		All.add(BM);
//		
//		System.out.println("Unsorted: " + All); //unsorted
//		
//		MailSorter.SortMail(All, true); //sort ascending in package cost first and weight
//		
//		System.out.println("Sorted Ascending: " + All); //sorted
//		
//		MailSorter.SortMail(All, false); //sort descending in package cost first and weight
//		
//		System.out.println("Sorted Descending: " + All); //sorted

/*
 * Expected Output (with debug output - uncomment line 21 and comment line 18):
 * Unsorted: [Calculated: $4.05 Weight: 1.0 At zone: 1, Calculated: $4.05 Weight: 1.0 At zone: 1 Insured of: 350, Calculated: $4.05 Weight: 2.0 At zone: 1, Calculated: $8.10 Weight: 1.5 At zone: 2]
 * Sorted Ascending: [Calculated: $8.10 Weight: 1.5 At zone: 2, Calculated: $4.05 Weight: 1.0 At zone: 1, Calculated: $4.05 Weight: 1.0 At zone: 1 Insured of: 350, Calculated: $4.05 Weight: 2.0 At zone: 1]
 * Sorted Descending: [Calculated: $4.05 Weight: 1.0 At zone: 1, Calculated: $4.05 Weight: 2.0 At zone: 1, Calculated: $4.05 Weight: 1.0 At zone: 1 Insured of: 350, Calculated: $8.10 Weight: 1.5 At zone: 2]
 * */

/*
 * Expected Output (without debug output):
 * Unsorted: [$4.05, $6.05, $4.05, $8.10]
 * Sorted Ascending: [$8.10, $4.05, $6.05, $4.05]
 * Sorted Descending: [$4.05, $4.05, $6.05, $8.10]
 * */
		
// Last case - final-boss-lake-case with reading from file
		
		ReadFile R = new ReadFile("Mails.txt"); //replace local path with realpath (right click the .txt file and copy its path)
		
		ArrayList<Mail> Mails = R.getMails();
		
		MailSorter.SortMail(Mails, false);
		
		System.out.println("Sorted Lake Mail: " + Mails);
		
/* Expected Output (with debug output - uncomment line 21 and comment line 18):
 * Sorted Lake Mail: [Calculated: $4.05 Weight: 3.2 At zone: 5 Insured of: 0, Calculated: $4.05 Weight: 5.7 At zone: 8 Insured of: 540, Calculated: $8.10 Weight: 1.0 At zone: 2 Insured of: 200, Calculated: $22.99 Weight: 1.3 At zone: 4 Insured of: 350]

 */

/* Expected Output (without debug output):
 * Sorted Lake Mail: [$4.05, $7.05, $9.10, $24.99]
 */
		
	}
	
}
