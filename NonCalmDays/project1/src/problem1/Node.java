package problem1;

import java.util.ArrayList;

public class Node 
{
	Node Left, Right = null;
	ArrayList<Signal> Signals = new ArrayList<Signal>();
	int OverallStrength = 0;
	
	public Node(Signal S) 
	{
		OverallStrength = S.GetStrength(); //Only need to do this once for sake of convience because all strengths stored in this node is same
		Add(S);
	}
	
	public void Add(Signal S)
	{
		boolean Contains = false;
		
		for (Signal SN : Signals)
		{
			if (SN.GetMessage().equals(S.GetMessage()))
			{
				Contains = true;
				SN.IncrementCount();
				break;
			}
		}
		
		if (Contains) //if already exists with the same message just increment count
		{
			return;
		}
		
		Signals.add(S);
	}
	
	public void Add(Node N)
	{
		if(N.GetStrength() < GetStrength())
		{
			if (GetLeftChild() == null)
			{
				SetLeftChild(N);
				return;
			}
			GetLeftChild().Add(N);
		}
		else
		{
			if (GetRightChild() == null)
			{
				SetRightChild(N);
				return;
			}
			GetRightChild().Add(N);
		}
	}
	
	public void Add(ArrayList<Signal> SM) //adds with list to be more convient
	{
		for (Signal S : SM)
			Add(S); //calls the add function in this class so don't need to rewrite logic
	}
	
	//Remove
	
	public void Remove(Signal S)
	{
		if (Signals.contains(S)) //if already exists with the same message just decrement count
		{
			S.DecrementCount();
			return;
		}
		
		Signals.remove(S);
	}
	
	public Node GetLeftChild()
	{
		return Left;
	}
	
	public Node GetRightChild()
	{
		return Right;
	}
	
	public void SetLeftChild(Node Left)
	{
		this.Left = Left;
	}
	
	public void SetRightChild(Node Right)
	{
		this.Right = Right;
	}
	
	public int GetStrength()
	{
		return this.OverallStrength;
	}
	
	public ArrayList<Signal> GetSignals()
	{
		return Signals;
	}
	
	public int GetSignalCount()
	{
		return Signals.size();
	}
	
	public String toString()
	{
		String Return = "Strength: " + GetStrength();
		for (Signal S : Signals)
		{
			Return += S.toString() + " ";
		}
		return Return;
	}
}
