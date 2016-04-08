package tiles;


import graphics.ImageManager;

import java.awt.Graphics;

import main.Game;

public class GrassFlower2Tile extends Tile{

	public GrassFlower2Tile(ImageManager im) {
		super(im);
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(im.grassFlower2Tile, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}