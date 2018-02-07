package ee222yb_lab2;
import java.util.ArrayList;
import java.util.Scanner;

public class OmvandOrdning {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>(); 
		boolean continueLoop = true; // Sentinel
		String print = new String();
		
		Scanner in = new Scanner(System.in);
		System.out.println("Mata in positiva heltal. Avsluta med ett negativt.");
		do {
			System.out.print("Tal " + (numbers.size() + 1) + ": ");
			if(in.hasNextInt()) {
				int inputInt = in.nextInt();
				if(inputInt >= 0) {
					numbers.add(inputInt);
				}
				else {
					continueLoop = false;
				}
			}
			else {
				System.out.println("Du får bara mata in heltal. Avbryter inmatning.");
				continueLoop = false;
			}
		}
		while(continueLoop);
		
		// Print result backwards
		System.out.println("\nAntal positiva: " + numbers.size());
		System.out.print("Baklänges: ");
		for(int i = numbers.size() - 1; i >= 0; i --) {
			print += numbers.get(i);
			if(i != 0) {
				print += ", ";
			}
		}
		System.out.print(print);
		in.close();
	}

}
