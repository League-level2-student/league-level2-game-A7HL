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

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener {
	
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
	
	int currentState = MENU;
	
	Font titleFont;
	
	Timer frameDraw;
	
	public GamePanel() {
		  frameDraw = new Timer(1000/60,this);
		  frameDraw.start();
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
		 
	 }
	 public void updateEndState(){ 
		 
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
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		    	//objMan = new ObjectManager(player);
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
