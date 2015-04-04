import java.awt.Point;

public class Board {
	private static byte[][] board;

	public static void initBoard() {
		board = new byte[8][8];
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[x].length; y++) {
				board[x][y] = 0;
			}
		}
	}

	public static boolean isInBounds(Point p) {
		if (p.x >= 8 || p.y >= 8 || p.x < 0 || p.y < 0)
			return false;
		return true;
	}

	public static boolean spotOccupied(Point p) {
		if (board == null) {
			initBoard();
			return false;
		}

		return isInBounds(p) && board[p.x][p.y] == 0;
	}

	public static boolean spotOccupiedByWhite(Point p) {
//		
//		if (board == null)
//			return false;
//		if (!isInBounds(p) || board[p.x][p.y] == 0)
//			return false;
		//^may be redundant

		return (spotOccupied(p) && getValueAtPos(p) % 2 == 1);
	}

	public static boolean spotOccupiedByBlack(Point p) {
		
//		if (board == null)
//			return false;
//		if (!isInBounds(p) || board[p.x][p.y] == 0)
//			return false;
		//^may be redundant

		return (spotOccupied(p) && getValueAtPos(p) % 2 == 0);
	}

	public static byte getValueAtPos(Point p) {
		return board[p.x][p.y];
	}

	public byte[][] getBoard() {
		return board;
	}

	public void setBoard(byte[][] board) {
		this.board = board;
	}

}
