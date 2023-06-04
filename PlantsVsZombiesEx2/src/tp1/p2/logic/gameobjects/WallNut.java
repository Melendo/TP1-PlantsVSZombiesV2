package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class WallNut extends Plant {

	public static final int HP = 10;
	public static final int COST = 50;
	public static final int DMG = 0;
	
	
	public WallNut(GameWorld game, int col, int row) {
		super(game, col, row, HP);
		this.name = Messages.WALL_NUT_NAME;
		this.symbol = Messages.WALL_NUT_SYMBOL;
	}
	
	public WallNut() {
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
		return Messages.WALL_NUT_NAME;
	}

	@Override
	public String getSymbol() {
		return Messages.WALL_NUT_SYMBOL;
	}

	@Override
	public int getCost() {
		return COST;
	}

	@Override
	public Plant copy(GameWorld game, int col, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean receivePlantAttack(int damage) {
		return false;
	}

	@Override
	public boolean fillPosition() {
		// TODO Auto-  stub
		return false;
	}

	@Override
	public void update() {
	}

	@Override
	public String getShortcut() {
		return Messages.WALL_NUT_NAME_SHORTCUT;
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
