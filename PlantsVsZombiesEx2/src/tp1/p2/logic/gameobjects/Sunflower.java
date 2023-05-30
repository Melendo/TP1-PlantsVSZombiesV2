package tp1.p2.logic.gameobjects;

import tp1.p2.logic.Game;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Sunflower extends Plant {

	public static final int COST = 20;
	public static final int DMG = 0;
	public static final int HP = 1;
	public static final int GEN_SUNS = 10;
	public static final int GEN_CCL = 3;
	
	private int shouldGenerate ;
	
	public Sunflower(GameWorld game, int col, int row){
		super(game, col, row);
	}
	
	public Sunflower() {
		this.name = getName();
		this.hp = HP;
	}
	
	public String getDescription1() {
		String str = String.format(Messages.PLANT_DESCRIPTION, COST, DMG, HP);
		return str ;
	}
	
	public boolean sunGeneration() {
		
		if(this.shouldGenerate < (GEN_CCL - 1 )) {
			this.shouldGenerate++;
		} else {
			this.shouldGenerate = 0;
			return true;	
		}
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
		public boolean fillPosition() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean catchObject() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Plant create (GameWorld game, int col, int row) {
			// TODO Auto-generated method stub
			return new Sunflower(game, col, row);
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void update() {
			// TODO Auto-generated method stub
			
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
