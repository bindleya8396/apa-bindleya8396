
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball {

	// instance variables

	public SpeedUpBall() {
		super();
	}

	public SpeedUpBall(int x, int y) {
		super(x, y);
	}

	public SpeedUpBall(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public SpeedUpBall(int x, int y, int w, int h, int xSpd, int ySpd) {
		super(x, y, w, h, xSpd, ySpd);
	}

	public SpeedUpBall(int x, int y, int w, int h, Color col, int xSpd, int ySpd) {
		super(x, y, w, h, col, xSpd, ySpd);
	}

	private void speedUp() {
		if (getXSpeed() > 0 && Math.abs(getXSpeed()) < 6) {
			setXSpeed(getXSpeed() + 1);
		} else {
			setXSpeed(getXSpeed() - 1);
		}

		if (getYSpeed() > 0 && Math.abs(getYSpeed()) < 6) {
			setYSpeed(getYSpeed() + 1);
		} else {
			setYSpeed(getYSpeed() - 1);
		}
	}

	public boolean didCollideLeft(Block b) {
		boolean collided = super.didCollideLeft(b);
		if (collided) {
			speedUp();
		}
		return collided;
	}

	public boolean didCollideRight(Block b) {
		boolean collided = super.didCollideRight(b);
		if (collided) {
			speedUp();
		}
		return collided;
	}

	public boolean didCollideTop(Block b) {
		boolean collided = super.didCollideTop(b);
		if (collided) {
			speedUp();
		}
		return collided;
	}

	public boolean didCollideBottom(Block b) {
		boolean collided = super.didCollideBottom(b);
		if (collided) {
			speedUp();
		}
		return collided;
	}
}
