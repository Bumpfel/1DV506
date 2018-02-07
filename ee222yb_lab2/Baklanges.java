package ee222yb_lab2;
import java.util.Scanner;

public class Baklanges {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Skriv en textrad: ");
		String text = in.nextLine();
		
		String textBackwards = new String();
		for(int i = text.length() - 1; i >= 0; i --) {
			textBackwards += text.charAt(i);
		}
		
		System.out.print("Baklanges: " + textBackwards);
		in.close();
	}

}
