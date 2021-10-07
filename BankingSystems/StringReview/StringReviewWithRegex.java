import java.util.ArrayList;
import java.util.StringTokenizer;

public class StringReview {
	
	//extract all the numbers from the string
	//precondition: all the tokens are seperated by a single space
	//extract all the numbers from the article
    //precondition: token pairs are separated by a single space 
    
    public static ArrayList<Double>ExtractNumbers(String Article)
    {
        
    	ArrayList<Double> Numbers = new ArrayList<Double>();
		
    	String ArticleNew = Article.replaceAll("\\D", " ");
    	
		StringTokenizer TK = new StringTokenizer(ArticleNew);
		
		while (TK.hasMoreTokens())
			Numbers.add(Double.parseDouble(TK.nextToken()));
		
		return Numbers;
        
        
    }
	
	//precondition: count all the numbers in the article
	//post condition: return the numbers in articles
	public static int CountNumbers(String Article) 
	{
		return StringReview.ExtractNumbers(Article).size();
	}
	
	public static void main (String[] args) {
		System.out.println(StringReview.ExtractNumbers(
				"You sometimes hear that N.F.L. stands for “No Fun League,” and the nickname has hung around because it resonates. Restrictions on celebrations and rules about shirt-tucking can sometimes make the league seem a little like an authoritarian boarding school. In recent years, the N.F.L. has loosened its school tie a bit. More elaborate touchdown celebrations were authorized a few years back. And now players have at least some more leeway in what numbers they wear since the league approved a rule change on Wednesday. In the past, players were limited to a fairly small range of numbers, dependent on their position. Regulations remain, but the loosened rules amendment opens up myriad possibilities. Most notably, single-digit numbers, previously only available to quarterbacks, kickers and punters, will be an option to more players. Among the changes: Running backs and defensive backs, formerly limited to jersey numbers between 20 and 49, will now gain access to 1 through 19 (and running backs can also now wear numbers in the 80s); linebackers, who were stuck with numbers in the 40s, 50s and 90s, can choose 1 through 39, as well; and wide receivers and tight ends will gain the single digits, 20s, 30s and 40s. No changes are being made for quarterbacks and kickers, who still must wear numbers under 20, or to linemen, who wear 50 to 79. The rule change was proposed because, in some cases, teams were running out of suitable numbers. During the pandemic, teams were allowed to have larger practice squads, eating into usable numbers. And some teams have retired enough numbers to significantly cut into their numbering flexibility. The Kansas City Chiefs, who proposed the change, have retired 10 numbers. “Frankly, the players themselves really like this,” said Troy Vincent, the N.F.L.’s executive vice president for football operations. “They like having that option. Bigs like wearing single-digit numbers. It’s different, it’s not what we’re accustomed to seeing, someone on the D-line wearing a single-digit number, but it’s fun.” Editors’ Picks What Do Marvel Characters Eat? Pop-Culture Cookbooks Have Answers, and Rapt Audiences. Sex, Drugs and Roller Skates Nearly Silenced by A.L.S., an Ex-N.F.L. Pro Thrives Telling His Story Continue reading the main story There you go. Fun."
				)
			);
	}
	
}
