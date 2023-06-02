package tp1.p2.logic;

import static tp1.p2.view.Messages.error;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Random;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.control.Level;
import tp1.p2.logic.actions.GameAction;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.view.Messages;

public class Game implements GameStatus, GameWorld {
	
	public static final int INITIAL_SUNCOINS = 50;

	private long seed;

	private Level level;
	
	private int cycle;

	private GameObjectContainer container;

	private Deque<GameAction> actions;
	
	private Random random;
	
	private int suncoins;

	private ZombiesManager zombiesManager;
	
	private SunsManager sunsManager;
	
	private boolean dead;
	
	private boolean quits;
	
	private boolean zombiesWin;
	
	private boolean playerWin;

	//Constructor
	public Game(long seed, Level level) {
		this.seed = seed;
		this.level = level;
		this.container = new GameObjectContainer();
		reset();
	}

	/**
	 * Resets the game.
	 */
	@Override
	public void reset() {
		reset(this.level, this.seed);
	}

	/**
	 * Resets the game with the provided level and seed.
	 * 
	 * @param level {@link Level} Used to initialize the game.
	 * @param seed Random seed Used to initialize the game.
	 */
	@Override
	public void reset(Level level, long seed) {
		// TODO add your code here
		
		this.level = level;
		this.seed = seed;
		this.random = new Random(seed);
		this.cycle = 0;
		this.actions = new ArrayDeque<>();
		quits = false;
		suncoins = INITIAL_SUNCOINS;
		zombiesManager = new ZombiesManager(this, level, random);
		container = new GameObjectContainer();
		sunsManager = new SunsManager(this, random);
	}

	/**
	 * Executes the game actions and update the game objects in the board.
	 * 
	 */
	@Override
	public void update() {

		// 1. Execute pending actions
		executePendingActions();

		// 2. Execute game Actions
		// TODO add your code here

		// 3. Game object updates
		// TODO add your code here
		zombiesManager.update();
		container.update();
		sunsManager.update();

		// 4. & 5. Remove dead and execute pending actions
		boolean deadRemoved = true;
		while (deadRemoved || areTherePendingActions()) {
			// 4. Remove dead
			deadRemoved = this.container.removeDead();

			// 5. execute pending actions
			executePendingActions();
		}

		this.cycle++;

		// 6. Notify commands that a new cycle started
		Command.newCycle();

	}

	private void executePendingActions() {
		while (!this.actions.isEmpty()) {
			GameAction action = this.actions.removeLast();
			action.execute(this);
		}
	}

	private boolean areTherePendingActions() {
		return this.actions.size() > 0;
	}

	/**
	 * Checks if a cell is fully occupied, that is, the position can be shared between an NPC (Plant, Zombie) and Suns .
	 * 
	 * @param col Column of the cell
	 * @param row Row of the cell
	 * 
	 * @return <code>true</code> if the cell is fully occupied, <code>false</code>
	 *         otherwise.
	 */
	@Override
	public boolean isFullyOcuppied(int col, int row) {
		return this.container.isFullyOccupied(col, row);
	}

	public boolean isPlayerQuits() {
		return this.quits;
	}

	public boolean isFinished() {
		boolean resul = false;
		if(zombieArrived()) {
			this.zombiesWin = true;
			resul = zombiesWin;
		}
		else if(zombiesManager.getRemainingZombies() == 0 && allZombiesDied()) {
			this.playerWin = true;
			resul = playerWin;
		}
		else {
			resul = isPlayerQuits();
		}
		return resul;
	}

	private boolean allZombiesDied() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean zombieArrived() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addSun() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean tryToCatchObject(int col, int row) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addItem(GameObject gameObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCycle() {
		return this.cycle;
	}

	@Override
	public int getSuncoins() {
		return this.suncoins;
	}

	@Override
	public int getRemainingZombies() {
		return 0;
	}

	@Override
	public String positionToString(int col, int row) {

        String sol = " ";
        return sol;
	}



	@Override
	public int getGeneratedSuns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCaughtSuns() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean execute(Command command) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void subtractSuncoins(int x) {
		// TODO Auto-generated method stub
		this.suncoins -= x;
	}
	
	

	// TODO add your code here

}
