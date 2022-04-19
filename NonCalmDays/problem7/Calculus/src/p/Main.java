package p;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		while (true)
		{
			
			Random r = new Random();
			
			double[] polyList = new double[20];
			for (int i = 0; i < polyList.length; i++)
			{
				polyList[i] = r.nextDouble();
			}
			
			Polynomial P = new Polynomial(polyList);
			
			if (!Calculus.differentiate(P).toString().equals(Calculus2.differentiate(P).toString()))
			{
				System.out.println("Differenciate; My Answer: " + Calculus.differentiate(P).toString());
				System.out.println("Differenciate; Their Answer: " + Calculus2.differentiate(P).toString());
				System.out.println();
			}
			else
				System.out.println("2");
			
			double val = Math.random() * (r.nextBoolean() ? -1: 1);
			
			if (Calculus.differentiate(P, val) !=  Calculus2.differentiate(P, val))
			{
				System.out.println("Differenciate with val of " + val + "; My Answer: " + Calculus.differentiate(P).toString());
				System.out.println("Differenciate with val of " + val + "; Their Answer: " + Calculus2.differentiate(P).toString());
				System.out.println();
			}
			else
				System.out.println("3");
			
			if (!Calculus.integrate(P).toString().equals(Calculus2.integrate(P).toString()))
			{
				System.out.println("Integrade; My Answer: " + Calculus.integrate(P).toString());
				System.out.println("Integrade; Their Answer: " + Calculus2.integrate(P).toString());
				System.out.println();
			}
			else
				System.out.println("4");
			
			double low = Math.random() * (r.nextBoolean() ? -1: 1);
			
			double upper = low + Math.random();
			
			if (Calculus.integrate(P, low, upper) != Calculus2.integrate(P, low, upper))
			{
				System.out.println("Integrade with val of " + low + " " + upper + "; My Answer: " + Calculus.integrate(P, low, upper));
				System.out.println("Integrade with val of " + low + " " + upper + "; Their Answer: " + Calculus2.integrate(P, low, upper));
				System.out.println();
			}
			else
				System.out.println("5");
			
		}
		
	}

}
