package tp1.p2.logic.gameobjects;

import tp1.p2.logic.Game;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Sporty extends Zombie {
	public static final int HP = 2;
	public static final int DMG = 1;
	public static final int SPEED= 1;
	
	public Sporty(GameWorld game, int row) {
		super(game,Game.NUM_COLS , row, HP);
		this.name = Messages.SPORTY_ZOMBIE_NAME;
		this.symbol = Messages.SPORTY_ZOMBIE_SYMBOL;
		this.cooldown = SPEED + 1;
		
	}
	
	public Sporty() {
		
	}
	
	@Override
	public Zombie create(GameWorld game, int row) {
		return new Sporty(game, row);
	}
	
	@Override
	public String getDescription() {
		String str = String.format(Messages.ZOMBIE_DESCRIPTION, Messages.SPORTY_ZOMBIE_NAME, SPEED, DMG, HP);
		return str ;
	}
	
	public String getName() {
		return Messages.SPORTY_ZOMBIE_NAME;
	}
	
	@Override
	public String getSymbol() {
		return Messages.SPORTY_ZOMBIE_SYMBOL;
	}

	@Override
	public void update() {
		

		if(this.col == -1) {
			game.isFinished();
		}
		
		else if(isAlive()) {
			if(cooldown == 0) {
				cooldown = SPEED;
			}
			cooldown--;
			if(!game.hasPositionEntity(col - 1, row) && cooldown == 0) {
				col -= 1;
			}
			else if(game.hasPositionEntity(col-1, row) ){
				game.attackPlant(col-1, row, DMG);	
			}
			
		}
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void onExit() {
		game.increaseScore(10);
		
	}
	

}
