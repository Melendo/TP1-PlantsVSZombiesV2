package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.logic.actions.ExplosionAction;
import tp1.p2.logic.actions.GameAction;
import tp1.p2.view.Messages;

public class CherryBomb extends Plant {
	private static final int COST = 50;
	private static final int HP = 2;
	private static final int DMG = 10;
	private static final int CYCLES = 3;
	
	protected String symbol = Messages.CHERRY_BOMB_SYMBOL;
	
	private int fuse ;
	
	
	
	public CherryBomb(GameWorld game, int col, int row) {
		super(game, col, row, HP);
		this.name = Messages.CHERRY_BOMB_NAME;
		this.fuse = CYCLES;
	}
	
	public CherryBomb() {}

	@Override
	public Plant create(GameWorld game, int col, int row) {
		return new CherryBomb(game, col, row);
	}

	@Override
	public String getDescription() {
		String str = String.format(Messages.PLANT_DESCRIPTION, Messages.CHERRY_BOMB_NAME_SHORTCUT, COST, DMG, HP);
		return str ;
	}
	
	@Override
	public String getName() {
		return Messages.CHERRY_BOMB_NAME;
	}
	
	@Override
	public String getShortcut() {
		return Messages.CHERRY_BOMB_NAME_SHORTCUT;
	}

	@Override
	public String getSymbol() {
		return this.symbol;
	}

	@Override
	public int getCost() {
		return COST;
	}

	@Override
	public void update() {
		fuse--;
		if(fuse < 0) {
			GameAction explosion = new ExplosionAction(col, row, DMG, true);
			explosion.execute(game);
			this.hp = 0;
		} else if(fuse == 0) {
			this.symbol = "C";
		}
	}

	@Override
	public void onEnter() {		
		
	}

	@Override
	public void onExit() {		
		
	}


	
}
