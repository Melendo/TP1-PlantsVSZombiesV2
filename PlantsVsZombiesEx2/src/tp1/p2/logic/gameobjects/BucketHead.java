package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;

public class BucketHead extends Zombie {
	public static final int HP = 10;
	
	public BucketHead(GameWorld game, int row) {
		// TODO Auto-generated constructor stub
		super(game, row);
	}
	
	public BucketHead() {
		
	}

	@Override
	public Zombie create(GameWorld game, int row) {
		return new BucketHead(game, row);
	}
}
