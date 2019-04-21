
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block {
	// instance variables
	private int speed;
	private int topBound;
	private int bottomBound;

	public Paddle() {
		super(10, 10);
		speed = 5;
		topBound = 0;
		bottomBound = 0;
	}

	// add the other Paddle constructors
	public Paddle(int x, int y) {
		super(x, y);
		speed = 5;
		topBound = 0;
		bottomBound = 0;
	}

	public Paddle(int x, int y, int spd) {
		super(x, y);
		speed = spd;
		topBound = 0;
		bottomBound = 0;
	}

	public Paddle(int x, int y, int w, int h) {
		super(x, y, w, h);
		speed = 5;
		topBound = 0;
		bottomBound = 0;
	}

	public Paddle(int x, int y, int w, int h, int spd) {
		super(x, y, w, h);
		speed = spd;
		topBound = 0;
		bottomBound = 0;
	}

	public Paddle(int x, int y, int w, int h, Color col) {
		super(x, y, w, h, col);
		speed = 5;
		topBound = 0;
		bottomBound = 0;
	}

	public Paddle(int x, int y, int w, int h, Color col, int spd) {
		super(x, y, w, h, col);
		speed = spd;
		topBound = 0;
		bottomBound = 0;
	}

	// set method
	public void setSpeed(int s) {
		speed = s;
	}

	public void setBounds(int t, int b) {
		topBound = t;
		bottomBound = b;
	}
	
	public void moveUpAndDraw(Graphics window) {
		draw(window, Color.WHITE);
		if (getY() < topBound) {
			setY(topBound);
		} else {
			setY(getY() - speed);
		}
		draw(window);
	}

	public void moveDownAndDraw(Graphics window) {
		draw(window, Color.WHITE);
		if (getY() > bottomBound - getHeight()) {
			setY(bottomBound - getHeight());
		} else {
			setY(getY() + speed);
		}
		draw(window);
	}

	// add get methods
	public int getSpeed() {
		return speed;
	}

	// add a toString() method
	public String toString() {
		return super.toString() + " " + speed;
	}
}
