package tp1.p2.logic.gameobjects;


import tp1.p2.logic.GameWorld;
import tp1.p2.logic.SunsManager;
import tp1.p2.view.Messages;

public class Sun extends GameObject {
	
	public static final int HP = 10;
	
	//Builder
	public Sun(GameWorld game, int x, int y) {
		super(game, x, y, HP);
		this.hp = HP;
		this.symbol = getSymbol();
	}

	@Override
	public boolean catchObject() {
		this.hp = 0;
		this.game.addSun(10);
		SunsManager.addCatchedSun();
		return true;
	}

	@Override
	public boolean receiveZombieAttack(int damage) {
		return false;
	}

	@Override
	public boolean receivePlantAttack(int damage) {
		return false;
	}

	@Override
	public boolean isAlive() {
		return (this.hp>0);
	}

	@Override
	protected String getSymbol() {
		return Messages.SUN_SYMBOL;
	}

	@Override
	public String getDescription() {
		return Messages.SUN_DESCRIPTION;
	}

	@Override
	public void update() {
		this.hp--;
		if(hp == 0) {
			onExit();
		}
		
	}

	@Override
	public void onEnter() {
		SunsManager.addGenSun();
		
	}

	@Override
	public void onExit() {
	}
	
	@Override
	public boolean isEntity() {
		return false;
	}

	@Override
	public int getCooldown() {
		return this.cooldown;
	}
}
