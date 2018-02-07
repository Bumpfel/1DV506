package ee222yb_lab2;

public class TartLjus {

	public static void main(String[] args) {
		final int CANDLES_PER_BOX = 24;
		final int MAX_AGE = 100;
		int spareCandles = 0;
		int totalBoxesBought = 0;
		
		for(int birthday = 1; birthday <= MAX_AGE; birthday ++) {
			if(spareCandles < birthday) {
				int candlesNeeded = birthday - spareCandles;
				int boxesNeeded = (int) Math.ceil(1.0 * candlesNeeded / CANDLES_PER_BOX); // Round up to complete boxes
				System.out.println("Before birthday " + birthday + ", buy " + boxesNeeded + " box(es)");
				
				spareCandles = boxesNeeded * CANDLES_PER_BOX - candlesNeeded;
				totalBoxesBought += boxesNeeded;
			}
			else {
				spareCandles -= birthday;
			}
		}
		System.out.print("\nTotal number of boxes: " + totalBoxesBought + ", Remaining candles: " + spareCandles);
	}
}
