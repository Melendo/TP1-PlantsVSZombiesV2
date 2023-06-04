package tp1.p2.control.commands;

import tp1.p2.control.Command;
import tp1.p2.control.Level;
import tp1.p2.exceptions.GameException;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class RecordCommand extends Command{
	
	private Level lv;


	@Override
	protected String getName() {
		return Messages.COMMAND_SHOW_RECORD_NAME;
	}
	@Override
	protected String getShortcut() {
		return Messages.COMMAND_SHOW_RECORD_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_SHOW_RECORD_DETAILS;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_SHOW_RECORD_HELP;
	}

	@Override
	public Command create(String[] parameters) throws GameException{
		return this;
	}

	@Override
	public boolean execute(GameWorld game) throws GameException {
		// TODO Auto-generated method stub
		System.out.println(game.getRecord());
		return false;
	}
}
