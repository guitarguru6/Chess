import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Component extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;

	private static String title = "Chess Pre-Alpha v0.0.3";

	private static final int width = 500;
	private static final int height = 500;

	private static boolean isRunning = false;

	private static Graphics g;
	private static Image screen; // Acts as an image buffer for the screen

	private static Image boardImage;
	
	private static Listening listening;
	
	private static Board board;
	
	private static Window window;
	
	
	public static void main(String[] args) {
		Component component = new Component();

		window = new Window(width, height, title);
		window.add(component);

		component.init();
	}

	public void init() {
		isRunning = true;

		// screen = createImage(width, height) /// Appears to be redundant due to its use in render(Graphics g).
		listening = new Listening();
		addMouseListener(listening);
		addMouseMotionListener(listening);
		board = new Board();
		//BoardTest.testBoard(board);
		
		try {
			boardImage = ImageIO.read(new File("res/blankChessBoard.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error occured while loading the board image");
		}

		//Thread th = new Thread(this);
		//th.start();
		new Thread(this).start(); // changed to be more concise
	}
	
	public static void restartBoard() {
		board.resetChessBoard();
	}
	
	public static Board getBoard() {
		return board;
	}

	public void run() {
		while (isRunning) {
			tick();
			render(g);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.err.println("Error in thread sleep operation.");
			}
		}
	}

	public void tick() {

	}
	
	public void showMouseCoordinates(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("(" + listening.getMouseX() + ", " + listening.getMouseY() + ")", width - 100, height - 20);
	}
	
	public void drawMouseLines(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(listening.getMouseX(), 0, listening.getMouseX(), height);
		g.drawLine(0, listening.getMouseY(), width, listening.getMouseY());
	}
	
	public void highlightSpaceUnderMouse(Graphics g) {
		g.setColor(Color.YELLOW);
		int x = (listening.getMouseX() - 42) / 52;
		int y = (listening.getMouseY() - 42) / 52;
		if(x >= 0 && y >= 0 && x < 8 && y < 8)
			g.fillRect(x*52+42, y*52+42, 52, 52);
	}

	public void render(Graphics g) {
		screen = createImage(width, height);
		g = screen.getGraphics();

		g.setColor(Color.gray);
		g.fillRect(0, 0, width, height); // fills in a gray background

		g.drawImage(boardImage, 0, 0, null); // draws the board
		
		highlightSpaceUnderMouse(g); // highlights the square under the mouse in yellow
		listening.render(g);
		
		board.render(g); // draws the pieces on the board
		
		g = getGraphics();
		g.drawImage(screen, 0, 0, null);
	}

}
