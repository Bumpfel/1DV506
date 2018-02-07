package ee222yb_lab1;
import java.util.Scanner;

public class SummaAvTre {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Ange ett tresiffrigt heltal: ");
		int nr = in.nextInt();	// t.ex. 476
		int nr1 = nr / 100; 	// = 4 
		int nr2 = nr / 10 % 10; // = 47 % 10 = 7
		int nr3 = nr % 10; 		// = 6
		int calc = (nr1 + nr2 + nr3);
		System.out.println("Siffersumman av talet är: " + calc);
		in.close();
	}
}
