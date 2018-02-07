package ee222yb_lab1;
import java.util.Scanner;

public class Tid {
	public static void main(String[] args) {
		System.out.print("Ange antal sekunder: ");
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		int secsLeft = input; // For calculations
		
		final int SECS_PER_MINUTE = 60;
		final int SECS_PER_HOUR = 3600;
		
		int hours = secsLeft / SECS_PER_HOUR; // Puts full hours in a variable
		secsLeft = secsLeft % SECS_PER_HOUR; // The remaining seconds will be used to calculate #minutes (and seconds)
		int minutes = secsLeft / SECS_PER_MINUTE;  
		int secs = secsLeft % SECS_PER_MINUTE; // The excess is less than a minute and will be displayed in seconds
		
		System.out.println(input + " sekunder motsvarar: " + hours + " timmar, " + minutes + " minuter, och " + secs + " sekunder.");
		in.close();
	}
	
}