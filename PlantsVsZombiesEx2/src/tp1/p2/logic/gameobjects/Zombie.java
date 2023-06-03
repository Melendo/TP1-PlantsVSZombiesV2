package tp1.p2.logic.gameobjects;

import tp1.p2.logic.Game;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Zombie extends GameObject {
	
	public static final int HP = 5;
	public static final int DMG = 1;
	public static final int SPEED= 2;
	private int shouldMove;
	private String symbol = Messages.ZOMBIE_SYMBOL;
	private String name = Messages.ZOMBIE_NAME;
	private String description = Messages.ZOMBIE_DESCRIPTION;
	
	//Zombie Builder
	public Zombie(GameWorld game, int row) {
		this.game = game;
		this.row = row;
		this.col = Game.NUM_COLS + 1;
		this.hp = HP;
		this.shouldMove = SPEED;
		
	}
	
	//Empty Zombie Builder
	public Zombie() {
		
	}
	
	//Creates a new zombie
	public Zombie create(GameWorld game, int row) {
		return new Zombie(game, row);
	}

	//Recives zombieAttack = null
	@Override
	public boolean receiveZombieAttack(int damage) {
		return false;
	}

	//Recives PlantAttack
	public boolean receivePlantAttack(int damage) {
		this.damage(damage);
		return true;
	}

	// Checks if the game object fills its current position
	@Override
	public boolean fillPosition() {
		return true;
	}

	@Override
	public boolean catchObject() {
		return false;
	}

	@Override
	protected String getSymbol() {
		return this.symbol;
	}

	@Override
	public String getDescription() {
		return this.description;
	}
	
	
	public String getName() {
		return this.name;
	}

	@Override
	public void update() {
		
		if(this.col == -1) {
			game.isFinished();
		}
		
		else if(isAlive()) {
			if(shouldMove == 0) {
				shouldMove = SPEED;
			}
			shouldMove--;
			if(game.isPositionEmpty(col - 1, row) && shouldMove == 0) {
				col -= 1;
			}
			else if(!game.isPositionEmpty(col-1, row) ){
				game.attackPlant(col-1, row, DMG);	
			}
			
		}
		
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

	@Override
	public int getCooldown() {
		// TODO Auto-generated method stub
		return 0;
	}

}
