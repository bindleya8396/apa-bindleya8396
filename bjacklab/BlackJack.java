//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack extends BlackJackCard
{
  //add in Player instance variable
	private Player player;
  //add in Dealer instance variable
	private Dealer dealer;

  public BlackJack()
  {
	player = new Player();
	dealer = new Dealer();
  }

  public void playGame()
  {
	  Scanner reader = new Scanner(System.in);
	  System.out.println("Do you want to play again? [Y/N]");
	  char answer = reader.next().charAt(0);
	  
	  dealer.shuffle();
	  
	  do {
		  
	    player.addCardToHand(dealer.deal());
	    player.addCardToHand(dealer.deal());
	    dealer.addCardToHand(dealer.deal());
	    dealer.addCardToHand(dealer.deal());
	    
	    int playerTotal = player.getHandValue();
	    int dealerTotal = dealer.getHandValue();
	    
	    out.println("Current " + player.toString());
	    
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Do you want to hit? [Y/N] ");
        char choice = keyboard.next().charAt(0);
	    while(playerTotal < 21 && choice == 'Y') {
	    	player.addCardToHand(dealer.deal());
		    out.println("\nPLAYER ");
		    out.println("Hand Value :: " + playerTotal );
		    out.println("Hand Size :: " + player.getHandSize() );
		    out.println("Cards in Hand :: " + player.toString() );
	    }
	    out.println("\nDEALER ");
	    out.println("Hand Value :: " + dealerTotal );
	    out.println("Hand Size :: " + dealer.getHandSize() );
	    out.println("Cards in Hand :: " + dealer.toString() );
	    
	    if(playerTotal>21&&dealerTotal<=21)
	    {
	      out.println("\nDealer wins - Player busted!");
	      dealer.setWinCount(dealer.getWinCount()+1);
	    }
	    else if(playerTotal<=21&&dealerTotal>21)
	    {
	      out.println("\nPlayer wins - Dealer busted!");
	      player.setWinCount(dealer.getWinCount()+1);
	    }
	    else if(playerTotal>21&&dealerTotal>21){
	      out.println("Both players bust!");
	    }
	    else if(playerTotal<dealerTotal){
	      out.println("\nDealer has bigger hand value!");
	      dealer.setWinCount(dealer.getWinCount()+1);
	    }
	    else{
	      out.println("\nPlayer has bigger hand value!");
	      player.setWinCount(dealer.getWinCount()+1);
	    }  
	    
	  } while (answer == 'Y');

  }
        
  
  public static void main(String[] args)
  {
    BlackJack game = new BlackJack();
    game.playGame();
  }
}