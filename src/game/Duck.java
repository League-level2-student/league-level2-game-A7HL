package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Duck {
	int x;
	int y;
	int width;
	int height;
	int xSpeed;
	int ySpeed;
	boolean isActive;
	Rectangle collisionBox;
	
	public Duck() {
		x = 400;
		y = 400;
		width =50;
		height =50;
		xSpeed = 1;
		ySpeed = 1;
		isActive = true;
	}
	public Duck(int x, int y, int xSpd, int  ySpd) {
		this.x =x;
		this.y=y;
		width =50;
		height =50;
		this.xSpeed = xSpd;
		this.ySpeed = ySpd;
		isActive = true;
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	public void checkBoundaries() {
		if( x > DuckHunt.WIDTH - 50){
			   xSpeed = -1*xSpeed;
		}
		if(x < 0){
			    xSpeed = -1*xSpeed;
		}
		if( y > DuckHunt.HEIGHT - 50){
			   ySpeed = -1*ySpeed;
		}
		if(y < 0){
			    ySpeed = -1*ySpeed;
		}	
	}
	public void update() {
		checkBoundaries();
		x+=xSpeed;
		y+=ySpeed;
	}
	
}
