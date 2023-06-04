package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.logic.actions.ExplosionAction;
import tp1.p2.logic.actions.GameAction;
import tp1.p2.view.Messages;

public class CherryBomb extends Plant {
	private static final int COST = 50;
	private static final int HP = 3;
	private static final int DMG = 10;
	private static final int CYCLES = 3;
	
	protected final String name = Messages.CHERRY_BOMB_NAME;
	protected String symbol = Messages.CHERRY_BOMB_SYMBOL;
	
	private int fuse = this.CYCLES;
	
	
	
	public CherryBomb(GameWorld game, int col, int row) {
		super(game, col, row, HP);
		// TODO Auto-generated constructor stub
	}
	
	public CherryBomb() {
		// TODO Auto-generated constructor stub
		this.hp = HP;
	}

	public String getDescription() {
		String str = String.format(Messages.PLANT_DESCRIPTION, COST, DMG, HP);
		return str ;
	}

	@Override
	public Plant create(GameWorld game, int col, int row) {
		// TODO Auto-generated method stub
		return new CherryBomb(game, col, row);
	}

	@Override
	public int getCooldown() {
		// TODO Auto-generated method stub
		return this.cooldown;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getSymbol() {
		// TODO Auto-generated method stub
		return this.symbol;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return this.COST;
	}

	@Override
	public Plant copy(GameWorld game, int col, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean receivePlantAttack(int damage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fillPosition() {
		// TODO Auto-generated method stub
		return false;
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
	public String getShortcut() {
		// TODO Auto-generated method stub
		return Messages.CHERRY_BOMB_NAME_SHORTCUT;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		
	}


	
}
