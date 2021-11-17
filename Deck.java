import java.util.List;
import java.util.ArrayList;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {

	/**
	 * cards contains all the cards in the deck.
	 */
   private ArrayList<Card> cards;

	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
   public Deck(String[] ranks, String[] suits, int[] values) 
	{
      cards = new ArrayList<Card>();
      for (int j = 0; j < ranks.length; j++) 
		    {
         for(String suitString : suits) 
            cards.add(new Card(ranks[j], suitString, values[j]));
           }
      shuffle();
   }
	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
   public boolean isEmpty() 
	{
		if(cards.size() == 0)
		return true;
	return false;	
		
   }

	//Shuffles deck
   public void shuffle() 
	{
    ArrayList <Card> shuffle = new ArrayList <Card>();
	while(cards.size() > 0)
	 {
		int r = (int)(Math.random()*cards.size());
		shuffle.add(cards.remove(r));
	 }	
	for(Card x: shuffle)
   cards.add(x); 
	//Creates new arraylist of Cards, and while the deck size is greater than zero,
	//And a random int is created that will not go over the size, and adds a random Card into shuffle
   }

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
   public Card deal() 
	{
   return cards.get(0);   
   }

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
   @Override
   public String toString() {
      int size = cards.size();
      
      String rtn = "size = " + size + "\nUndealt cards: \n";
   
      for (int k = size - 1; k >= 0; k--) {
         rtn = rtn + cards.get(k);
         if (k != 0) {
            rtn = rtn + ", ";
         }
         if ((size - k) % 2 == 0) {
         	// Insert carriage returns so entire deck is visible on console.
            rtn = rtn + "\n";
         }
      }
   
      rtn = rtn + "\n";
      return rtn;
   }
}