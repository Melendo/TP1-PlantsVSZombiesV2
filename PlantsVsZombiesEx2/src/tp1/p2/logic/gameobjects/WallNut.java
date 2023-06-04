package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class WallNut extends Plant {

	public static final int HP = 3;
	public static final int COST = 50;
	public static final int DMG = 1;
	
	protected final String name = Messages.WALL_NUT_NAME;
	protected final String symbol = Messages.WALL_NUT_SYMBOL;
	
	
	public WallNut(GameWorld game, int col, int row) {
		super(game, col, row, HP);
		// TODO Auto-generated constructor stub
	}
	
	public WallNut() {
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
		return new WallNut(game, col, row);
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
	}

	@Override
	public String getShortcut() {
		// TODO Auto-generated method stub
		return Messages.WALL_NUT_NAME_SHORTCUT;
	}
}
