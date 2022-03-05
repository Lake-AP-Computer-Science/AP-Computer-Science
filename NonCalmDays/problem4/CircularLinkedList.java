package Problem4;

import java.util.Calendar;
import java.util.Date;

public class CircularLinkedList {
  private Node start = null, end = null;
  private final long ONE_DAY = 1000 * 3600 * 24L;
  private final long TODAY = System.currentTimeMillis();
  
  //adds the Node to the list based on the case/crime priority
//and sets its court date by calling the method below [10 points]
  public void add(Node node) {
    if(start == null){
      node.next = node.previous = null;
      start = node;
      end = node;
      start.aCase.setDate(new Date(
              TODAY + ONE_DAY
      ));
      end.aCase.setDate(new Date(
              TODAY + ONE_DAY
      ));
      return;
    }
/*
    if(end == null && node.getData() >= start.getData()){
      end = node;
      start.previous = start.next = end;
      end.previous = end.next = start;
      //setCaseDate();
      return;
    }
*/
    
    if(start.getData() >= node.getData()) {
      insertBegin(node);
    }
    else if(end.getData() <= node.getData() || end == null) {
      insertEnd(node);
    }
    else {
      insert(node);
    }
    setCaseDate();
  }
  
  private void insertBegin(Node node) {
    end = (start).previous;
    node.next = start;
    node.previous = end;
    end.next = (start).previous = node;
    
    start = node;
    fixNulls();
  }
  
  private void insertEnd(Node node) {
    if(start == null) {
      node.next = node.previous = node;
      start = node;
      fixNulls();
    }
    
    end.next = start.previous = node;
    end = node;
  }
  
  private void insert(Node node) {
    Node current = start;
    while(current != end) {
      //cases for two nodes
      if(node.getData() > current.getData()) {
        //if current next is null
        if(current.next == null){
          current.previous = node;
          current.next = node;
  
          node.next = current;
          node.previous = current;
          return;
        }
        //if current next is not null
        else {
          current = current.next;
          if(node.getData() > current.getData()){
            node.next = current.next;
            current.next = node;
            
            node.previous = current;
            node.next.previous = node;
          }
        }
      }
      else {
        //if current prev is null
        if(current.previous == null){
          current.previous = node;
          current.next = node;
          
          node.next = current;
          node.previous = current;
          return;
        }
        //if current prev is not null
        else {
          current = current.next;
        }
      }
    }
    fixNulls();
  }
  
  private void fixNulls(){
    if(start.previous == null){
      start.previous = end;
    }
    if(end.next == null){
      end.next = start;
    }
    Node current = start;
    while(current.next != null){
      current = current.next;
      if(current.next == null || current.next == end) {
        break;
      }
    }
    current.next = end;
    end.previous = current;
    return;
  }
  
  //sets the case Date based on the case priority [7 points]
  private void setCaseDate() {
    Node current = start;
    
    Date date = Calendar.getInstance().getTime();
    int i = 1;
    while(current != end){
      current.aCase.setDate(new Date(
              TODAY + ONE_DAY * i
      ));
      current = current.next;
      i++;
    }
    end.getCase().setDate(new Date(TODAY + ONE_DAY * i));
    return;
  }
  //prints the list from start to end [5 points]
  public void printList()
  {
    Node current = start;
    while(current != end){
      System.out.println(current.aCase.toString());
      current = current.next;
    }
    System.out.println(end.aCase.toString());
  }
  
  public static void main(String[] args) {
    CircularLinkedList c = new CircularLinkedList();
    
    c.add(new Node(new Case(
            new Crime("Zach Zapper", "Abigail Applehead", "Civil Case Child Abuse")
    )));
    c.add(new Node(new Case(
            new Crime("Max Morrison", "Jeff Jefferies", "Traffic Case Child Abuse")
    )));
    c.add(new Node(new Case(
            new Crime("Bob Bounty", "Lana Lucid", "Criminal Case Child Abuse")
    )));
    c.add(new Node(new Case(
            new Crime("Martha Malta", "Matthew Patthew", "Traffic Case Arson")
    )));
    c.add(new Node(new Case(
            new Crime("Sam Shabam", "Slam Shazam", "Civil Case Conspiracy")
    )));
    c.printList();
  }
}
//pee pee poo poo
