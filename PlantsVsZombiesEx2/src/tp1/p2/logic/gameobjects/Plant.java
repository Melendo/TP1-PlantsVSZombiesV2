package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;

public abstract class Plant extends GameObject{
	
	public Plant(GameWorld game, int col, int row) {
		super(game, col, row);
	}
	
	public Plant () { }
	
	public abstract Plant create(GameWorld game, int col, int row);
	
	
	public String getName() {
		return this.name;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	@Override
	public boolean isNPC() {
		return false;
	}
}
