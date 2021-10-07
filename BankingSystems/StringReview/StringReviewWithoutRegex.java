package BankingSystem;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class StringReview


{

    //extract all the numbers from the article
    //precondition: token pairs are separated by a single space 
    
    public static ArrayList<Double>extractNumbers(String article)
    {
        ArrayList<Double> numbers = new ArrayList<Double>();
        
        char[] characters = article.toCharArray();
        
        for (int i = 0; i < characters.length; i ++)
        {    
            
            
            try
            {
                Integer.parseInt(String.valueOf(characters[i]));
                
            }
            
            catch(Exception e)
            {
                continue;
            }
            
            int c = 0;
                
            char[] temp = new char[characters.length];
            
            
            for(c = i; c < characters.length; c ++)    
            {
                
                
                if(characters [c] == '.') 
                {
                    temp[c - i] = (characters[c]);
                    continue;
                }
                
                try
                {
                    
                    Integer.parseInt(String.valueOf(characters[c]));
                    
                }
                
                catch(Exception e)
                {
                    break;
                }
                
                temp[c - i] = (characters[c]);
                
            }
            
            i = c;
            
            StringBuilder sb = new StringBuilder();
             
            for (Character ch : temp) 
            {
                sb.append(ch);
            }
     

            String s = sb.toString();

            numbers.add(Double.parseDouble(s));
        }
            
            
            
            
            
            
        
        return numbers;
        
        
    }
    
    
    
    
    //count how many numbers are in the article
    //precondition: same as above
    //postcondition: returns
    
    public static int  countNumbers(String article)
    {
        
        return StringReview.extractNumbers(article).size();
        
    }
    
    
    
    public static void main(String[] args)
            
    {
        System.out.println(StringReview.extractNumbers("8asdffh38.2a"));
    }
            
            
    
}