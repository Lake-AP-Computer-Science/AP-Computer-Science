package Codes;

import java.util.Random;

public class TestCaseRunner {
	
	public static void main(String[] args) {
	  
		while (true)
		{
			String code = new JasonCryptic().getKeycode();
			
			Random RNG = new Random();
			int Gen = RNG.nextInt(10);
			
			String TestString = getSaltString(Gen);
			String TestKey = getSaltString(Gen);
			
			AviCryptic AC = new AviCryptic();
			AC.setKeycode(code);
			JasonCryptic JC = new JasonCryptic();
			JC.setKeycode(code);
			
			String ACE = AC.encrypt(TestString, TestKey);
			
			String JCE = JC.encrypt(TestString, TestKey);
			
			AviScrambler AS = new AviScrambler(JCE + ACE);
			JasonScrambler JS = new JasonScrambler(ACE + JCE);
			
			AS.setEncryptedMessage(AS.scramble()); 
			JS.scramble();
			
			String ACD = JC.decrypt(ACE, TestKey);
			String JCD = AC.decrypt(JCE, TestKey);
			
			if (ACE.equals(JCE) && JCD.equals(ACD) && AS.getEncryptedMessage().equals(JS.getEncryptedMessage()) && AS.unscramble(JS.getEncryptedMessage()).equals(JS.unscramble(AS.getEncryptedMessage())))
			{
				System.out.print("true");
			}
			else
			{
				System.out.print("false");
			}
			
			
			
			System.out.println(" TestString: " + TestString + " TestKey: " + TestKey + " Code: " + code + " Avi encrypted: " + ACE + " Jason encrypted: " + JCE + " Avi Decrypted: " + ACD + " Jason Decrypted: " + JCD);
		}
	}
	
	public static String getSaltString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
