package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;

public class ExplosiveZombie extends Zombie {

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
