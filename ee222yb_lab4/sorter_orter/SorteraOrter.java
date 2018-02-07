package ee222yb_lab4.sorter_orter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SorteraOrter {

	public static void main(String[] args) {
		try {
			String filePath = "src\\ee222yb_lab4\\sorter_orter\\orter.dat";
			File file = new File(filePath);
			Scanner fileScanner = new Scanner(file);
		
			System.out.println("Laser orter fran filen: " + filePath);
			ArrayList<Ort> orter = new ArrayList<>();
			
			int lineCounter = 0;
			while(fileScanner.hasNextLine()) {
				lineCounter ++;
				String line = fileScanner.nextLine().trim();
				Scanner lineScan = new Scanner(line);
				
				lineScan.useDelimiter(";");
				String city = lineScan.next();
				if(!lineScan.hasNextInt()) {
					lineScan.close();
					throw new InputMismatchException("Cannot read zip code on line " + lineCounter + ". The file input lines must be in the format: city;zip_code");
				}
				int zip = lineScan.nextInt();
				lineScan.close();
				
				Ort currentOrt = new Ort(city, zip);
				orter.add(currentOrt);
			}
			Collections.sort(orter);

			System.out.println("Antal funna orter: " + orter.size());
			for(Ort ort : orter) {
				System.out.println(ort);
			}

			fileScanner.close();
		}
		catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
		catch(InputMismatchException ex) {
			System.out.println(ex.getMessage());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
