/*package game.engine.interfaces;

public interface Mobil {   //mobility distance covered with sort of speed
	// NOTE:the mobil is the object that moves from one place to another..
	int getDistance();  //return the distance of the mobil's movement and the target
	void setDistance(int distance); //displays the change mobil's distance
	int getSpeed();  //show mobil's speed
	void setSpeed(int speed);  //set speed
	default boolean hasReachedTarget() {
		int distance = getDistance();

		// If the distance is 0, the target has been reached
		return (distance == 0);
	}


	default boolean move() {
		int distance = getDistance();
		int speed = getSpeed();

		// Assuming the mobil moves based on its speed
		distance -= speed; // Decreasing distance by speed (assuming forward movement)

		// If the distance becomes negative, set it to 0 (assuming the target is reached)
		if (distance < 0) {
			distance = 0;
		}

		// Update the distance covered by the mobil
		setDistance(distance);

		// Check if the target has been reached after the movement
		return hasReachedTarget();
	}
}*/
package game.engine.interfaces;

public interface Mobil {
	int getDistance();
	void setDistance(int distance);
	int getSpeed();
	void setSpeed(int speed);
	default boolean hasReachedTarget(){
		return getDistance() <= 0;
		//return true if distance is less than or equal to 0
	}
	default boolean move(){
		setDistance(getDistance()-getSpeed());//set new distance
		return hasReachedTarget();
	}

}