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
		ArrayList<String> list = new ArrayList<String>();
		
		FileReader fstream = new FileReader(fileName);
		BufferedReader in = new BufferedReader(fstream);
		
		String value = ""; 
		while(value != null)
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
		ArrayList<Mail> mails = new ArrayList<Mail>();
		
		try {
			for (String S : getList())
			{
				String[] deliminated = S.split(",");
				
				String type = deliminated[0];
				double weight = Double.parseDouble(deliminated[1].strip());
				int zone = Integer.parseInt(deliminated[2].strip());
				int insurance = Integer.parseInt(deliminated[3].strip());
				
				Mail mailType = null;
				
				switch (type)
				{
					case "PriorityMail":
						mailType = new PriorityMail(weight, zone);
						break;
					case "FlatRateEnv":
						mailType = new FlatRateEnv(weight, zone);
						break;
					case "FlatRateBox":
						mailType = new FlatRateEnv(weight, zone);
						break;
					case "MediaMail":
						mailType = new MediaMail(weight, zone);
						break;
				}
				
				mailType = new InsuredMail(mailType, insurance);
				
				mails.add(mailType);
			}
		}
		catch (Exception error)
		{
			error.printStackTrace();
		}
		
		return mails;
	}
}