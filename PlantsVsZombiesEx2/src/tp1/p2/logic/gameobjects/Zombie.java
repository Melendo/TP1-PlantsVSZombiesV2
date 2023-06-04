package tp1.p2.logic.gameobjects;


import tp1.p2.logic.GameWorld;


public abstract class Zombie extends GameObject {
	
	public Zombie(GameWorld game, int col, int row, int life) {
		super(game, col, row, life);
	}
	
	public Zombie() {}
	
	public boolean receiveZombieAttack(int damage) {
		return false;
	}
	
	public  boolean receivePlantAttack(int damage) {
		this.damage(damage);
		return true;
	}
	
	public boolean fillPosition() {
		return true;
	}
	
	public boolean catchObject() {
		return false;
	}
	
	public boolean isEntity() {
		return true;
	}
	
	
	
	public abstract Zombie create(GameWorld game, int row);
	
	public abstract String getSymbol();
	
	public abstract String getDescription();
	
	public abstract String getName();
	
	public abstract void update();

}
