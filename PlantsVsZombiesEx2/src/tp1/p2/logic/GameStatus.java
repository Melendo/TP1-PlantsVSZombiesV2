package tp1.p2.logic;

import tp1.p2.control.Level;

public interface GameStatus {

	/**
	 * Get game cycles.
	 * 
	 * @return the game cycles
	 */
	int getCycle();

	/**
	 * Get available suncoins
	 * 
	 * @return the available suncoins
	 */
	int getSuncoins();

	/**
	 * Get the number of generated suns.
	 * 
	 * @return the number of generated suns
	 */
	int getRemainingZombies();

	/**
	 * Draw a cell of the game.
	 * 
	 * @param col Column of the cell to draw.
	 * @param row Row of the cell to draw.
	 * 
	 * @return a string that represents the content of the cell (col, row).
	 */
	String positionToString(int col, int row);

	/**
	 * Get the number of generated suns.
	 * 
	 * @return the number of generated suns
	 */
	int getGeneratedSuns();

	/**
	 * Get the number of caught suns.
	 * 
	 * @return the number of caught suns
	 */
	int getCaughtSuns();

	/**
	 * Resets the game.
	 */
	void reset();

	/**
	 * Resets the game with the provided level and seed.
	 * 
	 * @param level {@link Level} Used to initialize the game.
	 * @param seed Random seed Used to initialize the game.
	 */
	void reset(Level level, long seed);

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

	// TODO add your code here

}
