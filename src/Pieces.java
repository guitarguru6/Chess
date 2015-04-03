import java.awt.Image;

public abstract class Pieces {
	private Image image; // The image of the piece

	public void setImage(Image image) {
		this.image = image;
	}
	
	public Image getImage() {
		return image;
	}
	
	public abstract void setPosOnBoard(int x, int y);

	public abstract void defineMoveSet();
	
	
	
	

}

class Pawn extends Pieces {

	public void setPosOnBoard(int x, int y) {
		
	}

	public void defineMoveSet() {
		
	}
	
}
