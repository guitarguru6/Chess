import java.applet.Applet;
import java.awt.*;


public class Component extends Applet implements Runnable {
    private static final long serialVersionUID = 1L;

    private static String title = "Chess v0.0.1";

    private static final int width = 640;
    private static final int height = 480;

    private static boolean isRunning = false;

    private static Graphics g;
    private static Image screen; // Acts as an image buffer for the screen

    private static Window window;

    public static void main(String[] args) {
        Component component = new Component();

        window = new Window(width, height, title);
        window.add(component);

        component.init();
    }

    public void init() {
        isRunning = true;

        //screen = createImage(width, height)  /// Appears to be redundant due to its use in render(Graphics g).

        Thread th = new Thread(this);
        th.start();
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

    public void render(Graphics g) {
        screen = createImage(width, height);
        g = screen.getGraphics();

        g.setColor(Color.blue);
        g.fillRect(0, 0, width, height); // fills in a blue background

        g = getGraphics();
        g.drawImage(screen, 0, 0, null);
    }


}
