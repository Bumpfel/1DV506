package ee222yb_lab3;

public class Card {
	private Denomination denomination;
	private Suit suit;
	
	public static enum Suit { SPADES, HEARTS, DIAMONDS, CLUBS }
	public static enum Denomination { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }

	public Card(Denomination d, Suit s) {
		denomination = d;
		suit = s;
	}
	
	public Denomination getDenomination() {
		return denomination;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
}
