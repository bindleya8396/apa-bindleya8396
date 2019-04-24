
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.lang.*;
import java.util.ArrayList;

public class BreakOut extends Canvas implements KeyListener, Runnable {
	private Ball ball;
	private Paddle paddle;
	private Wall rightWall;
	private Wall leftWall;
	private Wall topWall;
	private Wall bottomWall;
	private boolean[] keys;
	private BufferedImage back;

	private ArrayList<DestroyableBlock> blocks;

	private int wallThickness = 15;
	private int padding = 20;
	private int paddleHeight = 20;
	private int paddleWidth = 100;

	private int blockHeight = 20;
	private int blockWidth = 50;

	private int blockRows = 10;
	private int blockColumns = 12;

	private int blockXOffset = 100;
	private int blockYOffset = 100;

	private int width;
	private int height;
	private int startingX;
	private int startingY;

	public BreakOut(int w, int h) {
		// set up all variables related to the game
		width = w;
		height = h;

		startingX = width / 2;
		startingY = blockYOffset + blockRows * blockHeight + 10;

		ball = new Ball(startingX, startingY);
		ball.setXSpeed(3);
		paddle = new Paddle(w / 2 - paddleWidth / 2, h - padding - wallThickness - paddleHeight, paddleWidth,
				paddleHeight, Color.gray);
		paddle.setBounds(0, 0, padding + wallThickness, w - padding - wallThickness);
		rightWall = new Wall(w - wallThickness - padding, padding, wallThickness, h - 2 * padding);
		leftWall = new Wall(padding, padding, wallThickness, h - 2 * padding);
		topWall = new Wall(padding, padding, w - 2 * padding, wallThickness);
		bottomWall = new Wall(padding, h - wallThickness - padding, w - 2 * padding, wallThickness);

		blocks = new ArrayList<DestroyableBlock>();
		for (int i = 0; i < blockRows; i++) {
			for (int j = 0; j < blockColumns; j++) {
				blocks.add(new DestroyableBlock(blockXOffset + j * blockWidth, blockYOffset + i * blockHeight,
						blockWidth, blockHeight));
			}
		}

		keys = new boolean[2];

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
		paddle.draw(graphToBack);
		rightWall.draw(graphToBack);
		leftWall.draw(graphToBack);
		topWall.draw(graphToBack);
		bottomWall.draw(graphToBack);
		for (DestroyableBlock db : blocks) {
			db.draw(graphToBack);
		}

		// see if ball hits bottom wall

		if (ball.didCollideBottom(bottomWall)) {
			ball.clear(graphToBack);
			ball.setPos(startingX, startingY);
			ball.setXSpeed(3);
			ball.setYSpeed(1);
		}

		// see if the ball hits the left or right wall

		if (ball.didCollideLeft(leftWall) || ball.didCollideRight(rightWall)) {
			ball.setXSpeed(-ball.getXSpeed());
		}

		if (ball.didCollideTop(topWall)) {
			ball.setYSpeed(-ball.getYSpeed());
		}

		// see if the ball hits the paddle
		if (ball.didCollideBottom(paddle)) {
			if (ball.getX() + ball.getWidth() <= paddle.getX() + Math.abs(ball.getXSpeed())
					|| ball.getX() >= paddle.getX() + paddleWidth - Math.abs(ball.getXSpeed())) {
				ball.setXSpeed(-ball.getXSpeed());
			} else {
				ball.setYSpeed(-ball.getYSpeed());
			}
		}

		DestroyableBlock blockToRemove = null;
		// see if the ball hits a remaining block
		for (DestroyableBlock db : blocks) {
			if (ball.didCollideTop(db) || ball.didCollideBottom(db)) {
				ball.setYSpeed(-ball.getYSpeed());
				blockToRemove = db;
				break;
			} else if (ball.didCollideLeft(db) || ball.didCollideRight(db)) {
				ball.setXSpeed(-ball.getXSpeed());
				blockToRemove = db;
				break;
			}
		}
		if (blockToRemove != null) {
			blockToRemove.clear(graphToBack);
			blocks.remove(blockToRemove);
			if (blocks.size() == 0) {
				ball.setXSpeed(0);
				ball.setYSpeed(0);
				graphToBack.setColor(Color.red);
				graphToBack.drawString("YOU WIN!", width / 2, height / 2);
			}
		}

		// see if the paddles need to be moved
		if (keys[0]) {
			paddle.moveLeftAndDraw(graphToBack);
		}
		if (keys[1]) {
			paddle.moveRightAndDraw(graphToBack);
		}

		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'A':
			keys[0] = true;
			break;
		case 'D':
			keys[1] = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'A':
			keys[0] = false;
			break;
		case 'D':
			keys[1] = false;
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