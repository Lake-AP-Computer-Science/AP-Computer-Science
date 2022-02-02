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
	
	public ArrayList<Signal> getSignals()
	{
		try {
			
			ArrayList<String> Inputs = getList();
			
			ArrayList<Signal> OutSignals = new ArrayList<Signal>();
			
			for (int i = 0; i < Inputs.size(); i += 2)
			{
				String Message = Inputs.get(i);
				String Strength = Inputs.get(i + 1);
				
				// Make sure it works - uncomment to test 
				//System.out.println("BData: " + BinaryData); System.out.println("Strength: " + Strength); System.out.println();
				
				OutSignals.add(new Signal(Message, Integer.parseInt(Strength)));
			}
			
			return OutSignals;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			return new ArrayList<Signal>();
		}
	}
	
	public ArrayList<Node> getNodes()
	{
		ArrayList<Node> Nodes = new ArrayList<Node>();
		
		for (Signal S : getSignals())
			Nodes.add(new Node(S));
		
		return Nodes;
	}
	
	public static void main(String[] args) {
		ReadFile F = new ReadFile("Signals.txt");
		
		for (Signal S : F.getSignals())
		{
			System.out.println(S);
		}
	}
	
}
