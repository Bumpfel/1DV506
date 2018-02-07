package ee222yb_lab3;

public class FractionMain {

	public static void main(String[] args) {
		try {
			Fraction frac1 = new Fraction(-32, 256);
			Fraction frac2 = new Fraction(0, -16);
			
			System.out.println(frac1.toString());
			System.out.println(frac2.toString());
			System.out.println();
			
			Fraction addedFrac = frac1.add(frac2);
			System.out.println("added frac: " + addedFrac.toString());
			
			Fraction subtractedFrac = frac1.subtract(frac2);
			System.out.println("subtracted frac: " + subtractedFrac.toString());

			Fraction multipliedFrac = frac1.multiply(frac2);
			System.out.println("multiplied frac: " + multipliedFrac.toString());
			
			Fraction dividedFrac = frac1.divide(frac2);
			System.out.println("divided frac: " + dividedFrac.toString());
			
			System.out.println();
			System.out.println("Fraction 1 and 2 are equal: " + frac1.isEqualTo(frac2));
			System.out.println("Fraction 1 is negative: " + frac1.isNegative());
			System.out.println("Fraction 2 is negative: " + frac2.isNegative());

		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}	
	}

}