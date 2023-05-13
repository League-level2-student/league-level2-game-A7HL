package game;

import java.awt.Dimension;

import javax.swing.JFrame;

public class DuckHunt {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 700;
	
	GamePanel gP;
	JFrame frame;
	
	public DuckHunt() {
		frame = new JFrame();
		gP = new GamePanel();
	}
	public static void main(String[] args) {
		DuckHunt game = new DuckHunt();
		game.setUp();
	}
	public void setUp() {
		frame.add(gP);
		frame.addKeyListener(gP);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(WIDTH,HEIGHT));
		frame.setVisible(true);
	}
}
