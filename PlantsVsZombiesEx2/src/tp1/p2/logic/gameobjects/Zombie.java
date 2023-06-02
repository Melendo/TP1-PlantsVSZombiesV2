package tp1.p2.logic.gameobjects;

import tp1.p2.logic.Game;
import tp1.p2.logic.GameWorld;

public class Zombie extends GameObject {
	
	public static final int HP = 5;
	public static final int DMG = 1;
	private int shouldMove ;
	
	
	public Zombie(GameWorld game, int row) {
		this.game = game;
		this.row = row;
		this.col = Game.NUM_COLS + 1;
		this.hp = HP;
		this.shouldMove = - 1;
	}
	
	public Zombie() {
		
	}
	
	public Zombie create(GameWorld game, int row) {
		return new Zombie(game, row);
	}

	@Override
	public boolean receiveZombieAttack(int damage) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean receivePlantAttack(int damage) {
		// TODO Auto-generated method stub
		this.damage(damage);
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
	protected String getSymbol() {
		// TODO Auto-generated method stub
		return null;
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
	@Override
	public boolean isNPC() {
		return true;
	}

}
