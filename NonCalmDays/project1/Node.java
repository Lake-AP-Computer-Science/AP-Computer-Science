package APCompSci3.problem1;

import java.util.ArrayList;

public class Node {
  int strength;
  ArrayList<Signal> signals = new ArrayList<>();
  Node left, right;
  
  public Node(int strength)
  {
    this.strength = strength;
  }
  
  public void addSignal(Signal signal){
    signals.add(signal);
  }
  
  public void addSignal(ArrayList<Signal> signals){
    for(int i = 0; i < signals.size(); i++) {
      addSignal(signals.get(i));
    }
    removeDupes();
  }
  
  private void removeDupes(){
    ArrayList<Signal> newSignals = this.signals;
    for(Signal signal : newSignals){
      //if it does not contain the signal, add it.
      if(!newSignals.contains(signal)){
        this.signals.add(signal);
      }
      else {
        for(int i = 0; i < this.signals.size(); i++) {
          if(this.signals.get(i).getSignal().equals(signal.getSignal())){
            this.signals.get(i).incr();
          }
        }
      }
    }
  }
}
