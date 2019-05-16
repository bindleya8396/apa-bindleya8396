//Name -
//Date -
//Class -
//Lab  - 


public abstract class Card
{
  public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
                                        "FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

  private String suit;
  private int face;

  //constructors
  public Card() {
	  this(0, " ");
  }

  public Card(int f, String s) {
	  face = f;
	  suit = s;
  }
  // modifiers
  public void setSuit(String s) {
	  suit = s;
  }

  public void setFace(int f) {
	  face = f;
  }

  //accessors
  public String getSuit() {
	  return suit;
  }

  public int getFace() {
	  return face;
  }

  public abstract int getValue();

  public boolean equals(Object obj)
  {
	Card card = (Card)obj;
	if(card.getSuit() == getSuit() && card.getFace() == getFace()) {
		return true;
	}
    return false;
  }

  //toString
  public String toString() {
        return "Suit: " + getSuit() + " Face: " + getFace();
  }
}