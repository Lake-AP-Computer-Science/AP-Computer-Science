package problem5;

import java.awt.Color;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.swing.JFrame;


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
        String Contents = "";
        FileReader fstream = new FileReader(fileName);
        BufferedReader in = new BufferedReader(fstream);
        
        String value = ""; 
        do
        {
            Contents += value;
            value = in.readLine();
        }while(value != null);
        in.close();
        
//        System.out.println(Contents);
        
        ArrayList<Color> ColorObjects = new ArrayList<Color>();
        
        for (int i = 0; i < 20; ++i)
        {
            String Colors = Contents.substring(i * 24, i * 24 + 24);
            
            //System.out.println(Colors);
            
            int R = Integer.parseInt((new BigInteger(Colors.substring(0, 8), 2)).toString(10));
            int G = Integer.parseInt((new BigInteger(Colors.substring(8, 16), 2)).toString(10));
            int B = Integer.parseInt((new BigInteger(Colors.substring(16, 24), 2)).toString(10));
            
            ColorObjects.add(new Color(R, G, B));
        }
        
        return ColorObjects;
    }
    
    public static void main(String[] args) 
    {
        ReadFile F = new ReadFile("random_colors.txt");
        
        try {
            for (Color c : F.getColors()) 
            {
                System.out.println(c);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
}