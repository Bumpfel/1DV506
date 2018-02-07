package ee222yb_lab1;
import java.util.Scanner;

public class Sekunder {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Timmar: ");
		int hours = in.nextInt();
		System.out.print("Minuter: ");
		int minutes = in.nextInt();
		System.out.print("Sekunder: ");
		int seconds = in.nextInt();
		
		final int secsPerMinute = 60;
		final int secsPerHour = secsPerMinute * secsPerMinute; // 3600
		int calculation = seconds + (minutes * secsPerMinute) + (hours * secsPerHour);
		
		System.out.println("\nTotala antalet sekunder: " + calculation);
		in.close();
	}
}
