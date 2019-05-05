//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
  private List<Alien> aliens;
  private int columns = 10;
  private boolean hitLeft;
  private boolean hitRight;
  
  public AlienHorde(int size)
  {
	  aliens = new ArrayList<Alien>();
	  for(int i = 0; i < Math.ceil((double)size/columns); i++) {
		  for(int j = 0; j < columns; j++) {
			  add(new Alien((j * 80) + 20, (i * 50) + 40, 1));
			  if(aliens.size() >= size) {
				  break;
			  }
		  }
	  }
	  hitLeft = false;
	  hitRight = true;
  }

  public void add(Alien al)
  {
	  aliens.add(al);
  }

  public void drawEmAll( Graphics window )
  {
	  for(Alien alien : aliens) {
		  alien.draw(window);
	  }
  }

  public void moveEmAll()
  {
	  for(Alien alien : aliens) {
		  if(hitRight) {
			  alien.move("LEFT");
			  if(alien.getX() - alien.getSpeed() <= 0) {
				  hitRight = false;
				  hitLeft = true;
				  alien.move("RIGHT");
			  }
		  }
		  if(hitLeft) {
			  alien.move("RIGHT");
			  if(alien.getX() + alien.getWidth() + alien.getSpeed() >= 800) {
				  hitLeft = false;
				  hitRight = true;
				  alien.move("LEFT");
			  }
		  }
	  }
  }

  public void removeDeadOnes(List<Ammo> shots)
  {
	  for(int i = aliens.size() - 1; i >= 0; i--) {
		  Alien alien = aliens.get(i);
		  for(int j = shots.size() - 1; j >= 0; j--) {
			  Ammo shot = shots.get(j);
			    if(shot.getY() <= alien.getY() + alien.getHeight() && 
			    		shot.getY() + shot.getHeight() >= alien.getY() && 
			    		shot.getX() <= alien.getX() + alien.getWidth() && 
			    		shot.getX() + shot.getWidth() >= alien.getX())
			    {
			    	aliens.remove(alien);
			    	shots.remove(shot);
			    }
		  }
	  }
  }

  public String toString()
  {
	return "Number of aliens left: " + aliens.size();
  }
}
