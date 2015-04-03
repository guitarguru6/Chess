

public class Board {
	private Pieces[][] board = new Pieces[8][8];
	
	public void initBoard() {
		for(int x = 0; x < board.length; x++) {
			for(int y = 0; y < board[x].length; y++) {
				//board[x][y] = new ;
			}
		}
	}

	public Pieces[][] getBoard() {
		return board;
	}

	public void setBoard(Pieces[][] board) {
		this.board = board;
	}
	
	
}
