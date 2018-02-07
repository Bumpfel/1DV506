package ee222yb_lab1;
import java.util.Scanner;

public class VindAvkylning {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Ange temperatur (C): ");
		double temp = in.nextDouble();
		
		System.out.print("Ange vindhastigheten (m/s): ");
		double wind = in.nextDouble();
		
		double unitConversionRatio = 3.6;
		wind *= unitConversionRatio; // From m/s to km/h
		
		double effectiveTemp = 13.12 + 0.6215 * temp - 11.37 * Math.pow(wind, 0.16) + 0.3965 * temp * Math.pow(wind, 0.16); // Wind Chill Index formula
		
		//double effectiveTemp = 33 + (temp - 33) * (.474 + .454 * Math.sqrt(wind) - .0454 * wind); // Siple's formula
		//int effectiveTempInt = (int) Math.round(effectiveTemp); // Rounds to one decimal precision and converts to integer
		
		System.out.printf("\nUpplevd temperatur (C): %.1f", effectiveTemp);
		
		in.close();
	}
}