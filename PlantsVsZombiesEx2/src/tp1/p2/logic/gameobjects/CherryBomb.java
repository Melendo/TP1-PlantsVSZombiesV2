package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;

public class CherryBomb extends Plant {
	
	public static final int COST = 20;
	public static final int DMG = 0;
	public static final int HP = 2;
	
	public CherryBomb(GameWorld game, int col, int row) {
		super(game, col, row);
	}

	public CherryBomb() {
		this.name = getName();
		this.hp = HP;
	}

	@Override
	public boolean receiveZombieAttack(int damage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receivePlantAttack(int damage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fillPosition() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean catchObject() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Plant create(GameWorld game, int col, int row) {
		// TODO Auto-generated method stub
		return new CherryBomb(game, col, row);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		
	}
}
