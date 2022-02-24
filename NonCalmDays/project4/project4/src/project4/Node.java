package project4;

public class Node
{
	private Case c;
	private Node previous, next;
	
	//Constructor [1 point]
	 public Node(Case c)
	{
		 setCase(c);
	}
 //create the accessor and mutator methods for the instance variables [6 points]

	public Case getCase() {
		return c;
	}

	public void setCase(Case c) {
		this.c = c;
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
}
