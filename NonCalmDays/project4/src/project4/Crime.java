import java.util.TreeMap;

public class Crime
{
    private String victimName, perpetratorName, typeOfCrime;
    TreeMap<String, Integer> Types = new TreeMap<>();
    TreeMap<String, Integer> crimes =  new TreeMap<>();
    
    public Crime(String vName, String pName, String typeOfCrime) //[3 points]
    {
        this.victimName = vName;
        this.perpetratorName = pName;
        this.typeOfCrime = typeOfCrime;
        
        Types.put("Civil Case", 2);
        Types.put("Criminal Case", 1);
        Types.put("Juvenile Case", 3);
        Types.put("Traffic Case", 4);        
        
        crimes.put("Aiding and Abetting/Accessory", 9);
        crimes.put("Arson", 8);
        crimes.put("Assault and Battery", 7);
        crimes.put("Bribery", 15);
        crimes.put("Burglary", 14);
        crimes.put("Child Abuse", 5);
        crimes.put("Computer Crime", 16);
        crimes.put("Conspiracy", 17);
        crimes.put("Credit/Debit Card Fraud", 18);
        crimes.put("Disorderly Conduct", 19);
        crimes.put("Domestic Violence", 10);
        crimes.put("Drug Cultivation", 20);
        crimes.put("Drug Distribution/Trafficking", 21);
        crimes.put("Drug Cultivation and Manufacturing", 22);
        crimes.put("Drug Possession", 23);
        crimes.put("Kidnapping", 6);
        crimes.put("Involuntary Manslaughter", 4);
        crimes.put("Voluntary Manslaughter", 3);
        crimes.put("First Degree Murder", 1);
        crimes.put("Second Degree Murder", 2);
        crimes.put("Perjury", 12);
        crimes.put("Robbery", 11);
        crimes.put("Theft/Larceny", 13);
    }
    
    //Do not create an instance variable to hold the priority.
    //Instead use a TreeMap to store the crime priorities according to the listed ones above.
    //Combines the case type digit with the crime value to generate a priority number.
    public int getPriority() //[3 points]
    {
        String[] str = typeOfCrime.split(" ");
        return Integer.parseInt(Types.get(str[0] + " " + str[1]) + String.valueOf(crimes.get(String.join(" ", Arrays.copyOfRange(str, 2, str.length)))));
    }
    
    //toString
    public String toString()
    {
        return "Victim Name: " + victimName + "; Perpetrator Name: " + perpetratorName + "; Crime: " + typeOfCrime + ";"; 
    }
    
    public static void main() 
    {
    	Crime C = new Crime("Me", "Larry", "Civil First Degree Murder");
    	
    	System.out.println(C);
    }
}