package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Sporty extends Zombie {
	private String symbol = Messages.SPORTY_ZOMBIE_SYMBOL;
	private String name = Messages.SPORTY_ZOMBIE_NAME;
	private String description = Messages.ZOMBIE_DESCRIPTION;
	
	public Sporty(GameWorld game, int row) {
		// TODO Auto-generated constructor stub
		super(game, row);
	}
	
	public Sporty() {
		
	}

	@Override
	public Zombie create(GameWorld game, int row) {
		return new Sporty(game, row);
	}

}
