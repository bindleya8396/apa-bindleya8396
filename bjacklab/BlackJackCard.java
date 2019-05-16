//Name -
//Date -
//Class -
//Lab  - 

public class BlackJackCard extends Card
{
  //constructors
	public BlackJackCard() {
		super();
	}

	public BlackJackCard(int f, String s) {
		super(f,s);
	}

  public int getValue()
  {
    if(FACES[getFace()] == "ACE") {
    	return 11;
    } else if(FACES[getFace()] == "JACK" || FACES[getFace()] == "QUEEN" || FACES[getFace()] == "KING") {
    	return 10;
    } else {
    	return getFace();
    }
  }
  
  public String toString() {
	  return FACES[getFace()] + " of " + getSuit() + " | value = " + getValue();  
  }
}