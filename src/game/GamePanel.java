package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
	
	int currentState = MENU;
	
	Font titleFont;
	
	Timer frameDraw;
	
	ObjectManager oM;
	
	public static BufferedImage image1;
	public static BufferedImage image2;
	public static BufferedImage image3;
	
		
	public GamePanel() {
		  frameDraw = new Timer(1000/60,this);
		  frameDraw.start();
		
		  oM = new ObjectManager();
		  
		  
			    image1 =loadImage ("country-platform-back.png");
			    image2 = loadImage ("country-platform-tiles-example.png");
			    image3 = loadImage ("country-platform-forest.png");
		  
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		
		repaint();
	}
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	 public void drawMenuState(Graphics g){
		 g.setColor(new Color(69, 196, 255));
		 g.fillRect(0, 0, DuckHunt.WIDTH, DuckHunt.HEIGHT);
		 
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("MENU (TEMP)", 23, 100);
	 }
	 public void drawGameState(Graphics g){
		 if (image1!=null) {
				g.drawImage(image1, 0, 0, DuckHunt.WIDTH, DuckHunt.HEIGHT, null);
				g.drawImage(image2, 0, 0, DuckHunt.WIDTH, DuckHunt.HEIGHT, null);
				//g.drawImage(image3, 0, 0, DuckHunt.WIDTH, DuckHunt.HEIGHT, null);
			} else {
				 g.setColor(new Color(69, 196, 255));
				 g.fillRect(0, 0, DuckHunt.WIDTH, DuckHunt.HEIGHT);
				 
				 g.setFont(titleFont);
				 g.setColor(Color.YELLOW);
				 g.drawString("GAME STATE (TEMP)", 23, 100);
				 
			}
		 
		 oM.draw(g);
		 
		 
	 }
	 public void drawEndState(Graphics g) {
		 g.setColor(new Color(69, 196, 255));
		 g.fillRect(0, 0, DuckHunt.WIDTH, DuckHunt.HEIGHT);
		 
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("END STATE (TEMP) - SCORE: "+oM.score, 23, 100);
	 }
	 public void updateMenuState(){  
		 
	 }
	 public void updateGameState(){
		 oM.update();
		 if(oM.gameOver == true) {
				currentState = END;
		 }
	 }
	 public void updateEndState(){ 
		 
	 }
	 public BufferedImage loadImage(String imageFile) {
		 BufferedImage image = null;
		   
		        try {
		            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
			   
		        } catch (Exception e) {
		            
		        }
		       
		    
			return image;
	 }
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		    	oM.reset();
		        currentState = MENU;
		    } else if(currentState == MENU){
		    	//startGame();
		  
		        currentState++;
		    }else {
		    	currentState++;
		    }
		}  
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
