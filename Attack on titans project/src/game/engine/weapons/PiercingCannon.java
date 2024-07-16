package game.engine.weapons;

import game.engine.titans.Titan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PiercingCannon extends Weapon {
	public static final int WEAPON_CODE = 1;

	public PiercingCannon(int baseDamage) {
		super(baseDamage);
	}

	/*@Override
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int totalResourcesGained = 0;
		int attacksPerformed = 0;

		// Use an iterator to go through the priority queue
		Iterator<Titan> it = laneTitans.iterator();
	//	PriorityQueue<Titan> orderedTitans = new PriorityQueue<>(Comparator.comparing(Titan::getDistanceFromCannon));
	//	orderedTitans.addAll(laneTitans);
		while (it.hasNext() && attacksPerformed < 5) {
			Titan titan = it.next();
			// Attack the titan and get the resources gained if it's defeated
			int resourcesGained = titan.takeDamage(getDamage());

			// If the titan is defeated, add the resources to the total and remove the titan
			if (titan.isDefeated()) {
				totalResourcesGained += resourcesGained;
				it.remove(); // Remove the defeated titan from the queue
			}

			attacksPerformed++; // Increment the number of attacks performed
		}

		// Return the total resources gained from defeated titans
		return totalResourcesGained;
	}*/
	/*@Override
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int totalResourcesGained = 0;
		int attacksPerformed = 0;

		// Create a temporary priority queue to sort titans by distance (closest first)
		PriorityQueue<Titan> sortedTitans = new PriorityQueue<>(Comparator.comparingInt(Titan::getDistance));
		sortedTitans.addAll(laneTitans);

		// Attack the closest 5 titans
		while (!sortedTitans.isEmpty() && attacksPerformed < 5) {
			Titan titan = sortedTitans.poll(); // Get the closest titan
			// Attack the titan and get the resources gained if it's defeated
			int resourcesGained = titan.takeDamage(getDamage());

			// If the titan is defeated, add the resources to the total and remove the titan
			if (titan.isDefeated()) {
				totalResourcesGained += resourcesGained;
				laneTitans.remove(titan); // Remove the defeated titan from the original queue
			}

			attacksPerformed++; // Increment the number of attacks performed
		}

		// Return the total resources gained from defeated titans
		return totalResourcesGained;
	}*/
	/*@Override
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int totalResourcesGained = 0;
		int attacksPerformed = 0;
		ArrayList<Titan> isremaining = new ArrayList<>();
		while (!laneTitans.isEmpty() && attacksPerformed < 5) {
			Titan titan = laneTitans.peek();
			attack(titan);
			if (titan!=null&&titan.isDefeated()) {
				totalResourcesGained+=titan.getResourcesValue();
				laneTitans.poll();
			} else {
				isremaining.add(laneTitans.poll());
			}
			attacksPerformed++;
		}
		laneTitans.addAll(isremaining);
		return totalResourcesGained;
	}
}*/
	@Override
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int totalResourcesGained = 0;
		int titansAttacked = 0;

		// Create a temporary priority queue to hold the Titans after attack
		PriorityQueue<Titan> tempQueue = new PriorityQueue<>(Comparator.comparingInt(Titan::getDistance));

		while (!laneTitans.isEmpty() && titansAttacked < 5) {
			Titan titan = laneTitans.poll(); // Get the closest titan
			//if (titan != null) {
				//int resourcesGained = titan.takeDamage(getDamage());
				int resourcesGained=attack(titan);
				if (titan.isDefeated()) {
					totalResourcesGained += resourcesGained; // Add resources if titan is defeated
				} else {
					tempQueue.add(titan); // Re-add the titan to the temporary queue if not defeated
				}
				titansAttacked++;
			//}
		}

		// Add back all remaining Titans to the lane queue
		laneTitans.addAll(tempQueue);

		return totalResourcesGained; // Return the total resources gained from defeated titans
	}
	/*public int turnAttack(PriorityQueue<Titan> laneTitans){
		int totalsumresourcesgathered=0;
		ArrayList<Titan>isremaining=new ArrayList<>();
		for (int i = 0; i <5&&!laneTitans.isEmpty() ; i++) {
			totalsumresourcesgathered+=attack(laneTitans.peek());
			if (laneTitans.peek()!=null&&laneTitans.peek().isDefeated()){
				laneTitans.poll();
			}else{
				isremaining.add(laneTitans.poll());
			}
		}
		laneTitans.addAll(isremaining);
		return totalsumresourcesgathered;
	}*/
//	public int turnAttack(PriorityQueue<Titan> laneTitans) {
//		int totalResourcesGained = 0;
//		int titansAttacked = 0;
//
//		// Create a temporary priority queue to hold the Titans after attack
//		PriorityQueue<Titan> tempQueue = new PriorityQueue<>(Comparator.comparingInt(Titan::getDistance));
//
//		// Add all Titans to the temporary queue to sort them by distance
//		tempQueue.addAll(laneTitans);
//		laneTitans.clear();
//
//		while (!tempQueue.isEmpty() && titansAttacked < 5) {
//			Titan titan = tempQueue.poll(); // Get the closest titan
//			if (titan != null) {
//				int resourcesGained = attack(titan);
//				if (titan.isDefeated()) {
//					totalResourcesGained += resourcesGained; // Add resources if titan is defeated
//				} else {
//					laneTitans.add(titan); // Re-add the titan to the original queue if not defeated
//				}
//				titansAttacked++;
//			}
//		}
//
//		// Add back all remaining Titans to the lane queue
//		laneTitans.addAll(tempQueue);
//
//		return totalResourcesGained; // Return the total resources gained from defeated titans
//	}
	/*public int turnAttack(PriorityQueue<Titan> laneTitans){
		int totalresourcesgathered=0;
		int numofattacksperformed=0;
		while (numofattacksperformed<5&&!laneTitans.isEmpty()){
			Titan t=laneTitans.poll();
			int damage=getDamage();
			totalresourcesgathered+=t.takeDamage(damage);
			if(t.isDefeated()){
				laneTitans.remove(t);
			}
			numofattacksperformed++;
		}
		return totalresourcesgathered;
	}*/
}
