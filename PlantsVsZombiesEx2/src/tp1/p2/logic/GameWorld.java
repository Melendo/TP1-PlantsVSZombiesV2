package tp1.p2.logic;

import tp1.p2.control.Level;
import tp1.p2.exceptions.CommandParseException;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.logic.gameobjects.Plant;

public interface GameWorld {

	public static final int NUM_ROWS = 4;

	public static final int NUM_COLS = 8;

	//AddsSun
	void addSun(int numSol);

	//Object catch
	boolean tryToCatchObject(int col, int row);

	//Add a GO to the game
	boolean addItem(GameObject gameObject);

	//Executes the game actions and update the game objects in the board.
	void update();

	//Returns true if the player has enough coins to buy the plant in the argument
	public boolean canBuy(Plant plant);
		
	//Exit the game
	public void exit();
	
	//Resests the game
	public void reset();
	
	//Resests the game with params
	public void reset(Level lv, long seed);

	public boolean isPositionEmpty(int numCols, int row);

	public boolean isFinished();

	public boolean attackPlant(int i, int row, int dmg);

	public boolean attackZombie(int i, int row, int dmg);

	public void genSun();
	
	public boolean hasPositionEntity(int col, int row);

	public void increaseScore(int i);

	public String getRecord() throws CommandParseException;

	public boolean checkPlayerVictory();
	


		

}
