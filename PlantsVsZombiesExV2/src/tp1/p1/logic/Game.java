package tp1.p1.logic;

import java.util.Random;

import tp1.p1.control.Level;
import tp1.p1.logic.gameobjects.Peashooter;
import tp1.p1.logic.gameobjects.PeashooterList;
import tp1.p1.logic.gameobjects.Sunflower;
import tp1.p1.logic.gameobjects.SunflowerList;
import tp1.p1.view.Messages;


public class Game {

	public static final int NUM_ROWS = 4;
	public static final int NUM_COLS = 8;
	public static final int NUM_SOLES = 50;
	
	private PeashooterList PSList;
	private SunflowerList SFList;
	private ZombiesManager ZM;
	private int nCiclos;
	private int nSoles;
	private Random rand;
	private long semilla;
	private Level nivel;

	public Game(long seed, Level level) {
		semilla = seed;
		nivel = level;
		nCiclos = 0;
		rand = new Random();
		rand.setSeed(seed);
		nSoles = NUM_SOLES;
		PSList = new PeashooterList();
		SFList = new SunflowerList();
		ZM = new ZombiesManager(this, nivel, rand);
		
	}
	
	public int getNumberOfCicles() {
		return nCiclos;
	}

	public int getRemainingZombies() {
		return ZM.getRemainingZombies();
	}

	public int getSuncoins() {
		return nSoles;
	}
	
	public String positionToString(int col, int row) {
		
        String sol = " ";
       
        if(!isEmpty(col, row)) {
			if(!ZM.isEmpty(col, row)){
				sol = ZM.printZombie(col, row);
			}
			else if(!SFList.isEmpty(col,row)){
				sol = SFList.printSF(col, row);
			}
			else if(!PSList.isEmpty(col, row)){
				sol = PSList.printPS(col, row);
			}
        }
        return sol;
    }
	
	public boolean isEmpty(int col, int row) {
		
		if(ZM.isEmpty(col, row) && PSList.isEmpty(col, row) && SFList.isEmpty(col, row)) {
			return true;
		}
		return false;
	}
	
	public void reset() {
		PSList = new PeashooterList();
		SFList = new SunflowerList();
		ZM = new ZombiesManager(this, nivel, rand);
		nCiclos = 0;
		nSoles = NUM_SOLES;
	}
	
	public void update() {
		this.nCiclos++;
		//sun generation
		this.nSoles += SFList.generateSun();
		
		//PS attack
		for(int i = 0; i < PSList.getCont(); i++) {
			int x = PSList.getCol(i) + 1;
			while(ZM.isEmpty(x, PSList.getRow(i)) && x < NUM_COLS - 1) {
				x++;
				//TODO
			}
			if(!ZM.isEmpty(x, PSList.getRow(i))) {
				for(int z = 0; z  < ZM.getCont(); z++) {
					if(ZM.getCol(z) == x && ZM.getRow(z) == PSList.getRow(i)) {
						ZM.damageZombie(z);
					}
				}
			}
		}
		//zombie move
		for(int i = 0; i < ZM.getCont(); i++) {
			if(ZM.isAlive(i) && isEmpty(ZM.getCol(i) - 1, ZM.getRow(i))) {
				ZM.moveZombie(i);
			}
		}
		//zombie attack
		for(int i = 0; i < ZM.getCont(); i++) {
			if(ZM.isAlive(i) && !isEmpty(ZM.getCol(i) - 1, ZM.getRow(i))) {
				damagePlant(ZM.getCol(i) - 1, ZM.getRow(i));
			}
		}
		//check death
		this.checkDeath();
		
	}
	
	public void damagePlant(int c, int r) {
		PSList.damage(c, r);
		SFList.damage(c, r);
		
	}
	
	public void checkDeath() {
		for(int i = 0; i < PSList.getCont(); i++) {
			if(PSList.getHp(i) == 0) {
				PSList.kill(i);
			}
		}
		for(int i = 0; i < SFList.getCont(); i++) {
			if(SFList.getHp(i) == 0) {
				SFList.kill(i);
			}
		}
		ZM.checkDeath();
		
	}
	
	public boolean plantar(int col, int row, char x) {
		if(isEmpty(col, row)){
			switch(x){
				case 'p':
				if(this.nSoles >= Peashooter.COST){
					PSList.addPS(col, row);
					nSoles -= Peashooter.COST;
					return true;
				}
				else {
					System.out.println(Messages.NOT_ENOUGH_COINS);
				}
				break;
				case 's':
				if(this.nSoles >= Sunflower.COST){
					SFList.addSF(col, row);
					nSoles -= Sunflower.COST;
					return true;
				}
				else {
					System.out.println(Messages.NOT_ENOUGH_COINS);
				}
				break;
			}
		}
		System.out.println(Messages.POSITION_FILLED);
		return false;
	}
	
	public boolean checkVictory() {
		if(!ZM.zombiesAlive() && ZM.getRemainingZombies() == 0) {
			return true;
		}
		return false;
	}

	public boolean checkDefeat(){
		return ZM.checkDefeat();
	}

	public void gameAction() {
		ZM.addZombie();
	}
	
	
	


}
