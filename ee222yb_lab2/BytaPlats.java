package ee222yb_lab2;

public class BytaPlats {

	public static void main(String[] args) {
		char[] text = { '!', 't', 't', 'a', 'l', ' ', 'r', 'a', 'v', ' ', 'a', 't', 't', 'e', 'D' };
		
		for(char element : text) {
			System.out.print(element);
		}
		
		for(int a = 0; a < text.length / 2; a ++) { // When arrived at the middle of the array, we're done with the swaps
			int z = text.length - 1 - a; // Calculates the reversed position
			char buffer = text[a];
			text[a] = text[z];
			text[z] = buffer;
		}
		
		System.out.println();
		for(char element : text) {
			System.out.print(element);
		}
	}

}
