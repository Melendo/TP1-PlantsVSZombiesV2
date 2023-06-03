package tp1.p2.logic;

import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.logic.gameobjects.Plant;

public interface GameWorld {

	public static final int NUM_ROWS = 4;

	public static final int NUM_COLS = 8;

	//AddsSun
	void addSun();

	//Object catch
	boolean tryToCatchObject(int col, int row);

	//Add a GO to the game
	boolean addItem(GameObject gameObject);

	//Executes the game actions and update the game objects in the board.
	void update();

	//Checks if a cell is fully occupied, that is, the position can be shared between an NPC (Plant, Zombie) and Suns .
	boolean isFullyOcuppied(int col, int row);
	
	//Returns true if the player has enough coins to buy the plant in the argument
	public boolean canBuy(Plant plant);
		
	//Exit the game
	public void exit();
	
	//Resests the game
	public void reset();

	public boolean isPositionEmpty(int numCols, int row);

	public boolean isFinished();

	public boolean attackPlant(int i, int row, int dmg);
		

}
