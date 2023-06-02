package tp1.p2.logic;

import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.logic.gameobjects.Plant;

public interface GameWorld {

	public static final int NUM_ROWS = 4;

	public static final int NUM_COLS = 8;

	// TODO add your code here

	void addSun();

	boolean tryToCatchObject(int col, int row);

	boolean addItem(GameObject gameObject);

	/**
	 * Executes the game actions and update the game objects in the board.
	 * 
	 */
	void update();

	/**
	 * Checks if a cell is fully occupied, that is, the position can be shared between an NPC (Plant, Zombie) and Suns .
	 * 
	 * @param col Column of the cell
	 * @param row Row of the cell
	 * 
	 * @return <code>true</code> if the cell is fully occupied, <code>false</code>
	 *         otherwise.
	 */
	boolean isFullyOcuppied(int col, int row);
	
	//Returns true if the player has enough coins to buy the plant in the argument
	public boolean canBuy(Plant plant);
		
		//To exit the game
	public void exit();
	
	public void reset();
		

}
