
public enum Suit {
  Club,
  Diamond,
  Heart,
  Spade
}

public class Card {
  private final faceValue;
  private final Suit suit;
  public Card(int c, Suit s) {
    suit = s;
    faceValue = c;
  }
  public int getValue() {
    return faceValue;
  }
  public Suit getSuit() {
    return suit;
  }
}

public class Deck {
  private static final Random random = new Random();
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
  
  private int remaininCards() {
    return cards.size()-dealtIndex;
  }
  
  public Card[] dealHand(int number) {
    if(remainingCards() < number) {
      return null;
    }
    Card[] cards = new Card[number];
    for(int i = 0; i < number; i++) {
      cards[i] = dealCard();
    }
    return cards;
  }
  
  public Card dealCard() {
    return remainingCards() == 0 ? null : cards.get(dealtIndex++);
  }
}

public class Hand {
  
    
    
    
    
    
    
    
    
    
    
    
    
  
