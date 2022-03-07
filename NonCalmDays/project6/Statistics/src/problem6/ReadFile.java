package problem6;
import java.io.*;
import java.util.ArrayList;

public class ReadFile 
{
	
	private String fileName;
	
	public ReadFile(String fileName) //lake requirement
	{
		this.fileName = fileName;
	}
	
	
	public ArrayList<String> getList() throws Exception
	{
		ArrayList<String>list = new ArrayList<String>();
		
		FileReader fstream = new FileReader(fileName);
		BufferedReader in = new BufferedReader(fstream);
		
		String value = ""; 
		while( value != null)
		{
		    value = in.readLine();
		    if(value != null)
		    {
		    	list.add(value);
		    }
		}
		
		in.close();
		
		return list;
	}
	
	public void RunFromFile()
	{
		ArrayList<String> Lines = null;
		
		try {
			Lines = getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (String Line : Lines)
		{
			
			String List = Line.replace("}", " ").replace("{", " ").split("  ")[1];
			
			int n = List.split(", ").length;
			
			int[] IntedList = new int[n];
			
			for (int i = 0; i < n; ++i)
			{
				IntedList[i] = Integer.parseInt(List.split(", ")[i].replace(" ", ""));
			}
 			
			if (Line.contains("mode"))
			{
				System.out.println(Statistics.getMode(IntedList));
			}
			else 
			{
				System.out.println(Statistics.getMean(IntedList));
			}
		}
	}
	
}
