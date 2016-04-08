package tiles;

import java.awt.Graphics;

import main.Game;
import graphics.ImageManager;

public abstract class Tile {
	
	protected ImageManager im;

	public static Tile grass = new GrassTile(Game.getImageManager());
	public static Tile dirt = new DirtTile(Game.getImageManager());
	public static Tile rock = new RockTile(Game.getImageManager());
	public static Tile wall = new WallTile(Game.getImageManager());
	public static Tile stone = new StoneTile(Game.getImageManager());
	public static Tile tree = new TreeTile(Game.getImageManager());
	public static Tile forrest = new ForrestTile(Game.getImageManager());
	public static Tile flower = new FlowerTile(Game.getImageManager());
	public static Tile grassCorner1 = new GrassCorner1Tile(Game.getImageManager());
	public static Tile grassCorner2 = new GrassCorner2Tile(Game.getImageManager());
	public static Tile grassPath1 = new GrassPath1Tile(Game.getImageManager());
	public static Tile grassPath2 = new GrassPath2Tile(Game.getImageManager());
	public static Tile grassPathStart = new GrassPathStartTile(Game.getImageManager());
	public static Tile grassPathEnd = new GrassPathEndTile(Game.getImageManager());
	public static Tile grassFLower = new GrassFlowerTile(Game.getImageManager());
	public static Tile grassPathUp = new GrassPathUpTile(Game.getImageManager());
	public static Tile grassFlower2Tile = new GrassFlower2Tile(Game.getImageManager());
	
	public static Tile tree1 = new Tree1Tile(Game.getImageManager());
	public static Tile tree2 = new Tree2Tile(Game.getImageManager());
	public static Tile tree3 = new Tree3Tile(Game.getImageManager());
	public static Tile tree4 = new Tree4Tile(Game.getImageManager());

	public static Tile house1 = new House1Tile(Game.getImageManager());
	public static Tile house2 = new House2Tile(Game.getImageManager());
	public static Tile house3 = new House3Tile(Game.getImageManager());
	public static Tile house4 = new House4Tile(Game.getImageManager());
	public static Tile house5 = new House5Tile(Game.getImageManager());
	public static Tile house6 = new House6Tile(Game.getImageManager());
	public static Tile house7 = new House7Tile(Game.getImageManager());
	public static Tile house8 = new House8Tile(Game.getImageManager());
	public static Tile house9 = new House9Tile(Game.getImageManager());
	
	public static Tile floor = new FloorTile(Game.getImageManager());

	public static Tile hillFront = new HillFrontTile(Game.getImageManager());
	public static Tile hillBack = new HillBackTile(Game.getImageManager());
	public static Tile hillCorner1 = new HillCorner1Tile(Game.getImageManager());
	public static Tile hillCorner2 = new HillCorner2Tile(Game.getImageManager());
	public static Tile hillCorner3 = new HillCorner3Tile(Game.getImageManager());
	public static Tile hillCorner4 = new HillCorner4Tile(Game.getImageManager());
	public static Tile hillSide1 = new HillSide1Tile(Game.getImageManager());
	public static Tile hillSide2 = new HillSide2Tile(Game.getImageManager());
	public static Tile hillGrassStairs = new HillGrassStairsTile(Game.getImageManager());
	public static Tile hillCorner5 = new HillCorner5Tile(Game.getImageManager());
	public static Tile hillCorner6 = new HillCorner6Tile(Game.getImageManager());
	
	
	public static Tile log1 = new log1Tile(Game.getImageManager());
	public static Tile log2 = new log2Tile(Game.getImageManager());
	public static Tile log3 = new log3Tile(Game.getImageManager());
	public static Tile log4 = new log4Tile(Game.getImageManager());

	public static Tile coast1 = new Coast1Tile(Game.getImageManager());
	public static Tile coast2 = new Coast2Tile(Game.getImageManager());
	public static Tile coast3 = new Coast3Tile(Game.getImageManager());
	public static Tile coast4 = new Coast4Tile(Game.getImageManager());
	public static Tile coast5 = new Coast5Tile(Game.getImageManager());

	public static Tile tunnel = new TunnelTile(Game.getImageManager());
	public static Tile hole = new HoleTile(Game.getImageManager());
	
	public static Tile statue1 = new Statue1Tile(Game.getImageManager());
	public static Tile statue2 = new Statue2Tile(Game.getImageManager());

	
	public Tile(ImageManager im){
		this.im=im;
	}
	public abstract void tick();
	
	public abstract void render(Graphics g,int x, int y);
	
	
	
}
