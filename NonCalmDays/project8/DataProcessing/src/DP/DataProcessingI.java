package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DataProcessingI
{
    
    //returns a random array of integers on the interval [10, 50]
    //of length n [5 points]
    public static int[] createData(int n)
    {
        Random rand = new Random();
        int nums[] = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = rand.nextInt(41) + 10;
        }
        return nums;
    }
    
    //returns the sum of all the values in array [5 points]
    public static int sum(int array[])
    {
        int sum = 0;
        for(int i : array) {
            sum += i;
        }
        return sum;
    }
    
    //returns the average of all the values in array [5 points]
    public static double average(int array[])
    {
        return sum(array)/array.length;
    }
    
    //returns a sorted array of integers [5 points]
    public static int[] sortArray(int array[])
    {
        Arrays.sort(array);
        return array;
    }
    //returns the range of the values in the array
    //The range is the difference between the largest and smallest
    //values in the array [5 points]
    public static int range(int array[])
    {
        array = sortArray(array);
        return array[array.length-1] - array[0];
    }
    
    //return the even integers in the array as a list [5 points]
    public static ArrayList<Integer> findEvens(int array[])
    {
        ArrayList<Integer> evens = new ArrayList<Integer>();
        for(int i : array) {
            if(i % 2 == 0)
                evens.add(i);
        }
        return evens;
    }
    
    public static void main(String[] args)
    {
        int num[] = createData(5000);
        num = sortArray(num);
        for(int i : num) {
            System.out.print(i + " ");
        }
    }
}