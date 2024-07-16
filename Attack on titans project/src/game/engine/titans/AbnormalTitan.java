package game.engine.titans;

import game.engine.interfaces.Attackee;

public class AbnormalTitan extends Titan {
	public final static int TITAN_CODE = 2;

	public AbnormalTitan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed,
			int resourcesValue, int dangerLevel) {
		super(baseHealth, baseDamage, heightInMeters, distanceFromBase, speed, resourcesValue, dangerLevel);
	}
	//checking if the abnormal titan is not defeated first then if the condition is true we double the attack per turn instead of once
	//if the condition is false we return 0

	@Override
	public int attack(Attackee target) {
		int resourcesGathered = target.takeDamage(getDamage());
		// If the target is not defeated by the first attack, attack again
		if (!target.isDefeated()) {
			resourcesGathered += target.takeDamage(getDamage());
		}
		return resourcesGathered;
	}

}
