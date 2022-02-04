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
		Node AvaliableNode = FindNodeByStrength(GetRoot(), node.GetStrength(), false);
		
		if (AvaliableNode == null)
		{
			Nodes.add(node);
			GetRoot().Add(node);
		}
		else
		{
			AvaliableNode.Add(node.Signals);
		}
		
		return this;
		
	}
	
	//removes a node from the SignalBST according to the Binary Search Tree rules of deletion
	public SignalBST remove(Node node)
	{
		Node AvaliableNode = FindNodeByStrength(GetRoot(), node.GetStrength(), false);
		
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
		return FindNodeByStrength(GetRoot(), 15, true).GetStrength();
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
	
	private Node FindNodeByStrength(Node At, int Strength, boolean ReturnClosest) 
	{
		
		if (At == null) //if not in nodes
		{
			return null;
		}
		
		int Target = At.GetStrength();
		
		if (Target == Strength) // found
			return At;
		
		if (Strength < Target) //go left
			return FindNodeByStrength(At.GetLeftChild(), Strength, ReturnClosest);
		
		if (Strength > Target) //go right
			return FindNodeByStrength(At.GetRightChild(), Strength, ReturnClosest);
		
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
	
	private void getBFS(Node At, ArrayList<ArrayList<Node>> All)
	{
		
		ArrayList<Node> Queue = new ArrayList<Node>();
		
		Node Left, Right = null;
		
		if (At != null)
		{
			Left = At.GetLeftChild();
			Right = At.GetRightChild();
		}
		else
		{
			Left = null;
			Right = null;
		}
		
		//Prefer left then right
		
		if (Left != null)
			Queue.add(Left);
		else //if (Right != null)
			Queue.add(new Node(new Signal("", -1)));
		
		if (Right != null)
			Queue.add(Right);
		else //if (Left != null)
			Queue.add(new Node(new Signal("", -1)));
		
		if (At != null)
		{
			getBFS(At.GetLeftChild(), All);
			getBFS(At.GetRightChild(), All);
			//All.add(Queue);
		}
		All.add(Queue);
	}
	
	public void PrettyPrint(Node At)
	{
		//implementing breadth-first search to print generations
		
		ArrayList<ArrayList<Node>> C = new ArrayList<ArrayList<Node>>();
		
		getBFS(At, C);
		
		//int T = 1;
		//int J = 0;
		
		/*for (int i = 0; i < C.size(); i++)
		{
			/*if (i != 0)
			{
				if (i % 2 == 0)
					System.out.print(" ⟂ ");
				else
					System.out.print("   ");
			}
			
			if (i == T + J)
			{
				System.out.println();
				T *= 2;
				J = i;
			}
			
			if (C.get(i).GetStrength() == -1)
			{
				System.out.print(" ");
				continue;
			}
			
			//System.out.print(C.get(i).toString());
			System.out.print(C.get(i).GetStrength() + " ");
		}*/
		
		System.out.println("Tip: " + GetRoot());
		
		for (ArrayList<Node> List : C)
		{
			for (Node S : List)
			{
				System.out.print(S.GetStrength() + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		ReadFile F = new ReadFile("Signals.txt");
		
		ArrayList<Node> Nodes = F.getNodes();
		
		SignalBST Tree = new SignalBST(Nodes.get(0));
		
		Nodes.remove(0);
		
		for (Node N : Nodes)
		{
			Tree.add(N);
		}
		
		//System.out.println(Tree.GetNodes());
		
		Tree.PrettyPrint(Tree.GetRoot());
		
	}
	
}
