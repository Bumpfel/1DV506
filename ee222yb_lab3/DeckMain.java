package ee222yb_lab3;

public class DeckMain {

	 public static void main(String[] args) {
		try {
			Deck deck = new Deck();
			
			deck.shuffleDeck();
			for(int i = 0; i < 5; i ++)
				deck.dealCard();

			System.out.println("There are " + deck.getCardsLeft() + " cards left in the deck.\n");
			System.out.println("Dealt cards:");
			
			System.out.println(deck.getDealtCards());

		}
		catch(IndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
			
		}
	}

}
