package tp1.p2.logic.gameobjects;

import tp1.p2.logic.Game;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.SunsManager;
import tp1.p2.view.Messages;

public class Sun extends GameObject {
	
	public static final int HP = 3;
	public static final int SUN_COOLDOWN = 10+1;
	
	//Builder
	public Sun(GameWorld game, int x, int y) {
		super(game, x, y, HP);
		cooldown = SUN_COOLDOWN;
		this.symbol = getSymbol();
		this.name = getSymbol();
		onEnter();
	}

	@Override
	public boolean catchObject() {
		this.hp = 0;
		this.game.addSun(10);
		SunsManager.addCatchedSun();
		return true;
	}

	@Override
	public boolean fillPosition() {
		return false;
	}

	@Override
	public boolean receiveZombieAttack(int damage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receivePlantAttack(int damage) {
		// TODO Auto-generated method stub
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
		this.cooldown--;
		if(cooldown == 0) {
			this.hp = 0;
			onExit();
		}
		
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onExit() {
		SunsManager.removeGenSun();
	}
	
	@Override
	public boolean isEntity() {
		return false;
	}

	@Override
	public int getCooldown() {
		// TODO Auto-generated method stub
		return 0;
	}
}
