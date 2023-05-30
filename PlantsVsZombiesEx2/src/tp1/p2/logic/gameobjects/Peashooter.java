package tp1.p2.logic.gameobjects;

import tp1.p2.logic.Game;
import tp1.p2.view.Messages;

public class Peashooter extends Plant {
	public static final int HP = 3;
	public static final int COST = 50;
	public static final int DMG = 1;
	
	private int col;
	private int row;
	private int hp;
	private Game game;
	
	public Peashooter(int col, int row){
		this.col = col;
		this.row = row;
		this.hp = HP;
	}
	
	public Peashooter() {
		
	}
	
	public static String getDescription() {
		String str = String.format(Messages.PLANT_DESCRIPTION, COST, DMG, HP);
		return str ;
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
