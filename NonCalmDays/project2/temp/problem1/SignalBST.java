package problem1;

import java.util.ArrayList;

public class SignalBST 
{
	private Object data;
	private Node left, right;
	private ArrayList<Node> nodes = new ArrayList<Node>();
	
	public SignalBST(Node root)
	{
		nodes.add(root);
	}
	
	//getters and setters
	public Object getData()
	{
		return data;
	}

	public void setData(Object data)
	{
		this.data = data;
	}

	public Node getLeft()
	{
		return left;
	}

	public void setLeft(Node left)
	{
		this.left = left;
	}

	public Node getRight()
	{
		return right;
	}

	public void setRight(Node right)
	{
		this.right = right;
	}
	
	public ArrayList<Node> getNodes()
	{
		return this.nodes;
	}
	
	//helper methods
	public Node getRoot()
	{
		return nodes.get(0);
	}
	
	private Node strengthNodeFinder(Node node, int strength)
	{

		if(node == null)
		{
			return null;
		}
		
		int target = node.getNodeStrength();
		
		if(target == strength)
			return node;
		
		if(strength < target)
			return strengthNodeFinder(node.getLeft(), strength);
		
		if(strength > target)
			return strengthNodeFinder(node.getRight(), strength);
		
		return null;
	}
	
	private ArrayList<Node> signalNodeFinder(String signal)
	{
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		for(int i = 1; i <= 15; ++i)
		{
			Node node = strengthNodeFinder(getRoot(), i);
			
			if(node == null)
				continue;
			
			for(Signal S : node.getSignals())
			{
				if(S.getSignalData() == signal)
				{
					nodes.add(node);
				}
			}
		}
		return nodes;
	}
	
	private int getDepth(Node node, int generations)
	{
		if(node == null)
			return generations;
		
		int l = getDepth(node.getLeft(), generations + 1);
		int r = getDepth(node.getRight(), generations + 1);
		
		return l > r ? l : r;
	}
	
	private void getBFS(Node node, ArrayList<ArrayList<Node>> Queue, int generation)
	{
		if(generation == getDepth(getRoot(), 0) || node == null)
			return;
		
		Queue.get(generation).add(node);
		
		getBFS(node.getLeft(), Queue, generation + 1);
		getBFS(node.getRight(), Queue, generation + 1);
	}
	
	
	public void prettyPrint()
	{
		ArrayList<ArrayList<Node>> c = new ArrayList<ArrayList<Node>>();
		ArrayList<Integer> used = new ArrayList<Integer>();
		
		for(int i = 0; i < getDepth(getRoot(), 0); ++i)
		{
			c.add(new ArrayList<Node>());
		}
		
		getBFS(getRoot(), c, 0);
		
		for(ArrayList<Node> list : c)
		{
			for(Node node : list)
			{
				if(!used.contains(node.getNodeStrength()))
				{
					used.add(node.getNodeStrength());
					System.out.print(node);
				}
			}
			System.out.println();
		}
     }
	
	//adds the signals in the node to the SignalBST according to the Binary Search Tree rules of insertion
	public SignalBST add(Node node)
	{
		Node avaliableNode = strengthNodeFinder(getRoot(), node.getNodeStrength());
		if(avaliableNode == null)
		{
			nodes.add(node);
			getRoot().addNode(node);
		}
		else
		{
			avaliableNode.addSignals(node.getSignals());
		}
		
		return this;
	}
	
	//removes the signals in the node from the SignalBST according to the Binary Search Tree rules of deletion
	public SignalBST remove(Node node)
	{
		Node avaliableNode = strengthNodeFinder(getRoot(), node.getNodeStrength());
		
		if(avaliableNode == null)
		{
			return this;
		}
		
		avaliableNode.remove(node.getSignals().get(0));
		
		if(avaliableNode.getSignalCount() == 0)
			nodes.remove(node);
		
		avaliableNode.removal();
		
		return this;
	}
	
	//returns a list of signal strengths for the given signal pattern
	public ArrayList<Integer> getSignalStrengths(String signalPattern)
	{
		ArrayList<Integer> strengths = new ArrayList<Integer>();
		
		for(Node node : signalNodeFinder(signalPattern))
		{
			strengths.add(node.getNodeStrength());
		}
		return strengths;
	}
	
	//returns the maximum signal strength for the given signal pattern
	public int getMaxSignalStrength(String signalPattern)
	{
		ArrayList<Node> node = signalNodeFinder(signalPattern);
		return node.get(node.size() - 1).getNodeStrength();
	}
	
	//combines and return the SignalBST that is  a combination of A and B
	public SignalBST combine(SignalBST A, SignalBST B)
	{
		for(Node node : B.getNodes())
		{
			A.add(node);
		}
		return A;
	}
}