package game;

import java.awt.Dimension;

import javax.swing.JFrame;

public class DuckHunt {
	//https://opengameart.org/content/country-side-platform-tiles
	//https://opengameart.org/content/duck
	public static final int WIDTH = 768;
	public static final int HEIGHT = 448;
	//w:800 h:700
	
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
		frame.addMouseListener(gP.oM);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(WIDTH,HEIGHT));
		frame.setVisible(true);
	}
}
