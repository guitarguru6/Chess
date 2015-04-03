import java.awt.Point;

public class moveSet {

	private final static byte WPAWN = 1;
	private final static byte BPAWN = 2;
	private final static byte WKNIGHT = 3;
	private final static byte BKNIGHT = 4;
	private final static byte WBISHOP = 5;
	private final static byte BBISHOP = 6;
	private final static byte WROOK = 7;
	private final static byte BROOK = 8;
	private final static byte WQUEEN = 9;
	private final static byte BQUEEN = 10;
	private final static byte WKING = 11;
	private final static byte BKING = 12;
	
	

	public static String getPiecetype(int pieceCode) {
		switch (pieceCode) {
		case WPAWN:
			return ("White Pawn");
		case BPAWN:
			return ("Black Pawn");
		case WKNIGHT:
			return ("White Knight");
		case BKNIGHT:
			return ("Black Knight");
		case WBISHOP:
			return ("White Bishop");
		case BBISHOP:
			return ("Black Bishop");
		case WROOK:
			return ("White Rook");
		case BROOK:
			return ("Black Rook");
		case WQUEEN:
			return ("White Queen");
		case BQUEEN:
			return ("Black Queen");
		case WKING:
			return ("White King");
		case BKING:
			return ("Black King");
		}

		System.err.print("Invalid Piece Code");
		return "";
	}
	
	public Point[] getWPawnMoves() {
		return new Point[]{new Point (0, -1)}; 
	}
	
	public Point[] getBPawnMoves() {
		return new Point[]{new Point (0, 1)}; 
	}
}
