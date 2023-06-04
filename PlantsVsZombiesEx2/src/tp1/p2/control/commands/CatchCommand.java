package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.exceptions.CommandExecuteException;
import tp1.p2.exceptions.CommandParseException;
import tp1.p2.exceptions.GameException;
import tp1.p2.exceptions.NotCatchablePositionException;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.PlantFactory;
import tp1.p2.view.Messages;


//Commando tercera version creo


public class CatchCommand extends Command implements Cloneable{

	private static boolean sun = false;

	private int col;

	private int row;

	public CatchCommand() {
		sun = false;
	}
	
	@Override
	protected void newCycleStarted() {
		sun = false;
	}

	private CatchCommand(int col, int row) {
		this.col = col;
		this.row = row;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_CATCH_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_CATCH_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_CATCH_DETAILS;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_CATCH_HELP;
	}

	@Override
	public boolean execute(GameWorld game) throws GameException{
		// TODO add your code here
		if(sun != true) {	
			if(game.tryToCatchObject(col, row)) {
				sun = true;
				return true;
			}
			else {
				throw new NotCatchablePositionException(Messages.NO_CATCHABLE_IN_POSITION.formatted(col, row));
			}
		}	
		
		return false;
		
	}

	
	@Override
	public Command create(String[] parameters) throws GameException{
		// TODO add your code here
		Command command = null;
		try {
			if(parameters.length == 3) {
				if(Integer.parseInt(parameters[1]) >= 0  && Integer.parseInt(parameters[2]) >= 0) {
					try {
						col = Integer.parseInt(parameters[1]);
						row = Integer.parseInt(parameters[2]);
						command = (CatchCommand) clone();
					}catch(CloneNotSupportedException e) {
						e.printStackTrace();
					}
					catch(NumberFormatException e) {
				        throw new CommandParseException((String.format(Messages.INVALID_POSITION, parameters[2], parameters[3], e)));
				    }
				} else throw new CommandParseException((Messages.INVALID_POSITION.formatted(parameters[1], parameters[2])));
			}
			else throw new NumberFormatException((Messages.COMMAND_PARAMETERS_MISSING));
		}
		catch(NumberFormatException e) {
			throw new CommandParseException((Messages.INVALID_POSITION.formatted(parameters[1], parameters[2], e)));
		}
		return command;
	}
	
}
