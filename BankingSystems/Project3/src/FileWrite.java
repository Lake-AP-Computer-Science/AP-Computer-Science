
import java.io.*;

public class FileWrite 
{
	private String fileName;
	
	
	public FileWrite (String fileName)
	{
		this.fileName = fileName + ".txt";
	}
	
	public void writeToFile(String s)
	{
		try
	  	{
	  		// Create file 
	  		FileWriter fstream = new FileWriter(this.fileName);
	  		BufferedWriter out = new BufferedWriter(fstream);
	  		out.write(s);
	  		out.close();  //Close the output stream
	    }
	  
		catch (Exception e) //Catch exception if any
		{
	  	   System.err.println("Error: " + e.getMessage());
		}
	}
	
	
	public void writeToFile(BankAccount b)
	{
		writeToFile(b.toString());
	}

  
}// end class FileWrite