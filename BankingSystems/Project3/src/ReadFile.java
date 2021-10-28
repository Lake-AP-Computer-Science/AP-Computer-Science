import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class ReadFile 
{
	private Scanner scanner;
	
	private String fileName;
	
	public ReadFile(String fileName)
	{
		this.fileName = fileName + ".txt";
	}
	
	
	//getList is an overloaded method
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
	
	
	
	
	public ArrayList<String> getList(String fileName) throws Exception
	{
		ArrayList<String>list = new ArrayList<String>();
		scanner = new Scanner(new File(fileName));
		
		while(scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			list.add(line);
		}
		scanner.close();
		return list;
	}
	
	
}
