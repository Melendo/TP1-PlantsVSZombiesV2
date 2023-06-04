package tp1.p2.logic.gameobjects;

import tp1.p2.logic.Game;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Sunflower extends Plant {

	public static final int HP = 1;
	public static final int COST = 20;
	public static final int DMG = 0;
	public static final int CD = 10;
	public static final int CYCLES = 3;
	
	protected final String name = Messages.SUNFLOWER_NAME;
	protected final String symbol = Messages.SUNFLOWER_SYMBOL;
	
	
	public Sunflower(GameWorld game, int col, int row) {
		super(game, col, row, HP);
		// TODO Auto-generated constructor stub
	}
	
	public Sunflower() {
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
		return new Sunflower(game, col, row);
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
		if(isAlive()) {
			int i = this.col;
			boolean terminado = false;
			while(!terminado && i < game.NUM_COLS) {
				if(game.attackZombie(i, this.row, DMG)) {
					terminado = true;
				}
				else i++;
			}
		}
	}

	@Override
	public String getShortcut() {
		// TODO Auto-generated method stub
		return Messages.SUNFLOWER_NAME_SHORTCUT;
	}
}
