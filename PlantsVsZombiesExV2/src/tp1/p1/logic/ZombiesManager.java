package tp1.p1.logic;

import java.util.Random;

import tp1.p1.control.Level;
import tp1.p1.logic.gameobjects.ZombieList;

/**
 * Manage zombies in the game.
 *
 */
public class ZombiesManager {

	private Game game;

	private Level level;

	private Random rand;

	private int remainingZombies;

	private ZombieList zombieList;

	public ZombiesManager(Game game, Level level, Random rand) {
		this.game = game;
		this.level = level;
		this.rand = rand;
		this.remainingZombies = level.getNumberOfZombies();
		this.zombieList = new ZombieList(this.remainingZombies);
	}
	/**
	 * Checks if the game should add (if possible) a zombie to the game.
	 * 
	 * @return <code>true</code> if a zombie should be added to the game.
	 */
	private boolean shouldAddZombie() {
		return rand.nextDouble() < level.getZombieFrequency();
	}
	
	
	/**
	 * Return a random row within the board limits.
	 * 
	 * @return a random row.
	 */
	
	public int zombiesOnBoard() {
		return zombieList.getCont();
	}
	private int randomZombieRow() {
		return rand.nextInt(Game.NUM_ROWS);
	}
	
	public boolean addZombie() {
		int row = randomZombieRow();
		return addZombie(row);
	}

	public boolean addZombie(int row) {
		boolean canAdd = getRemainingZombies() > 0 && shouldAddZombie()
				&& game.isEmpty(Game.NUM_COLS, row);

		if(canAdd) {
			zombieList.addZombie(row);
			this.remainingZombies--;
		}
		return canAdd;
	}
	
	public void moveZombie(int i) {
		zombieList.moveZombie(i);
	}
	
	public void damageZombie(int i) {
		zombieList.damageZombie(i);
	}
	
	public int getRemainingZombies() {
		return remainingZombies;
	}
	
	public boolean isEmpty(int col, int row) {
		return zombieList.isEmpty(col, row);
	}

	public boolean zombiesAlive() {
		return zombieList.zombiesAlive();
	}
	
	public String printZombie(int col, int row){
		
		return zombieList.printZombie(col,row);
	}
	
	public int getCont() {
		return zombieList.getCont();
	}
	
	public boolean isAlive(int i) {
		return zombieList.isAlive(i);
	}
	
	public int getRow(int i) {
		return zombieList.getRow(i);
	}
	
	public int getCol(int i) {
		return zombieList.getCol(i);
	}
	
	public boolean checkDefeat() {
		return zombieList.checkDefeat();
	}
	
	public void checkDeath() {
		for(int i = 0; i < zombieList.getCont(); i++) {
			zombieList.checkDeath(i);
		}
	}
	public int getAliveZ() {
		return zombieList.getAliveZ();
	}

}
