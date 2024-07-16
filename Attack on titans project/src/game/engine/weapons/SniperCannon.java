package game.engine.weapons;

import game.engine.titans.Titan;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SniperCannon extends Weapon {
	public static final int WEAPON_CODE = 2;

	public SniperCannon(int baseDamage) {
		super(baseDamage);
	}

	@Override
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		if (laneTitans.isEmpty()) {
			return 0; // No titans to attack
		}

		// Get the closest titan (the head of the priority queue)
		Titan t = laneTitans.peek();
		if (t != null) {
			int resourcesGained = t.takeDamage(getDamage());
			if (t.isDefeated()) {
				laneTitans.poll(); // Remove the defeated titan from the queue
				return resourcesGained; // Return the resources gained from the defeated titan
			}
		}
		return 0; // No resources gained if the titan was not defeated
	}
}