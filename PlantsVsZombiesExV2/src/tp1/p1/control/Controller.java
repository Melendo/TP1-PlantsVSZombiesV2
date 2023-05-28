package tp1.p1.control;

import java.util.Scanner;

import tp1.p1.logic.Game;
import tp1.p1.view.GamePrinter;
import tp1.p1.view.Messages;

/**
 * Accepts user input and coordinates the game execution logic.
 *
 */
public class Controller {

	private Game game;

	private Scanner scanner;

	private GamePrinter gamePrinter;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.gamePrinter = new GamePrinter(game);
	}

	/**
	 * Draw / Paint the game.
	 */
	private void printGame() {
		System.out.println(Messages.NUMBER_OF_CYCLES + game.getNumberOfCicles());
		System.out.println(Messages.NUMBER_OF_COINS + " " + game.getSuncoins());
		System.out.println("Remaining zombies: " + game.getRemainingZombies());
		System.out.println(gamePrinter);
	}

	/**
	 * Prints the final message once the match is finished.
	 */
	public void printEndMessage() {
		System.out.println(gamePrinter.endMessage());
	}

	/**
	 * Show prompt and request command.
	 *
	 * @return the player command as words
	 */
	private String[] prompt() {
        System.out.print(Messages.PROMPT);

        String line = scanner.nextLine();
        System.out.println( String.format(Messages.DEBUG, line));
        String[] words = line.toLowerCase().trim().split("\s+");

        return words;
    }
	
	private char userAction() {
		char sol = ' ';
		String[]input = this.prompt();		
		switch(input[0]) {
		
		case "h":		
		case "help":
			System.out.print(Messages.HELP);
			sol = 'h';
			break;
		
		case "l":			
		case "list":
			System.out.println(Messages.LIST);
			sol = 'l';
				break;
		
		case "e":			
		case "exit":
			sol = 'e';
			break;
			
		case "a":		
		case "add": 
			
			if (input.length == 4) {
				switch(input[1]) {
				case "peashooter":
				case "p":
					if(Integer.parseInt(input [2]) >-1 && Integer.parseInt(input [2])<8 && Integer.parseInt(input [3])>-1 && Integer.parseInt(input [3])< 4) {
						if(game.plantar(Integer.parseInt(input [2]), Integer.parseInt(input [3]), 'p' )) {
							sol = 'p';
						}
					}
					 else {
							System.out.println(Messages.INVALID_POSITION);
							sol = ' ';
						}
					break;
					
				case "sunflower":
				case "s":
					
					if(Integer.parseInt(input [2]) >-1 && Integer.parseInt(input [2])<8 && Integer.parseInt(input [3])>-1 && Integer.parseInt(input [3])< 4) {
						if(game.plantar(Integer.parseInt(input [2]), Integer.parseInt(input [3]), 's' )) {
							sol = 's';
						}
					}
					 else {
							System.out.println(Messages.INVALID_POSITION);
							sol = ' ';
						}
					break;
				
						
				}
			} else {
				System.out.println(Messages.INVALID_COMMAND);
			}
			
			break;
			
		case "n":
		case "none":
		case "":
			sol = 'n';
			
			break;
			
		case "r":
		case "reset":
			sol = 'r';
			game.reset();
			break;
			
		default:
			System.out.println(String.format(Messages.ERROR, Messages.UNKNOWN_COMMAND));
			break;
		}
		
		return sol;
		
	}

	/**
	 * Runs the game logic.
	 */
	public void run() {
		printGame();
		char sol = userAction();
		while(sol != 'e') {
			if(sol == 'p' || sol == 's' || sol== 'n') {
				game.gameAction();;
				game.update();
				
				if(game.checkDefeat()) {
					printGame();
					System.out.println(Messages.ZOMBIES_WIN);
					break;
				}
				else if(game.checkVictory()) {
					System.out.println(Messages.PLAYER_WINS);
					break;
				}
				printGame();
			}else if(sol == 'r') {
				printGame();
			}
			sol = userAction();
		}
		System.out.println(Messages.GAME_OVER);
		
		if(sol == 'e') {
			System.out.println(Messages.PLAYER_QUITS);
		}
	}
//hola
}
