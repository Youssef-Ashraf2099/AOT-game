/*package game.engine.interfaces;

public interface   Attackee {

	int getCurrentHealth();  //return the current health of the attackee
	void setCurrentHealth(int health);   //set the current health of the attackee
	int getResourcesValue();  //return the

	default boolean isDefeated(){
		if (getCurrentHealth()==0||getCurrentHealth()<0){
			return true;
		}
		return false;
	}
	default int takeDamage(int damage){
		int health=getCurrentHealth();
		health-=damage;
		setCurrentHealth(health);
		if(isDefeated()){
			return getResourcesValue();
		}
		return 0;
	}*/
	/*default int takeDamage(int damage){
		int health=getCurrentHealth();

		while(!isDefeated())
		{
			return health-=damage;
		}
		return 0;
	}*/
package game.engine.interfaces;

public interface Attackee {
	int getCurrentHealth();
	void setCurrentHealth(int health);
	public int getResourcesValue();
	default boolean isDefeated(){
		return getCurrentHealth() <= 0;
	}
	default int takeDamage(int damage){
		setCurrentHealth(getCurrentHealth()-damage);
		return isDefeated() ? getResourcesValue():0;
	}


}