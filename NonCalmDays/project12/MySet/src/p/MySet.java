package p;

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
		MySet Union = new MySet(this.charArray);
		
		for (int i = 0; i < other.charArray.length; ++i)
		{
			Union = Union.add(other.charArray[i]);
		}
		
		this.charArray = Union.charArray;
		
		return Union;
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
		
		this.charArray = Intersect.charArray;
		
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
		
		this.charArray = newCharArr;
		
		return this;
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
		
		this.charArray = newCharArr;
		
		return this;
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
		System.out.println("Your Output:     " + m);
		System.out.println("Expected Output: [a, b, c, d]\n");
		System.out.println("Your Output:     " + m.add('a'));
		System.out.println("Expected Output: [a, b, c, d]\n");
		System.out.println("Your Output:     " + m.remove('a'));
		System.out.println("Expected Output: [b, c, d]\n");
		System.out.println("Your Output:     " + m.add('z'));
		System.out.println("Expected Output: [b, c, d, z]\n");
		System.out.println("Your Output:     " + m.remove('z'));
		System.out.println("Expected Output: [b, c, d]\n");
		System.out.println("Your Output:     " + m.add('a'));
		System.out.println("Expected Output: [b, c, d, a]\n\n");
	
		System.out.println("Your Output:     " + n.add('b'));
		System.out.println("Expected Output: [a, b, c, d, e, f, g]\n");
		System.out.println("Your Output:     " + n.remove('d'));
		System.out.println("Expected Output: [a, b, c, e, f, g]\n");
		System.out.println("Your Output:     " + n.remove('c'));
		System.out.println("Expected Output: [a, b, e, f, g]\n\n");
		
		//
		//Test Cases for union()
		//
		System.out.println("Your Output:     " + a.union(b));
		System.out.println("Expected Output: [a, b, c, d, g, z, 1, 2, 9, 0]\n");
		//order does not matter (make sure there are these 10 characters though)
		System.out.println("Your Output:     " + a);
		System.out.println("Expected Output: [a, b, c, d, g, z, 1, 2, 9, 0]\n");
		//order does not matter (make sure there are these 3 characters though)
		
		a = new MySet("abc129".toCharArray());
		b = new MySet("zdga902".toCharArray());
		
		System.out.println("Your Output:     " + b.union(a));
		System.out.println("Expected Output: [a, b, c, d, g, z, 1, 2, 9, 0]\n");
		//order does not matter (make sure there are these 10 characters though)
		System.out.println("Your Output:     " + b);
		System.out.println("Expected Output: [a, b, c, d, g, z, 1, 2, 9, 0]\n");
		//order does not matter (make sure there are these 3 characters though)
		
		a = new MySet("abc129".toCharArray());
		b = new MySet("zdga902".toCharArray());
		
		//
		//Test Cases for intersect()
		//
		System.out.println("Your Output:     " + a.intersect(b));
		System.out.println("Expected Output: [a, 2, 9]\n");
		//order does not matter (make sure there are these 3 characters though)
		System.out.println("Your Output:     " + a);
		System.out.println("Expected Output: [a, 2, 9]\n");
		//order does not matter (make sure there are these 3 characters though)
		
		a = new MySet("abc129".toCharArray());
		b = new MySet("zdga902".toCharArray());
		
		System.out.println("Your Output:     " + b.intersect(a));
		System.out.println("Expected Output: [a, 2, 9]\n");
		//order does not matter (make sure there are these 3 characters though)
		System.out.println("Your Output:     " + b);
		System.out.println("Expected Output: [a, 2, 9]\n");
		//order does not matter (make sure there are these 3 characters though)
	}

}
