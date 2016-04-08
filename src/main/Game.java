package main;

import graphics.ImageLoader;
import graphics.ImageManager;
import graphics.SpriteSheet;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import level.Level;
import characters.Box;
import characters.Chicken;
import characters.Egg;
import characters.Fire;
import characters.Heart;

import characters.Mute;
import characters.Player;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 240,HEIGHT = 240,SCALE = 2;
	public static final int TILESIZE = 16;
	public static boolean running = false;
	public Thread gameThread;
	
	private BufferedImage spriteSheet;
	
	private BufferedImage lives6,lives5,lives4,lives3,lives2,lives1;
	
	private BufferedImage eggCount1,eggCount2,eggCount3,eggCount4,eggCount0;

	private BufferedImage img,img_choice,completed,letsgolevel2,muteimage;
	
	private BufferedImage vegg,boss,darkness,basement,house2,basement2;
	
	private static ImageManager im;
	private static Player player;
	private static Chicken chicken,chicken2,chicken3,chicken4,chicken5,chicken6;
	
	private static Egg egg,egg2,egg3,egg4,egg5,egg6,egg7,egg8;

	private static Fire fire,fire1,fire2,fire3,fire4,fire5,fire6;
	private static Heart heart,heart2;
	private static Box box,box2;

	
	private static Mute mute;
	private Audio bgmusic;
	
	private boolean bchicken1,bchicken2,bchicken3,bchicken4,bchicken5,bchicken6;
	public static boolean beentheredonethat,levelchanged1,dark,level1completed, gamecompleted,collectedmute;
	
	public static int currentState;
	
	public int chickenValue,chickenValue2,chickenValue3,chickenValue4,chickenValue5,chickenValue6;
	
	public int collectedEggs;
	public static int lives;

	private Level l1,l1house,l2,lt,l21,lboss,level21,level22,level23,level2house,level2basement,level2basement2;
	
	private int musicCounter;
	private static Exception audioExpt;
	
	
	public static Menu menu;
	public static GameOver go;

	public void init(){
		
		currentState=0;
		level1completed = false;
		gamecompleted = false;
		
		try {
			bgmusic=new Audio("/paskemorgen10.wav");
		} catch (Exception e) {
			audioExpt = e;
		}
		musicCounter=0;
		
		beentheredonethat = false;
		bchicken1=bchicken2=bchicken3=bchicken4=bchicken5=bchicken6=false;
	
		levelchanged1=false;
		
		chickenValue=0;chickenValue2 = 0;chickenValue3 =0;chickenValue4 =0;chickenValue5 =0;chickenValue6 =0;
		
		collectedEggs=0;
		lives = 6;
				
		ImageLoader loader = new ImageLoader();
		
		img = loader.load("/map.png");
		img_choice = loader.load("/choice.png");
		lives6 =loader.load("/bar.png");
		lives5 =loader.load("/lives5.png");
		lives5 =loader.load("/lives5.png");
		lives4 =loader.load("/lives4.png");
		lives3 =loader.load("/lives3.png");
		lives2 =loader.load("/lives2.png");
		lives1 =loader.load("/lives1.png");
		
		eggCount1 = loader.load("/egg1.png");
		eggCount2 = loader.load("/egg2.png");
		eggCount3 = loader.load("/egg3.png");
		eggCount4 = loader.load("/egg4.png");
		eggCount0 = loader.load("/egg0.png");
	
		vegg = loader.load("/generellvegg1.png");
		boss =loader.load("/boss-kopi.png");
		darkness =loader.load("/dark.png");
		basement =loader.load("/basement.png");
		house2 = loader.load("/house2.png");
		basement2 = loader.load("/basement2.png");
		letsgolevel2 = loader.load("/letsgolevel2.png");
		completed = loader.load("/completed.png");
		muteimage = loader.load("/mute.png");
		
		spriteSheet = loader.load("/spritesheet1-1.png");
		SpriteSheet ss = new SpriteSheet(spriteSheet);
		im = new ImageManager(ss);
		
		//Characters:
		
		menu = new Menu(img,img_choice);
		
		go = new GameOver(img,img_choice);
		
		//HUSK (86,360,im)
		player = new Player(86,160,im);
		
		mute = new Mute(250,200,im);
		
		chicken = new Chicken(130,400,im);
		chicken2 = new Chicken(144,350,im);
		chicken3 = new Chicken(385,165,im);
		chicken4 = new Chicken(230,160,im);
		chicken5 = new Chicken(130,90,im);
		chicken6 = new Chicken(320,280,im);
		
		heart = new Heart(300,80,im); heart.taken=false;
		heart2 =  new Heart(380,32,im); heart2.taken=false;
		
		
		egg = new Egg (240,410,im); egg.taken=false;
		egg2 = new Egg (35,350,im); egg2.taken=false; egg2.counted=false;
		egg3 = new Egg (130,50,im);
		egg4 = new Egg (390,300,im);
		egg5 = new Egg (66,60,im);
		
		egg6 = new Egg (120,120,im); //l21
		egg7 = new Egg (61,61,im); //trenger plass
		egg8 = new Egg(240,210,im); //i tunnel
		fire = new Fire(200,200,im);
		
		box = new Box(224,352,im);
		box2 = new Box(352,127,im);
		this.addKeyListener(new KeyManager());
		
		
		BufferedImage limage = loader.load("/level1.png");
		l1= new Level(limage);
		
		BufferedImage lhouseimage = loader.load("/HouseLevel.png");
		l1house= new Level(lhouseimage);

		BufferedImage l2image = loader.load("/level2.png");
		l2 = new Level(l2image);
		
		BufferedImage ltimage = loader.load("/tunnelLevel.png");
		lt = new Level(ltimage);
		
		BufferedImage l21image=loader.load("/level2-1.png");
		l21= new Level(l21image);
		
		BufferedImage lbossimage =loader.load("/bosslevel.png");
		lboss = new Level(lbossimage);
		
		BufferedImage level21image =loader.load("/2level.png");
		level21 = new Level(level21image);
		
		BufferedImage level22image =loader.load("/2level2.png");
		level22 = new Level(level22image);
		
		BufferedImage level23image = loader.load("/2level3.png");
		level23 = new Level(level23image);
		
		BufferedImage level2basementimage= loader.load("/2levelbasement.png");
		level2basement = new Level(level2basementimage);
		
		BufferedImage level2houseimage= loader.load("/2levelhouse.png");
		level2house = new Level(level2houseimage);
		
		BufferedImage level2basement2image= loader.load("/2levelbasement2.png");
		level2basement2 = new Level(level2basement2image);
	}
	
	public synchronized void start(){
		if (running)return;
		running = true;
		gameThread = new Thread(this);
		gameThread.start();
	}
	public synchronized void stop(){
		if(!running)return;
		running=false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run(){
		init();
		
		
		long lastTime = System.nanoTime();
	
		///HASTIGHET
		
		final double amountOfTicks = 60D;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		
		while(running){
			long now = System.nanoTime();
			delta +=((now-lastTime)/ns);
			lastTime = now;
			if(delta>=1){tick();delta--;}
			
			render();
			if(!collectedmute){bgmusic.play();}
		
		}
		stop();
	}
	
	public void tick(){
		
		player.tick();
		if (currentState==0){menu.update();}
		//else if (currentState==12){go.update();}
		//NB !!
		go.update();
		
		if (egg.taken && !egg.counted){collectedEggs+=1;egg.counted=true;}
		if (egg2.taken && !egg2.counted){collectedEggs+=1;egg2.counted=true;}
		if (egg3.taken && !egg3.counted){collectedEggs+=1;egg3.counted=true;}
		if (egg4.taken && !egg4.counted){collectedEggs+=1;egg4.counted=true;}
		if (egg5.taken && !egg5.counted){collectedEggs+=1;egg5.counted=true;}
		if (egg6.taken && !egg6.counted){collectedEggs+=1;egg6.counted=true;}
		if (egg7.taken && !egg7.counted){collectedEggs+=1;egg7.counted=true;}
		if (egg8.taken && !egg8.counted){collectedEggs+=1;egg8.counted=true;}

		if(heart.taken && !heart.counted){if(lives>=4){lives=6; heart.counted=true;}else if(lives<4){lives+=2; heart.counted=true;}}
		if(heart2.taken && !heart2.counted){if(lives>=4){lives=6; heart2.counted=true;}else if(lives<4){lives+=2; heart2.counted=true;}}
		
		if(mute.taken){collectedmute=true;}
		
		if (lives==0){currentState=12;lives+=6; player = new Player(200,340,im);}
		if (collectedEggs==4){if(!level1completed){collectedEggs-=4;player=new Player(100,350,im);level1completed = true; currentState=7;} 
		else{gamecompleted = true;}}
		
		
	}
	public void render(){
		
		//   	ikke tukl med dette:
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null){createBufferStrategy(3);return;}
		Graphics g = bs.getDrawGraphics();
		
		
		

		//RENDER HERE:-----------------------------------------
		
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		//OPPSTART / MENU :
		if(currentState ==0){g.drawImage(img, 0, 0, null);menu.render(g, img_choice);}
	
		
		//GAME OVER :
		if(currentState==12){
			g.setColor(Color.BLACK); g.fillRect(0, 0, SCALE*WIDTH, SCALE*HEIGHT); go.render(g, img_choice);}
			dark=false;
		
		if (currentState>0&&currentState!=12){
			
	
		//LEVEL 1-1
		if (currentState==1){
			l1.render(g); bchicken1=true; bchicken2=true;bchicken3 = true; bchicken4=false;bchicken5=false;bchicken6=false;
	
			if(!mute.taken){mute.render(g);}
			if((player.getPy()/30 ==getMute().getPy()/30)&&(player.getPx()/30 ==getMute().getPx()/30)){mute.taken=true;}
			
			if(mute.taken){if(musicCounter<150){g.drawImage(muteimage, 50, 50, null); musicCounter+=1;}}
			
			if (!egg2.taken){egg2.render(g);}
			if((player.getPy()/30 ==getEgg2().getPy()/30)&&(player.getPx()/30 ==getEgg2().getPx()/30)){egg2.taken=true;	}
			
			if ((l1.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){player.render(g);}
			
			//Går inn i hus:
			else if(l1.getTile(player.getPx()/30, player.getPy()/30).toString().contains("House6")){currentState = 2;}
			
			
			else if (getPlayer().up && !(l1.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player=new Player(player.getPx(),player.getPy()+5,im);
			}
			else if (getPlayer().dn && !(l1.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player=new Player(player.getPx(),player.getPy()-5,im);
			}
			else if (getPlayer().rt && !(l1.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player=new Player(player.getPx()-5,player.getPy(),im);
			}
			else if (getPlayer().lt && !(l1.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player=new Player(player.getPx()+5,player.getPy(),im);
			}
			else{ player=new Player(215,155,im);}
			
			//komme seg til lv 1-2:
			if (player.getPx()>=450){player=new Player(30,180,im);currentState=3;}

			
		}
		
		//INSIDE HOUSE:
		if (currentState==2){
			
			l1house.render(g); bchicken1=false; bchicken2=false; bchicken3=false;bchicken4=false;bchicken5=false;bchicken6=false;
			g.drawImage(vegg, 0, 0, null);
			
			if((player.getPy()/30 ==getEgg4().getPy()/30)&&(player.getPx()/30 ==getEgg4().getPx()/30)){egg4.taken=true;}
		
			if(l1house.getTile(player.getPx()/30, player.getPy()/30).toString().contains("House6")){
				currentState = 1;}
			else if(l1house.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor")){ player.render(g);}
			
			else if (getPlayer().up && !(l1house.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
				player=new Player(player.getPx(),player.getPy()+5,im);}
			else if (getPlayer().dn && !(l1house.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
				player=new Player(player.getPx(),player.getPy()-5,im);}
			else if (getPlayer().rt && !(l1house.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
				player=new Player(player.getPx()-5,player.getPy(),im);}
			else if (getPlayer().lt && !(l1house.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
				player=new Player(player.getPx()+5,player.getPy(),im);}
			else{ player = new Player(220,400,im);}
		
			if(egg4.taken==false){egg4.render(g);}}
			
		
		
	
		//LEVEL 1-2
		else if (currentState==3){
			l2.render(g);bchicken1=true;bchicken2=true; bchicken3=false; bchicken4=false;bchicken5=false;bchicken6=true;
			
			if(heart.taken==false){heart.render(g);}
			if(heart.taken==false){if(player.getPx()/32==heart.getPx()/32){if(player.getPy()/32==heart.getPy()/32){heart.taken = true;}}}
			
			if(player.getPy()>=400){player =new Player(10,440,im);currentState=5;}
			
			//går utenom gresset:
			if ((l2.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player.render(g);}
		
			//går inn i tunnel:
			else if(l2.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Tunnel")){
				if(egg.taken){player=new Player(380,180,im);}
				if(egg.taken==false){currentState = 4;}
			}
			
			//nedover:
		
			
			else if (getPlayer().up && !(l2.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player=new Player(player.getPx(),player.getPy()+5,im);
			}
			else if (getPlayer().dn && !(l2.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player=new Player(player.getPx(),player.getPy()-5,im);
			}
			else if (getPlayer().rt && !(l2.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player=new Player(player.getPx()-5,player.getPy(),im);
			}
			else if (getPlayer().lt && !(l2.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player=new Player(player.getPx()+5,player.getPy(),im);
			}
			else{ player=new Player(60,60,im);}
			
			if (player.getPx()<=20){if(player.getPy()<=250){player=new Player(420,200,im);currentState=1;}}
			
		}
		//TUNNEl:
		if (currentState==4){
			
			lt.render(g);
			g.fillRect(0, 0, 480, 480);
			bchicken1=false; bchicken2=false; bchicken3 =false;bchicken5=false;bchicken6=false;
			
			player.render(g);
			if(egg.taken==false){egg.render(g);} 
			
			if (player.getPx()<20){player=new Player(player.getPx()+5,player.getPy(),im);}
			if (player.getPx()>420){player=new Player(player.getPx()-5,player.getPy(),im);}
			if (player.getPy()<20){player=new Player(player.getPx(),player.getPy()+5,im);}
			if (player.getPy()>420){player=new Player(player.getPx(),player.getPy()-5,im);}

			
			fire.render(g);
			if (chickenValue2<20){fire.render(g);chickenValue2+=1;}
			if (chickenValue2>=20 && chickenValue2<27000000){
				
				if(player.getPx()>=fire.getPx()&&player.getPy()>=fire.getPy()){fire = new Fire(getFire().getPx()+2,getFire().getPy()+2,im);
					fire.render(g);}
				if(player.getPx()>=fire.getPx()&&player.getPy()<=fire.getPy()){
					fire = new Fire(getFire().getPx()+1,getFire().getPy()-1,im);	fire.render(g);}
				if(player.getPx()<=fire.getPx()&&player.getPy()>=fire.getPy()){
					fire = new Fire(getFire().getPx()-2,getFire().getPy()+1,im);	fire.render(g);}
				if(player.getPx()<=fire.getPx()&&player.getPy()<=fire.getPy()){
					fire = new Fire(getFire().getPx()-2,getFire().getPy()-1,im);	fire.render(g);}
				fire1 = new Fire(getFire().getPx()-30,getFire().getPy()+80,im);
				fire2 = new Fire(getFire().getPx()-60,getFire().getPy()+320,im);
				fire3 = new Fire(getFire().getPx()-190,getFire().getPy()-170,im);
				fire4 = new Fire(getFire().getPx()+100,getFire().getPy()+200,im);
				fire5 = new Fire(getFire().getPx()-220,getFire().getPy()+50,im);
				fire6 = new Fire(getFire().getPx()-150,getFire().getPy()+250,im);
				
				fire1.render(g);fire2.render(g);fire3.render(g);fire4.render(g);fire5.render(g);fire6.render(g);
				chickenValue2+=1;
			
				if((player.getPx()/30 ==getFire().getPx()/30)){if(player.getPy()/30 ==getFire().getPy()/30){player = new Player(200,70,im);lives-=1; fire = new Fire(480,480,im);}}
				if((player.getPx()/30 ==getFire1().getPx()/30)){if(player.getPy()/30 ==getFire1().getPy()/30){player = new Player(200,70,im);lives-=1; fire1 = new Fire(480,480,im);}}
				if((player.getPx()/30 ==getFire2().getPx()/30)){if(player.getPy()/30 ==getFire2().getPy()/30){player = new Player(200,70,im);lives-=1; fire2 = new Fire(480,480,im);}}
				if((player.getPx()/30 ==getFire3().getPx()/30)){if(player.getPy()/30 ==getFire3().getPy()/30){player = new Player(200,70,im);lives-=1; fire3 = new Fire(480,480,im);}}
				if((player.getPx()/30 ==getFire4().getPx()/30)){if(player.getPy()/30 ==getFire4().getPy()/30){player = new Player(200,70,im);lives-=1; fire4 = new Fire(480,480,im);}}
				if((player.getPx()/30 ==getFire5().getPx()/30)){if(player.getPy()/30 ==getFire5().getPy()/30){player = new Player(200,70,im);lives-=1; fire5 = new Fire(480,480,im);}}
				if((player.getPx()/30 ==getFire6().getPx()/30)){if(player.getPy()/30 ==getFire6().getPy()/30){player = new Player(200,70,im);lives-=1; fire6 = new Fire(480,480,im);}}}
	
		if((player.getPy()/30 ==getEgg().getPy()/30)&&(player.getPx()/30 ==getEgg().getPx()/30)){
				egg.taken=true;
				player=new Player(380,180,im);
				currentState=3;
			}}
		
		
		//NEDE:
		else if (currentState==5){
			l21.render(g); bchicken1=false; bchicken2=true; bchicken3 =false;bchicken4=true;bchicken5=true;bchicken6=true;
	
			if(egg3.taken==false){egg3.render(g);}
			
			
			//henter egg:
			if((player.getPy()/30 ==getEgg3().getPy()/30)&&(player.getPx()/30 ==getEgg3().getPx()/30)){
				if(egg3.taken!=true){egg3.taken=true;}}
			
			
			if(player.getPy()<=20){player =new Player(410,390,im);currentState=3;}
			else if ((l21.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player.render(g);}

			else if (getPlayer().up && !(l21.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player=new Player(player.getPx(),player.getPy()+5,im);
			}
			else if (getPlayer().dn && !(l21.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player=new Player(player.getPx(),player.getPy()-5,im);
			}
			else if (getPlayer().rt && !(l21.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player=new Player(player.getPx()-5,player.getPy(),im);
			}
			else if (getPlayer().lt && !(l21.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player=new Player(player.getPx()+5,player.getPy(),im);
			}
			else{ player=new Player(410,30,im);}
			
			
			
		}
		//BOSS:
		else if (currentState==6){
			lboss.render(g); bchicken1=false; bchicken2=false; bchicken3=false;bchicken4=false;bchicken5=false;bchicken6=false;
			g.drawImage(boss, 0, 0, null);
			
			//hvis faller ned stup:
			if(lboss.getTile(player.getPx()/30, player.getPy()/30).toString().contains("House6")){
				lives-=1; player=new Player(220,400,im); box=new Box(224,352,im);}
			
			//hvor kan spilleren gå:
			else if(lboss.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor")){ player.render(g);}
			
			else if (getPlayer().up && !(lboss.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
				player=new Player(player.getPx(),player.getPy()+5,im);}
			else if (getPlayer().dn && !(lboss.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
				player=new Player(player.getPx(),player.getPy()-5,im);}
			else if (getPlayer().rt && !(lboss.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
				player=new Player(player.getPx()-5,player.getPy(),im);}
			else if (getPlayer().lt && !(lboss.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
				player=new Player(player.getPx()+5,player.getPy(),im);}
			else{ player = new Player(220,400,im);}
			
			//skyving av box:sysout
			if(player.up&&player.getPx()/30==box.getPx()/30&&(player.getPy()-5)/32==box.getPy()/32){box.up=true;   }
			else if(player.dn&&player.getPx()/30==box.getPx()/30&&(player.getPy()+20)/32==box.getPy()/32){ box.dn=true;}
			if(player.lt&&(player.getPx()-7)/30==box.getPx()/30&&(player.getPy()+10)/32==box.getPy()/32){box.lt=true;}
			else if(player.rt&&(player.getPx()+7)/30==box.getPx()/30&&(player.getPy()+10)/32==box.getPy()/32){box.rt=true;}
			
			
			if (getPlayer().up && ((player.getPx()/30 == box.getPx()/30)||(player.getPx()/30 ==box.getPx()/30)||(player.getPx()/30 ==box.getPx()/30))){
				if((player.getPy()/30 ==box.getPy()/30)||(player.getPy()/30 ==box.getPy()/30)||(player.getPy()/30 ==box.getPy()/30)){
					player=new Player(player.getPx(),player.getPy()+15,im);}}
			if (getPlayer().dn && ((player.getPx()/30 ==box.getPx()/30)||(player.getPx()/30 ==box.getPx()/30)||(player.getPx()/30 ==box.getPx()/30))){
				if((player.getPy()/30 ==box.getPy()/30)||(player.getPy()/30 ==box.getPy()/30)||(player.getPy()/30 ==box.getPy()/30)){
					player=new Player(player.getPx(),player.getPy()-15,im);
				}
			}if (getPlayer().rt && ((player.getPx()/30 ==box.getPx()/30)||(player.getPx()/30 ==box.getPx()/30)||(player.getPx()/30 ==box.getPx()/30))){
				if((player.getPy()/30 ==box.getPy()/30)||(player.getPy()/30 ==box.getPy()/30)||(player.getPy()/30 ==box.getPy()/30)){
					player=new Player(player.getPx()-15,player.getPy(),im);
					}
			}if (getPlayer().lt && ((player.getPx()/30 ==box.getPx()/30)||(player.getPx()/30 ==box.getPx()/30)||(player.getPx()/30 ==box.getPx()/30))){
				if((player.getPy()/30 ==box.getPy()/30)||(player.getPy()/30 ==box.getPy()/30)||(player.getPy()/30 ==box.getPy()/30)){
					player=new Player(player.getPx()+15,player.getPy(),im);
					}
			}
			
			if(box.up){while(lboss.getTile(box.getPx()/32, (box.getPy()-3)/32).toString().contains("Floor")){
					box=new Box(box.getPx(),box.getPy()-(1),im); box.up=false;}}
			else if(box.dn){while(lboss.getTile(box.getPx()/32, (box.getPy()+30)/32).toString().contains("Floor")){
					box=new Box(box.getPx(),box.getPy()+1,im); box.dn=false;}	}
			if(box.lt){while(lboss.getTile((box.getPx()-3)/32, box.getPy()/32).toString().contains("Floor")){
					box=new Box(box.getPx()-1,box.getPy(),im);}	}
			else if(box.rt){while(lboss.getTile((box.getPx()+32)/32, box.getPy()/32).toString().contains("Floor")){box=new Box(box.getPx()+1,box.getPy(),im);}}
			
			//fullført:
			if(lboss.getTile((box.getPx()+32)/32, (box.getPy())/32).toString().contains("Rock")){
				box=new Box(box.getPx()+16,box.getPy(),im); box.render(g);
				if(egg6.taken==false){egg6.render(g);}
				if((player.getPy()/30 ==getEgg6().getPy()/30)&&(player.getPx()/30 ==getEgg6().getPx()/30)){
					if(egg6.taken!=true){egg6.taken=true; currentState=9;}}
			}	
			if(lboss.getTile((box.getPx()+16)/32, (box.getPy())/32).toString().contains("Rock")){
				box.render(g);
				if(egg6.taken==false){egg6.render(g);}
				if((player.getPy()/30 ==getEgg6().getPy()/30)&&(player.getPx()/30 ==getEgg6().getPx()/30)){
					if(egg6.taken!=true){egg6.taken=true; currentState=9;}}
			}
			box.render(g);
		}
		
		//LEVEL 2-1
		else if (currentState==7){
		level21.render(g);
		
		if(musicCounter<=310){g.drawImage(letsgolevel2,50,50,null); musicCounter+=1;}
		
		
		
		 bchicken1=true; bchicken2=false; bchicken3 =false;bchicken4=true;bchicken5=false;bchicken6=false;
		 if(egg5.taken==false){egg5.render(g);}
		 //egghenting:
		 if((player.getPy()/30 ==getEgg5().getPy()/30)&&(player.getPx()/30 ==getEgg5().getPx()/30)){
				if(egg5.taken!=true){egg5.taken=true;}}
		 
		if (player.getPy()<10){player=new Player(146,400,im);currentState=8;}
		 
		 //går inn i tunnel:
		 if((level21.getTile(player.getPx()/30, player.getPy()/30)).toString().contains("Tunnel")){
			 player = new Player(350,50,im); player.render(g);currentState=8;}
		 
		 
		 if ((level21.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){player.render(g);}
		 else if (getPlayer().up && !(level21.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player=new Player(player.getPx(),player.getPy()+5,im);
			}
			else if (getPlayer().dn && !(level21.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player=new Player(player.getPx(),player.getPy()-5,im);
			}
			else if (getPlayer().rt && !(level21.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player=new Player(player.getPx()-5,player.getPy(),im);
			}
			else if (getPlayer().lt && !(level21.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
				player=new Player(player.getPx()+5,player.getPy(),im);
			}
			else{ if(!beentheredonethat){player=new Player(260,360,im);} else{player=new Player(287,10,im);}}
			}
			
			//else if ((level21.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Flower2"))){player=new Player(150,350,im);currentState=8;}

		
		else if (currentState==8){
		
			
			level22.render(g);  bchicken1=false; bchicken2=false; bchicken3 =false;bchicken4=false;bchicken5=false;bchicken6=false;
			if (player.getPy()>=425){beentheredonethat=true;currentState=7;}
			
			if ((level22.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){player.render(g);}
			 
			 
			 else if((level22.getTile(player.getPx()/30, player.getPy()/30)).toString().contains("Tunnel")){
				 player = new Player(355,332,im); player.render(g); beentheredonethat=false; currentState=7;}
			
			 else if (getPlayer().up && !(level22.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
					player=new Player(player.getPx(),player.getPy()+5,im);
				}
				else if (getPlayer().dn && !(level22.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
					player=new Player(player.getPx(),player.getPy()-5,im);
				}
				else if (getPlayer().rt && !(level22.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
					player=new Player(player.getPx()-5,player.getPy(),im);
				}
				else if (getPlayer().lt && !(level22.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
					player=new Player(player.getPx()+5,player.getPy(),im);
				}
				else{ player=new Player(385,92,im); player.render(g);} 
			 
				if (player.getPx()>=450){player=new Player(35,180,im);currentState=9;}
		}
		else if (currentState==9){
			level23.render(g);  bchicken1=false; bchicken2=false; bchicken3 =true;bchicken4=true;bchicken5=false;bchicken6=false;
			
			if (player.getPx()<=20){player=new Player(430,150,im);currentState=8;}
			
			else if ((level23.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){player.render(g);} 
			 
			else if((level23.getTile(player.getPx()/30, player.getPy()/30)).toString().contains("House6")){
				player=new Player(200,150,im);
				currentState=10;
			}
			 
			 else if((level23.getTile(player.getPx()/30, player.getPy()/30)).toString().contains("Tunnel")){
				 if(!egg6.taken)
				 {player = new Player(355,332,im); player.render(g); currentState=6;}
				 else{player=new Player(player.getPx(),player.getPy()+5,im);}}
			 
			else if (getPlayer().up && !(level23.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
					player=new Player(player.getPx(),player.getPy()+5,im);
				}
				else if (getPlayer().dn && !(level23.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
					player=new Player(player.getPx(),player.getPy()-5,im);
				}
				else if (getPlayer().rt && !(level23.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
					player=new Player(player.getPx()-5,player.getPy(),im);
				}
				else if (getPlayer().lt && !(level23.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Grass"))){
					player=new Player(player.getPx()+5,player.getPy(),im);
				} else{ player=new Player(385,92,im); player.render(g); }}
		
		//10house:
		if (currentState==10){
			level2house.render(g); bchicken1=false; bchicken2=false; bchicken3=false;bchicken4=false;bchicken5=false;bchicken6=false;
			g.drawImage(house2, 0, 0, null);
			
			if(level2house.getTile(player.getPx()/30, player.getPy()/30).toString().contains("House6")){ player= new Player(330,380,im);
				currentState = 9;}
			if(level2house.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Rock")){currentState = 11;}
			
			else if(level2house.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor")){ player.render(g);}
			
			else if (getPlayer().up && !(level2house.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
				player=new Player(player.getPx(),player.getPy()+5,im);}
			else if (getPlayer().dn && !(level2house.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
				player=new Player(player.getPx(),player.getPy()-5,im);}
			else if (getPlayer().rt && !(level2house.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
				player=new Player(player.getPx()-5,player.getPy(),im);}
			else if (getPlayer().lt && !(level2house.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
				player=new Player(player.getPx()+5,player.getPy(),im);}
			else{ player = new Player(220,400,im);}
		
		}
		//11BASEMENT
		else if (currentState==11){
			level2basement.render(g);  bchicken1=true; bchicken2=true; bchicken3 =true;bchicken4=true;bchicken5=true;bchicken6=false;
			g.drawImage(basement, 0, 0, null);
			
			if(heart2.taken==false){heart2.render(g);}
			if(heart2.taken==false){if(player.getPx()/32==heart2.getPx()/32){if(player.getPy()/32==heart2.getPy()/32){heart2.taken = true;}}}
			
			//if(player.getPy()>=400){player =new Player(10,440,im);currentState=5;}
			//if (player.getPx()<=20){player=new Player(430,150,im);currentState=8;}
			dark=true;
			if(egg7.taken==false){egg7.render(g);}
			 //egghenting:
			 if((player.getPy()/30 ==getEgg7().getPy()/30)&&(player.getPx()/30 ==getEgg7().getPx()/30)){
					if(egg7.taken!=true){egg7.taken=true;}}
			 
			
			box2.render(g);
			if (getPlayer().rt && ((player.getPx()/30 ==box2.getPx()/30)||(player.getPx()/30 ==box2.getPx()/30)||(player.getPx()/30 ==box2.getPx()/30))){
				if((player.getPy()/30 ==box2.getPy()/30)||(player.getPy()/30 ==box2.getPy()/30)||(player.getPy()/30 ==box2.getPy()/30)){
					player=new Player(player.getPx()-15,player.getPy(),im);
					box2.rt=true;
					}}
			else if(box2.rt){while(lboss.getTile((box2.getPx()+32)/32, box2.getPy()/32).toString().contains("Floor")){box2=new Box(box2.getPx()+1,box2.getPy(),im);}}
			
			
			if ((level2basement.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){player.render(g);} 
			 
			 else if((level2basement.getTile(player.getPx()/30, player.getPy()/30)).toString().contains("Rock")){ player=new Player(180,400,im); dark=false;
				 currentState=10;
			 }
			
			 else if((level2basement.getTile(player.getPx()/30, player.getPy()/30)).toString().contains("House6")){
				 if(!egg8.taken)
				 {player = new Player(205,210,im); player.render(g); currentState=13;}
				 else{player=new Player(player.getPx()-5,player.getPy(),im);}}
			 
			else if (getPlayer().up && !(level2basement.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
					player=new Player(player.getPx(),player.getPy()+5,im);
				}
				else if (getPlayer().dn && !(level2basement.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
					player=new Player(player.getPx(),player.getPy()-5,im);
				}
				else if (getPlayer().rt && !(level2basement.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
					player=new Player(player.getPx()-5,player.getPy(),im);
				}
				else if (getPlayer().lt && !(level2basement.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
					player=new Player(player.getPx()+5,player.getPy(),im);
				} else{ player=new Player(40,400,im); player.render(g); }}
	

		if (currentState==13){
			level2basement2.render(g); bchicken1=false; bchicken2=false; bchicken3=false;bchicken4=false;bchicken5=false;bchicken6=false;
			g.drawImage(basement2, 0, 0, null);
			
			if((level2basement2.getTile(player.getPx()/30, player.getPy()/30)).toString().contains("House6")){
				player = new Player(395,52,im); currentState=11;}
			
			if(level2basement2.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor")){ player.render(g);}
			
			else if (getPlayer().up && !(level2basement2.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
				player=new Player(player.getPx(),player.getPy()+5,im);}
			else if (getPlayer().dn && !(level2basement2.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
				player=new Player(player.getPx(),player.getPy()-5,im);}
			else if (getPlayer().rt && !(level2basement2.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
				player=new Player(player.getPx()-5,player.getPy(),im);}
			else if (getPlayer().lt && !(level2basement2.getTile(player.getPx()/30, player.getPy()/30).toString().contains("Floor"))){
				player=new Player(player.getPx()+5,player.getPy(),im);}
			else{ player = new Player(220,200,im);}
			
			if(egg8.taken==false){egg8.render(g);}
			 //egghenting:
			 if((player.getPy()/30 ==getEgg8().getPy()/30)&&(player.getPx()/30 ==getEgg8().getPx()/30)){
					if(egg8.taken!=true){egg8.taken=true;}}
				 
		
		}
		
		
		
		//------------------
		
	
		if(gamecompleted){dark= false; g.drawImage(completed,50,50,null);}
		
		if(bchicken1){
			if (chickenValue<200){chicken.render(g);chickenValue+=1;}
			if (chickenValue>=200){getChicken().happy=true;chicken.render(g);chickenValue+=1;}
			if (chickenValue>250){getChicken().happy=false;chickenValue=0;chicken.render(g);}
			if (getPlayer().up && ((player.getPx()/30 ==getChicken().getPx()/30)||(player.getPx()/30 ==getChicken().getPx()/30)||(player.getPx()/30 ==getChicken().getPx()/30))){
				if((player.getPy()/30 ==getChicken().getPy()/30)||(player.getPy()/30 ==getChicken().getPy()/30)||(player.getPy()/30 ==getChicken().getPy()/30)){
					player=new Player(player.getPx(),player.getPy()+15,im);
					player.angry=true;
					lives-=1;
					}}
			if (getPlayer().dn && ((player.getPx()/30 ==getChicken().getPx()/30)||(player.getPx()/30 ==getChicken().getPx()/30)||(player.getPx()/30 ==getChicken().getPx()/30))){
				if((player.getPy()/30 ==getChicken().getPy()/30)||(player.getPy()/30 ==getChicken().getPy()/30)||(player.getPy()/30 ==getChicken().getPy()/30)){
					player=new Player(player.getPx(),player.getPy()-15,im);
					player.angry=true;
					lives-=1;}
			}if (getPlayer().rt && ((player.getPx()/30 ==getChicken().getPx()/30)||(player.getPx()/30 ==getChicken().getPx()/30)||(player.getPx()/30 ==getChicken().getPx()/30))){
				if((player.getPy()/30 ==getChicken().getPy()/30)||(player.getPy()/30 ==getChicken().getPy()/30)||(player.getPy()/30 ==getChicken().getPy()/30)){
					player=new Player(player.getPx()-15,player.getPy(),im);
					player.angry=true;
					lives-=1;}
			}if (getPlayer().lt && ((player.getPx()/30 ==getChicken().getPx()/30)||(player.getPx()/30 ==getChicken().getPx()/30)||(player.getPx()/30 ==getChicken().getPx()/30))){
				if((player.getPy()/30 ==getChicken().getPy()/30)||(player.getPy()/30 ==getChicken().getPy()/30)||(player.getPy()/30 ==getChicken().getPy()/30)){
					player=new Player(player.getPx()+15,player.getPy(),im);
					player.angry=true;
					lives-=1;}
			}}
		if(bchicken2){
			if (chickenValue2<30){chicken2.render(g);chickenValue2+=1;} if (chickenValue2>=30 && chickenValue2<130){
					chicken2 = new Chicken(getChicken2().getPx()-1,getChicken2().getPy(),im);
					getChicken2().lt=true;chickenValue2+=1;chicken2.render(g);}
				if (chickenValue2>=130 && chickenValue2<200){
					getChicken2().lt=false;chicken2 = new Chicken(getChicken2().getPx(),getChicken2().getPy(),im);
					getChicken2().happy=true;
					getChicken2().lt=false;chicken2.render(g);chickenValue2+=1;	}
				if(chickenValue2>=200 && chickenValue2<300){
					chicken2 = new Chicken(getChicken2().getPx()+1,getChicken2().getPy(),im);
					getChicken2().rt=true;chickenValue2+=1;chicken2.render(g);}
				if (chickenValue2>=300){chickenValue2-=300;chicken2.render(g);}
		
		if (getPlayer().dn && ((player.getPx()/30 ==getChicken2().getPx()/30)||(player.getPx()/30 ==getChicken2().getPx()/30)||(player.getPx()/30 ==getChicken2().getPx()/30))){
			if((player.getPy()/30 ==getChicken2().getPy()/30)||(player.getPy()/30 ==getChicken2().getPy()/30)||(player.getPy()/30 ==getChicken2().getPy()/30)){
				player=new Player(player.getPx(),player.getPy()-15,im);
				player.angry=true;
				lives-=1;}
		}if (getPlayer().rt && ((player.getPx()/30 ==getChicken2().getPx()/30)||(player.getPx()/30 ==getChicken2().getPx()/30)||(player.getPx()/30 ==getChicken2().getPx()/30))){
			if((player.getPy()/30 ==getChicken2().getPy()/30)||(player.getPy()/30 ==getChicken2().getPy()/30)||(player.getPy()/30 ==getChicken2().getPy()/30)){
				player=new Player(player.getPx()-15,player.getPy(),im);
				player.angry=true;
				lives-=1;}
		}if (getPlayer().lt && ((player.getPx()/30 ==getChicken2().getPx()/30)||(player.getPx()/30 ==getChicken2().getPx()/30)||(player.getPx()/30 ==getChicken2().getPx()/30))){
			if((player.getPy()/30 ==getChicken2().getPy()/30)||(player.getPy()/30 ==getChicken2().getPy()/30)||(player.getPy()/30 ==getChicken2().getPy()/30)){
				player=new Player(player.getPx()+15,player.getPy(),im);
				player.angry=true;
				lives-=1;}
		}
		else if((player.getPx()/30 ==getChicken2().getPx()/30)){
			if(player.getPy()/30 ==getChicken2().getPy()/30){
				player=new Player(200,350,im);
				player.angry=true;
				lives-=1;
			}}
		}
	
		if(bchicken3){if (chickenValue3<20){chicken3.render(g);chickenValue3+=1;}
			if (chickenValue3>=20){getChicken3().happy=true;chicken3.render(g);chickenValue3+=1;}
			if (chickenValue3>25){getChicken3().happy=false;chickenValue3=0;chicken3.render(g);}
			if (getPlayer().dn && ((player.getPx()/30 ==getChicken3().getPx()/30)||(player.getPx()/30 ==getChicken3().getPx()/30)||(player.getPx()/30 ==getChicken3().getPx()/30))){
				if((player.getPy()/30 ==getChicken3().getPy()/30)||(player.getPy()/30 ==getChicken3().getPy()/30)||(player.getPy()/30 ==getChicken3().getPy()/30)){
					player=new Player(player.getPx(),player.getPy()-15,im);
					player.angry=true;
					lives-=1;}
			}if (getPlayer().rt && ((player.getPx()/30 ==getChicken3().getPx()/30)||(player.getPx()/30 ==getChicken3().getPx()/30)||(player.getPx()/30 ==getChicken3().getPx()/30))){
				if((player.getPy()/30 ==getChicken3().getPy()/30)||(player.getPy()/30 ==getChicken3().getPy()/30)||(player.getPy()/30 ==getChicken3().getPy()/30)){
					player=new Player(player.getPx()-15,player.getPy(),im);
					player.angry=true;
					lives-=1;}
			}if (getPlayer().lt && ((player.getPx()/30 ==getChicken3().getPx()/30)||(player.getPx()/30 ==getChicken3().getPx()/30)||(player.getPx()/30 ==getChicken3().getPx()/30))){
				if((player.getPy()/30 ==getChicken3().getPy()/30)||(player.getPy()/30 ==getChicken3().getPy()/30)||(player.getPy()/30 ==getChicken3().getPy()/30)){
					player=new Player(player.getPx()+15,player.getPy(),im);
					player.angry=true;
					lives-=1;}
			}
			else if((player.getPx()/30 ==getChicken3().getPx()/30)){
				if(player.getPy()/30 ==getChicken3().getPy()/30){
					player=new Player(60,120,im);
					player.angry=true;
					lives-=1;
				}}}
		
		
		if(bchicken4){
			if (chickenValue4<30){chicken4.render(g);chickenValue4+=1;} 
				if (chickenValue4>=30 && chickenValue4<200){
					chicken4 = new Chicken(getChicken4().getPx()-1,getChicken4().getPy(),im);
					getChicken4().lt=true;chickenValue4+=1;chicken4.render(g);}
				if(chickenValue4>=200 && chickenValue4<370){
					chicken4 = new Chicken(getChicken4().getPx()+1,getChicken4().getPy(),im);
					getChicken4().rt=true;chickenValue4+=1;chicken4.render(g);}
				if (chickenValue4>=370){chickenValue4-=370;chicken4.render(g);}
		
		if (getPlayer().dn && ((player.getPx()/30 ==getChicken4().getPx()/30)||(player.getPx()/30 ==getChicken4().getPx()/30)||(player.getPx()/30 ==getChicken4().getPx()/30))){
			if((player.getPy()/30 ==getChicken4().getPy()/30)||(player.getPy()/30 ==getChicken4().getPy()/30)||(player.getPy()/30 ==getChicken4().getPy()/30)){
				player=new Player(player.getPx(),player.getPy()-15,im);
				player.angry=true;
				lives-=1;}
		}if (getPlayer().rt && ((player.getPx()/30 ==getChicken4().getPx()/30)||(player.getPx()/30 ==getChicken4().getPx()/30)||(player.getPx()/30 ==getChicken4().getPx()/30))){
			if((player.getPy()/30 ==getChicken4().getPy()/30)||(player.getPy()/30 ==getChicken4().getPy()/30)||(player.getPy()/30 ==getChicken4().getPy()/30)){
				player=new Player(player.getPx()-15,player.getPy(),im);
				player.angry=true;
				lives-=1;}
		}if (getPlayer().lt && ((player.getPx()/30 ==getChicken4().getPx()/30)||(player.getPx()/30 ==getChicken4().getPx()/30)||(player.getPx()/30 ==getChicken4().getPx()/30))){
			if((player.getPy()/30 ==getChicken4().getPy()/30)||(player.getPy()/30 ==getChicken4().getPy()/30)||(player.getPy()/30 ==getChicken4().getPy()/30)){
				player=new Player(player.getPx()+15,player.getPy(),im);
				player.angry=true;
				lives-=1;}
		}
		else if((player.getPx()/30 ==getChicken4().getPx()/30)){
			if(player.getPy()/30 ==getChicken4().getPy()/30){
				player=new Player(230,160,im);
				player.angry=true;
				lives-=1;
			}}
		}
		
		
		
		if(bchicken5){
			if (chickenValue5<30){chicken5.render(g);chickenValue5+=1;} 
				if (chickenValue5>=30 && chickenValue5<115){
					chicken5 = new Chicken(getChicken5().getPx(),getChicken5().getPy()-1,im);
					getChicken5().dn=true;chickenValue5+=1;chicken5.render(g);}
				if(chickenValue5>=115 && chickenValue5<200){
					chicken5 = new Chicken(getChicken5().getPx(),getChicken5().getPy()+1,im);
					getChicken5().up=true;chickenValue5+=1;chicken5.render(g);}
				if (chickenValue5>=200){chickenValue5-=200;chicken5.render(g);}
		
		if (getPlayer().dn && ((player.getPx()/30 ==getChicken5().getPx()/30)||(player.getPx()/30 ==getChicken5().getPx()/30)||(player.getPx()/30 ==getChicken5().getPx()/30))){
			if((player.getPy()/30 ==getChicken5().getPy()/30)||(player.getPy()/30 ==getChicken5().getPy()/30)||(player.getPy()/30 ==getChicken5().getPy()/30)){
				player=new Player(player.getPx(),player.getPy()-15,im);
				player.angry=true;
				lives-=1;}
		}if (getPlayer().rt && ((player.getPx()/30 ==getChicken5().getPx()/30)||(player.getPx()/30 ==getChicken5().getPx()/30)||(player.getPx()/30 ==getChicken5().getPx()/30))){
			if((player.getPy()/30 ==getChicken5().getPy()/30)||(player.getPy()/30 ==getChicken5().getPy()/30)||(player.getPy()/30 ==getChicken5().getPy()/30)){
				player=new Player(player.getPx()-15,player.getPy(),im);
				player.angry=true;
				lives-=1;}
		}if (getPlayer().lt && ((player.getPx()/30 ==getChicken5().getPx()/30)||(player.getPx()/30 ==getChicken5().getPx()/30)||(player.getPx()/30 ==getChicken5().getPx()/30))){
			if((player.getPy()/30 ==getChicken5().getPy()/30)||(player.getPy()/30 ==getChicken5().getPy()/30)||(player.getPy()/30 ==getChicken5().getPy()/30)){
				player=new Player(player.getPx()+15,player.getPy(),im);
				player.angry=true;
				lives-=1;}
		}
		else if((player.getPx()/30 ==getChicken5().getPx()/30)){
			if(player.getPy()/30 ==getChicken5().getPy()/30){
				player=new Player(230,160,im);
				player.angry=true;
				lives-=1;
			}}
		}
		if(bchicken6){
			if (chickenValue6<30){chicken6.render(g);chickenValue6+=1;} 
				if (chickenValue6>=30 && chickenValue6<200){
					chicken6 = new Chicken(getChicken6().getPx()-1,getChicken6().getPy(),im);
					getChicken6().lt=true;chickenValue6+=1;chicken6.render(g);}
				if(chickenValue6>=200 && chickenValue6<370){
					chicken6 = new Chicken(getChicken6().getPx()+1,getChicken6().getPy(),im);
					getChicken6().rt=true;chickenValue6+=1;chicken6.render(g);}
				if (chickenValue6>=370){chickenValue6-=370;chicken6.render(g);}
		
		if (getPlayer().dn && ((player.getPx()/30 ==getChicken6().getPx()/30)||(player.getPx()/30 ==getChicken6().getPx()/30)||(player.getPx()/30 ==getChicken6().getPx()/30))){
			if((player.getPy()/30 ==getChicken6().getPy()/30)||(player.getPy()/30 ==getChicken6().getPy()/30)||(player.getPy()/30 ==getChicken6().getPy()/30)){
				player=new Player(player.getPx(),player.getPy()-15,im);
				player.angry=true;
				lives-=1;}
		}if (getPlayer().rt && ((player.getPx()/30 ==getChicken6().getPx()/30)||(player.getPx()/30 ==getChicken6().getPx()/30)||(player.getPx()/30 ==getChicken6().getPx()/30))){
			if((player.getPy()/30 ==getChicken6().getPy()/30)||(player.getPy()/30 ==getChicken6().getPy()/30)||(player.getPy()/30 ==getChicken6().getPy()/30)){
				player=new Player(player.getPx()-15,player.getPy(),im);
				player.angry=true;
				lives-=1;}
		}if (getPlayer().lt && ((player.getPx()/30 ==getChicken6().getPx()/30)||(player.getPx()/30 ==getChicken6().getPx()/30)||(player.getPx()/30 ==getChicken6().getPx()/30))){
			if((player.getPy()/30 ==getChicken6().getPy()/30)||(player.getPy()/30 ==getChicken6().getPy()/30)||(player.getPy()/30 ==getChicken6().getPy()/30)){
				player=new Player(player.getPx()+15,player.getPy(),im);
				player.angry=true;
				lives-=1;}
		}
		else if((player.getPx()/30 ==getChicken6().getPx()/30)){
			if(player.getPy()/30 ==getChicken6().getPy()/30){
				player=new Player(230,120,im);
				player.angry=true;
				lives-=1;
			}}}
		if (dark){g.drawImage(darkness, (player.getPx()-550), (player.getPy()-510), null);}
		
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
		g.drawString("--- LIFE --- ", 8, 30);
		g.drawString("--- EGGS! --- ", 100, 30);
		if(lives>=6){g.drawImage(lives6, 20,37, null);}
		if(lives==5){g.drawImage(lives5, 20,37, null);}
		if(lives==4){g.drawImage(lives4, 20,37, null);}
		if(lives==3){g.drawImage(lives3, 20,37, null);}
		if(lives==2){g.drawImage(lives2, 20,37, null);}
		if(lives==1){g.drawImage(lives1, 20,37, null);}
		
		if(collectedEggs==0){g.drawImage(eggCount0, 100, 37, null);}
		if(collectedEggs==1){g.drawImage(eggCount1, 100, 37, null);}
		if(collectedEggs==2){g.drawImage(eggCount2, 100, 37, null);}
		if(collectedEggs==3){g.drawImage(eggCount3, 100, 37, null);}
		if(collectedEggs==4){g.drawImage(eggCount4, 100, 37, null);}
		
		
		
		}
		//-------------------
		
		
		
		
		//END RENTER:---------------------------------------------
		
		
		
		
		
		
		g.dispose();
		bs.show();
		
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		game.setMaximumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		game.setMinimumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		
		JFrame frame = new JFrame(".....Bunny in Wonderland.....");
		frame.setSize(WIDTH*SCALE,HEIGHT*SCALE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(game);
		frame.setVisible(true);
		if(audioExpt != null){
			JOptionPane.showMessageDialog(frame, audioExpt.getMessage());
		}

		game.start();
	}

	public static Player getPlayer(){
		return player;
		
	}
	
	public static Menu getMenu(){
		return menu;
	}
	public static ImageManager getImageManager(){
		return im;
	}
	public static Chicken getChicken(){
		return chicken;
	}
	public static Chicken getChicken2(){
		return chicken2;
	}
	public static Chicken getChicken3(){
		return chicken3;
	}
	public static Chicken getChicken4(){
		return chicken4;
	}
	
	public static Chicken getChicken5(){
		return chicken5;
	}
	public static Chicken getChicken6(){
		return chicken6;
	}
	
	public void setChicken2(Chicken c){
		chicken2 = c;
	}
	public static Egg getEgg(){
		return egg;
	}
	public static Egg getEgg2(){
		return egg2;
	}public static Egg getEgg3(){
		return egg3;
	}public static Egg getEgg4(){
		return egg4;
	}
	public static Egg getEgg8(){
		return egg8;
	}
	public static Egg getEgg6(){
		return egg6;
	}
	public static Egg getEgg7(){
		return egg7;
	}
	public static Egg getEgg5(){
		return egg5;
	}
	public static Mute getMute(){
		return mute;
	}
	
	public static Fire getFire(){return fire;}
	public static Fire getFire1(){return fire1;}
	public static Fire getFire2(){return fire2;}
	public static Fire getFire3(){return fire3;}
	public static Fire getFire4(){return fire4;}
	public static Fire getFire5(){return fire5;}
	public static Fire getFire6(){return fire6;}

	public static GameOver getGameOver() {
		return go;
	}



	
		
}




