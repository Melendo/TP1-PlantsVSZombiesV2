package tp1.p2.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.view.Messages;

public class GameObjectContainer {

	private List<GameObject> gameObjects;

	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}

	public String positionToString(int col, int row) {
		StringBuilder buffer = new StringBuilder();
		boolean sunPainted = false;
		boolean sunAboutToPaint = false;

		for (GameObject g : gameObjects) {
			if(g.isAlive() && g.getCol() == col && g.getRow() == row) {
				String objectText = g.toString();
				sunAboutToPaint = objectText.indexOf(Messages.SUN_SYMBOL) >= 0;
				if (sunAboutToPaint) {
					if (!sunPainted) {
						buffer.append(objectText);
						sunPainted = true;
					}
				} else {
					buffer.append(objectText);
				}
			}
		}

		return buffer.toString();
	}

	public boolean removeDead() {
		for(int i = 0; i < gameObjects.size(); i++) {
			if(!this.gameObjects.get(i).isAlive()) {
				this.gameObjects.get(i).onExit();
				this.gameObjects.remove(i);
				return true;
			}
		}
		return false;
		// TODO add your code here
	}

	public void update() {
		for(int i = 0; i < gameObjects.size(); i++) {
			GameObject g = gameObjects.get(i);
			if(g.isAlive()) {
				g.update();
			}
		}
	}

	public boolean isFullyOccupied(int col, int row) {
	
		for(GameObject go : gameObjects) {
			if (go.isAlive() && go.isInPosition(col, row) && go.isEntity()) {
				return true;
			}
		}

		return false;
	}

	public boolean zombieArrived() {
		
		for(GameObject go : gameObjects) {
			if(go.isEntity() && go.getCol() == -1) {
				return true;
			}
		}
		return false;
	}
	
	public boolean allZombiesDied() {
		for(GameObject go : gameObjects) {
			if(go.isEntity()) {
				return false;
			}
		}
		return true;
	}

	public boolean isPositionEmpty(int numCols, int row) {

		if(gameObjects.isEmpty()) {
			return true;
		}
		else {
			for(GameObject go : gameObjects) {
				if(go.getCol() == numCols && go.getRow() == row) {
					return false;
				}
			}

		}
		return true;
	}

	public void add(GameObject gameObject) {
		 gameObjects.add(gameObject);
		 gameObject.onEnter();
		
	}

	public boolean attackPlant(int i, int row, int dmg) {
		boolean res = false;
		for(GameObject go : gameObjects) {
			if(go.isAlive() && go.isInPosition(i, row)){
				res = go.receiveZombieAttack(dmg);	
			}
		}
		return res;
	}
	
	public boolean attackZombie(int col, int row, int dmg) {
		boolean res = false;
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i).getCol() == col && gameObjects.get(i).getRow() == row) {
				res = gameObjects.get(i).receivePlantAttack(dmg);
			}
		}
		return res;
	}

	public boolean tryToCatchObject(int col, int row) {
		for(GameObject go : gameObjects) {
			if(go.isAlive() && go.isInPosition(col, row)){
				if(go.catchObject()) {
					return true;
				}
			}
		}
		return false;
	}
}
