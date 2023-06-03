package tp1.p2.logic.gameobjects;

import tp1.p2.logic.Game;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Peashooter extends Plant {
	public static final int HP = 3;
	public static final int COST = 50;
	public static final int DMG = 1;
	protected String name = "peashooter";
	protected String symbol = "p";
	
	
	public Peashooter(GameWorld game, int col, int row) {
		super(game, col, row);
		// TODO Auto-generated constructor stub
	}
	
	public Peashooter() {
		// TODO Auto-generated constructor stub
		this.name = getName();
		this.hp = HP;
	}

	public String getDescription() {
		String str = String.format(Messages.PLANT_DESCRIPTION, COST, DMG, HP);
		return str ;
	}
	
	public boolean isAlive() {
		return (this.hp > 0);
		}

	@Override
	public Plant create(GameWorld game, int col, int row) {
		// TODO Auto-generated method stub
		return new Peashooter(game, col, row);
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
