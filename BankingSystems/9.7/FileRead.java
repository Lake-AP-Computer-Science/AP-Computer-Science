import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class FileRead {

	private String FileName;
	
	public FileRead(String FileName)
	{
		this.FileName = FileName;
	}
	
	public ArrayList<String> GetList() throws Exception
	{
		ArrayList<String>List = new ArrayList<String>();
		
		FileReader FStream = new FileReader(this.FileName);
		BufferedReader In = new BufferedReader(FStream);
		
		String Value = "";
		while (Value != null)
		{
			Value = In.readLine();
			List.add(Value);
		}
		
		In.close();
		
		return List;
	}
	
	public ArrayList<String> GetList(String FileName) throws Exception
	{
		ArrayList<String>List = new ArrayList<String>();
		Scanner Scan = new Scanner(new File(FileName));
		
		while (Scan.hasNextLine())
		{
			String Line = Scan.nextLine();
			List.add(Line);
		}
		
		Scan.close();
		
		return List;
	}
	
}