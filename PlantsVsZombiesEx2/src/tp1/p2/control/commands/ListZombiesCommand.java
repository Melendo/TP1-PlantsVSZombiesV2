package tp1.p2.control.commands;

import java.util.List;

import tp1.p2.control.Command;
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
		for(Zombie z: zombieList) {
			System.out.println(z.getDescription());
		}
		System.out.println();

		return false;
	}
	
	@Override
	public Command create(String[] parameters){
		return this;
	}

}
