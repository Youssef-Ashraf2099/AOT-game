package game.engine.weapons;
import game.engine.titans.Titan;

import java.util.PriorityQueue;
public class WallTrap extends Weapon {
	public final static int WEAPON_CODE = 4;

	public WallTrap(int baseDamage) {
		super(baseDamage);
	}
	/*public int turnAttack(PriorityQueue<Titan> laneTitans) {
		if (!laneTitans.isEmpty()) {
			Titan titan = laneTitans.peek();
			if (titan.getDistance() == 0) {
				int damageDealt = this.attack(titan);
				if (titan.getBaseHealth() <= 0) {
					titan.isDefeated();
					laneTitans.poll();
					return titan.getResourcesValue();
				}
			}
		}
		return 0;
	}*/
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
        int titanResources = 0;
        if (!laneTitans.isEmpty()) {
            Titan titan = laneTitans.peek();
            if (titan!=null&&titan.hasReachedTarget()) {
                attack(titan);
                if (titan.isDefeated()) {
                    laneTitans.poll();
                    titanResources+=titan.getResourcesValue();
                    return titanResources;
                }
            }

        }
        return 0;
    }
}

