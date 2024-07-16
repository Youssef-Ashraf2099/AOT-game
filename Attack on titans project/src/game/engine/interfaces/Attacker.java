/*package game.engine.interfaces;

public interface Attacker {
	int getDamage(); //return the damage of the attacker
	 default int attack(Attackee target){

		int damage=getDamage();
		int health= target.getCurrentHealth();
		health-=damage;
		target.setCurrentHealth(health);
		if (target.isDefeated()){
			return target.getResourcesValue();
		}
		return 0;
	}


}*/
package game.engine.interfaces;

public interface Attacker {
	int getDamage();

	default int attack(Attackee target){
		return target.takeDamage(getDamage());
	}


}
