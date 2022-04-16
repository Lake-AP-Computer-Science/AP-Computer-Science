package DP;

import java.util.ArrayList;

public class DataProcessingII
{
	//returns a random array of integers on the interval [10, 50]
	//of length n [5 points]
	public static int[] createData(int n)
	{
		int[] data = new int[n];
	
		for(int i = 0; i < n; i++)
		{
			data[i] = (int)(Math.random() * (50 - 10 + 1) + 10); 
		}
		return data;
	}
	
	//returns the sum of all the values in array [5 points]
	public static int sum(int array[])
	{
		int sum = 0;
		
		for(int i = 0; i < array.length; i++)
		{
			sum += array[i];
		}
		
		return sum;
	}
	
	//returns the average of all the values in array [5 points]
	public static double average(int array[])
	{
		return sum(array)/(double)array.length;
	}
	
	//returns a sorted array of integers [5 points]
	public static int[] sortArray(int array[])
	{
		int[] temp = new int[array.length];
		mSort(array, temp, 0, array.length - 1);
		return array;
	}
	
	//returns the range of the values in the array
	//The range is the difference between the largest and smallest 
	//values in the array [5 points]
	public static int range(int array[])
	{
		int max = array[0];
		int min = array[0];
		
		for(int i = 0; i < array.length; i++)
		{
			if(max < array[i])
			{
				max = array[i];
			}
			if(min > array[i])
			{
				min = array[i];
			}
		}
		return max - min;
	}
	
	//return the even integers in the array as a list [5 points] 
	public static ArrayList<Integer> findEvens(int array[])
	{
		ArrayList<Integer> evens = new ArrayList<Integer>();
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] % 2 == 0)
			{
				evens.add(array[i]);
			}
		}
		return evens;
	}
	
	//helper methods
	private static void merge(int[] arr, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd)
	{
		int i = leftStart;    
		int j = rightStart;   
		int k = leftStart;    

		while(i <= leftEnd && j <= rightEnd)
			if (arr[i] < arr[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];

		while(i <= leftEnd)
			temp[k++] = arr[i++];

		while(j <= rightEnd)
			temp[k++] = arr[j++];

		for(i = leftStart; i <= rightEnd; i++)
			arr[i] = temp[i];
	}

	private static void mSort(int[] array, int[] temp, int start, int end)
	{
		if (start >= end)
		{
			return;
		}
		
		int middle = (start + end)/2;
		
		mSort(array, temp, start, middle);
		mSort(array, temp, middle + 1, end);
		merge(array, temp, start, middle, middle + 1, end);
	}

	//main method
	public static void main(String[] args) 
	{
		int[] data = createData(10);
		System.out.print("Orignal List: ");
		for(int i = 0; i < data.length; i++)
		{
				System.out.print(data[i]);
				System.out.print(" ");
		}
		
		System.out.println();
		
		System.out.println("Sum: " + sum(data));
		
		System.out.println("Average: " + average(data));
		
		int[] sortedData = sortArray(data);
		System.out.print("Sorted Data: ");
		for(int i = 0; i < sortedData.length; i++)
		{
				System.out.print(sortedData[i]);
				System.out.print(" ");
		}
		
		System.out.println();
		
		System.out.println("Range: " + range(data));
		
		ArrayList<Integer> n = new ArrayList<Integer>();
		n = findEvens(data);
		System.out.print("Even Numbers: ");
		for(int i = 0; i < n.size(); i++)
		{
				System.out.print(n.get(i));
				System.out.print(" ");
		}
	}
}