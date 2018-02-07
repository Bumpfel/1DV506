package ee222yb_lab1;
import java.util.Scanner;

public class Vaxelpengar {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print(" Kostnad (kr): ");
		double itemCost = in.nextDouble();
		itemCost = Math.round(itemCost);
		
		System.out.print(" Erhållet belopp (kr): ");
		double moneyReceived = in.nextDouble();
		
		int change = (int) Math.floor(moneyReceived - itemCost); // Converts to int to remove decimals
		int difference = change; // A variable for calculations
		
		int bill1000 = difference / 1000; // # 1000kr-bills (Didn't use constants here, because if the denominations would change, you'd have to replace a lot of the code/text anyway)
		difference = difference % 1000; // Removes the 1000kr-bills from the calculation variable
		int bill500 = difference / 500;
		difference = difference % 500;
		int bill100 = difference / 100;
		difference = difference % 100;
		int bill50 = difference / 50;
		difference = difference % 50;
		int bill20 = difference / 20;
		difference = difference % 20;
		int coin10 = difference / 10;
		difference = difference % 10;
		int coin5 = difference / 5;
		difference = difference % 5;
		int coin1 = difference;
		
		System.out.println(
		"\n Pengar tillbaka: " + change + " kr" +
		"\n     Tusenlappar: " + bill1000 +
		"\n Femhundralappar: " + bill500 +
		"\n    Hundralappar: " + bill100 +
		"\n    Femtiolappar: " + bill50 +
		"\n     Tjugolappar: " + bill20 +
		"\n  Tiokronorsmynt: " + coin10 +
		"\n  Femkronorsmynt: " + coin5 +
		"\n   Enkronorsmynt: " + coin1);
		in.close();
	}
}
