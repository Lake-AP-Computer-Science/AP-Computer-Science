package project3;

public class Scrambler {
	
	private String encryptedMessage;
	
	//Precondition: encryptedMessage is not null and was properly encrypted 
	public Scrambler(String encryptedMessage) //[1 point]
	{
	}
	
	//returns the encryptedMessage
	public String getEncryptedMessage() //[1 point] 
	{
		return encryptedMessage;
	}
	//Precondition: encryptedMessage is not null and was properly encrypted //changes the current encrypted message to another one
	public void setEncryptedMessage(String encryptedMessage) //[1 point]
	{
		this.encryptedMessage = encryptedMessage;
	}
	//returns the scrambled encrypted message based on the algorithm described above 
	
	public String scramble() //[5 points]
	{
		return null;
	}
	
	//Precondition: scrambledEncryptedMessage is not null and was properly encrypted //and scrambled
	//returns the original encrypted message
	public String unscramble(String scrambledEncryptedMessage) //[5 points]
	{
		return null;Í
	}
}