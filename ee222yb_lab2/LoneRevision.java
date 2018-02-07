package ee222yb_lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LoneRevision {
	
	public static void main(String[] args) {
		ArrayList<Integer> salaries = new ArrayList<>();
		int salarySum = 0;
		int medianSalary = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.print("Mata in loner, avsluta med 'X': ");
		while(in.hasNextInt()) {
			int thisInt = in.nextInt();
			salaries.add(thisInt);
			salarySum += salaries.get(salaries.size() - 1);
		}
		
		Collections.sort(salaries);
		
		// Different calculations of the median, depending on if the arraylist has an even or uneven amount of elements
		if(salaries.size() % 2 == 0) {
			int middleHighValue = salaries.get(salaries.size() / 2);
			int middleLowValue = salaries.get(salaries.size() / 2 - 1);
			medianSalary = (middleHighValue + middleLowValue) / 2; // Average of the two middle values. User inputs are unlikely uneven values, but in that case, int division results in a rounding error of .5 unit at most
		}
		else {
			medianSalary = salaries.get(salaries.size() / 2);
		}
		
		System.out.println("    Medianlon: " + medianSalary);
		int averageSalary = salarySum / salaries.size();
		System.out.println("     Medellon: " + averageSalary);
		int salarySpread = salaries.get(salaries.size() - 1) - salaries.get(0);
		System.out.println("Lonespridning: " + salarySpread);
		
		in.close();
	}

}
