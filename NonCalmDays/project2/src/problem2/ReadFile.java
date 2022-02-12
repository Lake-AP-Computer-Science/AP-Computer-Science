package problem2;

import java.io.*;
import java.util.ArrayList;

public class ReadFile //ReadFile copied from lake's code from last project modified for creating Mail objects
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
		ArrayList<Mail> Mails = new ArrayList<Mail>();
		
		try {
			for (String S : getList())
			{
				
				/*
				 * what comes in is a big string such as "PriorityMail, 1.0, 2, 200"
				*we split it at the commas to get each value, and strip() to remove excess spacing for parseType() methods
				*/
				
				String[] Filtered = S.split(",");
				
				String Type = Filtered[0];
				double Weight = Double.parseDouble(Filtered[1].strip());
				int Zone = Integer.parseInt(Filtered[2].strip());
				int Insurance = Integer.parseInt(Filtered[3].strip());
				
				Mail mailType = null;
				
				switch (Type) //create the new Type of mail depending on what is in text file
				{
					case "PriorityMail":
						mailType = new PriorityMail(Weight, Zone);
						break;
					case "FlatRateEnv":
						mailType = new FlatRateEnv(Weight, Zone);
						break;
					case "FlatRateBox":
						mailType = new FlatRateEnv(Weight, Zone);
						break;
					case "MediaMail":
						mailType = new MediaMail(Weight, Zone);
						break;
				}
				
				if (Insurance > 0) //if insured, wrap in Insurance
					mailType = new InsuredMail(mailType, Insurance);
				
				Mails.add(mailType);
			}
		}
		catch (Exception Error)
		{
			Error.printStackTrace(); //oops
		}
		
		return Mails;
	}
}