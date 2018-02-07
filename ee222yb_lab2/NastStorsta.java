package ee222yb_lab2;
import java.util.Scanner;

public class NastStorsta {

	public static void main(String[] args) {
		final int TOTAL_INTS = 10;
		int biggest = 0;
		int secondBiggest = 0;

		Scanner in = new Scanner(System.in);
		System.out.print("Mata in " + TOTAL_INTS + " heltal: ");
		
		for(int i = 1; i <= TOTAL_INTS; i ++) {
			if(in.hasNextInt()) {
				int thisNumber = in.nextInt();
				// Makes sure to set biggest and secondBiggest to the first two values
				// (to solve the case where the second biggest / biggest value in the input is less than the init. values of 0)
				if(i == 1)
					biggest = thisNumber;
				else if(i == 2) {
					if(thisNumber > biggest) {
						secondBiggest = biggest;
						biggest = thisNumber;
					}
					else
						secondBiggest = thisNumber;
				}
				else {
					if(thisNumber > biggest) {
						secondBiggest = biggest;
						biggest = thisNumber;
					}
					else if (thisNumber > secondBiggest)
						secondBiggest = thisNumber;
				}
			}
			else {
				if(in.hasNextLine()) {
					i --;
					System.out.println("Exkluderar:" + in.nextLine());
					System.out.print("Mata in ytterligare " + (TOTAL_INTS - i) + " heltal: ");
				}
			}
		}
		
		System.out.println("Det nast storsta talet ar: " + secondBiggest);
		in.close();
	}
	
}