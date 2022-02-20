package Codes;

import java.util.ArrayList;
import java.util.Arrays;

public class AviCryptic {
  private String keycode;
  
  //initializes the keycode – creates a String with the 10 digits (0 – 9) in a random order
  public AviCryptic() //[5 points]
  {
    keycode = "";
    ArrayList<Integer> digits = new ArrayList<>(Arrays.asList(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 0
                                                             ));
    while (digits.size() > 0){
      int rand = (int)(Math.random() *  digits.size());
      keycode += "" + digits.get(rand);
      digits.remove(rand);
    }
  }
  
  //Create a public accessor method to get the generated keycode [2 points]
  
  public String getKeycode() {
    return keycode;
  }
  
  public void setKeycode(String keycode) {
    this.keycode = keycode;
  }
  
  //Precondition: sourceChar and keyChar are one-character Strings and are not null
  //Postcondition: returns an encrypted one-character String
  private String getCode(String sourceChar, String keyChar) //[5 points]
  {
    int sourceInt = (int)(sourceChar.charAt(0));
    int shiftInt = Integer.parseInt(keycode.charAt(0) + "");
    char coded = (char)(sourceInt + shiftInt);
    return "" + coded;
  }
  //Precondition: codedChar and keyChar are one-character Strings and are not null
  //Postcondition: returns a decrypted one-character String
  private String getSource(String codedChar, String keyChar) //[5 points]
  {
    int codeInt = (int)(codedChar.charAt(0));
    int shiftInt = Integer.parseInt(keycode.charAt(0) + "");
    char decoded = (char)(codeInt - shiftInt);
    return "" + decoded;
  }
  
  //Precondition: source and key are not null
  //Postcondition: returns the entire encrypted message
  public String encrypt(String source, String key) //[5 points]
  {
    String coded = "";
    String wrappedKey = wrapKey(key);
    
    for(int i = 0; i < source.length(); i++) {
      int sourceInt = (int)(source.charAt(i));
      int shiftInt = Integer.parseInt(wrappedKey.charAt(i % wrappedKey.length()) + "");
      coded += "" + ((char)(sourceInt + shiftInt));
    }
    return coded;
  }
  //Precondition: coded and key are not null
  //Postcondition: returns the entire decrypted message
  public String decrypt(String coded, String key) //[5 points]
  {
    String decoded = "";
    String wrappedKey = wrapKey(key);
    
    for(int i = 0; i < coded.length(); i++) {
      int codeInt = (int)(coded.charAt(i));
      int shiftInt = Integer.parseInt(wrappedKey.charAt(i % wrappedKey.length()) + "");
      decoded += "" + ((char)(codeInt - shiftInt));
    }
    return decoded;
  }
  
  //wraps the key to make it viable.
  private String wrapKey(String key){
    //if key length is less than keycode length, use a substring.
    if(key.length() <= keycode.length())return keycode.substring(0, key.length());
    //otherwise, continually wrap the key.
    else{
      String wrapped = "";
      for(int i = 0; i < key.length(); i++) {
        wrapped += keycode.charAt(i % keycode.length());
      }
      return wrapped;
    }
  }
}
