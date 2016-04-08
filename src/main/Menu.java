package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Menu{
	
	private int currentChoice = 0;
	private String[] options = {"START", "QUIT"};
	
	public boolean Menu_up = false,Menu_dn = false, Menu_enter=false, Menu_rt=false, Menu_lt=false;
	
	private Color titleColor;
	private Font titleFont;
	private Font font;


	public Menu(BufferedImage img, BufferedImage img_choice){
		try {
			titleColor = new Color(255,195,77);
			titleFont = new Font ("Georgia",Font.PLAIN,30);
			font = new Font("Georgia", Font.PLAIN,20);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public void render(Graphics g, BufferedImage img_choice){
		
		//draw title:
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("PÅSKESPILLET",140,100);
		
		
		//draw menu
		g.setFont(font);
		for (int i = 0; i < options.length; i++) {
			if(i==currentChoice){
				g.setColor(Color.ORANGE);
				g.drawImage(img_choice, 120+i*134, 300, null);
			}
			else{
				g.setColor(Color.BLACK);

			}
			g.drawString(options[i], 150+i*140,360);
		}
	}
	public void update(){
		if(Menu_enter){
			select();
			Menu_enter=false;
		}
		if(Menu_rt){
			currentChoice--;
			if (currentChoice ==-1){
				currentChoice = options.length-1;
			}
			Menu_rt=false;
		}
		if(Menu_lt){
			currentChoice++;
			if(currentChoice == options.length){
				currentChoice = 0;
				Menu_lt=false;
			}
			Menu_lt=false;
		}
	}
	
	private void select(){
		if(currentChoice ==0){
			Game.currentState=1;
			
		}
		if(currentChoice ==1){
			currentChoice=0;
			System.exit(0);
		}
		if(currentChoice ==2){
		}
	}


	

	
	
	

	
	
	}

	
	
		
