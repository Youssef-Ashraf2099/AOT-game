package game.engine.lanes;

import java.util.*;

import game.engine.base.Wall;
import game.engine.titans.*;
import game.engine.weapons.Weapon;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

public class Lane extends Node implements Comparable<Lane> {

	private final PriorityQueue<Titan> titans;
	private final ArrayList<Weapon> weapons;
	private final Wall laneWall;
	private int dangerLevel;

	public Lane(Wall laneWall) {
		this.laneWall = laneWall;
		titans = new PriorityQueue<Titan>();
		weapons = new ArrayList<Weapon>();
		dangerLevel = 0;
	}

	public int getDangerLevel() {
		return dangerLevel;
	}

	public void setDangerLevel(int dangerLevel) {
		this.dangerLevel = dangerLevel;
	}

	public Wall getLaneWall() {
		return laneWall;
	}

	public PriorityQueue<Titan> getTitans() {
		return titans;
	}

	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}

	@Override
	public int compareTo(Lane L) {

		return this.dangerLevel - L.dangerLevel;
	}

	public void addTitan(Titan titan){
		titans.add(titan);
	}
	public void addWeapon(Weapon weapon){
		weapons.add(weapon);
	}

   public void moveLaneTitans(){
	   ArrayList<Titan>titanmoves=new ArrayList<>();
	   while (!titans.isEmpty()) {
       Titan  titan =titans.poll();
		   titanmoves.add(titan);
		   if (!titan.hasReachedTarget()){
			   titan.move();
		 }

	   }
	   titans.addAll(titanmoves);
   }



	public int performLaneTitansAttacks() {
		int totalResourcesGathered = 0;




		for (Titan t : titans) {
			if (t.hasReachedTarget()) {
				totalResourcesGathered += t.attack(laneWall); // Assuming Titan class has an attack method
			}
		}

		return totalResourcesGathered;
	}

	public int performLaneWeaponsAttacks() {
		int totalResourcesGathered = 0;

		for (Weapon weapon : weapons) {
			totalResourcesGathered += weapon.turnAttack(titans); // Assuming Weapon class has a turnAttack method
		}

		return totalResourcesGathered;
	}


	public boolean isLaneLost(){
		return this.laneWall.getCurrentHealth()<=0;
	}

	public void updateLaneDangerLevel() {
		int totalupdateddangerlevel = 0;
		for (Titan titan : titans) {
			totalupdateddangerlevel += titan.getDangerLevel();
		}
		this.dangerLevel = totalupdateddangerlevel;
	}
}
