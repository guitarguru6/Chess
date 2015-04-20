import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Listening implements MouseMotionListener, MouseListener {
	private int mx, my;
	private Space s1 = null, s2 = null;

	public int getMouseX() {
		return mx;
	}

	public int getMouseY() {
		return my;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = (getMouseX() - 42) / 52;
		int y = (getMouseY() - 42) / 52;
		if (e.getButton() == MouseEvent.BUTTON1) {
			// BoardTest.randomMove(Component.getBoard()); // does a random move on left click

			if (x >= 0 && y >= 0 && x < 9 && y < 9) {
				if (s1 == null) {//first click chooses from square
					Space space = new Space(x, 8 - y);
					if(Component.getBoard().getAt(space.getPoint()) != ' ')//checks that you aren't trying to choose a blank square
						s1 = space;
				} else if (s1 != null) {//second click chooses to square, if valid 
					Space space = new Space(x, 8 - y);
					// space.print();
					s2 = space;
					Component.getBoard().move(s1, s2);
					s1 = null;
					s2 = null;
				}
			}
		}

		if (e.getButton() == MouseEvent.BUTTON3) {
			Component.restartBoard(); // resets board on right click, for testing purposes
			s1 = null;
			s2 = null;
		}

//		if (e.getButton() == MouseEvent.BUTTON3) {
//			// BoardTest.randomMove(Component.getBoard()); // does a random move
//			// on left click
//
//			if (x >= 0 && y >= 0 && x < 9 && y < 9) {
//				if (s1 != null) {
//					Space space = new Space(x, 8 - y);
//					// space.print();
//					s2 = space;
//					Component.getBoard().move(s1, s2);
//					s1 = null;
//					s2 = null;
//				}
//			}
//		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mx = e.getX();
		my = e.getY();
	}

	public void render(Graphics g) {
		if (s1 != null)
			Highlight.highLightSpace(s1, g);
	}

}
