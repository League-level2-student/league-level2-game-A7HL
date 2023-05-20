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
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	public void checkBoundaries() {
		if( x > DuckHunt.WIDTH - 25){
			   xSpeed = -1*xSpeed;
		}
		if(x < 0 +15){
			    xSpeed = -1*xSpeed;
		}
		if( y > DuckHunt.HEIGHT - 25){
			   ySpeed = -1*xSpeed;
		}
		if(y < 0 +15){
			    ySpeed = -1*xSpeed;
		}	
	}
	public void update() {
		checkBoundaries();
		x+=xSpeed;
		y+=ySpeed;
	}
	
}
