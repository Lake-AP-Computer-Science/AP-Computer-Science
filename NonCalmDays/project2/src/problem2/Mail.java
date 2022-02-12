package problem2;

import java.text.DecimalFormat;

public abstract class Mail extends Object implements Comparable<Object>
{
	public abstract double calculatePostage();
	
	public String toString() //write toString() method to print $dollars.cents
	{
		DecimalFormat dollars = new DecimalFormat("$0.00");
		return dollars.format(calculatePostage());
	}
	
	public PriorityMail GetPriorityMail(Mail Other) //A get priority mail method that takes in any mail object and converts them into a priority mail
	{	
		if (Other instanceof PriorityMail) //if it is a priority mail, just cast it
			return (PriorityMail)Other;
		
		if (Other instanceof MediaMail) //if it is a media mail, get the priority mail from the media mail's composition
				return ((MediaMail)Other).getPM();
		
		if (Other instanceof InsuredMail) //if it is an insured mail, it doesn't have a definitive type as it can be any type of mail but insured, so we can call the function again (recursion) to strip it layer by layer (eg. a insured mail of an insured mail of a media mail)
				return GetPriorityMail(((InsuredMail)Other).getNestedMail());
		
		return null; //nothing found- if this happens your code fucked up
	}
 
	@Override
	public int compareTo(Object other) //compare based on raw postage then of the weight (stored in prioritymails in other classes as a container)
	{
		
		PriorityMail Other = GetPriorityMail((Mail)other);
		
		PriorityMail Self = GetPriorityMail(this);
		
		double Cost = (((Mail)(other)).calculatePostage() - this.calculatePostage()); //if other is bigger than this it'll return something greater than 1, else less, if 0 compare weight instead
		
		if (Cost != 0)
			return (int)(Cost); 
		
		//if costs are equal
		return (int)(Other.getWeight() - Self.getWeight());
	}
	
	public boolean equals(Object other) //ez implementaition, no lines
	{
		return compareTo(other) == 0;
	}
}
