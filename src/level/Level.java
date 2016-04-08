package level;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import tiles.Tile;

public class Level {
	
	private int[][] tiles;
	private int w,h;
	
	public Level(BufferedImage levelImage){
		w = levelImage.getWidth();
		h = levelImage.getHeight();
		loadLevel(levelImage);
	}
	
	public void loadLevel(BufferedImage levelImage){
		tiles = new int[levelImage.getWidth()][levelImage.getHeight()];
		for(int y = 0;y < levelImage.getHeight();y++){
			for(int x = 0;x < levelImage.getWidth();x++){
				Color c = new Color(levelImage.getRGB(x, y));
				String h = String.format("%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());
				
				
				
				if (h.equals("23ff06")){//GRASS
					tiles[x][y] = 1;
				}
				else if (h.equals("00ff00")){//DIRT
					tiles[x][y] = 2;
					
				}else if (h.equals("ff0000")){//FLOWER
					tiles[x][y] = 3;
					
				}else if (h.equals("999999")){//ROCK
					tiles[x][y] = 4;
					
				}else if (h.equals("432301")){//TREE
					tiles[x][y] = 5;
					
				}else if (h=="780078"){//WALL
					tiles[x][y] = 6;
				}
				else if (h.equals("808000")){//FORREST
					tiles[x][y] = 7;
					
				}
				else if (h.equals("ccff66")){//FLOWER
					tiles[x][y] = 8;
					
				}
				else if (h.equals("c95f06")){//PATH START
					tiles[x][y] = 9;
				}
				else if (h.equals("fd871a")){//PATH 1
					tiles[x][y] = 10;
				}
				else if (h.equals("fd9732")){//PATH 2
					tiles[x][y] = 11;
				}
				else if (h.equals("fda84e")){//PATH CORNER 1
					tiles[x][y] = 12;
				}
				else if (h.equals("feca8e")){//PATH CORNER 2
					tiles[x][y] = 13;
				}
				else if (h.equals("fedcb2")){//PATH END
					tiles[x][y] = 14;
				}
				
				//TREE:
				else if (h.equals("000843")){//THREE1
					tiles[x][y] = 15;
				}
				else if (h.equals("00076c")){//TREE3
					tiles[x][y] = 16;
				}
				else if (h.equals("000399")){//TREE2
					tiles[x][y] = 17;
				}
				else if (h.equals("0000ca")){//TREE4
					tiles[x][y] = 18;
				}
				
				
				//HOUSE
				else if (h.equals("b100cb")){//HOUSE1
					tiles[x][y] = 19;
				}
				else if (h.equals("df00ff")){//HOUSE2
					tiles[x][y] = 20;
				}
				else if (h.equals("e200ff")){//HOUSE3
					tiles[x][y] = 21;
				}
				else if (h.equals("e609ff")){//HOUSE4
					tiles[x][y] = 22;
				}
				else if (h.equals("ea3aff")){//HOUSE5
					tiles[x][y] = 23;
				}
				else if (h.equals("ee60ff")){//HOUSE6
					tiles[x][y] = 24;
				}
				else if (h.equals("5f006c")){//HOUSE1
					tiles[x][y] = 25;
				}
				else if (h.equals("3b0043")){//HOUSE9
					tiles[x][y] = 26;
				}
				else if (h.equals("87009a")){//HOUSE8
					tiles[x][y] = 27;
				}
				
				else if (h.equals("09452f")){  //HILLSIDE1
					tiles[x][y] = 28;
				}else if (h.equals("3dffbf")){// SIDE2
					tiles[x][y] = 29;
				}
				else if (h.equals("0e6e4a")){ //Corner3
					tiles[x][y] = 30;
				}
				else if (h.equals("149d68")){//Hillfront
					tiles[x][y] = 31;
				}else if (h.equals("1bcf89")){//stairs
					tiles[x][y] = 32;
				}
				else if (h.equals("22ffab")){//corner4
					tiles[x][y] = 33;
			}
				else if (h.equals("87009a")){//HOUSE8
					tiles[x][y] = 34;
				}
				else if (h.equals("72ffd4")){//HOUSECorner 1
					tiles[x][y] = 35;
				}
				//}else if (h.equals("892ffdf")){//Corner2
				//	tiles[x][y] = 36;}
				else if (h.equals("92ffdf")){//Corner2
					tiles[x][y] = 36;
				}
				else if (h.equals("e3ff0a")){//log1
					tiles[x][y] = 37;
				}
				else if (h.equals("b5cf08")){//log2
					tiles[x][y] = 38;
				}
				else if (h.equals("eeff4e")){//log3
					tiles[x][y] = 39;
				}
				else if (h.equals("f5ff8e")){//log4
					tiles[x][y] = 40;
				}
				
				else if (h.equals("37bfff")){ //gress til sant topp
					tiles[x][y] = 41;
				}
				else if (h.equals("15aaff")){//log4
					tiles[x][y] = 42;
				}
				else if (h.equals("094a6c")){//log4
					tiles[x][y] = 43;
				}
				else if (h.equals("52c9ff")){//log4
					tiles[x][y] = 44;
				}
				else if (h.equals("90dfff")){//log4
					tiles[x][y] = 45;
				}
				else if (h.equals("fb0088")){
					tiles[x][y] = 46;

				}
				else if (h.equals("6b3502")){
					tiles[x][y] = 47;
				}
				else if (h.equals("121212")){
					tiles[x][y] = 48;
				}
			else if (h.equals("ffffff")){
					tiles[x][y] = 49;
				}
				else if (h.equals("0f774f")){
					tiles[x][y] = 50;
				}
				else if (h.equals("08412b")){
					tiles[x][y] = 51;
				}
				else if (h.equals("fc64b9")){
					tiles[x][y] = 52;
				}
				else if (h.equals("suppe")){
					tiles[x][y] = 53;
				}
				else if (h.equals("ff66ff")){
					tiles[x][y] = 54;
				}
				else if (h.equals("cc66ff")){
					tiles[x][y] = 55;
				}
				
				
				else{
			
					tiles[x][y] = 1;
					
				}
				}
			}
		}
	
	
	
	
	public void render(Graphics g){
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				getTile(x, y).render(g, x * Game.TILESIZE * Game.SCALE, y * Game.TILESIZE * Game.SCALE);
			}
		}
	}
	public Tile getTile(int x, int y){
		switch(tiles[x][y]){
		case 1:return Tile.grass;
		//case 2:return Tile.dirt;
		case 3:return Tile.grassFLower;
		case 4:return Tile.rock;
		case 5:return Tile.tree;
	//	case 6:return Tile.wall;
		//case 7: return Tile.forrest;
		case 8: return Tile.flower;
		
		case 9: return Tile.grassPathStart;
		case 10: return Tile.grassPath1;
		case 11: return Tile.grassPath2;
		case 12: return Tile.grassCorner1;
		case 13: return Tile.grassCorner2;
		case 14: return Tile.grassPathEnd;
		
		case 15:return Tile.tree1;
		case 16:return Tile.tree3;
		case 17:return Tile.tree2;
		case 18:return Tile.tree4;
		
	
		case 19:return Tile.house2;
		case 20:return Tile.house5;
		case 21:return Tile.house8;
		case 22:return Tile.house3;
		case 23:return Tile.house6;
		case 24:return Tile.house9;
		case 25:return Tile.house4;
		case 26:return Tile.house1;
		case 27:return Tile.house7;
		
		case 31:return Tile.hillFront;
		//case 29:return Tile.hillBack;
		case 28:return Tile.hillSide1;
		case 29:return Tile.hillSide2;
		//case 32:return Tile.hillCorner1;
		//case 29:return Tile.hillCorner2;
		case 33:return Tile.hillCorner3;
		case 30:return Tile.hillCorner4;
		case 32:return Tile.hillGrassStairs;
		
		case 35:return Tile.hillCorner1;
		case 36:return Tile.hillCorner2;
		
		case 37:return Tile.log1;
		case 38:return Tile.log2;
		case 39:return Tile.log3;
		case 40:return Tile.log4;
		
		
		case 41:return Tile.coast2;
		case 42:return Tile.coast3;
		case 43:return Tile.coast5;
		case 44:return Tile.coast4;
		case 45: return Tile.coast1;
		
		case 46:return Tile.floor;
		case 47:return Tile.grassPathUp;
		case 48:return Tile.tunnel;
		
		case 49: return Tile.hillCorner6;
		case 50:return Tile.hillCorner5;
		case 51: return Tile.hillBack;
		case 52: return Tile.grassFlower2Tile;
		
		case 53: return Tile.hole;
		
		case 54: return Tile.statue1;
		case 55: return Tile.statue2;
				
		default:return Tile.grass;		
	}
}
}
