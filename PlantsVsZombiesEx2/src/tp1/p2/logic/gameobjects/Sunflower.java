package tp1.p2.logic.gameobjects;

import tp1.p2.logic.Game;
import tp1.p2.view.Messages;

public class Sunflower extends Plant {

	public static final int COST = 20;
	public static final int DMG = 0;
	public static final int HP = 1;
	public static final int GEN_SUNS = 10;
	public static final int GEN_CCL = 3;
	

	private int shouldGenerate ;
	private int col;
	private int row;
	private int hp;
	private Game game;
	
	public Sunflower(int col, int row){
		this.col = col;
		this.row = row;
		this.hp = HP;
		this.shouldGenerate = -1;
	}
	
	public Sunflower() {
		
	}
	
	public static String getDescription() {
		String str = String.format(Messages.PLANT_DESCRIPTION, COST, DMG, HP);
		return str ;
	}
	
	public boolean sunGeneration() {
		
		if(this.shouldGenerate < (GEN_CCL - 1 )) {
			this.shouldGenerate++;
		} else {
			this.shouldGenerate = 0;
			return true;	
		}
		return false;
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
		
		public boolean isAlive() {
		return (this.hp > 0);
		}
}
