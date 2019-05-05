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

public class Bullets
{
  private List<Ammo> ammo;

  public Bullets()
  {
	  ammo = new ArrayList<Ammo>();
  }

  public void add(Ammo al)
  {
	  ammo.add(al);
  }

  //post - draw each Ammo
  public void drawEmAll( Graphics window )
  {
	  for(Ammo bullet : ammo) {
		  bullet.draw(window);
	  }
  }

  public void moveEmAll()
  {
	  for(Ammo bullet : ammo) {
		  bullet.move("UP");
	  }
  }

  public void cleanEmUp()
  {
	  for(int i = ammo.size() - 1; i >= 0; i--) {
		  Ammo bullet = ammo.get(i);
		  if(bullet.getY() <= 0) {
			  ammo.remove(bullet);
		  }
	  }
  }

  public List<Ammo> getList()
  {
    return ammo;
  }

  public int getSize() {
	  return ammo.size();
  }
  
  public String toString()
  {
    return "Number of bullets left: " + ammo.size();
  }
}
