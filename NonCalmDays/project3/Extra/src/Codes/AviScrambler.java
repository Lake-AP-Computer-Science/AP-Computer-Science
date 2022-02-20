package Codes;

public class AviScrambler {
  private String encryptedMessage;
  //Precondition: encryptedMessage is not null and was properly encrypted
  AviScrambler(String encryptedMessage) //[1 point]
  {
    this.encryptedMessage = encryptedMessage;
  }
  //returns the encryptedMessage
  public String getEncryptedMessage() //[1 point]
  {
    return encryptedMessage;
  }
  //Precondition: encryptedMessage is not null and was properly encrypted
//changes the current encrypted message to another one
  public void setEncryptedMessage(String encryptedMessage) //[1 point]
  {
    this.encryptedMessage = encryptedMessage;
  }
  //returns the scrambled encrypted message based on the algorithm described above
  public String scramble() //[5 points]
  {
    int splitPoint = (int)(Math.round(encryptedMessage.length()/2.0));
    String s1 = encryptedMessage.substring(0, splitPoint);
    String s2 = encryptedMessage.substring(splitPoint, encryptedMessage.length());
    String scrambled = "";
    for(int i = 0; i < encryptedMessage.length(); i++) {
      if(i % 2 == 0){
        scrambled += s1.charAt(i/2);
      }
      if(i % 2 == 1){
        scrambled += s2.charAt(i/2);
      }
    }
    return scrambled;
  }
  //Precondition: scrambledEncryptedMessage is not null and was properly encrypted
//and scrambled
//returns the original encrypted message
  public String unscramble(String scrambledEncryptedMessage) //[5 points]
  {
    String s1 = "";
    String s2 = "";
    for(int i = 0; i < scrambledEncryptedMessage.length(); i++) {
      if(i % 2 == 0){
        s1 += scrambledEncryptedMessage.charAt(i);
      }
      if(i % 2 == 1){
        s2 += scrambledEncryptedMessage.charAt(i);
      }
    }
    return s1 + s2;
  }
}
