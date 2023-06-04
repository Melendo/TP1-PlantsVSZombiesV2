package tp1.p2.control.commands;

import tp1.p2.control.Command;
import tp1.p2.control.Level;
import tp1.p2.exceptions.GameException;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class RecordCommand extends Command{
	
	private Level lv;


	@Override
	protected String getShortcut() {
		// TODO Auto-generated method stub
		return Messages.COMMAND_SHOW_RECORD_SHORTCUT;
	}

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return Messages.COMMAND_SHOW_RECORD_DETAILS;
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return Messages.COMMAND_SHOW_RECORD_HELP;
	}

	

	@Override
	public Command create(String[] parameters) throws GameException{
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean execute(GameWorld game) throws GameException {
		// TODO Auto-generated method stub
		System.out.println(game.getRecord());
		return false;
	}
}
