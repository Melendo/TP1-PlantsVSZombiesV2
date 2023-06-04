package tp1.p2.logic;

import java.util.Random;

import tp1.p2.control.Level;
import tp1.p2.exceptions.GameException;
import tp1.p2.logic.gameobjects.Zombie;
import tp1.p2.logic.gameobjects.ZombieFactory;

/**
 * Manage zombies in the game.
 *
 */
public class ZombiesManager {

	private GameWorld game;

	private Level level;

	private Random rand;

	private int remainingZombies;
	

	//Builder
	public ZombiesManager(GameWorld game, Level level, Random rand) {
		this.game = game;
		this.level = level;
		this.rand = rand;
		this.remainingZombies = level.getNumberOfZombies();
	}

	//Checks if the game should add (if possible) a zombie to the game.
	private boolean shouldAddZombie() {
		return rand.nextDouble() < level.getZombieFrequency();
	}

	//Return a random row within the board limits.
	private int randomZombieRow() {
		return rand.nextInt(GameWorld.NUM_ROWS);
	}

	//Return a random Zombie Type
	private int randomZombieType() {
		return rand.nextInt(ZombieFactory.getAvailableZombies().size());
	}

	//updates ZM
	public void update() {
		addZombie();
	}

	//Gets a random row and addZombie(row)
	public boolean addZombie() {
		int row = randomZombieRow();
		return addZombie(row);
	}

	//Checks if it can add the zombie to that row, if it can he spawns it
	public boolean addZombie(int row) {
		boolean canAdd = getRemainingZombies() > 0 && shouldAddZombie() && isPositionEmpty(GameWorld.NUM_COLS, row);
		int zombieType = randomZombieType();

		if (canAdd) {
			Zombie z = null;
			try {
				z = ZombieFactory.spawnZombie(zombieType, game, GameWorld.NUM_COLS, row);
			} catch (GameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			remainingZombies--;
			game.addItem(z);
			
		}
		return canAdd;
	}

	//Checks if the position is Empty
	private boolean isPositionEmpty(int numCols, int row) {
		return game.isPositionEmpty(numCols, row);
	}

	//Return remaining zombies
	public int getRemainingZombies() {
		return this.remainingZombies;
	}

}
