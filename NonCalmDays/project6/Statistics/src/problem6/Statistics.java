package problem6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.TreeMap;

public class Statistics {
	
	//part a
	//precondition: n > 0
	//postcondition returns an int[] array object with n integer values;
	public static int[] createList(int n)
	{
		int[] ReturnList = new int[n];
		
		Random r = new Random();
		
		for (int i = 0; i < n; ++i)
		{
			ReturnList[i] = r.nextInt(90) + 10;
		}
		
		return ReturnList;
	}
	
	//part b
	//precondition: n > 0
	//postcondition returns an int[] array object with n integer values;
	
	public static double getMean(int[] List)
	{
		double Result = 0.f;
		for (int Item : List)
		{
			Result += Item;
		}
		return Result / List.length;
	}
	
	//partc sort list, list is nonempty, and list are sorted
	public static void sortList(int[] List)
	{
		Arrays.sort(List);
	}
	
	//part c, getmMode
	public static int getMode(int[] List) 
	{
		sortList(List);
		
		TreeMap<Integer, Integer> Map = new TreeMap<Integer, Integer>();
		
		for (int Number : List)
		{
			int OGNumber = 0;
			
			if (Map.containsKey(Number))
				OGNumber = Map.get(Number);
			
			Map.put(Number, OGNumber + 1);
		}
		
		//System.out.println(Map);
		
		int Return = 0;
		int Count = 0;
		
		for (int Number : List)
		{
			if (Map.get(Number) > Count)
			{
				Count = Map.get(Number);
				Return = Number;
			}
		}
		
		return Return;
	}

	public static void main(String[] args) {
		int[] TestNumbers = {9, 10, 12, 13, 13, 13, 15, 15, 16, 16, 18, 22, 23, 24, 24, 25};
		
		//test cases
		
		/*
		 * Test case 1 - simple list-making
		 * 
		 * expected output: unique for each, but should be 6000 2 digit numbers 10-99
		 */
//		
//		int[] a = createList(6000);
//		
//		for (int i : a)
//		{
//			System.out.print(i + " ");
//		}
//		System.out.println();
		
		/*
		 * Test case 2 - simple mean
		 * 
		 * expected output: 16.75
		 */
		
//		System.out.println(getMean(TestNumbers));
		
		/*
		 * Test case 2 - simple mean
		 * 
		 * expected output: 16.75
		 */
		
//		System.out.println(getMode(TestNumbers));
		
		/*
		 * Test case 3 - sortList
		 * 
		 * expected output: {9, 10, 12, 13, 13, 13, 15, 15, 16, 16, 18, 22, 23, 24, 24, 25}
		 */
		
//		int[] a = {12, 13, 13, 13, 15, 15, 16, 16, 18, 22, 23, 24, 24, 25, 9, 11, 10};
//		
//		sortList(a);
//		
//		for (int i : a)
//		{
//			System.out.print(i + " ");
//		}
//		System.out.println();
		
		/*
		 * Test case 4 - simple mode
		 * 
		 * expected output: 13
		 */
		
//		System.out.println(getMode(TestNumbers));
		
		//-----Below are all of mr.lake's test cases
		
		//mean
		
//		int[] lakepartB1 = {10, 18, 17};
//		
//		System.out.println(getMean(lakepartB1)); // 15.0
//		
//		int[] lakepartB2 = {10, 15};
//		
//		System.out.println(getMean(lakepartB2)); // 12.5
//		
//		//mode 
//		
//		int[] lakepartC1 = {10, 10, 13, 17, 17, 17, 18, 21};
//		
//		System.out.println(getMode(lakepartC1)); // 17
//		
//		int[] lakepartC2 = {54, 54, 54, 60, 60, 70, 85, 85};
//		
//		System.out.println(getMode(lakepartC2)); // 54
//		
//		int[] lakepartC3 = {20, 20, 20, 30, 30, 30, 40, 40, 40};
//		
//		System.out.println(getMode(lakepartC3)); // 20
//		
//		int[] lakepartC4 = {50};
//		
//		System.out.println(getMode(lakepartC4)); // 50
		
		//Below is a repeat of the above but extracted via text file
		
		ReadFile f = new ReadFile("./Statistics.txt");
		
		f.RunFromFile();

	}

}
