package tp1.p2.control.commands;

import java.util.List;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.exceptions.GameException;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.Zombie;
import tp1.p2.logic.gameobjects.ZombieFactory;
import tp1.p2.view.Messages;

public class ListZombiesCommand extends Command {

	@Override
	protected String getName() {
		return Messages.COMMAND_LIST_ZOMBIES_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_LIST_ZOMBIES_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_LIST_ZOMBIES_DETAILS;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_LIST_ZOMBIES_HELP;
	}

	@Override
	public boolean execute(GameWorld game){
		System.out.println(Messages.AVAILABLE_ZOMBIES);
		List<Zombie>  zombieList = (List<Zombie>) ZombieFactory.getAvailableZombies();
		for(int i = 0; i< zombieList.size(); i++) {
			//Hacer descripciones con el nombre incluido
			System.out.print(zombieList.get(i).getName() + ": ");
			System.out.println(zombieList.get(i).getDescription());
		}
		System.out.println();

		return false;
	}
	
	@Override
	public Command create(String[] parameters){
		// TODO Auto-generated method stub
		return this;
	}

}
