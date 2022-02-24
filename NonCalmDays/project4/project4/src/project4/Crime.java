//Crime
//A Crime “has-a” victim name, perpetrator name, and type of crime. The type of crime is taken
//from the list of common crimes provided above with the same spelling. The get priority method
//stores this information in a TreeMap and uses the combined priorities to generate a priority for
//a particular case type and crime. For example, a criminal case with child abuse has the number
//15 because criminal case = 1 and child abuse = 5. Complete the Crime class below.

package project4;

public class Crime
{
	private String victimName, perpetratorName, typeOfCrime;
	public Crime(String vName, String pName, String typeOfCrime) //[3 points]
	{
		setVictimName(vName);
		setPerpetratorName(pName);
		setTypeOfCrime(typeOfCrime);
	}
		
	//Do not create an instance variable to hold the priority.
	// Instead use a TreeMap to store the crime priorities according to the listed ones above.
	//Combines the case type digit with the crime value to generate a priority number.
	public int getPriority() //[3 points]
	{
		
	}
	
	public String getVictimName() {
		return victimName;
	}
	public void setVictimName(String victimName) {
		this.victimName = victimName;
	}
	public String getPerpetratorName() {
		return perpetratorName;
	}
	public void setPerpetratorName(String perpetratorName) {
		this.perpetratorName = perpetratorName;
	}
	public String getTypeOfCrime() {
		return typeOfCrime;
	}
	public void setTypeOfCrime(String typeOfCrime) {
		this.typeOfCrime = typeOfCrime;
	}
}