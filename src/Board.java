import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Board {
	
	private char[][] board;
	
	private int moveCount = 0;
	
	private ArrayList<Move> moves = new ArrayList<Move>();
	
	public Board() {
		board = newChessBoard();
	}
	
	private static char[][] newChessBoard() {
		return new char[][] { 
				{ 'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R' },// 8
				{ 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' },// 7
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },// 6
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },// 5
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },// 4
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },// 3
				{ 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },// 2
				{ 'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r' } // 1
				};
		// 		   a    b    c    d    e    f    g    h

	}
	
	public void setBoard(char[][] c) {
		board = c;
	}
	
	public void resetChessBoard() {
		board = newChessBoard();
		resetMoveCounter();
		moves = new ArrayList<Move>();
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
	
	private void resetMoveCounter() {
		moveCount = 0;
	}

	public boolean move(Space f, Space t) {
		Point from = f.getPoint(), to = t.getPoint();
		if (getAt(from) == ' ' || getAt(to) == 'K' || getAt(to) == 'k'|| isSameColor(from, to)) return false;
		
		boolean takes = getAt(to) != ' ';
		char piece = Character.toLowerCase(getAt(from));
		
		printMove(f, t, takes);
		Move m = new Move(f, t, takes, piece);
		moves.add(m);
		setAt(to, getAt(from));
		setAt(from, ' ');
		
//		if (takes) {
//			if(piece == 'p') System.out.println(f.getFile() + "x" + t);
//			else System.out.println(piece + "x" + t);//System.out.println("Piece at " + f + " takes piece at " + t + ".");
//		}
//		else {
//			if(piece == 'p') System.out.println(t);
//			else System.out.println(piece + "" + t); //System.out.println("Moved piece from " + f + " to " + t);
//		}
		
		//moveCount++;
		
		//System.out.println("Move # " + moveCount);
		
		return true;
	}
	
	private void printMove(Space f, Space t, boolean takes) {
		moveCount++;
		if(moveCount % 2 == 1) System.out.print((moveCount/2+1) + ". ");
		char piece = Character.toUpperCase(getAt(f.getPoint()));
		Move m = new Move(f, t, takes, piece);
		System.out.print(m);
		if(moveCount % 2 == 0) System.out.println();
	}
	
	private void drawMoves(Graphics g) {// broken for now
		String s = "";
		int off = 0;
		for(int i = 0; i < moves.size(); i++) {
			if(i % 2 == 1) s += (moveCount+2/2) + ". ";
			s += moves.get(i);
			if(i % 2 == 0 && i+1 != moves.size()) {
				g.setColor(Color.BLACK);
				g.drawString(s, 510, 20 + off);
				s = "";
				off += 30;
			}
		}
		g.setColor(Color.BLACK);
		g.drawString(s, 510, 20 + off);
	}

	public int getMoveCount() {
		return moveCount;
	}

	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}
	public void incMoveCount() {
		this.moveCount++;
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
		//drawMoves(g);
	}
}
