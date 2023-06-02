package tp1.p2.logic;

import static tp1.p2.view.Messages.error;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Random;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.control.Level;
import tp1.p2.exceptions.GameException;
import tp1.p2.logic.actions.GameAction;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.logic.gameobjects.Plant;
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

	//Resets the game.
	@Override
	public void reset() {
		reset(this.level, this.seed);
	}

	//Resets the game with the provided level and seed.
	@Override
	public void reset(Level level, long seed) {
		// TODO add your code here
		
		this.level = level;
		this.seed = seed;
		this.random = new Random(seed);
		this.cycle = 0;
		//this.actions = new ArrayDeque<>();
		quits = false;
		suncoins = INITIAL_SUNCOINS;
		zombiesManager = new ZombiesManager(this, level, random);
		container = new GameObjectContainer();
		//sunsManager = new SunsManager(this, random);
	}

	//Executes the game actions and update the game objects in the board.
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

	//Executes all the pending actions
	private void executePendingActions() {
		while (!this.actions.isEmpty()) {
			GameAction action = this.actions.removeLast();
			action.execute(this);
		}
	}

	//Return true if there are pending actions
	private boolean areTherePendingActions() {
		return this.actions.size() > 0;
	}

	// Checks if a cell is fully occupied, that is, the position can be shared between an NPC (Plant, Zombie) and Suns .
	@Override
	public boolean isFullyOcuppied(int col, int row) {
		return this.container.isFullyOccupied(col, row);
	}

	//Return if player quited the game
	public boolean isPlayerQuits() {
		return this.quits;
	}

	//Return true if the game ended
	public boolean isFinished() {
		boolean resul = false;
		if(container.zombieArrived()) {
			this.zombiesWin = true;
			resul = zombiesWin;
		}
		else if(zombiesManager.getRemainingZombies() == 0 && container.allZombiesDied()) {
			this.playerWin = true;
			resul = playerWin;
		}
		else {
			resul = isPlayerQuits();
		}
		return resul;
	}

	//Adds Sun
	@Override
	public void addSun() {
		// TODO Auto-generated method stub
	}

	//Try to catch
	@Override
	public boolean tryToCatchObject(int col, int row) {
		// TODO Auto-generated method stub
		return false;
	}

	//Ads an Item to the game
	@Override
	public boolean addItem(GameObject gameObject) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//Returns number of cycle
	@Override
	public int getCycle() {
		return this.cycle;
	}

	//Return suncoins
	@Override
	public int getSuncoins() {
		return this.suncoins;
	}

	//Returns remaining zombies
	@Override
	public int getRemainingZombies() {
		return zombiesManager.getRemainingZombies();
	}

	//Returns the string that represents the object
	@Override
	public String positionToString(int col, int row) {
		return container.positionToString(col, row);
	}

	//Return the Gen Suns
	@Override
	public int getGeneratedSuns() {
		// TODO Auto-generated method stub
		return 0;
	}

	//Return Caught Suns
	@Override
	public int getCaughtSuns() {
		// TODO Auto-generated method stub
		return 0;
	}

	//Executes a specific command given
	public boolean execute(Command command) throws GameException{
		return command.execute(this);
	}

	//Substracts x suncions
	@Override
	public void subtractSuncoins(int x) {
		this.suncoins -= x;
	}

	@Override
	public boolean canBuy(Plant plant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void exit() {
		this.quits= true;
	}
	
	
	
	
	
	
	
	


}
