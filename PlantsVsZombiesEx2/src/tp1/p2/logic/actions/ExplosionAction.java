package tp1.p2.logic.actions;

import tp1.p2.logic.GameWorld;

public class ExplosionAction implements GameAction {

	private int col;

	private int row;

	private int damage;
	
	private boolean plant;

	public ExplosionAction(int col, int row, int damage, boolean plant) {
		this.col = col;
		this.row = row;
		this.damage = damage;
		this.plant = plant;
	}

	@Override
	public void execute(GameWorld game) {
		
		if(plant) {
			for(int i = this.col- 1; i <= this.col + 1; i++) {
				for(int j = this.row -1; j <= this.row +1; j++) {
					if(game.attackZombie( i, j, damage)) {
						game.increaseScore(10);
					}
				}
			}
		} else {
			for(int i = this.col- 1; i <= this.col + 1; i++) {
				for(int j = this.row -1; j <= this.row +1; j++) {
					game.attackPlant( i, j, damage);
				}
			}
		}

	}

}
