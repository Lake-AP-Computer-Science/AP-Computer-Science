package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class DataProcessing
{
	//returns a random array of integers on the interval [10, 50]
	//of length n [5 points]
	public static int[] createData(int n)
	{
		int[] Return = new int[n];
		
		for (int i = 0; i < n; ++i)
		{
			Return[i] = ThreadLocalRandom.current().nextInt(10, 51);
		}
		
		return Return;
	}
	//returns the sum of all the values in array [5 points]
	public static int sum(int array[])
	{
		int Sum = 0;
		
		for (int val : array)
		{
			Sum += val;
		}
		
		return Sum;
	}
	//returns the average of all the values in array [5 points]
	public static double average(int array[])
	{
		return (double)DataProcessing.sum(array) / array.length;
	}
	//returns a sorted array of integers [5 points]
	public static int[] sortArray(int array[])
	{
		int[] c = array.clone();
		Arrays.sort(c);
		return c;
	}
	//returns the range of the values in the array
	//The range is the difference between the largest and smallest
	//values in the array [5 points]
	public static int range(int array[])
	{
		array = DataProcessing.sortArray(array);
		return array[array.length - 1] - array[0];
	}
	//return the even integers in the array as a list [5 points]
	public static ArrayList<Integer> findEvens(int array[])
	{
		ArrayList<Integer> EvenArray = new ArrayList<Integer>();
		
		for (int val : array)
		{
			if (val % 2 == 0)
			{
				EvenArray.add(val);
			}
		}
		
		return EvenArray;
	}
	
	public static void main(String[] args) 
    {
        
    }
}