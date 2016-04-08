package tiles;

import graphics.ImageManager;

import java.awt.Graphics;

import main.Game;

public class GrassCorner1Tile extends Tile{

	public GrassCorner1Tile(ImageManager im) {
		super(im);
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(im.grassCorner1Tile, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
