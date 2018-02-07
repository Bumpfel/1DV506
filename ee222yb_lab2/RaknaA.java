package ee222yb_lab2;
import java.util.Scanner;

public class RaknaA {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Skriv en rad text: ");
		String text = in.nextLine();
		
		int count_a = 0;
		int count_A = 0;
		for(int i = 0; i < text.length(); i ++) {
			char thisChar = text.charAt(i);
			if(thisChar == 'a') {
				count_a ++;
			}
			else if(thisChar == 'A') {
				count_A ++; 
			}
		}
		
		System.out.println("Antal a: " + count_a);
		System.out.print("Antal A: " + count_A);
		in.close();
	}

}
