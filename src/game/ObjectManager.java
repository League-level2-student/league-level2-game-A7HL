package game;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class ObjectManager implements MouseListener{
	ArrayList<Duck> ducks;
	public static final int[] LEVELSPEED = new int[] {2,4,6,8,10};
	public static final int[] NUMDUCKS = new int[] {2,3,4,5,6};
	int level;
	int round;
	int score;
	int bullets;

	Random random;
	Duck temp;
	
	boolean gameOver;
	
	
	
	public ObjectManager() {
		reset();
	}
	public void startNextLevel() {
		
		startNextRound();
	}
	public void levelFinished() {
		
	}
	public void startNextRound() {
		if(round>=NUMDUCKS.length) {
			round =0;
			bullets = NUMDUCKS[round]+3;
			for(int i =0;i<NUMDUCKS[round];i++) {
				//addDuck(LEVELSPEED[level]);
				addDuck(level*2);
			}
		}else {
			bullets = NUMDUCKS[round]+3;
			for(int i =0;i<NUMDUCKS[round];i++) {
			//addDuck(LEVELSPEED[level]);
				addDuck(level*2);
			}
		}
	}
	public void roundFinished() {
		if(ducks.size()==0&&round+1>=NUMDUCKS.length) {
			level++;
			round++;
			startNextLevel();
			
		}else if(ducks.size()==0){
			round++;
			startNextRound();
		}
	}
	public void gameOver() {
		if(ducks.size()!=0&&bullets<=0) {
			gameOver=true;
		}
		
	}
	public void addDuck(int levelSpeed) {
		
		
		double dir = Math.random()*Math.PI*2;
		double xSpd = Math.cos(dir)*levelSpeed;
		double ySpd = Math.sin(dir)*levelSpeed;
		
//		while(xSpd==0||ySpd==0) {
//		xSpd = (int)(Math.random()*6)-3;
//		ySpd = (int)(Math.random()*6)-3;
//		}
		
		int x = (int)(Math.random()*400);
		int y = (int)(Math.random()*300);
		ducks.add(new Duck(x,y,xSpd,ySpd));
	}
	public void update() {
		
		for(Duck d:ducks) {
			d.update();
		}
		purgeObjects();
		gameOver();
		roundFinished();
		
	}
	public void reset() {
		ducks = new ArrayList<Duck>();
		random = new Random();
		temp = new Duck();
		level =1;
		round = 0;
		score = 0;
		gameOver = false;
		startNextLevel();
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
				score = score + (10*level);
				//addDuck();
				//break;
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
		System.out.println("Mouse Pressed");
		bullets--;
		int mX = arg0.getX()-1;
		int mY = arg0.getY()-31;
		System.out.println("mx:"+mX+" my:"+mY);
		//Adjust frame mouse cords
		for(int i = 0;i<ducks.size();i++) {
			System.out.println("for loop running");
			Duck d = ducks.get(i);
			System.out.println("dx:"+d.x+" dy: "+d.y);
			if(mX>d.x&&mX<d.x+d.width&&mY<d.y+d.height&&mY>d.y) {
				ducks.get(i).isActive = false;
				System.out.println("Clicked on square");
				//score++;
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
