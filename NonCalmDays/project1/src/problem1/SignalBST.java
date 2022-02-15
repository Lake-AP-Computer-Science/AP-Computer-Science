package problem1;

import java.util.ArrayList;

public class SignalBST 
{
	private ArrayList<Node> Nodes = new ArrayList<Node>();
	
	/*public SignalBST(Node Root)
	{
		Nodes.add(Root);
	}*/
	
	public SignalBST(Object data)
	{
		ArrayList<Node> N = (ArrayList<Node>)data;
		
		if (N == null)
		{
			Node Ns = (Node)data;
			
			nodes.add(Ns); // root
			return;
		}
		
		for (Node Ns : N)
			nodes.add(Ns);
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
		
		for (Signal S : node.GetSignals())
		{
			//System.out.println(S.GetMessage());
			AvaliableNode.Remove(S);
		}
		
		AvaliableNode.Prune(); //removes all nodes with messages that have 0x frequency (should be gone)
		
		return this;
	}
	
	//returns a list of signal strengths for the given signal pattern
	public ArrayList<Integer> getSignalStrengths(String signalPattern)
	{
		ArrayList<Integer> Strengths = new ArrayList<Integer>();
		
		for (Node S : FindNodesByMessage(signalPattern))
		{
			Strengths.add(S.GetStrength());
		}
		
		return Strengths;
	}
	
	//returns the maximum signal strength for the given signal pattern
	public int getMaxSignalStrength(String signalPattern)
	{
		ArrayList<Node> N = FindNodesByMessage(signalPattern);
		return N.get(N.size() - 1).GetStrength();
	}
	
	//combines and return the SignalBST that is  a combination of A and B
	public void combine(SignalBST Other)
	{
		for (Node N : Other.GetNodes())
		{
			add(N);
		}
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
	
	private ArrayList<Node> FindNodesByMessage(String Message)
	{
		ArrayList<Node> MessageNodes = new ArrayList<Node>();
		
		for (int i = 1; i <= 15; ++i)
		{
			Node N = FindNodeByStrength(GetRoot(), i);
			
			if (N == null)
				continue;
			
			for (Signal S : N.GetSignals())
			{
				if (S.GetMessage() == Message)
				{
					MessageNodes.add(N);
				}
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
		
		ArrayList<Integer> Used = new ArrayList<Integer>();
		
		for (int i = 0; i < GetDepth(GetRoot(), 0); ++i)
		{
			C.add(new ArrayList<Node>());
		}
		
		getBFS(GetRoot(), C, 0);
		
		for (ArrayList<Node> List : C)
		{
			for (Node S : List)
			{
				if (!Used.contains(S.GetStrength()))
				{
					Used.add(S.GetStrength());
					System.out.print(S);
				}
			}
			System.out.println();
		}
		
		
	}

	public static void main(String[] args) {
		
/* 
 * Test cases - Select in bulk the commented ones and press Ctrl/Command + '/' key to uncomment 
 * 
 * 1. Modify your code so that it matches mine in casing.
 * 2. Your code should be able to reproduce somewhat similar to the "expected output", if you think there's something wrong with the expected output, please contact me ASAP.
 * 3. If you would like to reproduce the exact same expected output, use my toString() methods for the Node and Signal classes.
 * 
 * */
		
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
//
//		Tree.PrettyPrint(); //steal this from my GitHub
		
/*
 * Expected output (*s are just for comments continuation):
 * 
 * Strength: 1 Signals: [ "Cow" x1, ]
 * Strength: 4 Signals: [ "Bull" x2,  "Calf" x1, ]
 * */

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
		
/*
 * Expected output (*s are just for comments continuation):
 * 
 * Strength: 2  Signals: [ "Cow" x1, ]
 * Strength: 1  Signals: [ "Bull" x1, ]
 * Strength: 3  Signals: [ "Calf" x1, ]
 * Strength: 4  Signals: [ "A" x1, ]
 * null
 * */

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
		
/*Expected output (*s are just for comments continuation):
 * 
 * Strength: 2  Signals: [ "Cow" x1, ]
 * Strength: 1  Signals: [ "Bull" x2,  "Calf" x1, ]
 * null
 * */

/* Test case 4 - Removing from tree*/
		
//		Signal FirstSignal = new Signal("Cow", 2); // root
//		Node First = new Node(FirstSignal);
//		
//		Signal SecondSignal = new Signal("Bull", 1); //make new node on right of 1 with bull
//		Node Second = new Node(SecondSignal);
//		
//		Signal ThirdSignal = new Signal("Birdy", 1); //should increment signal count
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
//		System.out.println("Before:");
//		System.out.println(Tree.FindNodeByStrength(Tree.GetRoot(), 2)); //root
//		System.out.println(Tree.FindNodeByStrength(Tree.GetRoot(), 1)); //Bull at 2 and Birdy
//		
//		Tree.remove(Third); //bye bye birdy
//		Tree.remove(Forth); //decrement bull back to 1 since Second still exists
//		Tree.remove(First); //removes root, shouldn't break tree. Root will have node with a strength but no signals
//		
//		System.out.println("After:");
//		System.out.println(Tree.FindNodeByStrength(Tree.GetRoot(), 2)); //root
//		System.out.println(Tree.FindNodeByStrength(Tree.GetRoot(), 1)); //Bull at 1 and Birdy gone

/* Expected output (*s are just for comments continuation):
 * 
 * Before:
 * Strength: 2  Signals: [ "Cow" x1, ]
 * Strength: 1  Signals: [ "Bull" x2,  "Birdy" x1, ]
 * After:
 * Strength: 2  Signals: []
 * Strength: 1  Signals: [ "Bull" x1, ]
 * */
		
/* Test case 6 - get signal strength && find nodes by message */
	
//		Signal FirstSignal = new Signal("Cow", 2); // root
//		Node First = new Node(FirstSignal);
//		
//		Signal SecondSignal = new Signal("Bull", 1); //make new node on right of 1 with bull
//		Node Second = new Node(SecondSignal);
//		
//		Signal ThirdSignal = new Signal("Bull", 5); //should increment signal count
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
//		System.out.println(Tree.FindNodesByMessage("Bull")); // 1 find it twice and 5 find it once
//		System.out.println(Tree.FindNodesByMessage("Cow")); // 2 find it once
//		
//		System.out.println(Tree.getSignalStrengths("Bull")); // [1, 5]
//		System.out.println(Tree.getSignalStrengths("Cow")); // [1]
//		
//		System.out.println(Tree.getMaxSignalStrength("Bull")); // 5
//		System.out.println(Tree.getMaxSignalStrength("Cow")); // 2

/* Expected output (*s are just for comments continuation):
 * 
 * [		 Strength: 1  Signals: [ "Bull" x2, ], 		 Strength: 5  Signals: [ "Bull" x1, ]]
 * [		 Strength: 2  Signals: [ "Cow" x1, ]]
 * [1, 5]
 * [2]
 *  5
 *  2
 * */
		
/* Test case 7 - Combine Signal BST */

//		//tree
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
//		SignalBST Tree1 = new SignalBST(First);
//		
//		Tree1.add(Second);
//		Tree1.add(Third);
//		Tree1.add(Forth);
//		
//		//next tree
//		FirstSignal = new Signal("Combine into 1", 1); //root
//		First = new Node(FirstSignal);
//		
//		SecondSignal = new Signal("New Node At 3", 3); //makes a new node at 3 with the new message
//		Second = new Node(SecondSignal);
//		
//		ThirdSignal = new Signal("Bull", 4); //should increment bull from tree 1
//		Third = new Node(ThirdSignal);
//		
//		ForthSignal = new Signal("Unique", 9); //add another message into fourth node
//		Forth = new Node(ForthSignal);
//		
//		SignalBST Tree2 = new SignalBST(First);
//		
//		Tree2.add(Second);
//		Tree2.add(Third);
//		Tree2.add(Forth);
//		
//		System.out.println("        Before:");
//		System.out.println("First:");
//		Tree1.PrettyPrint();
//		System.out.println("Second:");
//		Tree2.PrettyPrint();
//		
//		Tree1.combine(Tree2);
//		
//		System.out.println("After:");
//		Tree1.PrettyPrint();
		
/* Expected output (*s are just for comments continuation):
 * 
 *         Before:
 * First:
 * 		 Strength: 1  Signals: [ "Cow" x1, ]
 * 		 Strength: 4  Signals: [ "Bull" x2,  "Calf" x1, ]
 * Second:
 * 		 Strength: 1  Signals: [ "Combine into 1" x1, ]
 * 		 Strength: 3  Signals: [ "New Node At 3" x1, ]
 * 		 Strength: 4  Signals: [ "Bull" x1, ]
 * 		 Strength: 9  Signals: [ "Unique" x1, ]
 * After:
 * 		 Strength: 1  Signals: [ "Cow" x1,  "Combine into 1" x1, ]
 * 		 Strength: 4  Signals: [ "Bull" x3,  "Calf" x1, ]
 * 		 Strength: 3  Signals: [ "New Node At 3" x1, ]		 Strength: 9  Signals: [ "Unique" x1, ]
 */
		
		
/* The following test cases use Lake's 10-page-on-google-docs test case
 * which I have composed into characters to signify different patterns,
 * get it from: https://github.com/Lake-AP-Computer-Science/AP-Computer-Science/blob/main/NonCalmDays/project1/Signals.txt
 */
		
//		ReadFile F = new ReadFile("Signals.txt"); //
//		
//		ArrayList<Node> Nodes = F.getNodes();
//		
//		SignalBST Tree = new SignalBST(Nodes.get(0));
//		
//		Nodes.remove(0);
//		
//		Nodes.subList(0, 10); //for the first 10
//		
//		for (Node N : Nodes)
//		{
//			Tree.add(N);
//		}
//		
//		Tree.PrettyPrint();
		
		/* Expected output (for the first 10) (*s are just for comments continuation):
		 * 
		 * Strength: 4  Signals: [ "A" x6,  "F" x1,  "B" x5, ]
		 * Strength: 1  Signals: [ "A" x2,  "C" x4,  "F" x7,  "K" x5, ]		 Strength: 10  Signals: [ "B" x7,  "F" x6,  "I" x8, ]
		 * Strength: 2  Signals: [ "B" x2,  "D" x3,  "" x1, ]		 Strength: 7  Signals: [ "A" x7, ]		 Strength: 15  Signals: [ "E" x13,  "I" x5,  "G" x8, ]
		 * Strength: 3  Signals: [ "E" x1,  "A" x1,  "C" x4, ]		 Strength: 5  Signals: [ "A" x1,  "E" x4, ]		 Strength: 8  Signals: [ "B" x7, ]		 Strength: 11  Signals: [ "E" x1,  "C" x7,  "G" x5, ]
		 * Strength: 6  Signals: [ "B" x1,  "F" x5, ]		 Strength: 9  Signals: [ "E" x1,  "A" x1,  "K" x8, ]		 Strength: 12  Signals: [ "F" x1,  "D" x7,  "J" x5,  "H" x8, ]
		 * Strength: 13  Signals: [ "C" x7,  "G" x13, ]
		 * Strength: 14  Signals: [ "B" x7,  "H" x5,  "J" x8, ]
		 */
		
	}
	
}
