import java.awt.Point;

public class Board {
	private static byte[][] board;

	public void initBoard() {
		board = new byte[8][8];
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[x].length; y++) {
				// board[x][y] = ;
			}
		}
	}

	public static boolean isInBounds(Point p) {
		if (p.x >= 8 || p.y >= 8 || p.x < 0 || p.y < 0)
			return false;
		return true;
	}

	public static boolean spotOccupied(Point p) {
		if (board == null)
			return false;

		return isInBounds(p) && board[p.x][p.y] == 0;
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
