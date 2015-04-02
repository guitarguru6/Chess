import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class Component extends Applet implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static String title = "Chess thingy Pre-Alpha v0.0.1";
	
	public static int width = 640, height = 480;
	
	private static boolean isRunning = false;
	
	private static Graphics g;
	private static Image screen;
	
	public static Window window;
	public static void main(String[] args) {
		Component component = new Component();
		
		window = new Window(width, height, title);
		window.add(component);
		
		component.init();
	}
	
	public void init() {
		isRunning = true;
		
		screen = createImage(width, height);
		
		Thread th = new Thread(this);
		th.start();
	}

	public void run() {
		while(isRunning) {
			tick();
			render(g);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Error in thread sleep operation.");
			}
		}
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		screen = createImage(width, height);
		g = screen.getGraphics();
		
		g.setColor(Color.blue);
		g.fillRect(0, 0, width, height);
		
		g = getGraphics();
		g.drawImage(screen, 0, 0, null);
	}
	

}
