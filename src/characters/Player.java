package characters;

import java.awt.Graphics;


import main.Game;
import graphics.ImageManager;


public class Player {
	
	private int x,y;
	public boolean up = false,dn = false, lt = false, rt = false, angry = false;

	private ImageManager im;
	private int SPEED = 3;
	
	public Player(int x, int y, ImageManager im){
		this.x = x;
		this.y = y;
		this.im = im;
	}
	public void tick(){
		if(up){y-=SPEED;}
		if(dn){y+=SPEED;}
		if(lt){x-=SPEED;}
		if(rt){x+=SPEED;}
		}
	
	public void render(Graphics g){
		if (up){g.drawImage(im.player_up,x,y,Game.TILESIZE*Game.SCALE,Game.TILESIZE*Game.SCALE,null); angry=false;}
		else if(lt){g.drawImage(im.player_lt,x,y,Game.TILESIZE*Game.SCALE,Game.TILESIZE*Game.SCALE,null); angry=false;}
		else if(rt){g.drawImage(im.player_rt,x,y,Game.TILESIZE*Game.SCALE,Game.TILESIZE*Game.SCALE,null); angry=false;}
		else if(angry){g.drawImage(im.player_angry,x,y,Game.TILESIZE*Game.SCALE,Game.TILESIZE*Game.SCALE,null);}
		else{
			g.drawImage(im.player,x,y,Game.TILESIZE*Game.SCALE,Game.TILESIZE*Game.SCALE,null);
		}
	}
	
	public int getPx(){
		return x;
	}
	public int getPy(){
		return y;
	}
	public void setSpeed(int s){
		SPEED = s;
	}
	
}	