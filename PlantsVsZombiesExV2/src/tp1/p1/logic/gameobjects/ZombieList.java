package tp1.p1.logic.gameobjects;

import tp1.p1.view.Messages;

public class ZombieList {
	
	private Zombie zombies[];
	private int cont;

	public ZombieList(int remainingZombies) {
		zombies = new Zombie[remainingZombies];
		cont = 0;
	}
	
	public void moveZombie(int i) {
		zombies[i].moveZombie();
	}
	
	public int getCont() {
		
		return cont;
	}
	
	public void damageZombie(int i) {
		zombies[i].setHp(zombies[i].getHp() - 1);
	}
	
	public boolean isEmpty(int col, int row) {
		for(int i = 0; i < cont; i++) {
			if(zombies[i].getCol() == col && zombies[i].getRow() == row && zombies[i].isAlive()) {
				return false;
			}
		}
		return true;
	}

	public boolean zombiesAlive() {
		for(int i = 0; i < cont; i++) {
			if(zombies[i].isAlive()) {
				return true;
			}
		}
		return false;
	}
	
	public String printZombie(int col, int row){
		String sol = " ";
		for(int i = 0; i < cont; i++) {
			if(zombies[i].getCol() == col && zombies[i].getRow() == row && zombies[i].isAlive()) {
				sol = String.format(Messages.ZOMBIE_ICON , zombies[i].getHp()) ;
				return sol;
			}
		}
		
		return sol;
	}
	
	
	
	public boolean isAlive(int i) {
		return zombies[i].isAlive();
	}
	
	public int getRow(int i) {
		return zombies[i].getRow();
	}
	
	public int getCol(int i) {
		return zombies[i].getCol();
	}
	
	public boolean checkDefeat() {
		boolean sol = false;
		for(int i = 0; i < cont; i++) {
			if(zombies[i].getCol() == 0 && zombies[i].isAlive()) {
				sol = true ;
				return sol;
			}
		}
		return sol;
	}
	
	public void checkDeath(int i) {
		if(!this.isAlive(i)) {
			zombies[i].setCol(-1);
			zombies[i].setRow(-1);
		}
	}

	public void addZombie(int row) {
		zombies[cont] = new Zombie(row);
		cont++;
		
	}
	
	public int getAliveZ() {
		int cont = 0;
		for(int i = 0; i < this.cont; i++) {
			if(zombies[i].isAlive()) {
				cont ++;
			}
		}
		return cont;
	}


}
