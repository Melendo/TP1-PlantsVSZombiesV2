package tp1.p2.control.commands;

import tp1.p2.control.Command;
import tp1.p2.control.Level;
import tp1.p2.exceptions.CommandParseException;
import tp1.p2.exceptions.GameException;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class ResetCommand extends Command {
	
	private boolean changeSeedAndDif ;
	
	private Level lv;
	
	private long seed;


	public ResetCommand() {
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_RESET_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_RESET_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_RESET_DETAILS;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_RESET_HELP;
	}

	@Override
	public boolean execute(GameWorld game){
		if(changeSeedAndDif) {
			game.reset(lv, seed);
		}
		else {
			game.reset();
		}
		return true;
	}

	@Override
	public Command create(String[] parameters) throws GameException {
		if(parameters.length == 1) {
			changeSeedAndDif = false;
			return this;
		}
		else if(parameters.length == 3 ) {
			if(Integer.parseInt(parameters[2]) >= 0) {
				lv = Level.valueOfIgnoreCase(parameters[1]);
				if(lv == null) {
					throw new CommandParseException((Messages.INVALID_COMMAND));
				}
				seed = Integer.parseInt(parameters[2]);
				changeSeedAndDif = true;
				return this;
			}
			else {
				throw new CommandParseException((Messages.INVALID_COMMAND));
			}
		}
		else {
			throw new NumberFormatException((Messages.COMMAND_PARAMETERS_MISSING));
		}
	}

}
