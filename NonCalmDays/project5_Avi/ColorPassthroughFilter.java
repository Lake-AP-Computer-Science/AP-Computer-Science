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
        this.familyColor = familyColor;
        this.reader = new ReadFile(ColorDisplay.fileName);
    }
   
    /*
	 * Complete the getters and setters
	 * [3 points]
	 */
    public Color getFamilyColor()
    {
        return familyColor;
    }
    
    public void setFamilyColor(Color familyColor)
    {
        this.familyColor = familyColor;
    }
    
    public ReadFile getReader()
    {
        return reader;
    }
    
    public void setReader(ReadFile reader)
    {
        this.reader = reader;
    }
    
    public void setReader(String filename)
    {
        this.reader = new ReadFile(filename);
    }
    
    /*
     * Returns true if color is in the family color; returns false otherwise
     * [5 points] 
     */
    public boolean canPassthrough(Color color)
    { 
        int hueDifference = 12;
       
        int rThis = familyColor.getRed();
        int gThis = familyColor.getGreen();
        int bThis = familyColor.getBlue();
        float[] hsvThis = new float[3];
        Color.RGBtoHSB(rThis, gThis, bThis, hsvThis);
        
        int rOther = color.getRed();
        int gOther = color.getGreen();
        int bOther = color.getBlue();
        float[] hsvOther = new float[3];
        Color.RGBtoHSB(rOther, gOther, bOther, hsvOther);
        
        int trueHueDifference = (int)(hueDifference + 100 - hsvThis[2] * 100);
        int trueSatDifference = (int)(25 + 100 - hsvThis[2] * 100);
        
        if(hsvThis[0] * 360 >= 360 - hueDifference || hsvOther[0] * 360 >= 360 - hueDifference)
        {
            if(
            (Math.abs(hsvThis[0] - hsvOther[0])* 360 >= 360 - trueHueDifference ||
            Math.abs(hsvThis[0] - hsvOther[0]) * 360 <= trueHueDifference) && 
            Math.abs(hsvThis[1] - hsvOther[1]) * 100 <= trueSatDifference && 
            Math.abs(hsvThis[2] - hsvOther[2]) * 100 <= 50
            )
            {
                return true;
            }
        }
        
        if(
        Math.abs(hsvThis[0] - hsvOther[0]) * 360 <= trueHueDifference &&
        Math.abs(hsvThis[1] - hsvOther[1]) * 100 <= trueSatDifference &&
        Math.abs(hsvThis[2] - hsvOther[2]) * 100 <= 50
        )
        {
            return true;
        }
        return false;
    }
    
    /*
     *Returns the list of colors from the file that can pass through the filter.
     *[5 points]
     * 
     */
    public ArrayList<Color> getPassthroughColors() throws Exception
    {
        ArrayList<Color> colors = reader.getColors();
        ArrayList<Color> passedColors = new ArrayList<>();
        
        for(int i = 0; i < colors.size(); i++)
        {
            if(canPassthrough(colors.get(i)))
            {
                passedColors.add(colors.get(i));
            }
        }
        return passedColors;
    }
}