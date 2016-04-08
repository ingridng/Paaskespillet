package graphics;

import java.awt.image.BufferedImage;

public class ImageManager {

	
	public BufferedImage kvikk, box,mute,statue1Tile,statue2Tile, holeTile,chicken_dn,heart,grassFlower2Tile, hillCorner5Tile, hillCorner6Tile, fire, TunnelTile,grassPathUpTile, player_angry, floorTile, coast1Tile,coast2Tile,coast3Tile,coast4Tile,coast5Tile, egg,log1Tile,log2Tile,log3Tile,log4Tile,chicken_happy,chicken,chicken_up,chicken_lt,chicken_rt,hillSide1Tile,hillSide2Tile,hillGrassStairsTile,hillCorner4Tile,hillCorner3Tile,hillCorner2Tile,hillFrontTile,hillBackTile,hillCorner1Tile,house9Tile,house1Tile, house2Tile, house3Tile, house4Tile, house5Tile, house6Tile, house7Tile,house8Tile,tree1Tile,tree2Tile,tree3Tile,tree4Tile,player,player_up, player_rt,player_lt,grassTile,stoneTile, treeTile, rockTile, dirtTile, wallTile,forrestTile,flowerTile,grassPathEndTile,grassPathStartTile,grassCorner1Tile,grassCorner2Tile,grassPath1Tile,grassPath2Tile,grassFlowerTile;
	
	
	public ImageManager(SpriteSheet ss){
		
		
		//player:
		player = ss.crop(0,0,16,16);
		player_up = ss.crop(1, 1, 16, 16);
		player_lt = ss.crop(3, 1, 16, 16);
		player_rt = ss.crop(2, 1, 16, 16);
		player_angry = ss.crop(4, 7, 16, 16);
		
		//chicken:
		chicken = ss.crop(4,1,16,16);
		chicken_up = ss.crop(4,1,16,16);
		chicken_lt = ss.crop(0,3,16,16);
		chicken_rt = ss.crop(0,4,16,16);
		chicken_happy = ss.crop(0, 1, 16, 16);
		chicken_dn =ss.crop(7, 5, 16, 16);
		//egg:
		egg =ss.crop(6, 1, 16, 16);
		
		//heart:
		heart=ss.crop(2, 4, 16, 16);
		//fire
		fire =ss.crop(7, 2, 16, 16);
		
		//box:
		box=ss.crop(0, 5, 16, 16);
		
		kvikk=ss.crop(2, 0, 16, 16);
		
		
		grassTile = ss.crop(1,0,16,16);
		//stoneTile = ss.crop(2, 0, 16, 16);
		treeTile = ss.crop(3, 0, 16, 16);
		rockTile = ss.crop(4, 0, 16, 16);
		//dirtTile = ss.crop(5, 0, 16, 16);
		//wallTile = ss.crop(6, 0, 16, 16);
		mute = ss.crop(5, 1, 16,16);
		flowerTile = ss.crop(7, 0, 16,16);
		grassFlowerTile = ss.crop(7, 1, 16, 16);
		
		//tree:
		tree1Tile = ss.crop(0, 6, 16, 16);
		tree2Tile = ss.crop(0, 7, 16, 16);
		tree3Tile = ss.crop(1, 6, 16, 16);
		tree4Tile = ss.crop(1, 7, 16, 16);
		
		//house:
		house1Tile = ss.crop(4, 3, 16, 16);
		house2Tile = ss.crop(4, 4, 16, 16);
		house3Tile = ss.crop(4, 5, 16, 16);
		house4Tile = ss.crop(5, 3, 16, 16);
		house5Tile = ss.crop(5, 4, 16, 16);
		house6Tile = ss.crop(5, 5, 16, 16);
		house7Tile = ss.crop(6, 3, 16, 16);
		house8Tile = ss.crop(6, 4, 16, 16);
		house9Tile = ss.crop(6, 5, 16, 16);

		floorTile = ss.crop(6,7, 16, 16);
		
		//grassPath:
		grassCorner1Tile = ss.crop(3,2,16,16);
		grassCorner2Tile = ss.crop(4,2,16,16);
		grassPath1Tile = ss.crop(1,2,16,16);
		grassPath2Tile = ss.crop(2,2,16,16);
		grassPathStartTile = ss.crop(0,2,16,16);
		grassPathEndTile = ss.crop(5,2,16,16);
		grassPathUpTile =ss.crop(6,2, 16, 16);
		grassFlower2Tile=ss.crop(7, 0, 16, 16);
		
		//hill:
		hillFrontTile = ss.crop(7,3,16,16);
		hillBackTile = ss.crop(7,4,16,16);
		hillCorner1Tile = ss.crop(2,5,16,16);
		hillCorner2Tile = ss.crop(1,5,16,16);
		hillCorner3Tile = ss.crop(3,5,16,16);
		hillCorner4Tile = ss.crop(2,7,16,16);
		hillSide1Tile = ss.crop(2,6,16,16);
		hillSide2Tile = ss.crop(5,0,16,16);
		hillGrassStairsTile = ss.crop(6,6,16,16);
		hillCorner5Tile = ss.crop(6,0,16,16);
		hillCorner6Tile = ss.crop(2,0,16,16);
		//log:
		log1Tile = ss.crop(3,6,16,16);
		log2Tile = ss.crop(3,7,16,16);
		log3Tile = ss.crop(4,6,16,16);
		log4Tile = ss.crop(5,6,16,16);
	
		//coast:
		coast1Tile = ss.crop(3,4,16,16);
		coast2Tile = ss.crop(1,3,16,16);
		coast3Tile = ss.crop(2,3,16,16);
		coast4Tile = ss.crop(3,3,16,16);
		coast5Tile = ss.crop(1,4,16,16);

		//tunnel:
		TunnelTile = ss.crop(5, 7, 16, 16);
		
		holeTile = ss.crop(0, 5, 16, 16);
		//statue:
		statue1Tile = ss.crop(7, 6, 16, 16);
		statue2Tile = ss.crop(7, 7, 16, 16);

	}
	
	
}
