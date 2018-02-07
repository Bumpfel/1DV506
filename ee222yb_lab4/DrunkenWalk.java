package ee222yb_lab4;

import java.util.Scanner;

public class DrunkenWalk {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
			int totalFellInWater = 0;
			
			System.out.print("Ange storlek: ");
			int size = sc.nextInt();
			System.out.print("Ange max antal steg: ");
			int maxSteps = sc.nextInt();
			System.out.print("Ange antal slumpvandringar: ");
			int nrOfDrunkenWalks = sc.nextInt();
			
			/*int size = 0;
			int maxSteps = 1;
			int nrOfDrunkenWalks = 1;*/
			if(nrOfDrunkenWalks <= 0) 
				throw new IllegalArgumentException("No walks performed");
			
			for(int i = 0; i < nrOfDrunkenWalks; i ++) {
				RandomWalk drunkenWalk = new RandomWalk(maxSteps, size);
				
				drunkenWalk.walk();
				if(!drunkenWalk.inBounds())
					totalFellInWater++;
			}
			
			double calc = 100.0 * totalFellInWater / nrOfDrunkenWalks;
			System.out.format("Av %d onyktra personer, foll %d (%.2f%%) i vattnet.", nrOfDrunkenWalks, totalFellInWater, calc);
		}
		catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
}
