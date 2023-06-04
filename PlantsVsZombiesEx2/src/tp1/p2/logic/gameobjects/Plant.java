package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;

public abstract class Plant extends GameObject{
	
	public Plant(GameWorld game, int col, int row, int hp) {
		super(game, col, row, hp);
	}
	
	public Plant () { }
	
	public abstract Plant create(GameWorld game, int col, int row);
	
	
	public abstract String getName();
	
	public abstract String getSymbol();
	
	public abstract String getShortcut();
	
	public abstract int getCost();
	
	abstract public Plant copy(GameWorld game, int col, int row); 
	
	@Override
	public boolean isEntity() {
		return false;
	}
	
	@Override
	public boolean receiveZombieAttack(int damage) {
		if(isAlive()) {
			hp -= damage;
			return true;
		}
		return false;
	}
	
	@Override
	public void onEnter() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void onExit() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public boolean receivePlantAttack(int damage) {
		// TODO Auto-generated method stub
		return false;
	}

}
