package tiles;
import graphics.ImageManager;

import java.awt.Graphics;

import main.Game;

public class HillSide2Tile extends Tile{

	public HillSide2Tile(ImageManager im) {
		super(im);
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(im.hillSide2Tile, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}