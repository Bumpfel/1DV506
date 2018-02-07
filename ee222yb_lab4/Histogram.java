package ee222yb_lab4;

import java.io.File;
import java.util.Scanner;

public class Histogram {

	public static void main(String[] args) {
		try {
			File dataFile = new File(args[0]);
			Scanner input = new Scanner(dataFile);
			
			final int NR_OF_INTERVALS = 10;
			final int INTERVAL_SPAN = 10;
			int[] intervals = new int[NR_OF_INTERVALS];
			int numbersInInterval = 0, otherNumbers = 0;
			
			while(input.hasNextInt()) {
				int curNr = input.nextInt();
				int index = (curNr - 1) / INTERVAL_SPAN; // Calculates which interval the number fits in (which array index)

				if(index < intervals.length && index >= 0) {
					numbersInInterval ++;
					intervals[index] ++;
				}
				else
					otherNumbers ++;
			}
			input.close();

			System.out.println("Laser heltal fran filen: " + args[0]);
			System.out.println("Antal i intervallet [1, " + NR_OF_INTERVALS * INTERVAL_SPAN + "]: " + numbersInInterval);
			System.out.println("Ovriga: " + otherNumbers);
			System.out.println("Histogram");

			int lineStartInterval = 1;
			int lineEndInterval = INTERVAL_SPAN;
			
			for(int interval : intervals) {
				System.out.format("%-2d - %-3d | ", lineStartInterval, lineEndInterval); // prints the intervals for each line, making sure they line up properly
				lineStartInterval = lineEndInterval + 1;
				lineEndInterval = lineStartInterval - 1 + INTERVAL_SPAN; 
				
				String starPrint = new String();
				for(int j = 0; j < interval; j ++) {
					starPrint += "*";
				}
				System.out.println(starPrint);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}