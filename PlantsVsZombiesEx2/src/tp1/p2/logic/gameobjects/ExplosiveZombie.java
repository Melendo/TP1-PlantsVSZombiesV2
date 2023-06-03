package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
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
	
}
