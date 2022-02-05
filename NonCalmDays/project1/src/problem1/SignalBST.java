package problem1;

import java.util.ArrayList;

public class SignalBST 
{
	private ArrayList<Node> Nodes = new ArrayList<Node>();
	
	public SignalBST(Node Root)
	{
		Nodes.add(Root);
	}
	
	//adds a node to the SignalBST according to the Binary Search Tree rules of insertion
	public SignalBST add(Node node)
	{
		Node AvaliableNode = FindNodeByStrength(GetRoot(), node.GetStrength());
		
		if (AvaliableNode == null) //need new node bc new strength
		{
			Nodes.add(node);
			GetRoot().Add(node);
		}
		else //found node with equal strength
		{
			AvaliableNode.Add(node.GetSignals());
		}
		
		return this;
		
	}
	
	//removes a node from the SignalBST according to the Binary Search Tree rules of deletion
	public SignalBST remove(Node node)
	{
		Node AvaliableNode = FindNodeByStrength(GetRoot(), node.GetStrength());
		
		if (AvaliableNode == null) //not found in all Nodes
		{
			return this; //don't do anything
		}
		
		AvaliableNode.Remove(node.GetSignals().get(0));
		
		if (AvaliableNode.GetSignalCount() == 0)
			Nodes.remove(node);
		
		return this;
	}
	
	//returns a list of signal strengths for the given signal pattern
	public ArrayList<Integer> getSignalStrengths(String signalPattern)
	{
		ArrayList<Integer> Strengths = new ArrayList<Integer>();
		
		for (Node S : FindNodesByMessage(GetRoot(), signalPattern))
		{
			Strengths.add(S.GetStrength());
		}
		
		return Strengths;
	}
	
	//returns the maximum signal strength for the given signal pattern
	public int getMaxSignalStrength(String signalPattern)
	{
		return 0;
		//return FindNodeByStrength(GetRoot(), 15, true).GetStrength();
		//gets the node that has the strength closest to 15 (max) and returns its actual strength
	}
	
	//combines and return the SignalBST that is  a combination of A and B
	public SignalBST combine(SignalBST A, SignalBST B)
	{
		return null;
	}
	
	public ArrayList<Node> GetNodes()
	{
		return Nodes;
	}
	
	//other methods
	public Node GetRoot()
	{
		return Nodes.get(0);
	}
	
	private Node FindNodeByStrength(Node At, int Strength) 
	{
		
		if (At == null) //if not in nodes
		{
			return null;
		}
		
		int Target = At.GetStrength();
		
		if (Target == Strength) // found
			return At;
		
		if (Strength < Target) //go left
			return FindNodeByStrength(At.GetLeftChild(), Strength);
		
		if (Strength > Target) //go right
			return FindNodeByStrength(At.GetRightChild(), Strength);
		
		return null; 
		//code doesn't reach here but java goes error despite ==, <, and > all being covered above so frick java
	}
	
	private ArrayList<Node> FindNodesByMessage(Node At, String Message)
	{
		ArrayList<Node> MessageNodes = new ArrayList<Node>();
		
		for (Node N : FindNodesByMessage(At.GetLeftChild(), Message)) 
		{
			if (N == null)
				continue;
			
			for (Signal S : N.GetSignals())
			{
				if (S.GetMessage() == Message)
					MessageNodes.add(N);
			}
		}
		
		for (Node N : FindNodesByMessage(At.GetRightChild(), Message)) 
		{
			if (N == null)
				continue;
			
			for (Signal S : N.GetSignals())
			{
				if (S.GetMessage() == Message)
					MessageNodes.add(N);
			}
		}
		
		return MessageNodes;
	}
	
	private int GetDepth(Node n, int Generations)
	{
		if (n == null)
			return Generations;
		
		int L = GetDepth(n.GetLeftChild(), Generations + 1);
		int R = GetDepth(n.GetRightChild(), Generations + 1);
		
		return L > R ? L : R;
		
	}
	
	private void getBFS(Node At, ArrayList<ArrayList<Node>> Queue, int Generation)
	{
		if (Generation == GetDepth(GetRoot(), 0) || At == null)
			return;
		
		Queue.get(Generation).add(At);
		
		getBFS(At.GetLeftChild(), Queue, Generation + 1);
		getBFS(At.GetRightChild(), Queue, Generation + 1);
	}
	
	public void PrettyPrint()
	{
		//implementing breadth-first search to print generations
		
		ArrayList<ArrayList<Node>> C = new ArrayList<ArrayList<Node>>();
		
		for (int i = 0; i < GetDepth(GetRoot(), 0); ++i)
		{
			C.add(new ArrayList<Node>());
		}
		
		getBFS(GetRoot(), C, 0);
		
		for (ArrayList<Node> List : C)
		{
			for (Node S : List)
			{
				System.out.print(S);
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		
		/* Test cases - Ctrl/Command + '/' key to uncomment */
		
		/*Test case 1 - simple print tree*/
		
//		Signal FirstSignal = new Signal("Cow", 1); // root
//		Node First = new Node(FirstSignal);
//		
//		Signal SecondSignal = new Signal("Bull", 4); //make new node on right of 1 with bull
//		Node Second = new Node(SecondSignal);
//		
//		Signal ThirdSignal = new Signal("Bull", 4); //should increment signal count
//		Node Third = new Node(ThirdSignal);
//		
//		Signal ForthSignal = new Signal("Calf", 4); //should go to 4th node make new message
//		Node Forth = new Node(ForthSignal);
//		
//		SignalBST Tree = new SignalBST(First);
//		
//		Tree.add(Second);
//		Tree.add(Third);
//		Tree.add(Forth);
		
// 		Tree.PrettyPrint();
		
		/*Test case 2 - Test find node function*/
		
//		Signal FirstSignal = new Signal("Cow", 2); // root
//		Node First = new Node(FirstSignal);
//		
//		Signal SecondSignal = new Signal("Bull", 1); //make new node on right of 1 with bull
//		Node Second = new Node(SecondSignal);
//		
//		Signal ThirdSignal = new Signal("Calf", 3); //should increment signal count
//		Node Third = new Node(ThirdSignal);
//		
//		Signal ForthSignal = new Signal("A", 4); //should increment signal count
//		Node Forth = new Node(ForthSignal);
//		
//		SignalBST Tree = new SignalBST(First);
//		
//		Tree.add(Second);
//		Tree.add(Third);
//		Tree.add(Forth);
//		
//		System.out.println(Tree.FindNodeByStrength(Tree.GetRoot(), 2)); // Cow
//		System.out.println(Tree.FindNodeByStrength(Tree.GetRoot(), 1)); // Bull
//		System.out.println(Tree.FindNodeByStrength(Tree.GetRoot(), 3)); // Calf
//		System.out.println(Tree.FindNodeByStrength(Tree.GetRoot(), 4)); // A
//		System.out.println(Tree.FindNodeByStrength(Tree.GetRoot(), 9)); // null - 9 is not in nodes
		
		/* Test case 3 - Test find node function with more than one message in the same node and test total duplicates (increments)*/
		
//		Signal FirstSignal = new Signal("Cow", 2); // root
//		Node First = new Node(FirstSignal);
//		
//		Signal SecondSignal = new Signal("Bull", 1); //make new node on right of 1 with bull
//		Node Second = new Node(SecondSignal);
//		
//		Signal ThirdSignal = new Signal("Calf", 1); //should increment signal count
//		Node Third = new Node(ThirdSignal);
//		
//		Signal ForthSignal = new Signal("Bull", 1); //should increment signal count
//		Node Forth = new Node(ForthSignal);
//		
//		SignalBST Tree = new SignalBST(First);
//		
//		Tree.add(Second);
//		Tree.add(Third);
//		Tree.add(Forth);
//		
//		System.out.println(Tree.FindNodeByStrength(Tree.GetRoot(), 2)); // Cow
//		System.out.println(Tree.FindNodeByStrength(Tree.GetRoot(), 1)); // Bull
//		System.out.println(Tree.FindNodeByStrength(Tree.GetRoot(), 3)); // null
		
		
		
		/*Test case 10 - file IO - replace "Signals.txt" with your full path to the file*/
		
		ReadFile F = new ReadFile("Signals.txt"); //
		
		ArrayList<Node> Nodes = F.getNodes();
		
		SignalBST Tree = new SignalBST(Nodes.get(0));
		
		Nodes.remove(0);
		
		Nodes.subList(0, 10);
		
		//Tree.add(Nodes.get(0));
		
		for (Node N : Nodes)
		{
			Tree.add(N);
		}
		
		Tree.PrettyPrint();
		
	}
	
}
