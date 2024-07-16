package game.engine.weapons;
import game.engine.titans.Titan;

import java.util.PriorityQueue;
public class VolleySpreadCannon extends Weapon {
	public final static int WEAPON_CODE = 3;
	private final int minRange;
	private final int maxRange;


	public VolleySpreadCannon(int baseDamage, int minRange, int maxRange) {
		super(baseDamage);
		this.maxRange = maxRange;
		this.minRange = minRange;
	}
	public int getMinRange() {
		return minRange;
	}

	public int getMaxRange() {
		return maxRange;
	}
	/*@Override
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int totalResourcesGained = 0;
		PriorityQueue<Titan> remainingTitans = new PriorityQueue<>();

		while (!laneTitans.isEmpty()) {
			Titan titan = laneTitans.poll();
			if (titan.getDistance() >= this.minRange && titan.getDistance() <= this.maxRange) {
				int damageDealt = this.attack(titan);
				if (titan.getBaseHealth() <= 0) {
					titan.isDefeated();
				} else {
					remainingTitans.add(titan);
				}
			} else {
				remainingTitans.add(titan);
			}
		}

		while (!remainingTitans.isEmpty()) {
			laneTitans.add(remainingTitans.poll());
		}

		return totalResourcesGained;
	}
}*/
	@Override
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int totalResourcesGained = 0;
		PriorityQueue<Titan> remainingTitans = new PriorityQueue<>();

		while (!laneTitans.isEmpty()) {
			Titan titan = laneTitans.poll();
			if (titan.getDistance() >= this.minRange && titan.getDistance() <= this.maxRange) {
				int damageDealt = attack(titan);
				if (titan!=null&&titan.isDefeated()) {
					totalResourcesGained+=damageDealt;
				} else {
					remainingTitans.add(titan);
				}
			} else {
				remainingTitans.add(titan);
			}
		}
        laneTitans.addAll(remainingTitans);
		return totalResourcesGained;
	}
}


