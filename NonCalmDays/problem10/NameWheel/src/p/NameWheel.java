package p;

public class NameWheel
{
  //A wheel has a square 2D array with a minimum dimension //of 3x3 and a maximum dimension of 10x10
  private String[][] wheel;
  //Precondition: 3 <= size <= 10
  //creates a square 2D array of dimension size x size //and initializes the wheel [1 point]
  public NameWheel(int size)
  {
    this.wheel = new String[size][size];
  }
  //Precondition: name is not null
  //Postcondition: returns true if name is in the wheel; //false otherwise [5 points]
  public boolean contains(String name)
  {
    for (String[] row : this.wheel)
      {
        for (String each : row)
          {
            if (each == null)
            {
              continue;
            }
            if (each.equals(name))
            {
              return true;
            }
          }
      }
    return false;
  }

  private boolean IsValid(int row, int col)
  {
    return row == 0 || row == this.wheel.length - 1 || col == this.wheel.length - 1 || col == 0;
  }
  //Precondition: name is not null
  //Adds a name to any empty outermost locations of the wheel 
  //leaving the inner locations empty and returns the wheel. 
  //If there are no empty locations the wheel remains 
  //unchanged, and the name is not added. [5 points]
  public NameWheel add(String name)
  {
    for (int col = 0; col < this.wheel[0].length; ++col)
      {
        if (this.wheel[0][col] == null)
        {
          this.wheel[0][col] = name;
          return this;
        }
      }

    for (int row = 1; row < this.wheel.length; ++row)
      {
        if (this.wheel[row][this.wheel.length - 1] == null)
        {
          this.wheel[row][this.wheel.length - 1] = name;
          return this;
        }
      }

    for (int row = 1; row < this.wheel.length; ++row)
      {
        if (this.wheel[this.wheel.length - 1][this.wheel.length - 1 - row] == null)
        {
          this.wheel[this.wheel.length - 1][this.wheel.length - 1 - row] = name;
          return this;
        }
      }

    for (int col = 1; col < this.wheel[0].length; ++col)
      {
        if (this.wheel[this.wheel.length - 1 - col][0] == null)
        {
          this.wheel[this.wheel.length - 1 - col][0] = name;
          return this;
        }
      }
    return this;
  }
  //Precondition: name is not null
  //adds a name to the specified row and column locations //of the wheel if the location is valid leaving the //inner locations empty and returns the wheel. If there is //a name in that location it is overridden and the wheel //is returned. If the location is invalid the wheel //remains unchanged. [3 points]
  public NameWheel add(int row, int col, String name)
  {
    if (!IsValid(row, col))
    {
      return this;
    }

    this.wheel[row][col] = name;

    return this;
  }
  
  //removes the name, if it exists, from the wheel and //replaces it with null; otherwise the wheel is unchanged. //[5 points]
  public NameWheel remove(String name)
  {
    if (!this.contains(name))
    {
      return this;
    }

    for (int row = 0; row < this.wheel.length; row++)
      {
        for (int col = 0; col < this.wheel[row].length; col++)
          {
            if (this.wheel[row][col] == null)
            {
              continue;
            }
            //System.out.println(this.wheel[row][col] + " and " + name);
            if (this.wheel[row][col].equals(name))
            {
              this.wheel[row][col] = null;
              return this;
            }
          }
      }
    
    return this;
  }
  //Precondition: name is not null
  //removes a name from the specified row and column 
  //locations of the wheel if the location is valid leaving 
  //the locations null and returns the wheel. If there is a 
  //name in that location it is overridden with null and the 
  //wheel is returned. If the location is invalid the wheel 
  //remains unchanged. [3 points]
  public NameWheel remove(int row, int col)
  {
    if (!IsValid(row, col))
    {
      return this;
    }

    this.wheel[row][col] = null;
    return this;
  }
  //returns a string representation of the wheel
  //by showing the names in the correct locations.
  //All null values should be represented by a tab ("\t") //and names should be separated by a tab. [5 points] 
  public String toString()
  {
    String Return = "";
    for (int row = 0; row < this.wheel.length; row++)
      {
        for (int col = 0; col < this.wheel[row].length; col++)
          {
            if (this.wheel[row][col] != null)
            {
              Return += this.wheel[row][col];
            }
            else
            {
              Return += "\t";
            }
            Return += "\t";
          }
        Return += "\n";
      }
    return Return;
  }
  //Tough problem
  //The direction is not null and is either "clockwise" or 
  //"counterclockwise". Spins the wheel in the direction 
  //given. The wheel moves every name one space in the //clockwise or counterclockwise direction
  //and returns the updated wheel. [10 points]
  public NameWheel spin(String direction, int numSpaces)
  {
      NameWheel n = new NameWheel(this.wheel.length);
      n.wheel = this.wheel;

    for (int i = 0; i <= (int)(Math.abs(numSpaces-1)); ++i)
      {
        n = n.spin(direction);
      }

    this.wheel = n.wheel;
    return this;
  }
  
  public NameWheel spin(String direction)
  {
      NameWheel newN = new NameWheel(this.wheel.length);

      for (int row = 0; row < this.wheel.length; row++)
      {
    	  for (int col = 0; col < this.wheel[row].length; col++)
    	  {
    		  if (!IsValid(row, col))
    			  continue;
    		  
    		  int[] Indexes = findNewRotationLocation(direction, row, col, this.wheel.length - 1);
    		  //System.out.println(Indexes[0] + " " + Indexes[1] + "for next up from " + row + " " + col);
    		  newN.wheel[Indexes[0]][Indexes[1]] = this.wheel[row][col];
    	  }
      }
      
      this.wheel = newN.wheel;
      
      return newN;
  }
  
     //returns the new position that the name at [row][col]
     //needs to move to base on the direction of motion.
     //maxIndex is the largest index in the NameWheel
  private int[] findNewRotationLocation(String direction, int row, int col, int maxIndex)
  {
    if(direction.equals("clockwise")) {
      if(row == 0 && col != maxIndex) 
        return new int[] {row, col+1};
      else if(col == maxIndex && row != maxIndex) 
        return new int[] {row+1, col};
      else if(row == maxIndex && col != 0)
        return new int[] {row, col-1}; 
      else if(col == 0 && row <= maxIndex)
        return new int[] {row-1, col};
    }
    else if(direction.equals("counterclockwise"))
    {
      if(col == 0 && row != maxIndex)
        return new int[] {row+1, col};
      else if(row == maxIndex && col != maxIndex)
        return new int[] {row, col+1}; 
      else if(col == maxIndex && row != 0)
        return new int[] {row-1, col}; 
      else if(row == 0 && col <= maxIndex)
        return new int[] {row, col-1}; 
    }
    return new int[] {};
  }
  
  public static void main(String[] args) 
	{
		NameWheel wheelOfFortune = new NameWheel(4);
		for(int i = 0; i < 12; i++)
		{
			wheelOfFortune.add("a");
		}
		
		System.out.println("Wheel of 'a'");
		System.out.println(wheelOfFortune);
		
		System.out.println("Contains 'a'? " + wheelOfFortune.contains("a"));
		
		System.out.println("Contains 'b'? " + wheelOfFortune.contains("b"));
		
		wheelOfFortune.remove(1,0);
		System.out.println("Removed [1][0]");
		System.out.println(wheelOfFortune);
		
		wheelOfFortune.remove("a");
		System.out.println("Removed all 'a'");
		System.out.println(wheelOfFortune);
		
		for(int i = 0; i < 12; i++)
		{
			wheelOfFortune.add("a");
		}
		System.out.println("Wheel of 'a'");
		System.out.println(wheelOfFortune);
		
		wheelOfFortune.remove(0,3);
		System.out.println("Removed [0][3]");
		System.out.println(wheelOfFortune);
		
		wheelOfFortune.spin("clockwise");
		System.out.println("spining clockwise by 1");
		System.out.println(wheelOfFortune);
		
		wheelOfFortune.spin("counterclockwise");
		System.out.println("spinning counterclockwise by 1");
		System.out.println(wheelOfFortune);
		
		wheelOfFortune.spin("counterclockwise", 3);
		System.out.println("spinning counterclockwise by 3");
		System.out.println(wheelOfFortune);
		
		wheelOfFortune.spin("clockwise", 3);
		System.out.println("spinning clockwise by 3");
		System.out.println(wheelOfFortune);
	
		NameWheel nw = new NameWheel(5);
		nw.add("a");
		nw.add("b");
	    nw.add("c");
	    nw.add("d");
	    nw.add("e");
	    nw.add("f");
	    nw.add("g");
	    nw.add("h");
	    nw.add("i");
	    nw.add("j");
	    nw.add("k");
	    nw.add("l");
	    nw.add("m");
	    nw.add("n");
	    nw.add("o");
	    nw.add(4, 4, "p");
		  
	    System.out.println("5x5 alphabet wheel");
	    System.out.println(nw);
	    
	    nw = nw.spin("clockwise");
	    System.out.println("\nwheel after spin clockwise");
	    System.out.println(nw);
	    
	    nw.spin("clockwise");
	    System.out.println("\nwheel after spin clockwise");
	    System.out.println(nw);

	    nw = nw.spin("counterclockwise", 1);
	    System.out.println("\nwheel after spin counterclockwise by 1");
	    System.out.println(nw);
	}
}
 