//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

public class BigHouse extends Canvas
{
   public BigHouse()  //constructor - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      //call bigHouse
   }

   public void bigHouse( Graphics window )
   {
      window.setColor(Color.BLUE);

      window.drawString( "BIG HOUSE ", 50, 50 );

      window.setColor(Color.BLUE);

      window.fillRect( 200, 200, 400, 400 );

	window.setColor(Color.YELLOW);
	window.fillRect(250, 250, 100, 100);
	window.fillRect(450, 250, 100, 100);

	window.setColor(Color.WHITE);
	window.fillRect(300, 200, 150, 200);

	window.setColor(Color.GREEN);
	window.fillRect(0, 600, 800, 100);

   }
}
