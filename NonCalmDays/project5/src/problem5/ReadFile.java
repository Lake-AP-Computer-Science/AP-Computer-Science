package problem5;

import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class ReadFile 
{
	private String fileName;
	
	public ReadFile(String fileName)
	{
		this.fileName = fileName;
	}
	
	/*Get the list of Color objects from the file.
	 * [10 points]
	 */
	public ArrayList<Color> getColors() throws Exception
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
		
		ArrayList<Color> colorList = new ArrayList<Color>();
		String bits = list.get(0);
		
		for(int i = 0; i < 20; i++) 
		{
			String currentBits = bits.substring(i*24, i*24+24);
			int decimal = Integer.parseInt(currentBits, 2);
			
			String hexCode = Integer.toHexString(decimal);
			colorList.add(Color.decode("#" + hexCode));
		}
		
		return colorList;
	}
}
