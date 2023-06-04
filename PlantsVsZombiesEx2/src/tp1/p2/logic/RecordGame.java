package tp1.p2.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import tp1.p2.exceptions.CommandParseException;
import tp1.p2.exceptions.RecordException;
import tp1.p2.view.Messages;

public class RecordGame {

	private String level[];
	private int score[];
	private int cont;
	BufferedWriter writeFile;
	private static final String FILE_MSG = "Archivo corrupto";
	
	public RecordGame() {
		level = new String[3];
		score = new int[3];
		cont = 0;
	}

	
	public void readFile() throws CommandParseException{
		try {
    		String s = "";
	    	BufferedReader readFile = new BufferedReader(new FileReader("C:\\Users\\Robert\\Documents\\GitHub\\PlantsVSZombiesV2-1\\PlantsVsZombiesEx2\\records.txt"));
	    	while ((s = readFile.readLine()) != null && cont < level.length) {
				String[] parts = s.split(":", 2);
				level[cont]=parts[0];
                score[cont]=Integer.parseInt(parts[1]);
                cont++;
	    	}
			readFile.close();
    		
		} catch (Exception e) {
			throw new RecordException(FILE_MSG);
		}	

	}
	
	public int getScoreRecord(String s) {
        for (int i = 0; i < cont; i++) {
            if(level[i].equalsIgnoreCase(s)) {
                return score[i];
            }
        }
        return -1;
    }
	
	public void setScoreRecord(String s, int r) {
        for (int i = 0; i < cont; i++) {
            if(level[i].equalsIgnoreCase(s)) {            	
                if(score[i] < r) {
                	score[i] = r;
                }
                break;
            }
        }
	}
	
	public void save() throws RecordException {
		try {
        	writeFile = new BufferedWriter(new FileWriter("C:\\Users\\Robert\\Documents\\GitHub\\PlantsVSZombiesV2-1\\PlantsVsZombiesEx2\\\\records.txt", false));
        	for (int i = 0; i < cont; i++) {
        		writeFile.write(level[i] + ":" + score[i] + "\n");
        	}
			writeFile.close();
		} catch (Exception e) {
			throw new RecordException(FILE_MSG);
		}
	}
	

}

