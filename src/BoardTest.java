import java.util.Random;


public class BoardTest {
	
	public static void randomMoves(int i, Board b) {
		for(int x = 0; x < i; x++) {
			randomMove(b);
		}
	}
	
	public static void randomMove(Board b) {
		Random r = new Random();
		Boolean valid = false;
		while(!valid) {
			valid = valid || b.move(new Space(r.nextInt(8) + 1, r.nextInt(8) + 1), new Space(r.nextInt(8) + 1, r.nextInt(8) + 1));
		}
	}
	
	public static void testBoard(Board b) {
		b.move(new Space('E', 2), new Space('E', 4));
	}
}
