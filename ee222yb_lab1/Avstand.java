package ee222yb_lab1;
import java.util.Scanner;

public class Avstand {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Ange första koordinaten på formen (x,y): ");
		String coord1 = in.nextLine();
		coord1 = coord1.replace("(", ""); // Removes potential parentheses from the variable
		coord1 = coord1.replace(")", "");
		coord1 = coord1.replace(" ", "");
		System.out.print("Ange andra koordinaten på formen (x,y): ");
		String coord2 = in.nextLine();
		coord2 = coord2.replace("(", "");
		coord2 = coord2.replace(")", "");
		coord2 = coord2.replace(" ", "");
		
		int commaIndex1 = coord1.indexOf(","); // Finds position of comma in coord1
		int commaIndex2 = coord2.indexOf(",");
		
		/* Separates all x's and y's into their own variables */
		String str_x1 = coord1.substring(0, commaIndex1);
		String str_x2 = coord2.substring(0, commaIndex2);
		String str_y1 = coord1.substring(commaIndex1 + 1);
		String str_y2 = coord2.substring(commaIndex2 + 1);
		/* And converts them to integers for calculations */
		int x1 = Integer.parseInt(str_x1); 
		int x2 = Integer.parseInt(str_x2);
		int y1 = Integer.parseInt(str_y1);
		int y2 = Integer.parseInt(str_y2);
		/* ******************************** */
		
		double xCalc = Math.pow(x1 - x2, 2);
		double yCalc = Math.pow(y1 - y2, 2);
		double distance = Math.sqrt(xCalc + yCalc);
		
		System.out.printf("Avståndet är: %.3f", distance);
		in.close();
	}
}
