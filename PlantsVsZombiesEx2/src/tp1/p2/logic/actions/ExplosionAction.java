package tp1.p2.logic.actions;

import tp1.p2.logic.GameWorld;

public class ExplosionAction implements GameAction {

	private int col;

	private int row;

	private int damage;
	
	private boolean cherry;

	public ExplosionAction(int col, int row, int damage, boolean cherry) {
		this.col = col;
		this.row = row;
		this.damage = damage;
		this.cherry = cherry;
	}

	@Override
	public void execute(GameWorld game) {
		int c  = col - 1;
		int r = row;

	}

}
