package Package4;

public class Node {
  private Case aCase;
  private Node previous, next;
  //Constructor [1 point]
  public Node(Case aCase)
  {
    this.aCase = aCase;
  }
  
  public Case getCase() {
    return aCase;
  }
  
  public void setCase(Case aCase) {
    this.aCase = aCase;
  }
  
  public Node getPrevious() {
    return previous;
  }
  
  public void setPrevious(Node previous) {
    this.previous = previous;
  }
  
  public Node getNext() {
    return next;
  }
  
  public void setNext(Node next) {
    this.next = next;
  }
  
  public String toString(){
    return "Crime type: " + aCase.getCrime();
  }
}
