package ee222yb_lab2;
import java.util.Random;
import java.util.Scanner;

public class HighLow {

	public static void main(String[] args) {
		final int RAND_MAX = 100;
		final int RAND_MIN = 1;
		final int TOTAL_ATTEMPTS = 10;
		
		Random rand = new Random();
		int theNumber = rand.nextInt(RAND_MAX) + RAND_MIN;
		System.out.println("Slumpar ett varde mellan " + RAND_MIN + " och " + RAND_MAX + ". Du har " + TOTAL_ATTEMPTS + " gissning(ar) pa dig att hitta numret");
		//System.out.println(theNumber); // Debug ----------------------
		
		Scanner in = new Scanner(System.in);
		for(int attempt = 1; attempt <= TOTAL_ATTEMPTS; attempt ++) {
			System.out.print("Gissning " + attempt + ": ");
			int guess = in.nextInt();
			
			if(guess == theNumber) {
				System.out.print("\nRatt svar efter " + attempt + " gissning(ar) - Bra gjort!");
				break;
			}
			else if(attempt < TOTAL_ATTEMPTS) { // makes no sense to print leads if user has no more attempts
				if(guess > theNumber)
					System.out.println("   Ledtrad: lagre");
				else
					System.out.println("   Ledtrad: hogre");
			}
			else {
				System.out.print("\nSlut pa gissningar - svaret var " + theNumber);
			}
		}
		in.close();
	}
	
}
