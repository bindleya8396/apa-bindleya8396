//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
  private int xSpeed;
  private int ySpeed;

  public Ball()
  {
    super(200,200);
    xSpeed = 3;
    ySpeed = 1;
  }
  //add the other Ball constructors
  public Ball(int x, int y) {
     super(x, y);
     xSpeed = 3;
     ySpeed = 1;
   }
   public Ball(int x, int y, int w, int h) {
     super(x, y, w, h);
     xSpeed = 3;
     ySpeed = 1;
   }
   public Ball(int x, int y, int w, int h, Color col) {
     super(x, y, w, h, col);
     xSpeed = 3;
     ySpeed = 1;
   }
   public Ball(int x, int y, int w, int h, Color col, int xSpd) {
     super(x, y, w, h, col);
     xSpeed = xSpd;
     ySpeed = 1;
   }
   public Ball(int x, int y, int w, int h, Color col, int xSpd, int ySpd) {
     super(x, y, w, h, col);
     xSpeed = xSpd;
     ySpeed = ySpd;
   }        
     
  //add the set methods
  public void setXSpeed(int x) {
     xSpeed = x;
   }
   public void setYSpeed(int y) {
     ySpeed = y;
   }

  public void moveAndDraw(Graphics window)
  {
    //draw a white ball at old ball location
    draw(window, Color.WHITE);
    setX(getX() + xSpeed);
    //setY
    setY(getY() + ySpeed);
    //draw the ball at its new location
    draw(window);
  }
   
  public boolean equals(Object obj)
  {
     Ball boll = (Ball)obj;
     return xSpeed == boll.getXSpeed() && ySpeed == boll.getYSpeed();
  }   

  //add the get methods
  public int getXSpeed() {
	  return xSpeed;
  }
  public int getYSpeed() {
	  return ySpeed;
  }
   
  //add a toString() method
    public String toString() {
   	return super.toString() + " " + xSpeed + " " + ySpeed;
    }
}
