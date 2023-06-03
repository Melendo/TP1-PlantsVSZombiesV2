package tp1.p2.logic.gameobjects;

import static tp1.p2.view.Messages.status;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;

/**
 * Base class for game non playable character in the game.
 *
 */
public abstract class GameObject implements GameItem {

	protected GameWorld game;
	protected int col;
	protected int row;
	protected String name;
	protected String symbol;
	protected int hp;
	protected int cooldown;


	GameObject() {
	}

	GameObject(GameWorld game, int col, int row) {
		this.game = game;
		this.col = col;
		this.row = row;
	}

	public boolean isInPosition(int col, int row) {
		return this.col == col && this.row == row;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void damage(int i) {
		hp -= i;
	}
	
	public boolean isAlive() {
		if(this.hp > 0) {
			return true;
		}
		return false;
	}

	public String toString() {
		if (isAlive()) {
			// TODO add your code here
		} else {
			return "";
		}
		return null;
	}

	protected abstract String getSymbol();

	public abstract String getDescription();

	abstract public void update();
	
	abstract public void onEnter();
	
	abstract public void onExit();
}
