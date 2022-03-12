package problem5;

import java.awt.Color;
import java.util.ArrayList;

public class ColorPassthroughFilter 
{
	private ReadFile reader;
	private Color familyColor;
	/*Construct a ColorPassthroughFilter by instantiating the reader with the
	 * file name random_colors.txt and initialize the family color;
	 * [2 points]
	 */
	public ColorPassthroughFilter(Color familyColor)  
	{
		reader = new ReadFile("random_colors.txt");
		setFamilyColor(familyColor);
	}
	
	/*
	 * Complete the getters and setters
	 * [3 points]
	 */
	public Color getFamilyColor()
	{
		return this.familyColor;
	}
	
	public void setFamilyColor(Color familyColor)
	{
		this.familyColor = familyColor;
	}
	public ReadFile getReader()
	{
		return this.reader;
	}
	
	/*
	 * Returns true if color is in the family color; returns false otherwise
	 * [5 points] 
	 */
	public boolean canPassthrough(Color color)
	{
		//System.out.println(color);
		
		double ColorDistance = Math.sqrt(Math.pow(color.getRed()-familyColor.getRed(),2)+Math.pow(color.getGreen()-familyColor.getGreen(),2)+Math.pow(color.getBlue()-familyColor.getBlue(),2)); 
	
		//System.out.println(ColorDistance);
		
		return ColorDistance <= 60 * 3;
	}
	
	/*
	 *Returns the list of colors from the file that can pass through the filter.
	 *[5 points]
	 * 
	 */
	public ArrayList<Color> getPassthroughColors()
	{
		ArrayList<Color> Passed, All;
		
		try {
			All = this.getReader().getColors();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Color>();
		}
		
		Passed = new ArrayList<Color>();
		
		for (Color c : All)
		{
			if (canPassthrough(c))
			{
				Passed.add(c);
			}
		}
		
		return Passed;
		
	}
	

}
