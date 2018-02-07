package ee222yb_lab3;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> cardsInDeck = new ArrayList<>();
	private ArrayList<Card> dealtCards = new ArrayList<>();
	
	private static final int CARDS_IN_DECK = 52;
	
	public Deck() {
		for(Card.Suit suit : Card.Suit.values()) {
			for(Card.Denomination denomination : Card.Denomination.values()) {
				Card thisCard = new Card(denomination, suit);
				cardsInDeck.add(thisCard);
			}
		}
	}
	
	public void shuffleDeck() throws IndexOutOfBoundsException {
		if(cardsInDeck.size() < CARDS_IN_DECK)
			throw new IndexOutOfBoundsException("Cannot shuffle. Deck incomplete");
		Collections.shuffle(cardsInDeck); // shuffles the array list
		
	}
	
	public Card dealCard() throws IndexOutOfBoundsException {
		if(cardsInDeck.size() == 0) 
			throw new IndexOutOfBoundsException("All cards dealt. Cannot deal any more");
		Card thisCard = cardsInDeck.get(0); // Selects the card from the top of the deck
		cardsInDeck.remove(0);
		dealtCards.add(thisCard);
		return thisCard;
	}
	
	public int getCardsLeft() {
		return cardsInDeck.size();
	}
	
	/**
	 * Lists dealt cards from the deck object
	 * @return string of dealt cards, separated by line break
	 */
	public String getDealtCards() {
		String listDealtCards = new String();
		if(dealtCards.size() == 0)
			listDealtCards = "None";
		for(Card card : dealtCards) {
			listDealtCards += card.getDenomination().toString().toLowerCase() + " of " + card.getSuit().toString().toLowerCase() + "\n";
		}
		return listDealtCards;
	}
	
	public void restoreDeck() {
		cardsInDeck.addAll(cardsInDeck.size(), dealtCards);
		dealtCards.clear();	
	}


}
