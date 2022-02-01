package APCompSci3.problem1;

import java.util.ArrayList;
import java.util.Arrays;

public class SignalBST
{
	private Node root;
	private ArrayList<Integer> nodeStrengths;
	private ArrayList<Node> nodes;
	
	public SignalBST()
	{
		nodeStrengths = new ArrayList<>();
	}
	
	//adds a node to the SignalBST according to the Binary Search Tree rules of insertion
	public SignalBST add(Node node)
	{
		if(root == null){
			root = node;
		}
		
		else{
			insert(root, node);
		}
		nodes.add(node);
		nodeStrengths.add(node.strength);
		return this;
	}
	
	private void insert(Node parent, Node child) {
		if(parent.strength == child.strength){
			parent.addSignal(child.signals);
			return;
		}
		
		if(child.strength < parent.strength){
			if(parent.left == null){
				parent.left = child;
				return;
			}
			else {
				parent = child;
				child = child.left;
				insert(parent,child);
			}
		}
		else {
			if(parent.right == null){
				parent.right = child;
				return;
			}
			else {
				parent = child;
				child = child.right;
				insert(parent, child);
			}
		}
	}
	
	
	//removes a node from the SignalBST according to the Binary Search Tree rules of deletion
	public SignalBST removeSignal(Signal signal)
	{
		try {
			deleteSignal(root, signal);
		}
		catch(Exception e){
			return this;
		}
		return this;
	}

	
	public void deleteSignal(Node node, Signal signal){
		//check if node has signal
		for(int i = node.signals.size()-1; i >= 0; i--) {
			if(node.signals.get(i).getSignal().equals(signal.getSignal())){
				node.signals.get(i).decr();
				
				if(node.signals.get(i).getCount() == 0){
					node.signals.remove(signal);
				}
				return;
			}
		}
		
		//if node does not have signal...
		if(node.left != null){
			deleteSignal(node.left, signal);
		}
		if(node.right!= null){
			deleteSignal(node.right, signal);
		}
	}
	
	//returns a list of signal strengths for the given signal pattern
	public ArrayList<Integer> getSignalStrengths(String signalPattern)
	{
		return nodeStrengths;
	}
	
	//returns the maximum signal strength for the given signal pattern
	public int getMaxSignalStrength(String signalPattern)
	{
		int[] strengths = new int[this.nodeStrengths.size()];
		for(int i = 0; i < this.nodeStrengths.size(); i++) {
			strengths[i] = nodeStrengths.get(i);
		}
		Arrays.sort(strengths);
		return strengths[strengths.length - 1];
	}
	
	//combines and return the SignalBST that is  a combination of A and B
	public SignalBST combine(SignalBST A, SignalBST B)
	{
		for(Node node:
				B.nodes) {
			A.add(node);
		}
		return A;
	}
	
	
}
