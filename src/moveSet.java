import java.awt.Point;

public class MoveSet {

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

		System.err.print("Invalid Piece Code");
		return "";
	}

	public static int absDiff(int a, int b) {
		return Math.abs(a - b);
	}

	public static boolean isLegalMove(byte pieceCode, Point from, Point to) {

		switch (pieceCode) {
		case 0:
			return false;
		case WPAWN:
			return isWPawnMoveLegal(from, to);
		case BPAWN:
			return isBPawnMoveLegal(from, to);
		}

		return false;
	}

	public static boolean isWPawnMoveLegal(Point from, Point to) {
		if (!Board.isInBounds(to))
			return false;
		if (from.x == to.x && from.y - 1 == to.y && !Board.spotOccupied(to))
			return true;
		if (absDiff(from.x, to.x) == 1 && from.y - 1 == to.y
				&& Board.spotOccupied(to))
			return true;
		return false;
	}

	public static boolean isBPawnMoveLegal(Point from, Point to) {
		if (!Board.isInBounds(to))
			return false;
		if (from.x == to.x && from.y + 1 == to.y && !Board.spotOccupied(to))
			return true;
		if (absDiff(from.x, to.x) == 1 && from.y + 1 == to.y
				&& Board.spotOccupied(to))
			return true;
		return false;
	}

	public static boolean isWKnightMoveLegal(Point from, Point to) {
		// TODO write method to test if an white knight move is legal
		return false;
	}

	public static boolean isBKnightMoveLegal(Point from, Point to) {
		// TODO write method to test if an white knight move is legal
		return false;
	}

}
