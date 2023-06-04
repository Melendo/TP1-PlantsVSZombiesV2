package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;

public abstract class Plant extends GameObject{
	
	public Plant(GameWorld game, int col, int row, int hp) {
		super(game, col, row, hp);
	}
	
	public Plant () {}
	
	@Override
	public boolean receiveZombieAttack(int damage) {
		if(isAlive()) {
			hp -= damage;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean receivePlantAttack(int damage) {
		return false;
	}
	
	@Override
	public boolean catchObject() {
		return false;
	}
	
	@Override
	public boolean isEntity() {
		return true;
	}
	
	public abstract Plant create(GameWorld game, int col, int row);
	
	public abstract String getName();
	
	public abstract String getShortcut();
	
	public abstract String getSymbol();
	
	public abstract int getCost();
	

}
