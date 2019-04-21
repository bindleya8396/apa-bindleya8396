
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.lang.*;

public class Pong extends Canvas implements KeyListener, Runnable {
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	//private Wall rightWall;
	//private Wall leftWall;
	//private Wall topWall;
	//private Wall bottomWall;
	private Score score;
	private boolean[] keys;
	private BufferedImage back;

	public Pong() {
		// set up all variables related to the game
		ball = new Ball();
		ball.setPos(500, 10);
		ball.setXSpeed(-3);
		leftPaddle = new Paddle(50, 200, 20, 100, Color.RED);
		rightPaddle = new Paddle(730, 200, 20, 100, Color.BLUE);
		score = new Score();
		//rightWall = new Wall(0, 5, 5, 595);
		//leftWall = new Wall(800, 5, 5, 595);
		//topWall = new Wall(0, 0, 800, 5);
		//bottomWall = new Wall(0, 600, 800, 5);
		
		keys = new boolean[4];

		setBackground(Color.WHITE);
		setVisible(true);

		new Thread(this).start();
		addKeyListener(this); // starts the key thread to log key strokes
	}
	
	
	/*	public Pong(int w, int h) {
		// set up all variables related to the game
		ball = new Ball();
		ball.setPos(500, 10);
		ball.setXSpeed(-3);
		leftPaddle = new Paddle(50, 200, 20, 100, Color.RED);
		rightPaddle = new Paddle(730, 200, 20, 100, Color.BLUE);
		score = new Score();
		//rightWall = new Wall(0, 5, 5, h-5);
		//leftWall = new Wall(w, 5, 5, h-5);
		//topWall = new Wall(0, 0, w, 5);
		//bottomWall = new Wall(0, h, w, 5);
		
		keys = new boolean[4];

		setBackground(Color.WHITE);
		setVisible(true);

		new Thread(this).start();
		addKeyListener(this); // starts the key thread to log key strokes
	} */

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		// set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D) window;

		// take a snap shop of the current screen and same it as an image
		// that is the exact same width and height as the current screen
		if (back == null)
			back = (BufferedImage) (createImage(getWidth(), getHeight()));

		// create a graphics reference to the back ground image
		// we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		score.draw(graphToBack);
		// rightWall.draw(graphToBack);
		// leftWall.draw(graphToBack);
		// topWall.draw(graphToBack);
		// bottomWall.draw(graphToBack);
		
		// see if ball hits left wall or right wall
		
		// if (!(ball.didCollideLeft(leftWall) && ball.didCollideRight(rightWall)))
		if (!(ball.getX() >= 10 && ball.getX() <= 780)) {
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			score.clear(graphToBack);
			
			// if (ball.didCollideLeft(leftWall))
			if (ball.getX() < 10) {
				score.incrementRightScore();
			} else {
				score.incrementLeftScore();
			}
			ball.clear(graphToBack);
			ball.setPos(200, 200);
			ball.setXSpeed(3);
			ball.setYSpeed(1);
		}

		// see if the ball hits the top or bottom wall
		
		// if (ball.didCollideTop(topWall) || ball.didCollideBottom(bottomWall))
		if (!(ball.getY() >= 10 && ball.getY() <= 580)) {
			ball.setYSpeed(-ball.getYSpeed());
		}

		// see if the ball hits the left paddle
		if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() + Math.abs(ball.getXSpeed())
				&& ((ball.getY() >= leftPaddle.getY() && ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight())
						|| (ball.getY() + ball.getHeight() >= leftPaddle.getY()
								&& ball.getY() + ball.getHeight() < leftPaddle.getY() + leftPaddle.getHeight()))) {
			if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() - Math.abs(ball.getXSpeed())) {
				ball.setYSpeed(-ball.getYSpeed());
			} else {
				ball.setXSpeed(-ball.getXSpeed());
			}
		}

		// see if the ball hits the right paddle
		if (ball.getX() + ball.getWidth() >= rightPaddle.getX() + Math.abs(ball.getXSpeed())
				&& ((ball.getY() >= rightPaddle.getY() && ball.getY() <= rightPaddle.getY() + rightPaddle.getHeight())
						|| (ball.getY() + ball.getHeight() >= rightPaddle.getY()
								&& ball.getY() + ball.getHeight() < rightPaddle.getY() + rightPaddle.getHeight()))) {
			if (ball.getX() + ball.getWidth() >= rightPaddle.getX() + Math.abs(ball.getXSpeed())) {
				ball.setXSpeed(-ball.getXSpeed());
			} else {
				ball.setYSpeed(-ball.getYSpeed());
			}
		}

		// see if the paddles need to be moved
		if (keys[0]) {
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if (keys[1]) {
			leftPaddle.moveDownAndDraw(graphToBack);
		}
		if (keys[2]) {
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if (keys[3]) {
			rightPaddle.moveDownAndDraw(graphToBack);
		}

		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = true;
			break;
		case 'Z':
			keys[1] = true;
			break;
		case 'I':
			keys[2] = true;
			break;
		case 'M':
			keys[3] = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = false;
			break;
		case 'Z':
			keys[1] = false;
			break;
		case 'I':
			keys[2] = false;
			break;
		case 'M':
			keys[3] = false;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(8);
				repaint();
			}
		} catch (Exception e) {
		}
	}
}