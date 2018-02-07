package ee222yb_lab2;
import java.util.Scanner;

public class StorstaK {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	
		System.out.print("Ange ett positivt heltal: ");
		int N = in.nextInt();
		
		if(N < 0) {
			System.out.print("Talet måste vara positivt.");
			System.exit(-1);
		}
		final int INCREMENT_K = 2;
		int total = 0;
		int K = 0;
		while(N > total + (K + INCREMENT_K)) { // Run loop as long as N is greater than total count so far + the next adder
			K += INCREMENT_K; // Increment K before adding, otherwise the display value K will not be the same as the value that was last added
			total += K;
		}
		
		System.out.print("Största tal K sådant att 0+2+4+6+...+K < " + N + " => K = " + K);
		in.close();
	}
}