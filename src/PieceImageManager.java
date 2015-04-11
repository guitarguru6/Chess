import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PieceImageManager {
	private static boolean initialized = false;
	
	private static final int WIDTH = 52, HEIGHT = 52, XOFF = 42, YOFF = 42;
	
	private static Image WhiteKing;
	private static Image WhiteQueen;
	private static Image WhiteBishop;
	private static Image WhiteKnight;
	private static Image WhiteRook;
	private static Image WhitePawn;
	private static Image BlackKing;
	private static Image BlackQueen;
	private static Image BlackBishop;
	private static Image BlackKnight;
	private static Image BlackRook;
	private static Image BlackPawn;

	public static Image getImage(char c) {
		if(!initialized) {
			initImages();
			initialized = true;
		}
		if (!Character.isAlphabetic(c))
			return null;
		switch (c) {
		case 'K': return WhiteKing;
		case 'Q': return WhiteQueen;
		case 'B': return WhiteBishop;
		case 'N': return WhiteKnight;
		case 'R': return WhiteRook;
		case 'P': return WhitePawn;
		case 'k': return BlackKing;
		case 'q': return BlackQueen;
		case 'b': return BlackBishop;
		case 'n': return BlackKnight;
		case 'r': return BlackRook;
		case 'p': return BlackPawn;
		default: return null;
		}
	}

	private static void initImages() {
		WhiteKing = getImageAtLocation("whitePieces/King");
		WhiteQueen = getImageAtLocation("whitePieces/Queen");
		WhiteBishop = getImageAtLocation("whitePieces/Bishop");
		WhiteKnight = getImageAtLocation("whitePieces/Knight");
		WhiteRook = getImageAtLocation("whitePieces/Rook");
		WhitePawn = getImageAtLocation("whitePieces/Pawn");

		BlackKing = getImageAtLocation("blackPieces/King");
		BlackQueen = getImageAtLocation("blackPieces/Queen");
		BlackBishop = getImageAtLocation("blackPieces/Bishop");
		BlackKnight = getImageAtLocation("blackPieces/Knight");
		BlackRook = getImageAtLocation("blackPieces/Rook");
		BlackPawn = getImageAtLocation("blackPieces/Pawn");
	}

	private static Image getImageAtLocation(String location) {
		try {
			return ImageIO.read(new File("res/" + location + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error occured while loading piece image at location " + "\"res/" + location + ".png\"");
		}
		return null;
	}
	
	public static void drawPieceImage(char c, int x, int y, Graphics g) {
		g.drawImage(getImage(c), XOFF + (x * WIDTH), YOFF + (y * HEIGHT), WIDTH, HEIGHT, null);
	}
}
