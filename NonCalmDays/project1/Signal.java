package APCompSci3.problem1;

public class Signal 
{
  private String signal;
  private int count;
  
  public Signal(String signal, int count) {
    this.signal = signal;
    this.count = count;
  }
  
  public Signal(String signal) {
    this.signal = signal;
  }
  
  public String getSignal() {
    return signal;
  }
  
  public void setSignal(String signal) {
    this.signal = signal;
  }
  
  public int getCount() {
    return count;
  }
  
  public void setCount(int count) {
    this.count = count;
  }
  
  public void incr(){
    count++;
  }
  
  public void decr(){
    count--;
  }
}
