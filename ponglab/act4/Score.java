import java.awt.Color;
import java.awt.Graphics;

public class Score {
	
	private int rightScore;
	private int leftScore;
	private Color color;
	
	public Score() {
		rightScore = 0;
		leftScore = 0;
		color = Color.red;
	}
	
	public void incrementRightScore() {
		rightScore++;
	}
	
	public void incrementLeftScore() {
		leftScore++;
	}
	
	public void clear(Graphics window) {
		var c = window.getColor();
		window.setColor(Color.white);
		window.drawString(toString(),400,10);
		window.setColor(c);
	}
	
	public void draw(Graphics window) {
		var c = window.getColor();
		window.setColor(color);
		window.drawString(toString(), 400, 10);
		window.setColor(c);
	}
	
	public String toString() {
		return "Right Score = " + rightScore + " | Left Score = " + leftScore;
	}
}