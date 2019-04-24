
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable<Block> {
	private int xSpeed;
	private int ySpeed;

	public Ball() {
		super(200, 200);
		xSpeed = 3;
		ySpeed = 1;
	}

	// add the other Ball constructors
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

	public Ball(int x, int y, int w, int h, int xSpd, int ySpd) {
		super(x, y, w, h);
		xSpeed = xSpd;
		ySpeed = ySpd;
	}

	public Ball(int x, int y, int w, int h, Color col, int xSpd, int ySpd) {
		super(x, y, w, h, col);
		xSpeed = xSpd;
		ySpeed = ySpd;
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

	public boolean equals(Object obj) {
		Ball boll = (Ball) obj;
		return xSpeed == boll.getXSpeed() && ySpeed == boll.getYSpeed();
	}

	public boolean didCollideLeft(Block b) {
		return (getX() - Math.abs(getXSpeed()) <= b.getX() + b.getWidth() && getX() + getWidth() >= b.getX() + b.getWidth())
				&& ((getY() >= b.getY() && getY() <= b.getY() + b.getHeight())
						|| (getY() + getHeight() >= b.getY() && getY() + getHeight() < b.getY() + b.getHeight()));
	}

	public boolean didCollideRight(Block b) {
		return (getX() + getWidth() + Math.abs(getXSpeed()) >= b.getX() && getX() <= b.getX())
				&& ((getY() >= b.getY() && getY() <= b.getY() + b.getHeight())
						|| (getY() + getHeight() >= b.getY() && getY() + getHeight() < b.getY() + b.getHeight()));
	}

	public boolean didCollideTop(Block b) {
		return (getY() - Math.abs(getYSpeed()) <= b.getY() + b.getHeight() && getY() + getHeight() >= b.getY() + b.getHeight())
				&& ((getX() >= b.getX() && getX() <= b.getX() + b.getWidth())
						|| (getX() + getWidth() >= b.getX() && getX() + getWidth() < b.getX() + b.getWidth()));
	}

	public boolean didCollideBottom(Block b) {
		return (getY() + getHeight() + Math.abs(getYSpeed()) >= b.getY() && getY() <= b.getY())
				&& ((getX() >= b.getX() && getX() <= b.getX() + b.getWidth())
						|| (getX() + getWidth() >= b.getX() && getX() + getWidth() < b.getX() + b.getWidth()));
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
