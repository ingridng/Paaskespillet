package characters;

import graphics.ImageManager;

import java.awt.Graphics;

import main.Game;

public class Heart {
	
	private int x,y;
	public boolean taken = false;
	public boolean counted = false;

	private ImageManager im;
	
	public Heart(int x, int y, ImageManager im){
		this.x = x;
		this.y = y;
		this.im = im;
	}
	public void tick(){
		}
	
	public void render(Graphics g){
		g.drawImage(im.heart,x,y,Game.TILESIZE*Game.SCALE,Game.TILESIZE*Game.SCALE,null);}
	
	public int getPx(){
		return x;
	}
	public int getPy(){
		return y;
	}
	
}