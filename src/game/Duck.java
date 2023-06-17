package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Duck {
	double x;
	double y;
	int width;
	int height;
	double xSpeed;
	double ySpeed;
	boolean isActive;
	Rectangle collisionBox;
	
	public Duck() {
		x = 200;
		y = 200;
		width =50;
		height =50;
		xSpeed = 1;
		ySpeed = 1;
		isActive = true;
	}
	public Duck(double x, double y, double xSpd, double  ySpd) {
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
		g.fillRect((int)x, (int)y, width, height);
	}
	public void checkBoundaries() {
		if( x > DuckHunt.WIDTH - 50){
			   xSpeed = -1*xSpeed;
		}
		if(x < 0){
			    xSpeed = -1*xSpeed;
		}
		if( y > DuckHunt.HEIGHT - 100){
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
