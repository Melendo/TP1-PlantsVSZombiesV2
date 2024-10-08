package tp1.p2.logic.gameobjects;

import tp1.p2.logic.Game;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Peashooter extends Plant {
	public static final int HP = 3;
	public static final int COST = 50;
	public static final int DMG = 1;
	
	public Peashooter(GameWorld game, int col, int row) {
		super(game, col, row, HP);
		this.name = Messages.PEASHOOTER_NAME;
		this.symbol = Messages.PEASHOOTER_SYMBOL;
	}
	
	public Peashooter() {

	}

	@Override
	public Plant create(GameWorld game, int col, int row) {
		return new Peashooter(game, col, row);
	}

	@Override
	public String getDescription() {
		String str = String.format(Messages.PLANT_DESCRIPTION, Messages.PEASHOOTER_NAME_SHORTCUT, COST, DMG, HP);
		return str ;
	}

	@Override
	public String getName() {
		return Messages.PEASHOOTER_NAME;
	}
	
	@Override
	public String getShortcut() {
		return Messages.PEASHOOTER_NAME_SHORTCUT;
	}

	@Override
	public String getSymbol() {
		return Messages.PEASHOOTER_SYMBOL;
	}

	@Override
	public int getCost() {
		return COST;
	}
	
	@Override
	public void update() {
		if(this.isAlive()) {
			int i = this.col;
			while(!game.attackZombie(i, this.row, DMG) && i < Game.NUM_COLS - 1) {
				i++;
			}
		}
	}



	@Override
	public void onEnter() {
		
	}

	@Override
	public void onExit() {
		
	}

	
}
