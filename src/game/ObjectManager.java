package game;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class ObjectManager implements MouseListener{
	ArrayList<Duck> ducks;
	public static final int[] LEVELSPEED = new int[] {5,10,15,20,25};
	public static final int[] NUMDUCKS = new int[] {2,3,4,5,6};
	int level;
	Random random;
	Duck temp;
	
	public ObjectManager() {
		ducks = new ArrayList<Duck>();
		random = new Random();
		temp = new Duck();
		ducks.add(temp);
	}
	public void addDuck() {
		ducks.add(new Duck());
	}
	public void update() {
		for(Duck d:ducks) {
			d.update();
		}
	}
	public void draw(Graphics g) {
		for(Duck d:ducks) {
			d.draw(g);
		}
	}
	public void isShot() {
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
