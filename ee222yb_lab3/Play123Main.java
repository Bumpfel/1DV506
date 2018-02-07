package ee222yb_lab3;

public class Play123Main {

	public static void main(String[] args) {
		try {
			final int ATTEMPTS = 1000000;
			int successfulAttempts = 0;
			Deck deck = new Deck();
			
			for(int i = 0; i < ATTEMPTS; i ++) {
				deck.shuffleDeck();
				if(play123(deck))
					successfulAttempts ++;
				deck.restoreDeck();
			}
			System.out.println("Achieved a success rate of " + 100.0 * successfulAttempts / ATTEMPTS + "% in " + ATTEMPTS + " attempts.");
		}
		catch(IndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static boolean play123(Deck deck) {
		final int CARDS_IN_DECK = deck.getCardsLeft();
		
		int counter = 1; // The "spoken" value
		for(int i = 0; i < CARDS_IN_DECK; i ++) {
			Card.Denomination dealtCardDenomination = deck.dealCard().getDenomination();
			
			// If denomination enumerate index (+ 1) of the dealt card equals the counter - fail the solitaire
			if(dealtCardDenomination.ordinal() + 1 == counter)
				return false;
			if(counter == 3)
				counter = 1;
			else
				counter ++;
		}
		return true;
	}
}
