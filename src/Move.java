public class Move {
	private Space from, to;
	private boolean takes;
	private char piece;

	public Move(Space f, Space t, boolean take, char p) {
		setFrom(f);
		setTo(t);
		takes = take;
		piece = p;
	}

	public Space getFrom() {
		return from;
	}

	public void setFrom(Space from) {
		this.from = from;
	}

	public Space getTo() {
		return to;
	}

	public void setTo(Space to) {
		this.to = to;
	}

	public String toString() {
		if (takes) {
			if (piece == 'P' || piece == 'p')
				return (Character.toLowerCase(from.getFile()) + "x" + to + " ");
			else
				return (piece + "x" + to + " ");// System.out.println("Piece at "
												// + f + " takes piece at " + t
												// + ".");
		} else {
			if (piece == 'P' || piece == 'p')
				return (to + " ");
			else
				return (piece + "" + to + " "); // System.out.println("Moved piece from "
												// + f + " to " + t);
		}
	}
}
