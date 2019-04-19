//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
  //instance variables
  private int speed;

  public Paddle()
  {
    super(10,10);
    speed =5;
  }


  //add the other Paddle constructors
   public Paddle(int x, int y) {
     super(x, y);
     speed = 5;
   }
   public Paddle(int x, int y, int spd) {
     super(x, y);
     speed = spd;
   }
   public Paddle(int x, int y, int w, int h) {
     super(x, y, w, h);
     speed = 5;
   }
   public Paddle(int x, int y, int w, int h, int spd) {
     super(x, y, w, h);
     speed = spd;
   }   
   public Paddle(int x, int y, int w, int h, Color col) {
     super(x, y, w, h, col);
     speed = 5;
   }
   public Paddle(int x, int y, int w, int h, Color col, int spd) {
     super(x, y, w, h, col);
     speed = spd;
   }
   
   //set method
   public void setSpeed(int s)
   {
     speed = s; 
   }

  public void moveUpAndDraw(Graphics window)
  {
      setY(getY() + speed);
      draw(window);
  }

  public void moveDownAndDraw(Graphics window)
  {
      setY(getY() - speed);
      draw(window);
  }

  //add get methods
  public int getSpeed() {
     return speed;
   }
   
  //add a toString() method
  public String toString() {
     return super.toString() + " " + speed;
   }
}
