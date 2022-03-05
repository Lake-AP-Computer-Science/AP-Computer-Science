package Package4;

import java.util.TreeMap;

public class Crime {
  private String victimName, perpetratorName, typeOfCrime;
  private TreeMap <String, Integer> crimeInfo;
  
  public Crime(String victimName, String perpetratorName, String typeOfCrime) {
    this.victimName = victimName;
    this.perpetratorName = perpetratorName;
    this.typeOfCrime = typeOfCrime;
    createCrimeInfo();
  }
  
  private void createCrimeInfo(){
    crimeInfo =  new TreeMap<>(); //priority, determiner
  
    for(int i = 1; i <= 4; i++) {
      String s = "";
      switch(i){
        case 1: s = "Criminal Case "; break;
        case 2: s = "Civil Case  "; break;
        case 3: s = "Juvenile Case "; break;
        case 4: s = "Traffic Case "; break;
      }
      crimeInfo.put(s + "Aiding and Abetting/Accessory", i * 100 + 11 );
      crimeInfo.put(s + "Arson", i * 100 + 8);
      crimeInfo.put(s + "Assault and Battery" , i * 100 + 7);
      crimeInfo.put(s + "Bribery",  i * 100 + 15);
      crimeInfo.put(s + "Burglary", i * 100 + 14);
      crimeInfo.put(s + "Child Abuse" , i * 100 + 5);
      crimeInfo.put(s + "Computer Crime" , i * 100 + 16);
      crimeInfo.put(s + "Conspiracy", i * 100 +17);
      crimeInfo.put(s + "Credit/Debit Card Fraud", i * 100 +18);
      crimeInfo.put(s + "Disorderly Conduct", i * 100 + 19);
      crimeInfo.put(s + "Domestic Violence", i * 100 + 10);
      crimeInfo.put(s + "Drug Cultivation", i * 100 + 20);
      crimeInfo.put(s + "Drug Distribution/Trafficking", i * 100 +21);
      crimeInfo.put(s + "Drug Cultivation and Manufacturing", i * 100 +22);
      crimeInfo.put(s + "Drug Possession" , i * 100 +23);
      crimeInfo.put(s + "Kidnapping", i * 100 +60);
      crimeInfo.put(s + "Involuntary Manslaughter", i * 100 +40);
      crimeInfo.put(s + "Voluntary Manslaughter", i * 100 +30);
      crimeInfo.put(s + "First Degree Murder", i * 100 +11);
      crimeInfo.put(s + "Second Degree Murder", i * 100 +20);
      crimeInfo.put(s + "Perjury", i * 100 +12);
      crimeInfo.put(s + "Robbery", i * 100 +11);
      crimeInfo.put(s + "Theft/Larceny", i * 100 +13);
    }
    
    
    System.out.println("crimeInfo = " + crimeInfo);
  }
  
  //Do not create an instance variable to hold the priority.
// Instead use a TreeMap to store the crime priorities according to the listed ones above.
//Combines the case type digit with the crime value to generate a priority number.
  public int getPriority(){
    return crimeInfo.get(typeOfCrime);
  }
  
  public static void main(String[] args) {
    
  }
}
