package ee222yb_lab3;

import java.util.Scanner;

public class Pnr {
	
	public static void main(String[] args) {
		// For the testers!
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a personal code (YYMMDD-NNNN): ");
		String pNr = input.nextLine();
		
		System.out.println();
		System.out.println("             First part: " + getFirstPart(pNr));
		System.out.println("            Second part: " + getSecondPart(pNr));
		System.out.println("                 Female: " + isFemaleNumber(pNr));
		System.out.println("                   Male: " + isMaleNumber(pNr));
		System.out.println("Personnumret är korrekt: " + isCorrect(pNr));
		
		System.out.println();
		System.out.print("Enter another personal code(YYMMDD-NNNN): ");
		String pNr2 = input.nextLine();
		
		System.out.println("   The inputs are equal: " + areEqual(pNr, pNr2));
		
		input.close();
	}
	
	/**
	 * A method that returns the first part of a personal code
	 * @param pCode - Personal code
	 * @return string, as to not cut any initial zeros
	 */
	public static String getFirstPart(String pCode) {
		return pCodePart(pCode, 0, 6);
	}
	
	/**
	 * A method that returns the second part of a personal code
	 * @param pCode - Personal code
	 * @return string, as to not cut any initial zeros
	 */
	public static String getSecondPart(String pCode) {
		return pCodePart(pCode, pCode.length() - 4, pCode.length());
	}
	
	/**
	 * 
	 * @param pCode - Personal code
	 * @param startPos - Start position of the cut-out
	 * @param endPos - End position of cut-out
	 * @return Requested code part if format is correct (the length is 11, the cut-out is a number, and there's a dash at position 6). Null otherwise
	 */
	private static String pCodePart(String pCode, int startPos, int endPos) {
		if(pCode.length() != 11)
			return null;
		String codePart = pCode.substring(startPos, endPos); // Cuts out desired part
		if(isInt(codePart) && pCode.charAt(6) == '-')
			return codePart;
		else
			return null;
	}
	
	/**
	 * Determines if a string is an integer
	 * @param str - String to be checked
	 * @return Boolean
	 */
	private static boolean isInt(String str) {
		try {
			int number = Integer.parseInt(str);
			if(number > 0)
				return true;
		}
		catch (NumberFormatException ex) {
			return false;
		}
		return false;
	}
	
	/**
	 * Checks if the personal code points to a female (if the second last number in the personal code is even)
	 * @param pCode - Personal code
	 * @return Boolean
	 */
	public static boolean isFemaleNumber(String pCode) {
		int gender = getGender(pCode);
		return gender % 2 == 0;
	}
	
	/**
	 * Checks if the personal code points to a male (if the second last number in the personal code is uneven)
	 * @param pCode - Personal code
	 * @return Boolean
	 */
	public static boolean isMaleNumber(String pCode) {
		int gender = getGender(pCode);
		return gender % 2 == 1;
	}
	
	private static int getGender(String pCode) {
		String genderStr = pCodePart(pCode, pCode.length() - 2, pCode.length() - 1);
		if(genderStr == null)
			return -1;
		int gender = Integer.parseInt(genderStr);
		return gender;
	}
	
	/**
	 * Determines if two strings are equal
	 * @param str1 - First string
	 * @param str2 - Second string
	 * @return Boolean
	 */
	public static boolean areEqual(String str1, String str2) {
		return str1.equals(str2);
	}
	
	/**
	 * 
	 * @param dateStr - date in string format
	 * @return Boolean
	 */
	private static boolean isValidDate(String dateStr) {
		int date = Integer.parseInt(dateStr);
		int year = date / 10000;
		int month = date / 100 % 100;
		int day = date % 100;
		
		// Note: not checking for negative values; they will fail checks before this method is called, and it's a private method I only use for one purpose
		// only made it a separate method to reduce code height in the isCorrect method
		if(month == 2) {
			if(day <= 28)
				return true;
			else if(day == 29 && year % 4 == 0) // 29 days is okay in February for leap years
				return true;
		}
		else if(month <= 12) {
			if(day <= 30) // 30 days or fewer is okay for any month other than February
				return true;
			else if(day == 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12))
				return true;
		}
		return false;
	}
	
	/**
	 * Checks a personal code for correct date and correct control number
	 * @param pCode - Personal code number
	 * @return Boolean
	 */
	public static boolean isCorrect(String pCode) {
		String firstPart = getFirstPart(pCode);
		String secondPart = getSecondPart(pCode);

		if(firstPart != null && secondPart != null && isValidDate(firstPart)) { // Checks if input format and date is correct
			int date = Integer.parseInt(firstPart);
			int lastFour = Integer.parseInt(secondPart);
			int birthNr = lastFour / 10; // the capitals in yymmddd-NNNn
			int controlNr = lastFour % 10; // the capital in yymmdd-nnnN
			String calcString = new String() + date + birthNr; // Makes a string of the date and birth number from the personal code (YYMMDDNNN)
			int sumOfNumbers = 0;
			
			for(int i = 0; i < calcString.length(); i ++) {
				char thisChar = calcString.charAt(i);
				int thisNr = Character.getNumericValue(thisChar);
				int multiplier = (i + 1) % 2 + 1; // Starts at 2, then alternates between 1 and 2
				int newNr = thisNr * multiplier;
				int tensDigit = newNr / 10; // Potential tens digit (tiotal) of the new number
				int onesDigit = newNr % 10;
				sumOfNumbers += tensDigit + onesDigit;
			}

			// The sum of the earlier calculation and the control number should be evenly divisible by 10 in order to make a correct personal code
			if((sumOfNumbers + controlNr) % 10 == 0)
				return true;
		}
		return false;
	}

}
