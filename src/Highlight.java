import java.awt.Color;
import java.awt.Graphics;


public class Highlight {
	
	
	public static void highLightSpace(Space s, Graphics g) {
		g.setColor(Color.YELLOW);
		int x = s.getFileNum();
		int y = 7-s.getRank();
		if(x >= 0 && y >= 0 && x < 8 && y < 8)
			g.fillRect(x*52+42, y*52+42, 52, 52);
	}
	public static void highLightSpace(int x, int y, Graphics g) {
		g.setColor(Color.YELLOW);
		if(x >= 0 && y >= 0 && x < 8 && y < 8)
			g.fillRect(x*52+42, y*52+42, 52, 52);
	}
}
