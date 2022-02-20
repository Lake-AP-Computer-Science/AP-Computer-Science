package Codes;

public class JasonScrambler {
	
	private String encryptedMessage;
	
	//Precondition: encryptedMessage is not null and was properly encrypted 
	public JasonScrambler(String encryptedMessage) //[1 point]
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
		
		char[] A = this.encryptedMessage.substring(0, (int)Math.ceil((double)this.encryptedMessage.length() / 2)).toCharArray();
		//System.out.println(A);
		char[] B = this.encryptedMessage.substring((int)Math.ceil((double)this.encryptedMessage.length() / 2), this.encryptedMessage.length()).toCharArray();
		//System.out.println(B);
		
		for (int i = 0; i < A.length; i++)
		{
			Return += String.valueOf(A[i]);
			
			if (i < B.length)
				Return += String.valueOf(B[i]);
		}
		
		this.encryptedMessage = Return;
		
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
		
		this.encryptedMessage = A + B;
		
		return A + B;
	}
}