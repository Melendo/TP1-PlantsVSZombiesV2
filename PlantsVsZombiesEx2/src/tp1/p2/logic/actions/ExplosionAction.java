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
		if(cherry) {
			game.attackZombie(damage, row, col - 1);
			game.attackZombie(damage, row + 1, col - 1);
			game.attackZombie(damage, row + 1, col);
			game.attackZombie(damage, row + 1, col + 1);
			game.attackZombie(damage, row, col + 1);
			game.attackZombie(damage, row - 1, col + 1);
			game.attackZombie(damage, row - 1, col);
			game.attackZombie(damage, row - 1, col - 1);
		} else {
			game.attackPlant(damage, row, col - 1);
			game.attackPlant(damage, row + 1, col - 1);
			game.attackPlant(damage, row + 1, col);
			game.attackPlant(damage, row + 1, col + 1);
			game.attackPlant(damage, row, col + 1);
			game.attackPlant(damage, row - 1, col + 1);
			game.attackPlant(damage, row - 1, col);
			game.attackPlant(damage, row - 1, col - 1);
		}

	}

}
