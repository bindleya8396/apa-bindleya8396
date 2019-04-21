
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
	private Wall rightWall;
	private Wall leftWall;
	private Wall topWall;
	private Wall bottomWall;
	private Score score;
	private boolean[] keys;
	private BufferedImage back;

	private int wallThickness = 15;
	private int padding = 20;
	private int paddleHeight = 100;
	private int paddleWidth = 20;

	private int ballStartX;
	private int ballStartY;
	
	public Pong(int w, int h) {
		// set up all variables related to the game
		ballStartX = w/2;
		ballStartY = h/2;
		ball = new InvisibleBall(ballStartX, ballStartY);
		leftPaddle = new Paddle(padding + wallThickness, h / 2 - paddleHeight / 2, paddleWidth, paddleHeight,
				Color.RED);
		leftPaddle.setBounds(padding + wallThickness, h - padding - wallThickness);
		rightPaddle = new Paddle(w - padding - wallThickness - paddleWidth, h / 2 - paddleHeight / 2, paddleWidth,
				paddleHeight, Color.BLUE);
		rightPaddle.setBounds(padding + wallThickness, h - padding - wallThickness);
		score = new Score();
		rightWall = new Wall(w - wallThickness - padding, padding, wallThickness, h - 2 * padding);
		leftWall = new Wall(padding, padding, wallThickness, h - 2 * padding);
		topWall = new Wall(padding, padding, w - 2 * padding, wallThickness);
		bottomWall = new Wall(padding, h - wallThickness - padding, w - 2 * padding, wallThickness);

		keys = new boolean[4];

		setBackground(Color.WHITE);
		setVisible(true);

		new Thread(this).start();
		addKeyListener(this); // starts the key thread to log key strokes
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		// set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D) window;

		// take a snap shot of the current screen and save it as an image
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
		rightWall.draw(graphToBack);
		leftWall.draw(graphToBack);
		topWall.draw(graphToBack);
		bottomWall.draw(graphToBack);

		// see if ball hits left wall or right wall
		if (ball.didCollideLeft(leftWall) || ball.didCollideRight(rightWall)) {
			score.clear(graphToBack);

			if (ball.didCollideLeft(leftWall)) {
				score.incrementRightScore();
			} else {
				score.incrementLeftScore();
			}
			ball.reset(graphToBack);
		}

		// see if the ball hits the top or bottom wall

		if (ball.didCollideTop(topWall) || ball.didCollideBottom(bottomWall)) {
			ball.setYSpeed(-ball.getYSpeed());
		}

		// see if the ball hits the left paddle
		if (ball.didCollideLeft(leftPaddle)) {
			if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() - Math.abs(ball.getXSpeed())) {
				ball.setYSpeed(-ball.getYSpeed());
			} else {
				ball.setXSpeed(-ball.getXSpeed());
			}
		}

		// see if the ball hits the right paddle
		if (ball.didCollideRight(rightPaddle)) {
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