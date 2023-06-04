package tp1.p2.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import tp1.p2.exceptions.CommandParseException;
import tp1.p2.exceptions.RecordException;
import tp1.p2.view.Messages;

public class RecordGame {
	private String level[];
	private int cont;
	BufferedWriter writeFile;
	private GameStatus game;
	int score[];
	
	public RecordGame(GameStatus game) {
		level = new String[3];
		score = new int[3];
		cont = 0;
		this.game = game;
	}
	
	public void readFile() throws CommandParseException{
		try {
    		String aux = "";
	    	BufferedReader readFile = new BufferedReader(new FileReader("record.txt"));
	    	while ((aux = readFile.readLine()) != null && cont < level.length) {
				String[] line = aux.split(":", 2);
				level[cont] = line[0];
                score[cont] = Integer.parseInt(line[1]);
                cont++;
	    	}
			readFile.close();
    		
		} catch (Exception e) {
			throw new RecordException("record.txt no existe");
		}	

	}
	
	public int getRecord (String level) {
		for(int i = 0; i < score.length; i++) {
			if(this.level[i].equalsIgnoreCase(level)) {
				return score[i];
			}
		}
		return 0;
	}
	
	public void newRecord(String level, int score) {
		for(int i = 0; i < this.score.length; i++) {
			if(this.level[i].equalsIgnoreCase(level)) {
				this.score[i] = score;
			}
		}
    }
	
	public void save() throws RecordException {
		try {
        	writeFile = new BufferedWriter(new FileWriter("record.txt"));
        	for (int i = 0; i < cont; i++) {
        		writeFile.write(level[i] + ":" + score[i] + "\n");
        	}
			writeFile.close();
		} catch (Exception e) {
			throw new RecordException("record.txt no existe");
		}
	}
}
