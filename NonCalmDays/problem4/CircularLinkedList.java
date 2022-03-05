package Package4;

public class CircularLinkedList {
  private Node start, end;
  //adds the Node to the list based on the case/crime priority
//and sets its court date by calling the method below [10 points]
  public void add(Node node)
  {
    //if start is null
    if(start == null) {
      start = node;
      start.setPrevious(end);
      end.setNext(start);
      return;
    }
    //link end node
   end.setNext(node);
   node.setPrevious(end);
   //link start node
   node.setNext(start);
   start.setPrevious(node);
   //end = node, at least I think that is how it works
   end = node;
  }
  //sets the case Date based on the case priority [7 points]
  private void setCaseDate()
  {
  
  }
  //prints the list from start to end [5 points]
  public void printList()
  {
  }
}
//41 42 48 49 20 49 53 20 41 20 50 45 45 50 45 45 0A
