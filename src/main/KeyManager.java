package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP){
			Game.getPlayer().up=true;
			Game.getMenu().Menu_up=true;
			Game.getGameOver().go_up=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			Game.getPlayer().dn=true;	
			Game.getMenu().Menu_dn=true;
			Game.getGameOver().go_dn=true;
			}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			Game.getPlayer().lt=true;
			Game.getMenu().Menu_lt=true;
			Game.getGameOver().go_lt=true;}
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			Game.getPlayer().rt=true;	
			Game.getMenu().Menu_rt=true;
			Game.getGameOver().go_rt=true;}
			
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			Game.getMenu().Menu_enter=true;
			Game.getGameOver().go_enter=true;}
	}
			
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP){
			Game.getPlayer().up=false;
			//Game.getMenu().Menu_up=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			Game.getPlayer().dn=false;
			//Game.getMenu().Menu_dn=false;}
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			Game.getPlayer().lt=false;	}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			Game.getPlayer().rt=false;
		}
		//if(e.getKeyCode()==KeyEvent.VK_ENTER){
		//	Game.getMenu().Menu_enter=true;}
	}

	public void keyTyped(KeyEvent arg0) {
	}

}