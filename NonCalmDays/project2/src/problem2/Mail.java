package problem2;

import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class Mail extends Object implements Comparable<Object>
{
	public abstract double calculatePostage();
	
	public String toString() //write toString() method to print $dollars.cents
	{
		DecimalFormat dollars = new DecimalFormat("$0.00");
		return dollars.format(calculatePostage());
	}
	
	public PriorityMail GetPriorityMail(Mail Other) //A get priority mail method that takes in any mail object and converts them into a priority mail
	{	
		if (Other instanceof PriorityMail) //if it is a priority mail, just cast it
			return (PriorityMail)Other;
		
		if (Other instanceof MediaMail) //if it is a media mail, get the priority mail from the media mail's composition
				return ((MediaMail)Other).getPM();
		
		if (Other instanceof InsuredMail) //if it is an insured mail, it doesn't have a definitive type as it can be any type of mail but insured, so we can call the function again (recursion) to strip it layer by layer (eg. a insured mail of an insured mail of a media mail)
				return GetPriorityMail(((InsuredMail)Other).getNestedMail());
		
		return null; //nothing found- if this happens your code fucked up
	}
 
	@Override
	public int compareTo(Object other) //compare based on raw postage then of the weight (stored in prioritymails in other classes as a container)
	{
		
		PriorityMail Other = GetPriorityMail((Mail)other);
		
		PriorityMail Self = GetPriorityMail(this);
		
		if (((Mail)(other)).calculatePostage() > this.calculatePostage())
			return 1;
		
		if (((Mail)(other)).calculatePostage() < this.calculatePostage())
			return -1;
		
		//if costs are equal
		
		if (Other.getWeight() == Self.getWeight())
			return 0;
		
		if (Other.getWeight() > Self.getWeight())
			return 1;
		
		return -1;
	}
	
	public boolean equals(Object other) //ez implementaition, no lines
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
	 * $6.05 Insured of: 350
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
	 * Sorted Ascending: [$4.05, $4.05, $6.05 Insured of: 350, $8.10, $24.30]
	 * */
			
	// Last case - final-boss-lake-case with reading from file
			
			ReadFile R = new ReadFile("Mails.txt"); //replace local path with realpath (right click the .txt file and copy its path)
			
			ArrayList<Mail> Mails = R.getMails();
			
			System.out.println("Unsorted: " + Mails); //unsorted
			
			MailSorter.SortMail(Mails, true); //sort ascending in package cost first and weight
			
			System.out.println("Sorted Lake Mail: " + Mails); //sorted

	/* Expected Output (without debug output):
	 * Unsorted: [$5.05 Insured of: 200, $4.05, $7.05 Insured of: 540, $32.78 Insured of: 350]
	 * Sorted Lake Mail: [$4.05, $5.05 Insured of: 200, $7.05 Insured of: 540, $32.78 Insured of: 350]
	 */
			
		}
}