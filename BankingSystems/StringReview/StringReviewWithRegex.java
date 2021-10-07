import java.util.ArrayList;

public class StringReview {
	
	//extract all the numbers from the string
	//precondition: all the tokens are seperated by a single space
	public static ArrayList<Double> ExtractNumbers(String Article)
	{
		ArrayList<Double> Numbers = new ArrayList<Double>();
		
		Numbers = Article.replaceAll("\\D", " ");
		
		return Numbers;
	}
	
	//precondition: count all the numbers in the article
	//post condition: return the numbers in articles
	public static int CountNumbers(String Article) 
	{
		return ExtractNumbers(Article).size();
	}
	
	public static void main (String[] args) {
		System.out.println(StringReview.ExtractNumbers("Cow 1 moo, 132, 12md, cows1283417238312, 142"));
	}
	
}
