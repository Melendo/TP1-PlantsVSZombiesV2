package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;

public class Sporty extends Zombie {
	
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
