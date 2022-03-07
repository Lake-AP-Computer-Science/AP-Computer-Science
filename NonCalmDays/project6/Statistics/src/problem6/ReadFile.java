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
		ArrayList<String> Lines;
		try {
			Lines = getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//todo
	}
	
}
