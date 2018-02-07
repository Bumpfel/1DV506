package ee222yb_lab1;
import java.util.Scanner;

public class Citat {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Skriv en rad: ");
		String cite = in.nextLine();
		System.out.println("Citat: \"" + cite + "\"");
		in.close();
	}
}