package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.exceptions.CommandParseException;
import tp1.p2.exceptions.GameException;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.Zombie;
import tp1.p2.logic.gameobjects.ZombieFactory;
import tp1.p2.view.Messages;

public class AddZombieCommand extends Command implements Cloneable {

	private int zombieIdx;

	private int col;

	private int row;

	public AddZombieCommand() {
		
	}

	private AddZombieCommand(int zombieIdx, int col, int row) {
		this.zombieIdx = zombieIdx;
		this.col = col;
		this.row = row;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_ADD_ZOMBIE_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_ADD_ZOMBIE_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_ADD_ZOMBIE_DETAILS;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_ADD_ZOMBIE_HELP;
	}

	@Override
	public boolean execute(GameWorld game) throws GameException { 
		if(!game.hasPositionEntity(col, row)) {
			game.addItem(ZombieFactory.spawnZombie(zombieIdx, game, col, row));
			game.update();
		} else throw new CommandParseException(Messages.INVALID_POSITION);
		return true;
	}

	@Override
	public Command create(String[] parameters) throws GameException {
		Command command = null;
		if(parameters.length == 4) {
			if(ZombieFactory.isValidZombie(Integer.parseInt(parameters[1]))) {
				if(Integer.parseInt(parameters[2]) >= 0 && Integer.parseInt(parameters[3]) >= 0) {
					try {
						command = (AddZombieCommand) clone();
					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					}
				} else throw new CommandParseException(Messages.INVALID_POSITION);
			} else throw new CommandParseException(Messages.INVALID_GAME_OBJECT);
		} else throw new CommandParseException(Messages.COMMAND_PARAMETERS_MISSING);
		
		return command;
		// TODO add your code here
	}

}
