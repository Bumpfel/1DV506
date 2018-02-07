package ee222yb_lab1;
import java.util.Scanner;

public class BMI {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Ange din längd i meter: ");
		double length = in.nextDouble();
		System.out.print("Ange din vikt i kilogram: ");
		int weight = in.nextInt();
		
		double calc = weight / Math.pow(length, 2);
		int bmi = (int) Math.round(calc); // Rounds and converts to integer
		System.out.println("Ditt BMI är: " + bmi);
		in.close();
	}
}
