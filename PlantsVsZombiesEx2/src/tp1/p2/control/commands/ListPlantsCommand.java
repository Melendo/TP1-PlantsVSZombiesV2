package tp1.p2.control.commands;

import java.util.List;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.exceptions.GameException;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.PlantFactory;
import tp1.p2.view.Messages;

public class ListPlantsCommand extends Command {
	
	
	@Override
	protected String getName() {
		return Messages.COMMAND_LIST_NAME;
	}
	@Override
	protected String getShortcut() {
		return Messages.COMMAND_LIST_SHORTCUT;
	}
	@Override
	public String getDetails() {
		return Messages.COMMAND_LIST_DETAILS;
	}
	@Override
	public String getHelp() {
		return Messages.COMMAND_LIST_HELP;
	}

	@Override
	public boolean execute(GameWorld game) throws GameException{
		System.out.println(Messages.AVAILABLE_PLANTS);
		for(Plant p: PlantFactory.getAvailablePlants()) {
			System.out.println(p.getName());
			System.out.println(p.getDescription());
		}

		System.out.println();

		return true;
	}
	
	@Override
	public Command create(String[] parameters){
		// TODO Auto-generated method stub
		return this;
	}

}
