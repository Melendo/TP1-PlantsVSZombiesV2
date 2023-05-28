package tp1.p1.logic.gameobjects;

import tp1.p1.logic.Game;

public class Zombie {

	public static final int HP = 5;
	public static final int DMG = 1;
	
	private int col;
	private int row;
	private int hp;
	private int shouldMove ;
	private Game game;
	
	public Zombie(int row) {
		this.row = row;
		this.col = Game.NUM_COLS + 1;
		this.hp = HP;
		this.shouldMove = - 1;
	}

	public void moveZombie() {
		if(this.shouldMove == 0) {
			this.shouldMove++;
		} else {
			this.shouldMove = 0;
			col--;
		}
 	}
	
	public boolean isAlive() {
		return (this.hp > 0);
		}
	
	
	//Getters
	
	public int getCol() {
		return this.col;
	}
		
	public int getRow() {
		return this.row;
	}
		
	public int getHp() {
		return this.hp;
	}
		
	//Setters
		
	public void setCol(int col) {
		this.col = col;
	}
		
	public void setRow(int row) {
		this.row = row;
	}
		
	public void setHp(int hp) {
		this.hp = hp;
	}
}
