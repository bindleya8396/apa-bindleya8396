import java.awt.Color;
import java.awt.Graphics;

public class DestroyableBlock extends Block {
	
	public DestroyableBlock() {
		super();
		setRandomColor();
	}

	public DestroyableBlock(int x, int y) {
		super(x, y);
		setRandomColor();
	}

	public DestroyableBlock(int x, int y, int w, int h) {
		super(x, y, w, h);
		setRandomColor();
	}

	public DestroyableBlock(int x, int y, int w, int h, Color col) {
		super(x, y, w, h, col);
	}
	
	private void setRandomColor() {
	    int r = (int)(Math.random()*255);
	    int g = (int)(Math.random()*255);
	    int b = (int)(Math.random()*255);
	    setColor(new Color(r,g,b));
	}
	
	public void clear(Graphics window) {
		draw(window, Color.WHITE);
	}
}