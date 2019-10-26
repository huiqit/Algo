// https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
public enum Suit {
  Club,
  Spade,
  Diamond,
  Heart //后面有内容比如constructor 这里就写分号，没内容就不加标点
}

public class Card {
  private final int faceValue;
  private final Suit suit;
  
  public Card(int v, Suit s) {
    faceValue = v;
    suit = s;
  }
  
  public void getValue() {
    return faceValue;
  }
  
  public void getSuit() {
    return suit;
  }
}

public class Deck {
  List<Card> deck = new ArrayList<>();
  private int dealtIndex = 0;
  
  public void shuffle() {
    
  }
  
  public Card[] dealHand(int num) {
    
  }
}

public class Hand {
  protected final List<Card> cards = new ArrayList<>();
  
  public int score() {
    int score = 0;
    for(Card card : cards) {
      score += card.value();
    }
    return score;
  }
  
  public void addCards(Card[] c) {
    Collections.addAll(cards, c);
  }
  
  public int size() {
    return cards.size();
  }
}


  
  
  

