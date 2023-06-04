package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Sunflower extends Plant {

	public static final int HP = 1;
	public static final int COST = 20;
	public static final int DMG = 0;
	public static final int CYCLES = 3;

	
	public Sunflower(GameWorld game, int col, int row) {
		super(game, col, row, HP);
		this.name = Messages.SUNFLOWER_NAME;
		this.symbol = Messages.SUNFLOWER_SYMBOL;
		this.cooldown = CYCLES;
	}
	
	public Sunflower() {
		
	}

	@Override
	public Plant create(GameWorld game, int col, int row) {
		return new Sunflower(game, col, row);
	}
	
	@Override
	public String getDescription() {
		String str = String.format(Messages.PLANT_DESCRIPTION, Messages.SUNFLOWER_NAME_SHORTCUT, COST, DMG, HP);
		return str ;
	}

	@Override
	public String getName() {
		return Messages.SUNFLOWER_NAME;
	}

	@Override
	public String getShortcut() {
		return Messages.SUNFLOWER_NAME_SHORTCUT;
	}

	@Override
	public String getSymbol() {
		return Messages.SUNFLOWER_SYMBOL;
	}

	@Override
	public int getCost() {
		return COST;
	}
	

	@Override
	public boolean receivePlantAttack(int damage) {
		return false;
	}

	@Override
	public void update() {
		if(isAlive()) {
			if(cooldown == 1) {
				game.genSun();
				cooldown = CYCLES;
				
			}
			else {
				cooldown--;
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
