package problem1;

import java.util.ArrayList;

public class Node
{
	private ArrayList<Signal> signals = new ArrayList<Signal>();
	private Node left, right;
	private int nodeStrength = 0;
	
	public Node(Signal s) 
	{
		nodeStrength = s.getStrength();
		add(s);
	}
	
	public ArrayList<Signal> getSignals()
	{
		return this.signals;
	}
	
	public void setSignals(ArrayList<Signal> signals)
	{
		this.signals = signals;
	}
	
	public Node getLeft()
	{
		return this.left;
	}
	
	public void setLeft(Node left)
	{
		this.left = left;
	}
	
	public Node getRight()
	{
		return this.right;
	}
	
	public void setRight(Node right)
	{
		this.right = right;
	}
	
	public int getNodeStrength()
	{
		return this.nodeStrength;
	}
	
	public int getSignalCount()
	{
		return this.signals.size();
	}

	public void add(Signal s)
	{
		boolean duplicate = false;
		
		for(Signal sn : signals)
		{
			if(sn.getSignalData().equals(s.getSignalData()))
			{
				duplicate = true;
				sn.incrementCount();
				break;
			}
		}
		
		if(duplicate)
		{
			return;
		}
		signals.add(s);
	}
	
	public void addSignals(ArrayList<Signal> ALS)
	{
		for(Signal s : ALS)
		{
			add(s);
		}
	}
	
	public void addNode(Node n)
	{
		if(n.getNodeStrength() < getNodeStrength())
		{
			if (getLeft() == null)
			{
				setLeft(n);
				return;
			}
			getLeft().addNode(n);
		}
		else
		{
			if(getRight() == null)
			{
				setRight(n);
				return;
			}
			getRight().addNode(n);
		}
	}
	
	public void removal()
	{
		for(int i = signals.size() - 1; i >= 0; --i)
		{
			if (signals.get(i).getCount() == 0)
			{
				signals.remove(i);
				--i;
			}
		}
	}
	
	public void remove(Signal s)
	{
		for(Signal sn : signals)
		{
			if(sn.getSignalData().equals(s.getSignalData()))
			{
				sn.decrementCount();
				break;
			}
		}
	}
	
	public String toString()
	{
		String newNode = "Node: Signals: ";
		for(Signal s : signals)
		{
			newNode += s.toString() + " ";
		}
		return newNode;
	}
}
