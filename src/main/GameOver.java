package main;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GameOver{
	
	private int currentChoice_go = 0;
	private String[] options = {"CONTINUE", "QUIT"};
	
	public boolean go_up = false,go_dn = false, go_enter=false, go_rt=false, go_lt=false;
	
	private Font titleFont;
	private Font font;

	public GameOver(BufferedImage img, BufferedImage img_choice){
		currentChoice_go = 0;
		try {

			titleFont = new Font ("ARIAL",Font.PLAIN,18);
			font = new Font("ARIAL", Font.PLAIN,14);

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public void render(Graphics g, BufferedImage img_choice){
		
		//draw title:
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("GAME OVER",170,100);
		
		
		//draw menu
		g.setFont(font);
		for (int i = 0; i < options.length; i++) {
			if(i==currentChoice_go){
				g.setColor(Color.ORANGE);
				//g.drawImage(img_choice, 120+i*134, 300, null);
			}
			else{
				g.setColor(Color.WHITE);

			}
			g.drawString(options[i], 150+i*140,200);
		}
	}
	public void update(){
		if(go_enter){
			select();
			go_enter=false;
		}
		if(go_rt){
			//currentChoice--;
			//if (currentChoice ==-1){
		//		currentChoice = options.length-1;
			//}
			if(currentChoice_go==0){currentChoice_go=1;}
			else if(currentChoice_go==1){currentChoice_go=0;}
			go_rt=false;
		}
		if(go_lt){
			//currentChoice++;
			//if(currentChoice == options.length){
			//	currentChoice = 0;
			//	go_lt=false;
			//}
			if(currentChoice_go==0){currentChoice_go=1;}
			else if(currentChoice_go==1){currentChoice_go=0;}
			go_lt=false;
		}
	}
	
	private void select(){
		if(currentChoice_go==0){
			//Game.lives = 6;
			if(Game.level1completed){Game.currentState = 7;}
			else{Game.currentState=1;}
			
			
		}
		if(currentChoice_go ==1){
			System.exit(0);
		}
		if(currentChoice_go ==2){
		}
	}


	



	

	
	
	

	
	
	}