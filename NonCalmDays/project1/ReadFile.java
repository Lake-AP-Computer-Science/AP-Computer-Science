package problem1;
import APCompSci3.problem1.Signal;

import java.io.*;
import java.util.ArrayList;



public class ReadFile
{
	
	private String fileName;
	
	public ReadFile(String fileName)
	{
		this.fileName = fileName;
	}
	
	
	public ArrayList<Signal>getSignals() throws Exception
	{
		ArrayList<Signal>list = new ArrayList<Signal>();
		
		FileReader fstream = new FileReader(fileName);
		BufferedReader in = new BufferedReader(fstream);
		
		String data = "";
		String strength = "";
		while( data != null)
		{
			data = in.readLine();
			strength = in.readLine();
			if(data != null)
			{
				Signal s = new Signal(data, Integer.parseInt(strength));
				list.add(s);
			}
		}
		
		in.close();
		
		return list;
	}
	
	
	
	
}