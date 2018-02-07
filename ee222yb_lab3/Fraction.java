package ee222yb_lab3;

public class Fraction {
	// (Det var så sjukt förvirrande att dessa skulle heta T och N samtidigt som man helst vill skriva engelska namn på variablerna, så jag döpte om dem)
	private int N; // Täljare / Numerator
	private int D; // Nämnare / Denominator
	
	public Fraction(int numerator, int denominator) throws Exception {
		N = numerator;
		if(denominator == 0)
			throw new Exception("Error: Can not set denominator to 0");
		// Removes the negative signs if the numerator and denominator are both negative (looks better)
		else if(numerator < 0 && denominator < 0) {
			N = Math.abs(numerator);
			D = Math.abs(denominator);
		}
		// Puts the minus in front of the numerator if the numerator is positive and the denominator is negative (looks better)
		else if(numerator >= 0 && denominator < 0) { 
			N = numerator * (-1);
			D = Math.abs(denominator);
		}
		else
			D = denominator;
	}
	
	public int getNumerator() {
		return N;
	}
	
	public int getDenominator() {
		return D;
	}
	
	public boolean isNegative() {
		return (N < 0 && D > 0) || (N > 0 && D < 0);
	}
	
	public boolean isEqualTo(Fraction frac) {
		return 1.0 * N / D == 1.0 * frac.N / frac.D; // multiplying with 1.0 to make sure an integer division is not performed
	}
	
	public String toString() {
		return N + "/" + D;
	}
	
	public Fraction add(Fraction frac) throws Exception {
		int commonDenominator = D * frac.D;
		int thisNumerator = frac.D * N;
		int fracNumerator = D * frac.N;
		int newNumerator = thisNumerator + fracNumerator;
		
		return shortFrac(newNumerator, commonDenominator);
	}
	
	public Fraction subtract(Fraction frac) throws Exception {
		int commonDenominator = D * frac.D;
		int thisNumerator = N * frac.D;
		int fracNumerator = frac.N * D;
		int newNumerator = thisNumerator - fracNumerator;
		
		return shortFrac(newNumerator, commonDenominator);
	}
	
	public Fraction multiply(Fraction frac) throws Exception {
		int newNumerator = N * frac.N;
		int newDenominator = D * frac.D;
		return shortFrac(newNumerator, newDenominator);
	}
	
	public Fraction divide(Fraction frac) throws Exception {
		int newNumerator = N * frac.D;
		int newDenominator = D * frac.N;
		if(newDenominator == 0)
			throw new Exception("Error: Attempted division by 0");
		return shortFrac(newNumerator, newDenominator);
	}
	
	/**
	 * Creates a new shortened fraction
	 * @param numerator - int
	 * @param denominator - int
	 * @return shortened Fraction
	 */
	private Fraction shortFrac(int numerator, int denominator) throws Exception {
		// Don't want a negative result
		int a = Math.abs(numerator);
		int b = Math.abs(denominator);
		int c;
		
		// makes sure a is the biggest
		if(a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		// Finds the last remainder that isn't 0
		while(b > 0) {
			c = a % b;
			a = b;
			b = c;
		}
		int sgd = a; // Biggest common divider
		
		return new Fraction(numerator / sgd, denominator / sgd);
	}


}
