package problem2;
import java.io.*;
import java.util.ArrayList;



public class ReadFile 
{
	
	private String fileName;
	
	public ReadFile(String fileName)
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
	
	public ArrayList<Mail> getMails()
	{
		ArrayList<Mail> Returns = new ArrayList<Mail>();
		
		try {
			for (String S : getList())
			{
				String[] Delimed = S.split(",");
				
				String Type = Delimed[0];
				double Weight = Double.parseDouble(Delimed[1].strip());
				int Zone = Integer.parseInt(Delimed[2].strip());
				int Insurance = Integer.parseInt(Delimed[3].strip());
				
				Mail M = null;
				
				switch (Type)
				{
					case "PriorityMail":
						M = new PriorityMail(Weight, Zone);
						break;
					case "FlatRateEnv":
						M = new FlatRateEnv(Weight, Zone);
						break;
					case "FlatRateBox":
						M = new FlatRateEnv(Weight, Zone);
						break;
					case "MediaMail":
						M = new MediaMail(Weight, Zone);
						break;
				}
				
				M = new InsuredMail(M, Insurance);
				
				Returns.add(M);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Returns;
	}
	
	public static void main(String[] args) {
		ReadFile F = new ReadFile("Signals.txt");
		
		for (Mail S : F.getMails())
		{
			System.out.println(S);
		}
	}
	
}
