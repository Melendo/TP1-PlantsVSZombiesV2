package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.logic.actions.ExplosionAction;
import tp1.p2.logic.actions.GameAction;
import tp1.p2.view.Messages;

public class ExplosiveZombie extends Zombie {
	private String symbol = Messages.EXPLOSIVE_ZOMBIE_SYMBOL;
	private String name = Messages.EXPLOSIVE_ZOMBIE_NAME;
	private String description = Messages.ZOMBIE_DESCRIPTION;

	public ExplosiveZombie(GameWorld game, int row) {
		// TODO Auto-generated constructor stub
		super(game, row);
	}
	
	public ExplosiveZombie() {
		
	}

	@Override
	public Zombie create(GameWorld game, int row) {
		return new ExplosiveZombie(game, row);
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
		if(hp == 0) {
			GameAction explosion = new ExplosionAction(col, row, DMG, false);
			explosion.execute(game);
		}
	}
	
}
