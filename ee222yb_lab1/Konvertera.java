package ee222yb_lab1;
import java.util.Scanner;

public class Konvertera {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Ange temperatur i Fahrenheit: ");
		double fahrenheit = in.nextDouble();
		double celsius = (fahrenheit - 32) * 5 / 9;
		
		System.out.printf("Det motsvarar %.1f grader Celsius.", celsius);
		in.close();
	}
}