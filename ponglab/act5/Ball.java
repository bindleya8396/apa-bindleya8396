
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable<Block> {
	private int xSpeed;
	private int ySpeed;
	private int initialXSpeed;
	private int initialYSpeed;
	private int initialX;
	private int initialY;

	public Ball() {
		super(200, 200);
		initialX = 200;
		initialY = 200;
		initialXSpeed = xSpeed = 3;
		initialYSpeed = ySpeed = 1;
	}
	
	// add the other Ball constructors
	public Ball(int x, int y) {
		super(x, y);
		initialX = x;
		initialY = y;
		initialXSpeed = xSpeed = 3;
		initialYSpeed = ySpeed = 1;
	}

	public Ball(int x, int y, int w, int h) {
		super(x, y, w, h);
		initialX = x;
		initialY = y;
		initialXSpeed = xSpeed = 3;
		initialYSpeed = ySpeed = 1;
	}

	public Ball(int x, int y, int w, int h, Color col) {
		super(x, y, w, h, col);
		initialX = x;
		initialY = y;
		initialXSpeed = xSpeed = 3;
		initialYSpeed = ySpeed = 1;
	}

	public Ball(int x, int y, int w, int h, int xSpd, int ySpd) {
		super(x, y, w, h);
		initialX = x;
		initialY = y;
		initialXSpeed = xSpeed = xSpd;
		initialYSpeed = ySpeed = ySpd;
	}

	public Ball(int x, int y, int w, int h, Color col, int xSpd, int ySpd) {
		super(x, y, w, h, col);
		initialX = x;
		initialY = y;
		initialXSpeed = xSpeed = xSpd;
		initialYSpeed = ySpeed = ySpd;
	}

	// add the set methods
	public void setXSpeed(int x) {
		xSpeed = x;
	}

	public void setYSpeed(int y) {
		ySpeed = y;
	}

	public void moveAndDraw(Graphics window) {
		// draw a white ball at old ball location
		clear(window);
		setX(getX() + xSpeed);
		// setY
		setY(getY() + ySpeed);
		// draw the ball at its new location
		draw(window);
	}

	public void clear(Graphics window) {
		draw(window, Color.WHITE);
	}
	
	public void reset(Graphics window) {
		clear(window);
		setPos(initialX, initialY);
		setXSpeed(initialXSpeed);
		setYSpeed(initialYSpeed);		
	}

	public boolean equals(Object obj) {
		Ball boll = (Ball) obj;
		return xSpeed == boll.getXSpeed() && ySpeed == boll.getYSpeed();
	}

	public boolean didCollideLeft(Block b) {
		return (getX() <= b.getX() + b.getWidth() + Math.abs(getXSpeed())
				&& ((getY() >= b.getY() && getY() <= b.getY() + b.getHeight())
						|| (getY() + getHeight() >= b.getY() && getY() + getHeight() < b.getY() + b.getHeight())));
	}

	public boolean didCollideRight(Block b) {
		return (getX() + getWidth() >= b.getX() + Math.abs(getXSpeed())
				&& ((getY() >= b.getY() && getY() <= b.getY() + b.getHeight())
						|| (getY() + getHeight() >= b.getY() && getY() + getHeight() < b.getY() + b.getHeight())));
	}

	public boolean didCollideTop(Block b) {
		return (getY() <= b.getY() + b.getHeight() + Math.abs(getYSpeed())
				&& ((getX() >= b.getX() && getX() <= b.getX() + b.getWidth())
						|| (getX() + getWidth() >= b.getX() && getX() + getWidth() < b.getX() + b.getWidth())));
	}

	public boolean didCollideBottom(Block b) {
		return (getY() + getHeight() >= b.getY() + Math.abs(getYSpeed())
				&& ((getX() >= b.getX() && getX() <= b.getX() + b.getWidth())
						|| (getX() + getWidth() >= b.getX() && getX() + getWidth() < b.getX() + b.getWidth())));
	}

	// add the get methods
	public int getXSpeed() {
		return xSpeed;
	}

	public int getYSpeed() {
		return ySpeed;
	}

	// add a toString() method
	public String toString() {
		return super.toString() + " " + xSpeed + " " + ySpeed;
	}
}
