package tp1.p2.logic.gameobjects;

import tp1.p2.logic.Game;

public class Zombie extends GameObject {
	
	public static final int HP = 5;
	public static final int DMG = 1;
	
	private int col;
	private int row;
	private int hp;
	private int shouldMove ;
	private Game game;
	
	public Zombie(int row) {
		this.row = row;
		this.col = Game.NUM_COLS + 1;
		this.hp = HP;
		this.shouldMove = - 1;
	}
	
	public Zombie() {
		
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
	public boolean isAlive() {
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

}
