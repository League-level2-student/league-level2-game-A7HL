package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Duck {
	double x;
	double y;
	int width;
	int height;
	double xSpeed;
	double ySpeed;
	boolean isActive;
	Rectangle collisionBox;
	
	int count;
	
	public static BufferedImage duck1;
	public static BufferedImage duck2;
	public static BufferedImage duckF1;
	public static BufferedImage duckF2;
	
	public Duck() {
		x = 200;
		y = 200;
		width =50;
		height =50;
		xSpeed = 1;
		ySpeed = 1;
		isActive = true;
		
		 duck1 =loadImage ("d1.png");
		 duckF1 = loadImage("d1Flip.png");
		 duck2 = loadImage ("d2.png");
		 duckF2 = loadImage("d2Flip.png");
		 
		 count = 0;
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
		//duck 53x43
		if(duck1!=null||duck2!=null) {
			if(xSpeed>=0) {
				if(count<=30) {
					g.drawImage(duck1,(int)x, (int)y, 53, 43, null);
					count++;
				}else {
					g.drawImage(duck2,(int)x, (int)y, 53, 43, null);
					count++;
					if(count>60) {
						count = 0;
					}
				}
				
			}else {
				if(count<=30) {
					g.drawImage(duckF1,(int)x, (int)y, 53, 43, null);
					count++;
				}else {
					g.drawImage(duckF2,(int)x, (int)y, 53, 43, null);
					count++;
					if(count>60) {
						count = 0;
					}
				}
			}
			
			
		}else {
		g.setColor(Color.BLUE);
		g.fillRect((int)x, (int)y, width, height);
		}
		
	}
	public void checkBoundaries() {
		if( x > DuckHunt.WIDTH - 50){
			   xSpeed = -1*xSpeed;
		}
		if(x < 0){
			    xSpeed = -1*xSpeed;
		}
		if( y > DuckHunt.HEIGHT - 150){
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
	 public BufferedImage loadImage(String imageFile) {
		 BufferedImage image = null;
		   
		        try {
		            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
			   
		        } catch (Exception e) {
		            
		        }
		       
		    
			return image;
	 }
	
}
