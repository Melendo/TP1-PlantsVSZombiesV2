package tp1.p2.logic.gameobjects;

import tp1.p2.logic.Game;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class NormalZombie extends Zombie {

	public static final int HP = 5;
	public static final int DMG = 1;
	public static final int SPEED= 2;
	
	//Zombie Builder
	public NormalZombie(GameWorld game, int row) {
		super(game,Game.NUM_COLS + 1, row, HP);
		this.name = Messages.ZOMBIE_NAME;
		this.symbol = Messages.ZOMBIE_SYMBOL;
		this.cooldown = SPEED;
		
	}
	
	//Empty Zombie Builder
	public NormalZombie() {
		
	}
	
	//Creates a new zombie
	@Override
	public Zombie create(GameWorld game, int row) {
		System.out.println("Creado ZNormal");
		return new NormalZombie(game, row);
	}
	
	@Override
	public String getDescription() {
		String str = String.format(Messages.ZOMBIE_DESCRIPTION, SPEED, DMG, HP);
		return str ;
	}

	@Override
	public int getCooldown() {
		return this.cooldown;
	}

	@Override
	public String getSymbol() {
		return Messages.ZOMBIE_SYMBOL;
	}
	
	public String getName() {
		return Messages.ZOMBIE_NAME;
	}

	@Override
	public void update() {
		
		if(this.col == -1) {
			game.isFinished();
		}
		
		if(cooldown == 1) {
			cooldown = SPEED;
		}
		else {
			cooldown--;
			if(game.isPositionEmpty(col - 1, row) && cooldown == 0) {
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
	

	
}
