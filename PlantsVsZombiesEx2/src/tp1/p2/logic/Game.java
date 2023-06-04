package tp1.p2.logic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import tp1.p2.control.Command;
import tp1.p2.control.Level;
import tp1.p2.exceptions.CommandParseException;
import tp1.p2.exceptions.GameException;
import tp1.p2.exceptions.RecordException;
import tp1.p2.logic.actions.GameAction;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.logic.gameobjects.Plant;

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
	
	private int score;
	
	private RecordGame record;
	
	private boolean newRecord = false;

	//Constructor
	public Game(long seed, Level level) {
		this.seed = seed;
		this.level = level;
		this.container = new GameObjectContainer();
		reset();
		record = new RecordGame();
	}

	//Resets the game.
	@Override
	public void reset() {
		reset(this.level, this.seed);
	}

	//Resets the game with the provided level and seed.
	@Override
	public void reset(Level level, long seed) {
		
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
		score = 0;
	}

	//Executes the game actions and update the game objects in the board.
	@Override
	public void update() {

		
		executePendingActions();
		zombiesManager.update();
		container.update();
		sunsManager.update();

		boolean deadRemoved = true;
		while (deadRemoved || areTherePendingActions()) {
			deadRemoved = this.container.removeDead();

			executePendingActions();
		}
		
		

		this.cycle++;

		Command.newCycle();
		
		if(checkPlayerVictory()) {
			isFinished();
		}
		
		
		if(record.getScoreRecord(level.name()) == -1) {
			record.newLevelRecord(level.name());
		}
		else if(record.getScoreRecord(level.name()) < getScore() && isFinished()) {
			record.setScoreRecord(level.name(), getScore());
			newRecord = true;
		}	

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

	//Return if player quited the game
	@Override
	public boolean isPlayerQuits() {
		return this.quits;
	}
	
	//Return if zombies won the game
	@Override
	public boolean getZombiesWin() {
		return this.zombiesWin;
	}
	
	//Return if player won the game
	@Override
	public boolean getPlayerWin() {
		return this.playerWin;
	}

	//Return true if the game ended
	@Override
	public boolean isFinished() {
		boolean resul = false;
		if(container.zombieArrived()) {
			this.zombiesWin = true;
			resul = zombiesWin;
		}
		else if(checkPlayerVictory()) {
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
	public void addSun(int numSol) {
		this.suncoins += numSol;
	}

	//Try to catch a sun
	@Override
	public boolean tryToCatchObject(int col, int row) {
		return container.tryToCatchObject(col, row);
	}

	//Ads an Item to the game
	@Override
	public boolean addItem(GameObject gameObject) {
		if(gameObject.isEntity()) {
			if(!hasPositionEntity(gameObject.getCol(), gameObject.getRow())) {
			container.add(gameObject);
			return true;
			}
		}
		else {
			if(!isPosSun(gameObject.getCol(), gameObject.getRow())) {
				container.add(gameObject);
				return true;
			}
		}
		return false;
	}
	
	public boolean isPosSun(int col, int row) {
		return container.isPosSun(col, row);
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
		return SunsManager.getGeneratedSuns();
	}

	//Return Caught Suns
	@Override
	public int getCaughtSuns() {
		return SunsManager.getCatchedSuns();
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

	//Return true if you buy the plant and substract the sc
	@Override
	public boolean canBuy(Plant plant) {
		if(this.suncoins >= plant.getCost()) {
			subtractSuncoins(plant.getCost());
			return true;
		}
		return false;
	}

	@Override
	public void exit() {
		this.quits= true;
	}
	
	@Override
	public Level getLevel() {
		return this.level;
	}
	
	@Override
	public long getSeed() {
		return this.seed;
	}
	
	@Override
	public boolean isPositionEmpty(int numCols, int row) {
		return container.isPositionEmpty(numCols,row);
	}
	
	@Override
	public boolean attackPlant(int i, int row, int dmg) {
		return container.attackPlant(i, row, dmg);
		
	}

	@Override
	public boolean attackZombie(int i, int row, int dmg) {
		return this.container.attackZombie(i, row, dmg);
	}
	
	@Override
	public void genSun() {
		sunsManager.addSunToGen();
	}
	
	@Override
	public boolean hasPositionEntity(int col, int row) {
		return container.hasPositionEntity(col, row);
	}

	@Override
	public int getScore() {
		return this.score;
	}
	
	@Override
	public void increaseScore(int i) {
		this.score += i;
	}
	
	public String getRecord() throws CommandParseException {
		// TODO Auto-generated method stub
		//r.readFile();
		if(record.getScoreRecord(level.name()) == -1){
			return level.name() + " record is " + 0;
		}
		else {
			return level.name() + " record is " + record.getScoreRecord(level.name());
		}
	}
	
	public boolean isNewRecord() {
		return newRecord;
	}
	
	public void saveRecord() throws RecordException{
		record.save();
	}
	
	@Override
	public boolean checkPlayerVictory() {
		return zombiesManager.getRemainingZombies() == 0 && container.allZombiesDied();
	}
	
	

}
