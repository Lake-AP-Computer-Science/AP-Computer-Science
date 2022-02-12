package problem2;

import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class Mail extends Object implements Comparable<Object>
{
	public abstract double calculatePostage();
	
	public String toString()
	{
		DecimalFormat dollars = new DecimalFormat("$0.00");
		return dollars.format(calculatePostage());
		
		//debug line (comment the return above):
		//return GetPriorityMail(this).toString();
	}
	
	public PriorityMail GetPriorityMail(Mail Other)
	{
		//System.out.println(Other.getClass());
		
		if (Other instanceof PriorityMail)
			return (PriorityMail)Other;
		
		if (Other instanceof MediaMail)
				return ((MediaMail)Other).getPM();
		
		if (Other instanceof InsuredMail)
				return (PriorityMail)(((InsuredMail)Other).getIMail());
		
		//System.out.println("failed " + Other.getClass());
		
		return null;
	}
 
	@Override
	public int compareTo(Object other)
	{
		
		PriorityMail Other = GetPriorityMail((Mail)other);
		
		PriorityMail Self = GetPriorityMail(this);
		
		//System.out.println("S: " + Self.getClass() + " O: " + Other.getClass());
		
		if (Other.calculatePostage() > Self.calculatePostage())
			return 1;
		else if (Other.calculatePostage() < Self.calculatePostage())
			return -1;
		
		if (Other.getWeight() == Self.getWeight())
			return 0;
		else if (Other.getWeight() > Self.getWeight())
			return 1;
		
		return -1;
	}
	
	public boolean equals(Object other)
	{
		return compareTo(other) == 0;
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
			
//				PriorityMail PM = new PriorityMail(1.0, 1);
//				
//				FlatRateEnv FE = new FlatRateEnv(1.0, 1);
//				
//				FlatRateBox FB = new FlatRateBox(1.0, 1);
//				
//				System.out.println(PM);
//				
//				System.out.println(FE);
//				
//				System.out.println(FB);
			
	/*
	 * Expected Output:
	 * $4.05
	 * $4.05
	 * $8.10
	 * */

	// Test case 2 - test default constructors of flat rate env/boxes
			
//				FlatRateEnv FE = new FlatRateEnv(1.0, 1);
//				
//				FlatRateBox FB = new FlatRateBox(1.0, 1);
//				
//				System.out.println(FE);
//				
//				System.out.println(FB);
			
	/*
	 * Expected Output:
	 * $4.05
	 * $8.10
	 * */

	// Test case 3 - test Media mail (make sure its 25% thing is working)
			
//				PriorityMail PM = new PriorityMail(1.0, 1);
//				MediaMail MM = new MediaMail(1.0, 1);
//				
//				System.out.println(PM);
//				System.out.println(MM);
			
	/*
	 * Expected Output:
	 * $4.05
	 * $6.07
	 * */
			
	// Test case 4 - Insured mail
			
//				PriorityMail PM = new PriorityMail(1.0, 1);
//				InsuredMail IM = new InsuredMail(PM, 350);
//				
//				System.out.println(PM);
//				System.out.println(IM);
			
	/*
	 * Expected output:
	 * $4.05
	 * $6.05
	 * */
			
	// Test case 5 - Test comparisons
			
//				PriorityMail PM = new PriorityMail(1.0, 1);
//				InsuredMail IM = new InsuredMail(PM, 350);
//				FlatRateEnv EM = new FlatRateEnv(2.0, 1);
//				FlatRateBox BM = new FlatRateBox(1.5, 2);
//				PriorityMail PM2 = new PriorityMail(10.0, 5);
//				
//				ArrayList<Mail> All = new ArrayList<Mail>();
//				
//				All.add(PM2);
//				All.add(PM);
//				All.add(IM);
//				All.add(EM);
//				All.add(BM);
//				
//				System.out.println("Unsorted: " + All); //unsorted
//				
//				MailSorter.SortMail(All, true); //sort ascending in package cost first and weight
//				
//				System.out.println("Sorted Ascending: " + All); //sorted

	/*
	 * Expected Output 
	 * Unsorted: [$24.30, $4.05, $6.05 Insured of: 350, $4.05, $8.10]
	 * Sorted Ascending: [$4.05, $6.05 Insured of: 350, $4.05, $8.10, $24.30]
	 * */
			
	// Last case - final-boss-lake-case with reading from file
			
			ReadFile R = new ReadFile("Mails.txt"); //replace local path with realpath (right click the .txt file and copy its path)
			
			ArrayList<Mail> Mails = R.getMails();
			
			System.out.println("Unsorted: " + Mails); //unsorted
			
			MailSorter.SortMail(Mails, true); //sort ascending in package cost first and weight
			
			System.out.println("Sorted Lake Mail: " + Mails); //sorted

	/* Expected Output (without debug output):
	 * Sorted Lake Mail: [$4.05 zone: 2 weight: 1.0 Insured of: 200, $4.05 zone: 5 weight: 3.2 Insured of: 0, $4.05 zone: 8 weight: 5.7 Insured of: 540, $30.78 Insured of: 350]
	 */
			
		}
}