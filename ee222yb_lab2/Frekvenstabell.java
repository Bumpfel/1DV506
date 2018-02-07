package ee222yb_lab2;
import java.util.Random;

public class Frekvenstabell {

	public static void main(String[] args) {
		final int DIE_ROLLS = 6000;
		final int MAX_DIE_VALUE = 6;
		int[] dieData = new int[MAX_DIE_VALUE];
		Random rand = new Random();
		
		for(int i = 0; i < DIE_ROLLS; i ++) {
			int randomDieValue = rand.nextInt(MAX_DIE_VALUE); // Keeping die values at 0-5 instead of 1-6 to fit array indexes
			dieData[randomDieValue] ++;
		}
		
		System.out.println("Frequencies when rolling a die 6000 times."); // ("a dice" = "en tärningar")
		for(int i = 0; i < dieData.length; i ++) {
			System.out.println((i + 1) + ": " + dieData[i]);
		}
	}
}
