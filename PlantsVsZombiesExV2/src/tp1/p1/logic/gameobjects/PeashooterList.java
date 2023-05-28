package tp1.p1.logic.gameobjects;

import tp1.p1.logic.Game;
import tp1.p1.view.Messages;

public class PeashooterList {
	private Peashooter arrayPS[];
	private int cont;
	
	public PeashooterList() {
		arrayPS = new Peashooter[Game.NUM_COLS* Game.NUM_ROWS];
		cont = 0;
	}
	
	public int getCont() {
		
		return cont;
	}
	
	public int getCol(int i) {
		return arrayPS[i].getCol();
	}
	
	public int getRow(int i) {
		return arrayPS[i].getRow();
	}
	
	public int getHp(int i) {
		return arrayPS[i].getHp();
	}
	
	public boolean isEmpty(int col, int row) {
		for(int i = 0; i < cont; i++) {
			if(arrayPS[i].getCol() == col && arrayPS[i].getRow() == row && arrayPS[i].isAlive()) {
				return false;
			}
		}
		return true;
	}
	
	public String printPS(int col, int row){
		String sol = " ";
		for(int i = 0; i < cont; i++) {
			if(arrayPS[i].getCol() == col && arrayPS[i].getRow() == row && arrayPS[i].isAlive()) {
				sol = String.format(Messages.PEASHOOTER_ICON , arrayPS[i].getHp()) ;
				return sol;
			}
		}
		return sol;
	}
	
	public void damage(int c, int r) {
		for (int i = 0; i < cont; i++) {
			if(arrayPS[i].getCol() == c && arrayPS[i].getRow() == r) {
				arrayPS[i].setHp(arrayPS[i].getHp() - 1);
			}
		}
	}
	
	public void addPS(int col, int row){
		arrayPS[cont] = new Peashooter(col, row);
		cont++;
	}
	
	public void kill(int i) {
		arrayPS[i].setCol(-1);
		arrayPS[i].setRow(-1);
	}
	
	public int getAlivePS() {
		int cont = 0;
		for(int i = 0; i < this.cont; i++) {
			if(arrayPS[i].isAlive()) {
				cont ++;
			}
		}
		return cont;
	}
	
	


}
