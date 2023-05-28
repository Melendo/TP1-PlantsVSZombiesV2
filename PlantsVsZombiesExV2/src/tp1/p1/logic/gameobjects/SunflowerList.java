package tp1.p1.logic.gameobjects;

import tp1.p1.logic.Game;
import tp1.p1.view.Messages;

public class SunflowerList {
	private Sunflower arraySF[];
	private int cont;
	
	public SunflowerList() {
		arraySF = new Sunflower[Game.NUM_COLS* Game.NUM_ROWS];
		cont = 0;
	}

	public int generateSun() {
		int cont = 0;
		for(int i = 0; i < this.cont; i++) {
			if(arraySF[i].isAlive() && arraySF[i].sunGeneration()) {
				cont += Sunflower.GEN_SUNS;
			}
		}
		return cont;
	}
	
	public int getCont() {
		
		return cont;
	}
	
	public boolean isEmpty(int col, int row) {
		for(int i = 0; i < cont; i++) {
			if(arraySF[i].getCol() == col && arraySF[i].getRow() == row && arraySF[i].isAlive()) {
				return false;
			}
		}
		return true;
	}
	
	public String printSF(int col, int row){
		String sol = " ";
		for(int i = 0; i < cont; i++) {
			if(arraySF[i].getCol() == col && arraySF[i].getRow() == row && arraySF[i].isAlive()) {
				sol = String.format(Messages.SUNFLOWER_ICON , arraySF[i].getHp()) ;
				return sol;
			}
		}
		return sol;
	}
	
	public void damage(int c, int r) {
		for (int i = 0; i < cont; i++) {
			if(arraySF[i].getCol() == c && arraySF[i].getRow() == r) {
				arraySF[i].setHp(arraySF[i].getHp() - 1);
			}
		}
	}
	
	public void addSF(int col, int row){
		arraySF[cont] = new Sunflower(col, row);
		this.cont++;
	}
	
	public int getHp(int i) {
		return arraySF[i].getHp();
	}
	
	public void kill(int i) {
		arraySF[i].setCol(-1);
		arraySF[i].setRow(-1);
	}

	public int getAliveSF() {
		int cont = 0;
		for(int i = 0; i < this.cont; i++) {
			if(arraySF[i].isAlive()) {
				cont ++;
			}
		}
		return cont;
	}
	
}
