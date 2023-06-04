package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import tp1.p2.exceptions.GameException;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class ZombieFactory {

	/* @formatter:off */
	private static final List<Zombie> AVAILABLE_ZOMBIES = Arrays.asList(
		new NormalZombie(),
		new BucketHead(),
		new Sporty(),
		new ExplosiveZombie()
	);
	/* @formatter:on */

	public static boolean isValidZombie(int zombieIdx) {
		return zombieIdx >= 0 && zombieIdx < AVAILABLE_ZOMBIES.size();
	}

	public static Zombie spawnZombie(int zombieIdx, GameWorld game, int col, int row) {
		if (!isValidZombie(zombieIdx)) {
			//throw new GameException(Messages.INVALID_GAME_OBJECT);
		}
		Zombie z = AVAILABLE_ZOMBIES.get(zombieIdx);
		return z.create(game, row);
		
	}

	public static List<Zombie> getAvailableZombies() {
		return Collections.unmodifiableList(AVAILABLE_ZOMBIES);
	}

	/*
	 * Avoid creating instances of this class
	 */
	private ZombieFactory() {
	}
}
