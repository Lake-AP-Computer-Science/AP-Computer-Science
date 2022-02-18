package project3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cryptic
{
	private String keycode;
	
	//initializes the keycode – creates a String with the 10 digits (0 – 9) in a random order 
	public Cryptic() //[5 points]
	{
		keycode = "";
		
		ArrayList<Integer> Ten = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		
		Collections.shuffle(Ten);
		
		while (!Ten.isEmpty())
			keycode += String.valueOf(Ten.remove(0));
	}

	//Create a public accessor method to get the generated keycode [2 points]
	public String getKeycode() {
		return keycode;
	}

	public void setKeycode(String keycode) {
		this.keycode = keycode;
	}
	
	//Precondition: sourceChar and keyChar are one-character Strings and are not null //Postcondition: returns an encrypted one-character String
	private String getCode(String sourceChar, String keyChar) //[5 points]
	{
		return Character.toString((int)(sourceChar.toCharArray()[0]) + (int)(keyChar.toCharArray()[0]));
	}

	//Precondition: codedChar and keyChar are one-character Strings and are not null //Postcondition: returns a decrypted one-character String
	private String getSource(String codedChar, String keyChar) //[5 points]
	{
		return Character.toString((int)(codedChar.toCharArray()[0]) - (int)(keyChar.toCharArray()[0]));
	}
	
	//Precondition: source and key are not null //Postcondition: returns the entire encrypted message
	public String encrypt(String source, String key) //[5 points] 
	{
		String Return = "";
		
		String Code = keycode.substring(0, key.length());
		
		for (int i = 0; i < source.length(); i++)
		{
			Return += getCode(String.valueOf(source.charAt(i)), String.valueOf((char)Integer.parseInt(String.valueOf(Code.charAt(i % Code.length()))))); //String.valueOf(key.charAt(i % key.length())));
		}
		
		return Return;
	}
	//Precondition: coded and key are not null //Postcondition: returns the entire decrypted message 
	public String decrypt(String coded, String key) //[5 points] 
	{
		String Return = "";
		
		String Code = keycode.substring(0, key.length());
		
		for (int i = 0; i < coded.length(); i++)
		{
			Return += getSource(String.valueOf(coded.charAt(i)), String.valueOf((char)Integer.parseInt(String.valueOf(Code.charAt(i % Code.length()))))); //String.valueOf(key.charAt(i % key.length())));
		}
		
		return Return;
	}
	
	public static void main(String args[])
	{
		Cryptic C = new Cryptic();
		
/*Test case 1 - Lake monday case*/

//		C.setKeycode("920175");
//		
//		System.out.println(C.getKeycode());
//		
//		String Encrypted = C.encrypt("DISCOMBOBULATED", "MONDAY");
//		String Decrypted = C.decrypt(Encrypted, "MONDAY");
//		
//		System.out.println("Get Encrypted: " + Encrypted);
//		System.out.println("Get Decrypted: " + Decrypted);
		
/* Expected output:
 * 920175
 * Get Encrypted: MKSDVRKQBVSF]GD
 * Get Decrypted: DISCOMBOBULATED
 */
		
/*Test case 2 - A shift case*/
		
//		C.setKeycode("123456789");
//		
//		String Encrypted = C.encrypt("aaaaaa", "a"); //shifting a one should be b
//		String Decrypted = C.decrypt(Encrypted, "a");
//		
//		System.out.println("Get Encrypted: " + Encrypted);
//		System.out.println("Get Decrypted: " + Decrypted);
		
/* Expected output:
 * Get Encrypted: bbbbbb
 * Get Decrypted: aaaaaa
 */
		
		
		
		
	}

}