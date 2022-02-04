package problem1;

import java.util.ArrayList;
import java.lang.Math;

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
	
	private int GetDepth(Node n, int Generations)
	{
		if (n == null)
			return Generations;
		
		int L = GetDepth(n.GetLeftChild(), Generations + 1);
		int R = GetDepth(n.GetRightChild(), Generations + 1);
		
		return L > R ? L : R;
		
	}
	
	private int GetExpectedAtGeneration(int Generation)
	{
		return (int) Math.pow(2, Generation);
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
		
		/*System.out.println(C);
		
		int GenerationCounter = 1;
		
		for (int i = 0; i < C.size(); i++)
		{
			if (i != 0)
			{
				if (i % 2 == 0)
					System.out.print(" ⟂ ");
				else
					System.out.print("   ");
			}
			
			if (i == GetExpectedAtGeneration(GenerationCounter) - 1)
			{
				++GenerationCounter;
				System.out.println();
			}
			
			if (C.get(i) == null)
			{
				System.out.print(" ");
				continue;
			}
			
			//System.out.print(C.get(i).toString());
			System.out.print(C.get(i).GetStrength() + " ");
		}*/
		
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
		
		ReadFile F = new ReadFile("Signals.txt");
		
		ArrayList<Node> Nodes = F.getNodes();
		
		SignalBST Tree = new SignalBST(Nodes.get(0));
		
		Nodes.remove(0);
		
		for (Node N : Nodes)
		{
			Tree.add(N);
		}
		
		//System.out.println(Tree.GetNodes());
		
		//System.out.println(Tree.GetDepth(Tree.GetRoot(), 0));
		
		Tree.PrettyPrint();
		
	}
	
}
