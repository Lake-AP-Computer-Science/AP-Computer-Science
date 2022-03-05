package project4;

public class Node
{
	private Case caseType;
	private Node previous, next;
	
	//Constructor [1 point]
	 public Node(Case caseType)
	{
		 setCase(caseType);
	}
	 
 	//create the accessor and mutator methods for the instance variables [6 points]

	public Case getCase() {
		return caseType;
	}

	public void setCase(Case caseType) {
		this.caseType = caseType;
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
	
	public String toString() 
	{
		return getCase().toString();
	}
	
}
