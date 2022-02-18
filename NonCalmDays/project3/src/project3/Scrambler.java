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
	
	public static void main(String args[])
	{

//ty max for writing these test cases <3
		
/* Test Case 0 - hadlet */
		
	    Scrambler s = new Scrambler("hadlet");
		
/* Expected Output: 
Get Scrambled: hlaedt
Get Unscrambled: hadlet
 * */
              
/* Test Case 1 - Monday */ 

//		Scrambler s = new Scrambler("monday");
        
/* Expected Output: 
Get Scrambled: mdoany
Get Unscrambled: monday
* */

/* Test Case 2 - Alphabet (ODD NUMBERED CASE) */

//	      Scrambler s = new Scrambler("abcde");

/* Expected Output:
Get Scrambled: adbec
Get Unscrambled: abcde
 */
      
/* Test Case 3 - mixed */
		
//      Scrambler s = new Scrambler("29[]ds2hiwefoihpjq23");
  
/* Expected Output:
Get Scrambled: 2e9f[o]idhsp2jhqi2w3
Get Unscrambled: 29[]ds2hiwefoihpjq23
*/
		
/* Test Case 4 - one-char edge case */

//      Scrambler s = new Scrambler("a");

/* Expected Output:
Get Scrambled: a
Get Unscrambled: a
*/
      
/* Test Case 5 - how good you are at code */

//      Scrambler s = new Scrambler("poopoo");
      
/* Expected Output:
Get Scrambled: ppoooo
Get Unscrambled: poopoo
*/
      
/* Test Case 6 - Lake Level Test Case */
		
		/*this case is too long for human grading so script will say if you passed or not.*/
		
//		String Original = "iohewoiuebohfljkvwiosdhvoweifhnvopwedkcsjkoiuwejdvnoiweunvi0982379408170398247123";
//		String ScrambledExpected = "ikoohieuwwoeijudevbnoohifwlejuknvvwii0o9s8d2h3v7o9w4e0i8f1h7n0v3o9p8w2e4d7k1c2s3j";
//		String UnscrambledExpected = "iohewoiuebohfljkvwiosdhvoweifhnvopwedkcsjkoiuwejdvnoiweunvi0982379408170398247123";
//		
//        Scrambler s = new Scrambler(Original);
//	      
//      	System.out.println("Scrambled Case Passed?: " + ScrambledExpected.equals(s.scramble()));
//      	System.out.println("Unscrambled Case Passed?: " + UnscrambledExpected.equals(s.unscramble(s.getEncryptedMessage())) + "\n");
		
      	//keep below code uncommented, universal for all cases
      	
      	System.out.println("Get Scrambled: " + s.scramble());
        System.out.println("Get Unscrambled: " + s.unscramble(s.getEncryptedMessage()));
      	
	}
}