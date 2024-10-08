package tp1.p2.logic;

import java.util.Random;

import tp1.p2.logic.gameobjects.Sun;

public class SunsManager {

	private static final int COOLDOWN_RANDOM_SUN = 5;

	private GameWorld game;

	private Random rand;

	private int cooldown;
	
	private int sunsToGen;
	
	private static int catchedSuns;
	
	private static int generatedSuns;

	public SunsManager(GameWorld game, Random rand) {
		this.game = game;
		this.rand = rand;
		this.cooldown = COOLDOWN_RANDOM_SUN;
		this.sunsToGen = 0;
		catchedSuns = 0;
		generatedSuns = 0;
	}

	public static int getCatchedSuns() {
		return catchedSuns;
	}

	public static int getGeneratedSuns() {
		return generatedSuns;
	}

	public void update() {
		
		for(int i = 0;i<this.sunsToGen;i++) {
			addSun();
		}
		this.sunsToGen = 0;
		
		if (cooldown == 0) {
			addSun();
			cooldown = COOLDOWN_RANDOM_SUN;
		} else {
			cooldown--;
		}
	}

	private int getRandomInt(int bound) {
		return this.rand.nextInt(bound);
	}

	public void addSun() {
		int col = getRandomInt(GameWorld.NUM_COLS);
		int row = getRandomInt(GameWorld.NUM_ROWS);
		game.addItem(new Sun(this.game, col, row));
	}
	
	public void addSunToGen() {
		this.sunsToGen++;
	}
	
	public static void addCatchedSun() {
		catchedSuns++;
	}
	
	public static void addGenSun() {
		generatedSuns ++;
	}
	
	public static void removeGenSun() {
		generatedSuns--;
	}
	
}
