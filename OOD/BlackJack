/* 
先对游戏道具进行描述:
1. define the class & their relationship
1）一张牌 card:
  花色 suit
  面值/牌面 value
2）一副牌 deck of cards:
  List<card>
2. functionalities
card
  - value()
  - suit()
deck 
  - shuffle() 洗牌
  - dealHead() 发牌
*/
/*
注意：
class 大写开头（convention)，constructor配套的也大写
*/
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
 
  
  
  
  
  

