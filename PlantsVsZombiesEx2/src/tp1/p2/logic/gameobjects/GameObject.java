package tp1.p2.logic.gameobjects;

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

	GameObject(GameWorld game, int col, int row, int hp) {
		this.game = game;
		this.col = col;
		this.cooldown = 0;
		this.row = row;
		this.hp = hp;
	}

	public boolean isInPosition(int col, int row) {
		return this.col == col && this.row == row;
	}

	public int getCol() {
		return this.col;
	}

	public int getRow() {
		return this.row;
	}
	
	public int getHp() {
		return this.hp;
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
			String string = this.getSymbol() + "[" + this.hp + "]";
			return string;
		} else {
			return "";
		}
	}

	protected abstract String getSymbol();

	public abstract String getDescription();
	
	public abstract int getCooldown();

	abstract public void update();
	
	abstract public void onEnter();
	
	abstract public void onExit();
	
	abstract public boolean catchObject();
}
