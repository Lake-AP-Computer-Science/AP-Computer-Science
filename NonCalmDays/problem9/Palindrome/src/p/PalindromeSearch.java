package p;

public class PalindromeSearch {
	
	private String str = "";
	private String revstr = "";
	
	public PalindromeSearch(String Input)
	{
		this.str = Input;
		char[] inCharArr = Input.toCharArray();
		for (int i = inCharArr.length - 1; i >= 0; i--)
		{
			this.revstr += inCharArr[i];
		}
//		System.out.println(str);
//		System.out.println(revstr);
	}
	
	public String toString()
	{
		return this.str;
	}
	
	public boolean isPalindrome()
	{
		return this.str.equals(this.revstr);
	}
	
	public boolean isNearlyPalindrome()
	{
		return this.str.toLowerCase().replace(" ", "").equals(this.revstr.toLowerCase().replace(" ", "")) && !isPalindrome();
	}
	
	boolean isOffByOnePalindrome()
	{
		return findOffByOnePalindromeLetterIndex() >= 0 && !isPalindrome();
	}
	
	int findOffByOnePalindromeLetterIndex()
	{
		int index = -1;
		
		for (int i = 0; i < this.str.length() / 2; ++i)
		{
			if (this.str.charAt(i) != this.str.charAt(this.str.length() - 1 - i))
			{
				if (index != -1)
				{
					index = -1;
					break;
				}
				else
				{
					index = i;
				}
			}
		}
		
		if (index != -1)
			return index;
		
		for (int i = 0; i < this.str.length(); ++i)
		{
			String remove = this.str.substring(0, i) + this.str.substring(i + 1, this.str.length());
			
			//System.out.println(remove);
			
			PalindromeSearch tester = new PalindromeSearch(remove);
			
			if (tester.isPalindrome())
			{
				return i; 
			}
		}
		return -1;
	}
	
	public String convertToPalindrome()
	{
		if (isPalindrome())
			return this.str;
		
		if (isNearlyPalindrome())
			return this.str.toLowerCase().replace(" ", "");
		
		if (isOffByOnePalindrome())
		{
			int i = findOffByOnePalindromeLetterIndex();
			char[] s = this.str.toCharArray();
			s[i] = s[s.length - 1 - i];
			String ret = "";
			for (char c : s)
				ret += c;
			PalindromeSearch test = new PalindromeSearch(ret);
			if (test.isPalindrome())
				return ret;
			else
				return this.str.substring(0, i) + this.str.substring(i + 1, this.str.length());
				
		}
		
		return null;
	}
	
	//main
		public static void main(String[] args) 
		{
			PalindromeSearch p0 = new PalindromeSearch("mom");
//			String: mom
//			Palindrome? true
//			Nearly a Palindrome? true
//			Off by one? false
//			This string is not 1 character away from being a palindrome.
//			Converted Palindrome: mom
			
			PalindromeSearch p1 = new PalindromeSearch("poop");
//			String: poop
//			Palindrome? true
//			Nearly a Palindrome? true
//			Off by one? false
//			This string is not 1 character away from being a palindrome.
//			Converted Palindrome: poop
			
			PalindromeSearch p2 = new PalindromeSearch("pop");
//			String: pop
//			Palindrome? true
//			Nearly a Palindrome? true
//			Off by one? false
//			This string is not 1 character away from being a palindrome.
//			Converted Palindrome: pop
			
			PalindromeSearch p3 = new PalindromeSearch("121");
//			String: 121
//			Palindrome? true
//			Nearly a Palindrome? true
//			Off by one? false
//			This string is not 1 character away from being a palindrome.
//			Converted Palindrome: 121
			
			PalindromeSearch p4 = new PalindromeSearch("civic");
//			String: civic
//			Palindrome? true
//			Nearly a Palindrome? true
//			Off by one? false
//			This string is not 1 character away from being a palindrome.
//			Converted Palindrome: civic
			
			PalindromeSearch p5 = new PalindromeSearch("racecar");
//			String: racecar
//			Palindrome? true
//			Nearly a Palindrome? true
//			Off by one? false
//			This string is not 1 character away from being a palindrome.
//			Converted Palindrome: racecar
			
			PalindromeSearch p6 = new PalindromeSearch("Poop");
//			String: Poop
//			Palindrome? false
//			Nearly a Palindrome? true
//			Off by one? true
//			This index needs to be changed to make the string into a Palindrome: 0
//			Converted Palindrome: poop
			
			PalindromeSearch p7 = new PalindromeSearch("Refer");
//			String: Refer
//			Palindrome? false
//			Nearly a Palindrome? true
//			Off by one? true
//			This index needs to be changed to make the string into a Palindrome: 0
//			Converted Palindrome: refer
			
			PalindromeSearch p8 = new PalindromeSearch("Mom");
//			String: Mom
//			Palindrome? false
//			Nearly a Palindrome? true
//			Off by one? true
//			This index needs to be changed to make the string into a Palindrome: 0
//			Converted Palindrome: mom
			
			PalindromeSearch p9 = new PalindromeSearch("put");
//			String: put
//			Palindrome? false
//			Nearly a Palindrome? false
//			Off by one? true
//			This index needs to be changed to make the string into a Palindrome: 0
//			Converted Palindrome: tut
			
			PalindromeSearch p10 = new PalindromeSearch("soB");
//			String: soB
//			Palindrome? false
//			Nearly a Palindrome? false
//			Off by one? true
//			This index needs to be changed to make the string into a Palindrome: 0
//			Converted Palindrome: BoB
			
			PalindromeSearch p11 = new PalindromeSearch("race car");
//			String: race car
//			Palindrome? false
//			Nearly a Palindrome? true
//			Off by one? true
//			This index needs to be changed to make the string into a Palindrome: 3
//			Converted Palindrome: racecar
			
			PalindromeSearch p12 = new PalindromeSearch("civics");
//			String: civics
//			Palindrome? false
//			Nearly a Palindrome? false
//			Off by one? true
//			This index needs to be changed to make the string into a Palindrome: 5
//			Converted Palindrome: civic
			
			PalindromeSearch p13 = new PalindromeSearch("meme");
//			Palindrome? false
//			Nearly a Palindrome? false
//			Off by one? true
//			This index needs to be changed to make the string into a Palindrome: 3
//			Converted Palindrome: mem
			
			PalindromeSearch p14 = new PalindromeSearch("refers");
//			String: refers
//			Palindrome? false
//			Nearly a Palindrome? false
//			Off by one? true
//			This index needs to be changed to make the string into a Palindrome: 5
//			Converted Palindrome: refer
			
			PalindromeSearch p15 = new PalindromeSearch("poasdfop");
//			String: poasdfop
//			Palindrome? false
//			Nearly a Palindrome? false
//			Off by one? false
//			This string is not 1 character away from being a palindrome.
//			Converted Palindrome: null
			
			PalindromeSearch p16 = new PalindromeSearch("sdaadfsgfgsgaSAH");
//			String: sdaadfsgfgsgaSAH
//			Palindrome? false
//			Nearly a Palindrome? false
//			Off by one? false
//			This string is not 1 character away from being a palindrome.
//			Converted Palindrome: null
			
			PalindromeSearch[] a = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16};
			
			int counter = 1;
				
			for (PalindromeSearch c : a)
			{
				System.out.println("String " + counter + " - " + c);
				System.out.println("Palindrome? " + c.isPalindrome());
				System.out.println("Nearly a Palindrome? " + c.isNearlyPalindrome());
				System.out.println("Off by one? " + c.isOffByOnePalindrome());
				if(c.isOffByOnePalindrome() == true)
				{
					System.out.println("This index needs to be changed to make the string into a Palindrome: " + c.findOffByOnePalindromeLetterIndex());
				}
				else
				{
					System.out.println("This string is not 1 character away from being a palindrome.");
				}
				System.out.println("Converted Palindrome: " + c.convertToPalindrome());
				System.out.println();
				counter ++;
				
			}

		}

}
