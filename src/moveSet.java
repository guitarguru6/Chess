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
		case WKNIGHT:
			return isWKnightMoveLegal(from, to);
		case BKNIGHT:
			return isBKnightMoveLegal(from, to);
		case WBISHOP:
			return isWBishopMoveLegal(from, to);
		case BBISHOP:
			return isBBishopMoveLegal(from, to);

		}

		return false;
	}

	public static boolean isWPawnMoveLegal(Point from, Point to) {
		if (!Board.isInBounds(to))
			return false;
		if (from.equals(to))
			return false;
		if (Board.spotOccupiedByWhite(to))
			return false;
		if (from.x == to.x && from.y - 1 == to.y && !Board.spotOccupied(to))
			return true;
		if (absDiff(from.x, to.x) == 1 && to.y == from.y - 1
				&& Board.spotOccupiedByBlack(to))
			return true;
		return false;
	}

	public static boolean isBPawnMoveLegal(Point from, Point to) {
		if (!Board.isInBounds(to))
			return false;
		if (from.equals(to))
			return false;
		if (Board.spotOccupiedByBlack(to))
			return false;
		if (from.x == to.x && from.y + 1 == to.y && !Board.spotOccupied(to))
			return true;
		if (absDiff(from.x, to.x) == 1 && to.y == from.y + 1
				&& Board.spotOccupiedByWhite(to))
			return true;
		return false;
	}

	public static boolean isWKnightMoveLegal(Point from, Point to) {
		if (!Board.isInBounds(to))
			return false;
		if (from.equals(to))
			return false;
		if (Board.spotOccupiedByWhite(to))
			return false;
		if (absDiff(to.x, from.x) == 1 && absDiff(to.y, from.y) == 2)
			return true;
		if (absDiff(to.x, from.x) == 2 && absDiff(to.y, from.y) == 1)
			return true;

		return false;
	}

	public static boolean isBKnightMoveLegal(Point from, Point to) {
		if (!Board.isInBounds(to))
			return false;
		if (from.equals(to))
			return false;
		if (Board.spotOccupiedByBlack(to))
			return false;

		if (absDiff(to.x, from.x) == 1 && absDiff(to.y, from.y) == 2
				&& !Board.spotOccupiedByBlack(to))
			return true;
		if (absDiff(to.x, from.x) == 2 && absDiff(to.y, from.y) == 1
				&& !Board.spotOccupiedByBlack(to))
			return true;

		return false;
	}

	public static boolean isWBishopMoveLegal(Point from, Point to) {
		// TODO write method to check to see if a given White Bishop move is
		// legal
		if (!Board.isInBounds(to))
			return false;
		if (from.equals(to))
			return false;
		if (Board.spotOccupiedByWhite(to))
			return false;

		byte xDir = (byte) (to.x - from.x);
		byte yDir = (byte) (to.y - from.y);
		xDir /= Math.abs(xDir);
		yDir /= Math.abs(yDir);

		if (absDiff(from.x, to.x) == absDiff(from.y, to.y)) {
			int x = from.x, y = from.y;
			while (x != to.x && y != to.y) {
				x += xDir;
				y += yDir;
				if (Board.spotOccupied(new Point(x, y)) && x != to.x
						&& y != to.y)
					return false;
				if (Board.spotOccupied(new Point(x, y)) && x == to.x
						&& y == to.y)
					return true;
			}
			return true;
		}

		return false;
	}

	public static boolean isBBishopMoveLegal(Point from, Point to) {
		// TODO write method to check to see if a given Black Bishop move is
		// legal
		if (!Board.isInBounds(to))
			return false;
		if (from.equals(to))
			return false;
		if (Board.spotOccupiedByBlack(to))
			return false;

		byte xDir = (byte) (to.x - from.x);
		byte yDir = (byte) (to.y - from.y);
		xDir /= Math.abs(xDir);
		yDir /= Math.abs(yDir);

		if (absDiff(from.x, to.x) == absDiff(from.y, to.y)) {
			int x = from.x, y = from.y;
			while (x != to.x && y != to.y) {
				x += xDir;
				y += yDir;
				if (Board.spotOccupied(new Point(x, y)) && x != to.x
						&& y != to.y)
					return false;
				if (Board.spotOccupied(new Point(x, y)) && x == to.x
						&& y == to.y)
					return true;
			}
			return true;
		}

		return false;
	}

	public static boolean isWRookMoveLegal(Point from, Point to) {
		// TODO write method to check to see if a White Rook move is legal
		if (!Board.isInBounds(to))
			return false;
		if (from.equals(to))
			return false;
		if (Board.spotOccupiedByWhite(to))
			return false;

		return false;
	}

	public static boolean isBRookMoveLegal(Point from, Point to) {
		// TODO write method to check to see if a Black Rook move is legal
		if (!Board.isInBounds(to))
			return false;
		if (from.equals(to))
			return false;
		if (Board.spotOccupiedByBlack(to))
			return false;

		return false;
	}
}
