package ee222yb_lab2;
import java.util.Scanner;

public class RaknaSiffror {

	public static void main(String[] args) {
		int countZero = 0;
		int countEven = 0;
		int countOdd = 0;
		
		Scanner in = new Scanner(System.in);
		System.out.print("Ange ett heltal: ");
		String input = in.nextLine();
		
		for(int i = 0; i < input.length(); i ++) {
			String thisString = new String() + input.charAt(i);
			int thisInt = Integer.parseInt(thisString);
			if(thisInt == 0) {
				countZero ++;
			}
			else if(thisInt % 2 == 1) {
				countOdd ++;
			}
			else {
				countEven ++;
			}
		}
		
		System.out.println("Nollor: " + countZero);
		System.out.println("Udda siffror: " + countOdd);
		System.out.println("Jämna siffror: " + countEven);
		in.close();
	}
}
