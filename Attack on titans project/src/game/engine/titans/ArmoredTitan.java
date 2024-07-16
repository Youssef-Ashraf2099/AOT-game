package game.engine.titans;

public class ArmoredTitan extends Titan {
	public final static int TITAN_CODE = 3;

	public ArmoredTitan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed,
			int resourcesValue, int dangerLevel) {
		super(baseHealth, baseDamage, heightInMeters, distanceFromBase, speed, resourcesValue, dangerLevel);
	}
	//armored titan Only takes quarter of the intended damage when attacked
	public int takeDamage(int damage) {
		// ArmoredTitan takes only a quarter of the intended damage
		int reducedDamage = damage / 4;
		return super.takeDamage(reducedDamage);
	}


}
