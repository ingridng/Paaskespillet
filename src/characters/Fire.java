package characters;

import graphics.ImageManager;

import java.awt.Graphics;

import main.Game;

public class Fire {
	
	private int x,y;
	public boolean up = false,dn = false, lt = false, rt = false;

	private ImageManager im;
	private final int SPEED = 3;
	
	public Fire(int x, int y, ImageManager im){
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
			g.drawImage(im.fire,x,y,Game.TILESIZE*Game.SCALE,Game.TILESIZE*Game.SCALE,null);
		
	}
	
	public int getPx(){
		return x;
	}
	public int getPy(){
		return y;
	}
	
}
