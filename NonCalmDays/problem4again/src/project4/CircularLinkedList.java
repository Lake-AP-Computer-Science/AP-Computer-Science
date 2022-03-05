package project4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class CircularLinkedList
{
	private Node start, end;
	ArrayList<Node> nodes = new ArrayList<Node>();
	
	//adds the Node to the list based on the case/crime priority
	//and sets its court date by calling the method below [10 points]
	public void add(Node node)
	{
		nodes.add(node);
        
		if(start == null)
		{
            start = node;
            end = node;
            node.setNext(node);
            node.setPrevious(node);
            
            setCaseDate();
            return;
	    }
		
        if(comparePriorities(node, start) == -1 || comparePriorities(node, end) == 1)
        {
        	//specific order don't mix it up
            end.setNext(node);
            start.setPrevious(node);
            node.setNext(start);
            node.setPrevious(end);
            
            if(comparePriorities(node, start) == -1)
            {
                start = node;
            }
            else
            {
                end = node;
            }
            
            setCaseDate();
            return;
        }
        
        Node findr = start;
        while(findr != end)
        {
            if(comparePriorities(node, findr) == 1 && comparePriorities(node, findr.getNext()) == -1) {
            	//specific order again
                node.setPrevious(findr);
                node.setNext(findr.getNext());
                findr.setNext(node);
                findr.getNext().setPrevious(findr);
                
                setCaseDate();
                return;
            }
            findr = findr.getNext();
        }
	} 
	
	//sets the case Date based on the case priority [7 points]
	private void setCaseDate()
	{
		Date DateLowerBound = null, DateUpperBound = null;
		String Today = "04-03-2022";
		String InTenYears = "04-03-2032";
		
		SimpleDateFormat dateformatter = new SimpleDateFormat("dd-MM-yyyy");
		
		Node NodeAtEndOfArrayList = nodes.get(nodes.size()-1);
		
		try 
		{
			DateLowerBound = dateformatter.parse(Today);
			DateUpperBound = dateformatter.parse(InTenYears);
	    } 
		catch (ParseException e)
		{
	        e.printStackTrace();
		}
	        
	    if(nodes.size() == 1)
	    {
    		NodeAtEndOfArrayList.getCase().setDate(randomDate(DateLowerBound, DateUpperBound));
            return;
	    }
	        
	    if(NodeAtEndOfArrayList.equals(start))
	    {
	    	NodeAtEndOfArrayList.getCase().setDate(randomDate(DateLowerBound, start.getNext().getCase().getDate()));
	    }
	        
	    else if(NodeAtEndOfArrayList.equals(end))
	    {
	    	NodeAtEndOfArrayList.getCase().setDate(randomDate(end.getPrevious().getCase().getDate(), DateUpperBound));
	    }
	        
	    else
	    {
	    	NodeAtEndOfArrayList.getCase().setDate(randomDate(NodeAtEndOfArrayList.getPrevious().getCase().getDate(), NodeAtEndOfArrayList.getNext().getCase().getDate()));
	    }
	}
	
	//prints the list from start to end [5 points]
	public void printList()
	{
		Node temp = end;
        
		do
		{
			temp = temp.getNext();
            System.out.println(temp);
        }
		while(!temp.equals(end));
	}
	
	private int comparePriorities(Node n1, Node n2)
	{
		int Priority1 = n1.getCase().getCrime().getPriority();
		
	    int Priority2 = n2.getCase().getCrime().getPriority();
 
	    int Level1 = Integer.parseInt(String.valueOf(String.valueOf(Priority1).charAt(0)));
	    
	    int Level2 = Integer.parseInt(String.valueOf(String.valueOf(Priority2).charAt(0)));

	    if(Level1 == Level2) 
	    {
		    if(Priority1 == Priority2) return 0;
		    return (Priority1 > Priority2) ? 1: -1;
	    }
	        
	    return (Level1 < Level2) ? -1 : 1;
	}
	
	private Date randomDate(Date lowerBound, Date upperBound)
	{
		return new Date(ThreadLocalRandom.current().nextLong(lowerBound.getTime(), upperBound.getTime()));
	}
}