package ee222yb_lab1;
import java.util.Scanner;

public class KortNamn {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Förnamn: ");
		String firstName = in.nextLine();
		System.out.print("Efternamn: ");
		String lastName = in.nextLine();
		
		int countLastNameChars = lastName.length();
		int i = Math.min(countLastNameChars,  4); // Sets a variable to 4 if lastName is longer than 4 chars. Otherwise to lastName's length
		String shortFirstName = firstName.substring(0, 1);
		String shortLastName = lastName.substring(0, i);
		System.out.print("Kort namn: " + shortFirstName + ". " + shortLastName);
		in.close();
	}
}
