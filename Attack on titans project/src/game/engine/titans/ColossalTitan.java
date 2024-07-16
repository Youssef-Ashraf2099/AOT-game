package game.engine.titans;

public class ColossalTitan extends Titan {
	public final static int TITAN_CODE = 4;

	public ColossalTitan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed,
			int resourcesValue, int dangerLevel) {
		super(baseHealth, baseDamage, heightInMeters, distanceFromBase, speed, resourcesValue, dangerLevel);
	}
	@Override
	public boolean move() {
		// Call the original move method from the Titan class
		boolean hasReached = super.move();

		// Increase the speed by 1 after the move action
			setSpeed(getSpeed() + 1);
		// Return whether the target has been reached
		return hasReached;
	}

}
