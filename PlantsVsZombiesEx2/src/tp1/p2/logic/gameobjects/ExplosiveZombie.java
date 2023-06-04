package tp1.p2.logic.gameobjects;

import tp1.p2.logic.Game;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.actions.ExplosionAction;
import tp1.p2.logic.actions.GameAction;
import tp1.p2.view.Messages;

public class ExplosiveZombie extends Zombie {
	public static final int HP = 5;
	public static final int DMG = 1;
	public static final int SPEED= 2;
	
	public ExplosiveZombie(GameWorld game, int row) {
		super(game,Game.NUM_COLS + 1, row, HP);
		this.name = Messages.EXPLOSIVE_ZOMBIE_NAME;
		this.symbol = Messages.EXPLOSIVE_ZOMBIE_SYMBOL;
		this.cooldown = SPEED;
	}
	
	public ExplosiveZombie() {
		
	}

	@Override
	public Zombie create(GameWorld game, int row) {
		System.out.println("Creado ZBucket");
		return new BucketHead(game, row);
	}

	@Override
	public String getSymbol() {
		return Messages.EXPLOSIVE_ZOMBIE_SYMBOL;
	}

	@Override
	public String getDescription() {
		String str = String.format(Messages.ZOMBIE_DESCRIPTION, SPEED, DMG, HP);
		return str ;
	}

	@Override
	public String getName() {
		return Messages.EXPLOSIVE_ZOMBIE_NAME;
	}
	
	@Override
	public int getCooldown() {
		return this.cooldown;
	}

	@Override
	public void update() {
		
		if(this.col == -1) {
            game.isFinished();
        }

        else if(isAlive()) {
            if(cooldown == 0) {
            	cooldown = SPEED;
            }
            cooldown--;
            if(game.isPositionEmpty(col - 1, row) && cooldown == 0) {
                col -= 1;
            }
            else if(!game.isPositionEmpty(col-1, row) ){
                game.attackPlant(col-1, row, DMG);
            }

        }
        if(hp == 0) {
            GameAction explosion = new ExplosionAction(col, row, DMG, false);
            explosion.execute(game);
        }
		
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
