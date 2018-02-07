package ee222yb_lab2;
import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Ange ett udda heltal: ");
		
		if(in.hasNextInt()) { // If input is an int
			int input = in.nextInt();
			if(input > 0 && input % 2 == 1) { // If input is positive and uneven
				// Makes a rectangular triangle 
				System.out.println("Rätvinklig triangel");
				for(int row = 1; row <= input ; row ++) {
					int spacesThisRow = input - row;
					for(int space = 1; space <= spacesThisRow; space ++) {
						System.out.print(" ");
					}
					for(int star = 1; star <= row; star ++) {
						System.out.print("*");
					}
					System.out.println();
				}
				
				// Makes an equilateral triangle
				int totalRows = (input / 2) + 1; // int division cuts the decimal. adding 1 is easier than rounding a double and converting it to int
				int starsThisRow = 1;
				System.out.println("\nLiksidig triangel");
				for(int row = 1; row <= totalRows; row ++) {
					int spacesThisRow = totalRows - row;
					for(int space = 1; space <= spacesThisRow; space ++) {
						System.out.print(" ");
					}
					for(int star = 1; star <= starsThisRow; star ++) {
						System.out.print("*");
					}
					System.out.print("\n");
					starsThisRow += 2;
				}
			}
			else {
				System.out.print("Du måste ange ett udda naturligt tal");
			}
		}
		else {
			System.out.print("Du måste ange ett udda naturligt tal");
		}
		in.close();
	}

}
