
public enum Suit() {
  club,
  diamond,
  heart,
  spade
}
public class Card {
  private final int value;
  private final Suit suit;
  
  public Card(int value, Suit suit) {
    this.value = value;
    this.suit = suit;
  }
  public int getValue() {
    return value;
  }
  public int getSuit() {
    return suit;
  }
}
  
public class Deck {
  private final List<Card> cards = new ArrayList<>();
  private int dealtIndex = 0;
  
  public Deck() {
    for(int i = 1; i <= 13; i++) {
      for(Suit suit : Suit.values()) {
        cards.add(new Card(i, suit));
      }
    }
  }
  public void shuffle() {
  
  }
  private int remainingCards() {
    return cards.size() - dealtIndex;
  }
  public Card[] dealHead(int number) {
    //corner case check
    if(remainingCards() < number) {
      return null;
    }
    //return the cards that has been dealt
    Cards[] card = new Card[number];
    for(int i = 0; i < number; i++) {
      cards[i] = dealCard();
    }
    return cards;
  }
  private Card dealCard() {
    return remainingCards() == 0 ? null : cards.get(dealtIndex++);
  }
}
 
  
  
  
  
  
