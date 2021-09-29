import java.io.*;

public class FileWrite {

	private String FileName;
	
	public FileWrite(String FileName)
	{
		this.FileName = FileName + ".txt";
	}
	
	public void WriteToFile(String S)
	{
		try
		{
			FileWriter FStream = new FileWriter(this.FileName);
			BufferedWriter Out = new BufferedWriter(FStream);
			Out.write(S);
			Out.close();
		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public void WriteToFile(BankingSystems A)
	{
		WriteToFile(A.toString());
	}
}
