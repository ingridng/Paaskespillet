package tiles;

import graphics.ImageManager;

import java.awt.Graphics;

import main.Game;

public class GrassPath2Tile extends Tile{

	public GrassPath2Tile(ImageManager im) {
		super(im);
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(im.grassPath2Tile, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
	}

	@Override
	public void tick() {
	}
	
}
