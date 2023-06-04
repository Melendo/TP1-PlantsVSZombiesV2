package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import tp1.p2.logic.GameWorld;

public class PlantFactory {

	/* @formatter:off */
	private static final List<Plant> AVAILABLE_PLANTS = Arrays.asList(
		new Sunflower(),
		new Peashooter(),
		new WallNut(),
		new CherryBomb()
	);
	/* @formatter:on */

	public static boolean isValidPlant(String plantName) { //da siempre falso por alguna razon
		for (Plant p : AVAILABLE_PLANTS) {
			if(p.getName().equalsIgnoreCase(plantName) || p.getSymbol().equalsIgnoreCase(plantName)) { //era porque el == no iba por algun motivo
				//System.out.println(p.getShortcut() + " SI es la planta seleccionada");
				return true;			
			} else {
				//System.out.println(p.getSymbol() + " No es la planta seleccionada");
			}
		}

		return false;
	}

	public static Plant spawnPlant(String plantName, GameWorld game, int col, int row) {
		for (Plant p : AVAILABLE_PLANTS) {
			// TODO add your code here
			
			if(p.getName().equalsIgnoreCase(plantName) || p.getSymbol().equalsIgnoreCase(plantName)) {
				return p.create(game, col, row);
			}
		}
		return null;
	}

	public static Iterable<Plant> getAvailablePlants() {
		return Collections.unmodifiableList(AVAILABLE_PLANTS);
	}

	/*
	 * Avoid creating instances of this class
	 */
	private PlantFactory() {
	}
}
