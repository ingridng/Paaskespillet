package characters;

import graphics.ImageManager;

import java.awt.Graphics;

import main.Game;

public class Chicken {
	
	private int x,y;
	public boolean up = false,dn = false, lt = false, rt = false, happy = false;

	private ImageManager im;
	private final int SPEED = 3;
	
	public Chicken(int x, int y, ImageManager im){
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
		if (up){g.drawImage(im.chicken_up,x,y,Game.TILESIZE*Game.SCALE,Game.TILESIZE*Game.SCALE,null);}
		else if(dn){g.drawImage(im.chicken_dn,x,y,Game.TILESIZE*Game.SCALE,Game.TILESIZE*Game.SCALE,null);}
		else if(lt){g.drawImage(im.chicken_lt,x,y,Game.TILESIZE*Game.SCALE,Game.TILESIZE*Game.SCALE,null);}
		else if(rt){g.drawImage(im.chicken_rt,x,y,Game.TILESIZE*Game.SCALE,Game.TILESIZE*Game.SCALE,null);}
		else if (happy) {g.drawImage(im.chicken_happy,x,y,Game.TILESIZE*Game.SCALE,Game.TILESIZE*Game.SCALE,null);}
		else{
			g.drawImage(im.chicken,x,y,Game.TILESIZE*Game.SCALE,Game.TILESIZE*Game.SCALE,null);
		}
	}
	
	public int getPx(){
		return x;
	}
	public int getPy(){
		return y;
	}
	
}
