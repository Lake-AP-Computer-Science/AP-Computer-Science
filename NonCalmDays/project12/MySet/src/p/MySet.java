package p;

import java.util.HashSet;

public class MySet {
	
	char[] charArray;
	
	public MySet(char[] InArray)
	{
		this.charArray = InArray;
	}
	
	public MySet()
	{
		this.charArray = new char[0];
	}
	
	public int contains(char InComp)
	{
		for (int i = 0; i < this.charArray.length; ++i)
		{
			if (this.charArray[i] == InComp)
				return i;
		}
		return -1;
	}
	
	public MySet union(MySet other)
	{
		MySet ReturnSet = new MySet(this.charArray);
		
		for (int i = 0; i < other.charArray.length; ++i)
		{
			ReturnSet = ReturnSet.add(other.charArray[i]);
		}
		
		return ReturnSet;
	}
	
	public MySet intersect(MySet other) 
	{
		MySet Intersect = new MySet(new char[0]);
		
		for (char c : this.charArray)
		{
			if (other.contains(c) != -1)
			{
				Intersect = Intersect.add(c);
			}
		}
		
		return Intersect;
	}
	
	public MySet add(char c)
	{
		if (this.contains(c) != -1)
		{
			return new MySet(this.charArray);
		}
		
		char[] newCharArr = new char[this.charArray.length + 1];
		
		for (int i = 0; i < this.charArray.length; ++i)
		{
			newCharArr[i] = this.charArray[i];
		}
		
		newCharArr[this.charArray.length] = c;
		
		return new MySet(newCharArr);
	}
	
	public MySet remove(char c) 
	{
		if (this.contains(c) == -1)
		{
			return new MySet(this.charArray);
		}
		
		char[] newCharArr = new char[this.charArray.length - 1];
		
		for (int i = 0, j = 0; i < this.charArray.length; ++i)
		{
			if (i != this.contains(c))
			{
				newCharArr[j++] = this.charArray[i];
			}
		}
		
		return new MySet(newCharArr);
		
		//return this;
	} //you can add more methods like contains
	
	public String toString()
	{
		String Return = "[";
		
		for (char c : this.charArray)
		{
			Return += c + ", ";
		}
		
		return (Return + " ").replace(",  ", "") + "]";
	}

	public static void main(String[] args)
    {
        //
        //Sets
        //
        MySet a = new MySet("abc129".toCharArray());
        MySet b = new MySet("zdga902".toCharArray());
        MySet m = new MySet("abcd".toCharArray());
        MySet n = new MySet("abcdefg".toCharArray());

        //
        //Test Cases for add() and remove()
        //
        System.out.println("Test Cases for add() and remove()");
        System.out.println(m);
        System.out.println("Expected:  [a, b, c, d]");
        System.out.println(m.add('a'));
        System.out.println("Expected:  [a, b, c, d]");
        System.out.println(m.remove('a'));
        System.out.println("Expected:  [b, c, d]");
        System.out.println(m.add('z'));
        System.out.println("Expected:  [a, b, c, d, z]");
        System.out.println(m.remove('z'));
        System.out.println("Expected:  [a, b, c, d]");
        System.out.println(m.add('a'));
        System.out.println("Expected:  [a, b, c, d]");
        System.out.println(n.add('b'));
        System.out.println("Expected:  [a, b, c, d, e, f, g]");
        System.out.println(n.remove('d'));
        System.out.println("Expected:  [a, b, c, e, f, g]");
        System.out.println("");

        //
        //Test Cases for union()
        //
        System.out.println("union()");
        System.out.println(a.union(b));
        System.out.println("Expected:  [a, b, c, d, g, z, 1, 2, 9, 0]");
        System.out.println(b.union(a));
        System.out.println("Expected:  [a, b, c, d, g, z, 1, 2, 9, 0]");
        System.out.println("");

        //
        //Test Cases for intersect()
        //
        System.out.println("intersect()");
        System.out.println(a.intersect(b));
        System.out.println("Expected:  [a, 2, 9]");
        System.out.println(b.intersect(a));
        System.out.println("Expected:  [a, 2, 9]");
        System.out.println("");
    }

}
