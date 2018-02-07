package ee222yb_lab2;
import java.util.Scanner;

public class Palindrom {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Skriv en textrad: ");
		String input = in.nextLine();
		String strippedInput = new String();
		String reversedInput = new String();
		
		// This loop puts all letters from the input to a new variable and turns them to lower case
		for(int i = 0; i < input.length(); i ++) {
			char thisChar = input.charAt(i);
			if(Character.isLetter(thisChar)) {
				thisChar = Character.toLowerCase(thisChar);
				strippedInput += thisChar;
			}
		}
		
		// Creates a reversed string of strippedInput. StringBuilder.reverse is an alternative
		for(int i = strippedInput.length() - 1; i >= 0; i --) {
			reversedInput += strippedInput.charAt(i);
		}
		
		if(strippedInput.equals(reversedInput)) {
			System.out.println("Textradens bokstäver är ett palindrom");
		}
		else {
			System.out.println("Textradens bokstäver är inte ett palindrom");
		}
		in.close();
	}
}
