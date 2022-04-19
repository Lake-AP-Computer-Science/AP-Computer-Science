package p;

public class Calculus2
{
	 //Precondition: p is not null
	 //Postcondition: returns the derivative of p as a Polynomial [5 points]
	 public static Polynomial differentiate(Polynomial p)
	 {
		 if(p.getPolynomial().length <= 1)
		 {
			 double a[] = new double[1];
			 a[0] = 0;
			 return new Polynomial(a);
		 }
		 double derivative[] = new double[p.getPolynomial().length - 1];
		 
		 for(int i = 1; i < p.getPolynomial().length; i++)
		 {
			 derivative[i-1] = p.getPolynomial()[i] * i;
		 }
		 
		 return new Polynomial(derivative);
	 }
	 
	 //Precondition: p is not null
	 //Postcondition: returns the value of the derivative of p at x = value
	 //First find the derivative and then substitute the value for x into
	 //the derivative and calculate a solution [5 points]
	 public static double differentiate(Polynomial p, double value)
	 {
		 Polynomial polynomial = differentiate(p);
		 return substituteSimplify(polynomial, value);
	 }
	 
	 //Precondition: p is not null
	 //Postcondition: returns a Polynomial as the antiderivative of p
	 //This is the indefinite integral of p and should include 
	 //the constant of integration in the solution but we
	 //will ignore it and put zero instead [5 points]
	 public static Polynomial integrate(Polynomial p)
	 {
		 double integral[] = new double[p.getPolynomial().length + 1];
		 
		 for(int i = 0; i < p.getPolynomial().length; i++)
		 {
			 if(p.getPolynomial()[i] != 0)
			 {
				 integral[i+1] = p.getPolynomial()[i]/(i+1);
			 }
		 }
		 
		 return new Polynomial(integral);
	 }
	 
	 //Precondition: p is not null, lowerLimit < upperLimit
	 //Postcondition: returns the solution to the definite integral [5 points]
	 public static double integrate(Polynomial p, double lowerLimit, double upperLimit)
	 {
		 Polynomial polynomial = integrate(p);
		 return substituteSimplify(polynomial, upperLimit) - substituteSimplify(polynomial, lowerLimit);
	 }
	 
	 //helper methods
	 public static double substituteSimplify(Polynomial polynomial, double num) 
	 {
		 double sum = 0;
		 for(int i = 0; i < polynomial.getPolynomial().length; i++)
		 {
			 sum += Math.pow(num, i) * polynomial.getPolynomial()[i];
		 }
		 return sum;
	 }
}