package tp1.p2.control.commands;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.exceptions.CommandParseException;
import tp1.p2.exceptions.GameException;
import tp1.p2.exceptions.NotEnoughCoinsException;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.PlantFactory;
import tp1.p2.view.Messages;

public class AddPlantCheatCommand extends Command implements Cloneable{

	private int col;

	private int row;

	private String plantName;

	private boolean consumeCoins;

	public AddPlantCheatCommand() {
		this(true);
	}

	public AddPlantCheatCommand(boolean consumeCoins) {
		this.consumeCoins = consumeCoins;
	}

	public AddPlantCheatCommand(String plantName, int col, int row) {
		// TODO Auto-generated constructor stub
		this.col = col;
		this.row = row;
		this.plantName = plantName;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_ADD_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_ADD_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_ADD_DETAILS;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_ADD_HELP;
	}


	@Override
	public boolean execute(GameWorld game) throws GameException {
		if(!game.isFullyOcuppied(col, row)) { 
			if(true) {
				game.addItem(PlantFactory.spawnPlant(plantName, game, col, row));
				game.update();
			} 
		} else {
			throw new CommandParseException(Messages.INVALID_POSITION);
		}
		return true;
		// TODO add your code here
	}

	
	/*
	@Override
	public Command create(String[] parameters) throws GameException {
		Command command = null;
		if(PlantFactory.isValidPlant(parameters[1])) {
			if(Integer.parseInt(parameters[2]) >= 0 && Integer.parseInt(parameters[3]) >= 0) {
				try {
						command = (AddZombieCommand) clone();
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else throw new CommandParseException(Messages.INVALID_POSITION);
		} else throw new CommandParseException(Messages.INVALID_GAME_OBJECT + parameters[1]);
		// TODO add your code here
		return command;
	}
	*/
	
	@Override
	public Command create(String[] parameters) throws GameException {
		Command command = null;
		if(parameters.length == 4) {
			if(PlantFactory.isValidPlant(parameters[1])) {
				try {
			        if(Integer.parseInt(parameters[2]) >= 0  && Integer.parseInt(parameters[3]) >= 0) {
			          try {
			        	plantName = parameters[1];
			        	col = Integer.parseInt(parameters[2]);
			            row = Integer.parseInt(parameters[3]);
			            command = (AddPlantCommand) clone();
			          }  catch(CloneNotSupportedException e) {
			            e.printStackTrace();
			          }
			        }
			     
			      else{
			        throw new CommandParseException(Messages.COMMAND_PARAMETERS_MISSING);
			      }
			      }
			      catch(NumberFormatException e) {
			        throw new CommandParseException((String.format(Messages.INVALID_POSITION, parameters[2], parameters[3], e)));//rompe cuando no metes uno se los parametros
			      }
			} else throw new CommandParseException(Messages.INVALID_GAME_OBJECT);
		} else throw new CommandParseException(Messages.COMMAND_PARAMETERS_MISSING);

		return command;
	}

}
