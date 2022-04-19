package p;

public class Calculus
{
	 //Precondition: p is not null
	 //Postcondition: returns the derivative of p as a Polynomial [5 points]
	 public static Polynomial differentiate(Polynomial p)
	 {
		 double[] numbers = p.getPolynomial().clone();
		 
		 for (int i = 1; i < numbers.length; i++)
		 {
			 numbers[i - 1] = numbers[i] * i;
		 }
		 
		 numbers[numbers.length - 1] = 0;
		 
		 return new Polynomial(numbers);
	 }
	 
	 public static double solve(Polynomial p, double x)
	 {
		 double Return = 0.0;
		 
		 double[] numbers = p.getPolynomial();
		 
		 for (int i = 0; i < numbers.length; ++i)
		 {
//			 System.out.println(numbers[i] + " * " + x + "^" + (i));
			 Return += numbers[i] * Math.pow(x, i);
		 }
		 
		 return Return;
	 }
	 
	 //Precondition: p is not null
	 //Postcondition: returns the value of the derivative of p at x = value
	 //First find the derivative and then substitute the value for x into
	 //the derivative and calculate a solution [5 points]
	 public static double differentiate(Polynomial p, double value)
	 {
		 return Calculus.solve(Calculus.differentiate(p), value);
	 }
	 //Precondition: p is not null
	 //Postcondition: returns a Polynomial as the antiderivative of p
	 //This is the indefinite integral of p and should include
	 //the constant of integration in the solution but we
	 //will ignore it and put zero instead [5 points]
	 public static Polynomial integrate(Polynomial p)
	 {
		 double[] numbers = p.getPolynomial().clone();
		 
		 double[] newPoly = new double[numbers.length + 1];
		 
		 for (int i = 0; i < numbers.length; i++)
		 {
			 newPoly[i + 1] = numbers[i] / (i + 1);
		 }
		 
		 newPoly[0] = 0;
		 
		 return new Polynomial(newPoly);
	 }
	 //Precondition: p is not null, lowerLimit < upperLimit
	 //Postcondition: returns the solution to the definite integral [5 points]
	 public static double integrate(Polynomial p, double lowerLimit, double upperLimit)
	 {
		 Polynomial n = Calculus.integrate(p);
		 System.out.println(Calculus.solve(n, upperLimit));
		 System.out.println(Calculus.solve(n, lowerLimit));
		 return Calculus.solve(n, upperLimit) - Calculus.solve(n, lowerLimit);
	 }
	 
}