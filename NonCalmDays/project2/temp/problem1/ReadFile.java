package problem1;
import java.io.*;
import java.util.ArrayList;

public class ReadFile 
{
	private String fileName;
	
	public ReadFile(String fileName)
	{
		this.fileName = fileName;
	}
	
	public ArrayList<String>getList() throws Exception
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
	
	public ArrayList<Signal> getSignals()
	{
		try
		{
			
			ArrayList<String> inputs = getList();
			
			ArrayList<Signal> outputs = new ArrayList<Signal>();
			
			for(int i = 0; i < inputs.size(); i += 2)
			{
				String Message = inputs.get(i);
				String Strength = inputs.get(i + 1);
				
				outputs.add(new Signal(Message, Integer.parseInt(Strength)));
			}
			return outputs;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			
			return new ArrayList<Signal>();
		}
	}
	
	public ArrayList<Node> getNodes()
	{
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		for(Signal s : getSignals())
			nodes.add(new Node(s));
		
		return nodes;
	}
}