//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
  public Robot()    //constructor method - sets up the class
  {
    setSize(800,600);
    setBackground(Color.WHITE);   	
    setVisible(true);
  }
  
  public void paint( Graphics window )
  {
    window.setColor(Color.BLUE);
    
    window.drawString("Robot LAB ", 35, 35 );
    
    //call head method
    head(window);
    //call other methods
    upperBody(window);
    lowerBody(window);
  }
  
  public void head( Graphics window )
  {
    window.setColor(Color.YELLOW);
    
    window.fillOval(300, 100, 200, 100);
    

    //add more code here
    window.setColor(Color.GREEN);
    window.fillOval(375, 175, 10, 10);
    window.fillOval(475, 175, 10, 10);

    window.setColor(Color.BLACK);
    window.fillOval(400, 150, 10, 10);

    window.setColor(Color.RED);
    window.drawArc(375, 150, 100, 75, 180, 0); 
  }

  public void upperBody( Graphics window )
  {

    //add more code here
    window.setColor(Color.BLACK);
    window.drawLine(200, 100, 300, -50);
    window.drawLine(500, -50, 600, 100);

    window.setColor(Color.BLUE);
    window.fillRect(300, -50, 200, 100);
  }

  public void lowerBody( Graphics window )
  {

    //add more code here
    window.setColor(Color.BLACK);
    window.drawLine(200, -450, 300, -300);
    window.drawLine(500, -300, 600, -450);

    window.setColor(Color.BLUE);
    window.fillRect(300, -200, 200, 100);
  }
}
