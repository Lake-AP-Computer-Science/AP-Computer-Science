package problem1;

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		ReadFile file = new ReadFile("C:\\Users\\balle\\Downloads\\signals.txt");
		ArrayList<Node> nodes = file.getNodes();
		SignalBST Tree = new SignalBST(nodes.get(0));
		nodes.remove(0);
		
		for(Node N : nodes)
		{
			Tree.add(N);
		}
	
		Tree.prettyPrint();
	}
}