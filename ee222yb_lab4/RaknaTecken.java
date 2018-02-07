package ee222yb_lab4;

import java.io.File;
import java.util.Scanner;

public class RaknaTecken {

	public static void main(String[] args) {
		try {
			String filePath = "src\\ee222yb_lab4\\HistoryOfProgramming.txt";
			File file = new File(filePath);
			Scanner input = new Scanner(file);
			input.useDelimiter("");
			
			int countUC = 0, countLC = 0, countNums = 0, countWS = 0, countOthers = 0;
			
			while(input.hasNext()) {
				char thisChar = input.next().charAt(0);
				if(Character.isUpperCase(thisChar))
					countUC ++;
				else if(Character.isLowerCase(thisChar))
					countLC ++;
				else if(Character.isDigit(thisChar))
					countNums ++;
				else if(Character.isWhitespace(thisChar))
					countWS ++;
				else
					countOthers ++;
			}
			
			System.out.println("Antal stora bokstaver: " + countUC);
			System.out.println("Antal sma bokstaver: " + countLC);
			System.out.println("Antal siffror: " + countNums);
			System.out.println("Antal \"whitespaces\": " + countWS);
			System.out.println("Antal ovriga: " + countOthers);
			
			input.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
