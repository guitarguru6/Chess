import java.awt.Point;

public class Space {
	private char file;
	private int rank;

	public Space(char c, int i) {
		file = fileCheck(c);
		rank = rankCheck(i);
	}

	private char fileCheck(char c) {
		if (Character.isLowerCase(c)) {
			c = Character.toUpperCase(c);
		}
		
		if ((int) c < (int) 'A') return 'A';
		if ((int) c > (int) 'H') return 'H';
		
		return c;
	}
	
	private int rankCheck(int i) {
		if(i < 0) return 1;
		if(i > 8) return 8;
		
		return i;
	}

	public Space(int c, int i) {
		this( (char) (c + 65), i);
		
	}

	public Point getPoint() {
		return new Point(getRank(), getFileNum());
	}

	public int getFileNum() {
		return (int) (file - 65);
	}

	public char getFile() {
		return file;
	}

	public void setFile(char file) {
		this.file = file;
	}

	public int getRank() {
		return rank-1;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String getPointForPrinting() {
		return "(" + (getFileNum() + 1) + ", "+ (getRank() + 1) + ")";
	}
	
	public void print() {
		System.out.println((file) + "" + (rank));
	}
	
	@Override
	public String toString() {
		return file + "" + rank;
	}

}
