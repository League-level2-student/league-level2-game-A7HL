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
	public static final int[] NUMDUCKS = new int[] {2,3,4,5,6,8};
	int level;
	int score;
	int bullets;

	Random random;
	Duck temp;
	
	boolean gameOver = false;
	
	
	
	public ObjectManager() {
		ducks = new ArrayList<Duck>();
		random = new Random();
		temp = new Duck();
		level =0;
		startNextLevel();
	}
	public void startNextLevel() {
		
		if(level>=NUMDUCKS.length) {
			level =0;
			bullets = NUMDUCKS[level]+3;
			for(int i =0;i<NUMDUCKS[level];i++) {
				addDuck(LEVELSPEED[0]);
			}
		}else {
			bullets = NUMDUCKS[level]+3;
			for(int i =0;i<NUMDUCKS[level];i++) {
			addDuck(LEVELSPEED[0]);
			}
		}
	}
	public void levelFinished() {
		if(ducks.size()==0) {
			level++;
			startNextLevel();
			
		}
	}
	public void gameOver() {
		if(ducks.size()!=0&&bullets<=0) {
			gameOver=true;
		}
		
	}
	public void addDuck(int i) {
		int xSpd =0;
		int ySpd =0;
		
		while(xSpd==0||ySpd==0) {
		xSpd = (int)(Math.random()*6)-3;
		ySpd = (int)(Math.random()*6)-3;
		}
		int x = (int)(Math.random()*400);
		int y = (int)(Math.random()*400);
		ducks.add(new Duck(x,y,xSpd,ySpd));
	}
	public void update() {
		
		for(Duck d:ducks) {
			d.update();
		}
		purgeObjects();
		gameOver();
		levelFinished();
		
	}
	public void draw(Graphics g) {
		for(Duck d:ducks) {
			d.draw(g);
		}
	}
	public void purgeObjects() {
		for(int i = ducks.size()-1;i>=0;i--) {
			if(!(ducks.get(i).isActive)) {
				ducks.remove(i);
				//addDuck();
				break;
			}
		}
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
		bullets--;
		int mX = arg0.getX()-1;
		int mY = arg0.getY()-31;
		//System.out.println("mx:"+mX+" my:"+mY);
		//Adjust frame mouse cords
		for(int i = 0;i<ducks.size();i++) {
			Duck d = ducks.get(i);
			//System.out.println("dx:"+d.x+" dy: "+d.y);
			if(mX>d.x&&mX<d.x+d.width&&mY<d.y+d.height&&mY>d.y) {
				ducks.get(i).isActive = false;
				
				score++;
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
