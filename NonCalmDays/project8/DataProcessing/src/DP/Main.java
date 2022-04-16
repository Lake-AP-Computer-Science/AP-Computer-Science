package DP;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) {
		
		while (true)
		{
			
			String Jason = "";
			String Mike = "";
			String Max = "";
			
			int[] data = DataProcessingI.createData(ThreadLocalRandom.current().nextInt(10, 10000));
			
			Jason += ("Orignal List: ");
	        for(int i = 0; i < data.length; i++)
	        {
	        	Jason += (data[i]);
	        }
	        
	        Mike += ("Orignal List: ");
	        for(int i = 0; i < data.length; i++)
	        {
	        	Mike += (data[i]);
	        }
	        
	        Max += ("Orignal List: ");
	        for(int i = 0; i < data.length; i++)
	        {
	        	Max += (data[i]);
	        }
	
	        Jason += ("Sum: " + DataProcessing.sum(data));
	        Mike += ("Sum: " + DataProcessingII.sum(data));
	        Max += ("Sum: " + DataProcessing.sum(data));
	
	        Jason += ("Average: " + DataProcessing.average(data));
	        Mike += ("Average: " + DataProcessingII.average(data));
	        Max += ("Average: " + DataProcessingII.average(data));
	
	        int[] sortedData = DataProcessing.sortArray(data);
	        Jason += ("Sorted Data: ");
	        for(int i = 0; i < sortedData.length; i++)
	        {
	        	Jason += (sortedData[i]);
	        }
	        
	        //System.out.println();
	        
	        sortedData = DataProcessingII.sortArray(data);
	        Mike += ("Sorted Data: ");
	        for(int i = 0; i < sortedData.length; i++)
	        {
	        	Mike += (sortedData[i]);
	        }
	        
	        sortedData = DataProcessingII.sortArray(data);
	        Max += ("Sorted Data: ");
	        for(int i = 0; i < sortedData.length; i++)
	        {
	        	Max += (sortedData[i]);
	        }
	
	        Jason += ("Range: " + DataProcessing.range(data));
	        Mike += ("Range: " + DataProcessingII.range(data));
	        Max += ("Range: " + DataProcessingII.range(data));
	
	        ArrayList<Integer> n = new ArrayList<Integer>();
	        n = DataProcessing.findEvens(data);
	        Jason += ("Even Numbers: ");
	        for(int i = 0; i < n.size(); i++)
	        {
	        	Jason += (n.get(i));
	        }
	        
	        //System.out.println();
	        
	        n = new ArrayList<Integer>();
	        n = DataProcessing.findEvens(data);
	        Mike += ("Even Numbers: ");
	        for(int i = 0; i < n.size(); i++)
	        {
	        	Mike += (n.get(i));
	        }
	        
	        n = new ArrayList<Integer>();
	        n = DataProcessing.findEvens(data);
	        Max += ("Even Numbers: ");
	        for(int i = 0; i < n.size(); i++)
	        {
	        	Max += (n.get(i));
	        }
	        
	        System.out.println(Jason.equals(Mike) && Jason.equals(Max));
		}
	}

}
