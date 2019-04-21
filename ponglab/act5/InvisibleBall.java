import java.awt.Color;
import java.awt.Graphics;

public class InvisibleBall extends Ball {

	private Color initialColor;

	public InvisibleBall() {
		super();
		initialColor = getColor();
	}

	public InvisibleBall(int x, int y) {
		super(x, y);
		initialColor = getColor();
	}

	public InvisibleBall(int x, int y, int w, int h) {
		super(x, y, w, h);
		initialColor = getColor();
	}

	public InvisibleBall(int x, int y, int w, int h, int xSpd, int ySpd) {
		super(x, y, w, h, xSpd, ySpd);
		initialColor = getColor();
	}

	public InvisibleBall(int x, int y, int w, int h, Color col, int xSpd, int ySpd) {
		super(x, y, w, h, col, xSpd, ySpd);
		initialColor = col;
	}

	private void turnInvisible() {
		int z = (int) (Math.random() * 100);
		if (z > 97) {
			if(getColor() == Color.white) {
				setColor(initialColor);
			} else {
				setColor(Color.white);
			}
		}
	}
	
	public void reset(Graphics window) {
		setColor(initialColor);
		super.reset(window);
	}

	public void moveAndDraw(Graphics window) {
		turnInvisible();
		super.moveAndDraw(window);
	}
}