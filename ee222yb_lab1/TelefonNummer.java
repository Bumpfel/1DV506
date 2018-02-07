package ee222yb_lab1;
import java.util.Random;

public class TelefonNummer {

	public static void main(String[] args) {
		Random rand = new Random();
		
		final int MAX = 10; // Max-value for the randomizations (will exclude 10 in the randomizations)
		
		int startingAreaCodeInt = 0;
		int areaCodeInt2 = rand.nextInt(MAX);
		int areaCodeInt3 = rand.nextInt(MAX);
		int areaCodeInt4 = rand.nextInt(MAX);
		String areaCode = new String() + startingAreaCodeInt + areaCodeInt2 + areaCodeInt3 + areaCodeInt4; // String instead of int to prevent arithmetic addition
		
		int startingLocalInt = rand.nextInt(MAX - 1) + 1; // Randomizes a number between 0-8 and adds 1 to it = 1-9
		int localInt2 = rand.nextInt(MAX);
		int localInt3 = rand.nextInt(MAX);
		int localInt4 = rand.nextInt(MAX);
		int localInt5 = rand.nextInt(MAX);
		int localInt6 = rand.nextInt(MAX);
		String localNumber = "" + startingLocalInt + localInt2 + localInt3 + localInt4 + localInt5 + localInt6;
		
		String phoneNumber = areaCode + "-" + localNumber;
		System.out.println(phoneNumber);
	}

}