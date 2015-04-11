import java.awt.Graphics;
import java.awt.Point;

public class Board {
	
	private char[][] board;
	
	public Board() {
		board = new char[][] { 
				{ 'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R' },// 8
				{ 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' },// 7
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },// 6
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },// 5
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },// 4
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },// 3
				{ 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },// 2
				{ 'r', 'n', 'b', 'k', 'q', 'b', 'n', 'r' } // 1
				};
		// 		   a    b    c    d    e    f    g    h

	}

	public boolean isInBounds(Point p) {
		return p.x >= 0 && p.x < board.length && p.y >= 0 && p.y < board[p.x].length;
	}

	public static String pointToString(Point p) {
		return "(" + p.x + ", " + p.y + ")";
	}

	public void setAt(int x, int y, char value) {
		board[x][y] = value;
	}

	public void setAt(Point p, char value) {
		setAt(p.x, p.y, value);
	}

	public char getAt(int x, int y) {
		return board[x][y];
	}

	public char getAt(Point p) {
		return getAt(p.x, p.y);
	}

	public boolean isSameColor(Point p1, Point p2) {
		if (!Character.isAlphabetic(getAt(p1))) return false;
		if (!Character.isAlphabetic(getAt(p2))) return false;

		return (Character.isUpperCase(getAt(p1)) == Character.isUpperCase(getAt(p2)));
	}

	public boolean move(Space f, Space t) {
		Point from = f.getPoint(), to = t.getPoint();
		if (getAt(from) == ' ' || getAt(to) == 'K' || getAt(to) == 'k'|| isSameColor(from, to)) return false;
		
		boolean takes = getAt(to) != ' ';
		
		setAt(to, getAt(from));
		setAt(from, ' ');
		
		if (takes) System.out.println("Piece at " + f + " takes piece at " + t + ".");
		else System.out.println("Moved piece from " + f + " to " + t);
		
		return true;
	}

	public String toString() {
		String s = "";
		int i = 9;
		for (int file = 7; file >= 0; file--) {
			i--;
			s += i + " | ";
			for (int rank = 0; rank < board[file].length; rank++) {
				s += board[file][rank] + " | ";
			}
			s += "\n  - - - - - - - - - - - - - - - - -\n";
		}
		s += "    A   B   C   D   E   F   G   H \n";
		return s;
	}
	
	public void render(Graphics g) {
		for (int file = 0; file < board.length; file++) {
			for (int rank = 0; rank < board[file].length; rank++) {
				PieceImageManager.drawPieceImage(board[7-file][rank], rank, file, g);
			}
		}
	}
}
