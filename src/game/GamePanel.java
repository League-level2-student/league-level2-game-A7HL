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
	
	public GamePanel() {
		  frameDraw = new Timer(1000/60,this);
		  frameDraw.start();
		
		  oM = new ObjectManager();
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
		 g.setColor(new Color(69, 196, 255));
		 g.fillRect(0, 0, DuckHunt.WIDTH, DuckHunt.HEIGHT);
		 
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("GAME STATE (TEMP)", 23, 100);
		 
		 
		 
		 oM.draw(g);
		 
		 
	 }
	 public void drawEndState(Graphics g) {
		 g.setColor(new Color(69, 196, 255));
		 g.fillRect(0, 0, DuckHunt.WIDTH, DuckHunt.HEIGHT);
		 
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("END STATE (TEMP)", 23, 100);
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
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		    	oM = new ObjectManager();
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
