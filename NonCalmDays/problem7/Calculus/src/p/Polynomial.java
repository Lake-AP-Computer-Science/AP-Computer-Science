package p;

import java.util.Collections;

public class Polynomial
{
	/*
	* The double array polynomial will hold the values in
	* reverse order so that the index will match the exponent
	* of the polynomial term. So the constant will be at position
	* 0, the x term will be at position 1, the x^2 term will
	* be at position 2 and so on.
	* [4, 5, 3, 1, 1]
	* 1x^4 + 1x^3 + 3x^2 + 5x^1 + 4
	*/
	private double polynomial[];
	//complete the Polynomial constructor [1 point]
	public Polynomial(double polynomial[])
	{
		this.polynomial = polynomial;
	}
	//returns the Polynomial [1 point]
	public double[] getPolynomial()
	{
		return this.polynomial;
	}
	//returns the Polynomial as a String in descending
	//term degree order. For example, [2,1,3] should be
	//returned as 3x^2 + x + 2. Use the symbol ^ for exponents
	//and use the variable x for all Polynomial objects.
	//All coefficients of 1 should not appear in the String [3 points]
	public String toString()
	{
		String Return = "";
		for (int i = polynomial.length - 1; i >= 0; --i)
		{	
			Return += (polynomial[i] != 0 ? (polynomial[i] > 0 ? (Return != "" ? " + " : "") : (Return != "" ? " - " : "-")) + (Math.abs(polynomial[i]) == 1 && i > 0 ? "":Math.abs(polynomial[i])) + (i != 0 ? (i > 1 || i < -1 ? "x^" + i :"x") : ""): "");
		}
		return Return.replace(".0", "");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double c[] = {0,3,2,-1,0};
		Polynomial Cow = new Polynomial(c);
		System.out.println(Cow);
	}
}