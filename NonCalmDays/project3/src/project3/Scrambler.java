package project3;

public class Scrambler {
	
	private String encryptedMessage;
	
	//Precondition: encryptedMessage is not null and was properly encrypted 
	public Scrambler(String encryptedMessage) //[1 point]
	{
		this.encryptedMessage = encryptedMessage;
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
		String Return = "";
		
		char[] A = this.encryptedMessage.substring(0, (int)Math.ceil(this.encryptedMessage.length() / 2)).toCharArray();
		char[] B = this.encryptedMessage.substring((int)Math.ceil(this.encryptedMessage.length() / 2), this.encryptedMessage.length()).toCharArray();
		
		for (int i = 0; i < A.length; i++)
		{
			Return += String.valueOf(A[i]);
			
			if (i < B.length)
				Return += String.valueOf(B[i]);
		}
		
		return Return;
		
	}
	
	//Precondition: scrambledEncryptedMessage is not null and was properly encrypted //and scrambled
	//returns the original encrypted message
	public String unscramble(String scrambledEncryptedMessage) //[5 points]
	{
		String A = "";
		String B = "";

		for (int i = 0; i < scrambledEncryptedMessage.length(); ++i)
		{
			if (i % 2 == 0)
				A += String.valueOf(scrambledEncryptedMessage.charAt(i));
			else
				B += String.valueOf(scrambledEncryptedMessage.charAt(i));
		}
		
		return A + B;
	}
	
	public static void main(String args[])
	{
		Scrambler A = new Scrambler("hadlet");
		
		String B = A.scramble();
		
		System.out.println(B);
		
		System.out.println(A.unscramble(B));
		
		
	}
}