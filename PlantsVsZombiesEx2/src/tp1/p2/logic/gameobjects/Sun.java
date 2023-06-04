package tp1.p2.logic.gameobjects;

import tp1.p2.logic.Game;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.SunsManager;
import tp1.p2.view.Messages;

public class Sun extends GameObject {
	
	public Sun(GameWorld game, int col, int row) {
		
	}

	// Remember that a Sun is updated the very same cycle is added to the container
	public static final int SUN_COOLDOWN = 10+1;

	@Override
	public boolean catchObject() {
		this.hp = 0;
		this.game.addSun(10);
		//SunsManager.setCatchedSuns(SunsManager.getCatchedSuns()+1);
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
		//SunsManager.setGeneratedSuns(SunsManager.getGeneratedSuns()-1);
		
	}
	
	@Override
	public boolean isNPC() {
		return false;
	}

	@Override
	public int getCooldown() {
		// TODO Auto-generated method stub
		return 0;
	}
}
