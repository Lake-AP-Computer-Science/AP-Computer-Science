package problem2;

import java.util.ArrayList;

//import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		/* 
		 * Test cases - Select in bulk the commented ones and press Ctrl/Command + '/' key to uncomment 
		 * 
		 * 1. Modify your code so that it matches mine in casing.
		 * 2. Your code should be able to reproduce somewhat similar to the "expected output", if you think there's something wrong with the expected output, please contact me ASAP.
		 * 3. If you would like to reproduce the exact same expected output, use my toString() methods for the Node and Signal classes.
		 * 
		 * */

		// Test case #1 - display for Priority mail and flat rate envelope and boxes
				
//					PriorityMail PM = new PriorityMail(1.0, 1);
//					
//					FlatRateEnv FE = new FlatRateEnv(1.0, 1);
//					
//					FlatRateBox FB = new FlatRateBox(1.0, 1);
//					
//					System.out.println(PM);
//					
//					System.out.println(FE);
//					
//					System.out.println(FB);
				
		/*
		 * Expected Output:
		 * $4.05
		 * $4.05
		 * $8.10
		 * */

		// Test case 2 - test default constructors of flat rate env/boxes
		
//					FlatRateEnv FE = new FlatRateEnv(1.0, 1);
//					
//					FlatRateBox FB = new FlatRateBox(1.0, 1);
//					
//					System.out.println(FE);
//					
//					System.out.println(FB);
				
		/*
		 * Expected Output:
		 * $4.05
		 * $8.10
		 * */

		// Test case 3 - test Media mail (make sure its 25% thing is working)
				
//					PriorityMail PM = new PriorityMail(1.0, 1);
//					MediaMail MM = new MediaMail(1.0, 1);
//					
//					System.out.println(PM);
//					System.out.println(MM);
				
		/*
		 * Expected Output:
		 * $4.05
		 * $6.07
		 * */
				
		// Test case 4 - Insured mail
				
//					PriorityMail PM = new PriorityMail(1.0, 1);
//					InsuredMail IM = new InsuredMail(PM, 350);
//					
//					System.out.println(PM);
//					System.out.println(IM);
				
		/*
		 * Expected output:
		 * $4.05
		 * $6.05 Insured of: 350
		 * */
				
		// Test case 5 - Test comparisons
				
//					PriorityMail PM1 = new PriorityMail(1.0, 1);
//					PriorityMail PM2 = new PriorityMail(2.0, 1);
//					InsuredMail IM = new InsuredMail(new PriorityMail(1.0, 1), 500);
//	
//					// * -1 because i wrote the method backwards (and it is reflected in my SortMail class)
//					System.out.println(PM2.compareTo(PM1) * -1); // PM1 should be lower, thus returning a positive number (indicating params is bigger)
//					System.out.println(IM.compareTo(PM1) * -1); // PM1 should be lower, returning a positive number, this compares the weight first, but since weight is same, it returns the one that costs lower (PM1 since it isn't insured)

		/*
		 * Expected Output 
		 * 4
		 * 2
		 * */
		
		// Test case 6 - Test comparisons with sorting
		
//			PriorityMail PM = new PriorityMail(1.0, 1);
//			InsuredMail IM = new InsuredMail(PM, 350);
//			FlatRateEnv EM = new FlatRateEnv(2.0, 1);
//			FlatRateBox BM = new FlatRateBox(1.5, 2);
//			PriorityMail PM2 = new PriorityMail(10.0, 5);
//			
//			ArrayList<Mail> All = new ArrayList<Mail>();
//			
//			All.add(PM2);
//			All.add(PM);
//			All.add(IM);
//			All.add(EM);
//			All.add(BM);
//			
//			System.out.println("Unsorted: " + All); //unsorted
//			
//			MailSorter.SortMail(All, true); //sort ascending in package cost first and weight
//			
//			System.out.println("Sorted Ascending: " + All); //sorted
	
		/*
		* Expected Output 
		* Unsorted: [$24.30, $4.05, $6.05 Insured of: 350, $4.05, $8.10]
		* Sorted Ascending: [$4.05, $4.05, $6.05 Insured of: 350, $8.10, $24.30]
		* */
				
		// Test case 7 - final-boss-lake-case with reading from file
				
				ReadFile R = new ReadFile("Mails.txt"); //replace local path with realpath (right click the .txt file and copy its path)
				
				ArrayList<Mail> Mails = R.getMails();
				
				System.out.println("Unsorted: " + Mails); //unsorted
				
				MailSorter.SortMail(Mails, true); //sort ascending in package cost first and weight
				
				System.out.println("Sorted Lake Mail: " + Mails); //sorted

		/* Expected Output (without debug output):
		 * Unsorted: [$5.05 Insured of: 200, $4.05, $7.05 Insured of: 540, $16.58 Insured of: 350]
		 * Sorted Lake Mail: [$4.05, $5.05 Insured of: 200, $7.05 Insured of: 540, $16.58 Insured of: 350]
		 */
	}
}
