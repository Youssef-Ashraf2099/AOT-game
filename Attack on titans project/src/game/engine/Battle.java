package game.engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

import game.engine.exceptions.GameActionException;
import game.engine.interfaces.Attackee;

import game.engine.base.Wall;
import game.engine.dataloader.DataLoader;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import game.engine.titans.Titan;
import game.engine.titans.TitanRegistry;
import game.engine.weapons.Weapon;
import game.engine.weapons.factory.FactoryResponse;
import game.engine.weapons.factory.WeaponFactory;


//import javax.naming.InsufficientResourcesException;

public class Battle {

	private final static int[][] PHASES_APPROACHING_TITANS =
		{		{ 1, 1, 1, 2, 1, 3, 4 },
				{ 2, 2, 2, 1, 3, 3, 4 },
				{ 4, 4, 4, 4, 4, 4, 4 } };

	private final static int WALL_BASE_HEALTH =10000 ;
	private final WeaponFactory weaponFactory;
	private final HashMap<Integer, TitanRegistry> titansArchives;
	private final  ArrayList<Titan> approachingTitans;
	private	final PriorityQueue<Lane> lanes;
	private final ArrayList<Lane> originalLanes;
	private int numberOfTurns;
	private int resourcesGathered;
	private BattlePhase battlePhase;
	private int numberOfTitansPerTurn;
	private int score;
	private int titanSpawnDistance;



	public Battle(int numberOfTurns, int score, int titanSpawnDistance, int initialNumOfLanes,
			int initialResourcesPerLane) throws IOException {
		this.numberOfTurns = numberOfTurns;
		this.score = score;
		this.titanSpawnDistance = titanSpawnDistance;
		this.battlePhase = BattlePhase.EARLY;
		this.numberOfTitansPerTurn = 1;
		resourcesGathered = initialNumOfLanes*initialResourcesPerLane;
		titansArchives = DataLoader.readTitanRegistry();
		approachingTitans = new ArrayList<Titan>();
		lanes = new PriorityQueue<Lane>();
		originalLanes = new ArrayList<Lane>();
		weaponFactory = new WeaponFactory();
		initializeLanes(initialNumOfLanes);
	
	}

	public int getNumberOfTurns() {
		return numberOfTurns;
	}

	public void setNumberOfTurns(int numberOfTurns) {
		this.numberOfTurns = numberOfTurns;
	}

	public int getResourcesGathered() {
		return resourcesGathered;
	}

	public void setResourcesGathered(int resourcesGathered) {
		this.resourcesGathered = resourcesGathered;
	}

	public BattlePhase getBattlePhase() {
		return battlePhase;
	}

	public void setBattlePhase(BattlePhase battlePhase) {
		this.battlePhase = battlePhase;
	}

	public int getNumberOfTitansPerTurn() {
		return numberOfTitansPerTurn;
	}

	public void setNumberOfTitansPerTurn(int numberOfTitansPerTurn) {
		this.numberOfTitansPerTurn = numberOfTitansPerTurn;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTitanSpawnDistance() {
		return titanSpawnDistance;
	}

	public void setTitanSpawnDistance(int titanSpawnDistance) {
		this.titanSpawnDistance = titanSpawnDistance;
	}

	public int[][] getPHASES_APPROACHING_TITANS() {
		return PHASES_APPROACHING_TITANS;
	}

	public int getWALL_BASE_HEALTH() {
		return WALL_BASE_HEALTH;
	}

	public WeaponFactory getWeaponFactory() {
		return weaponFactory;
	}

	public HashMap<Integer, TitanRegistry> getTitansArchives() {
		return titansArchives;
	}

	public ArrayList<Titan> getApproachingTitans() {
		return approachingTitans;
	}

	public PriorityQueue<Lane> getLanes() {
		return lanes;
	}

	public ArrayList<Lane> getOriginalLanes() {
		return originalLanes;
	}
	private void initializeLanes(int numOfLanes)  {

		for (int i = 0; i < numOfLanes; i++) {
			Lane l = new Lane(new Wall(WALL_BASE_HEALTH));
			originalLanes.add(l);
			lanes.add(l);

		}

	}
	public void refillApproachingTitans() {
		Titan addtitans;
		switch (battlePhase) {
			//note the first phase is the early phase and it is equal first array in the 2D array
			//first array=2d array[0]
			//second array=2d array[1]
			//therefor we will loop through the first array size directly
			case EARLY:
				for (int i = 0; i < PHASES_APPROACHING_TITANS[0].length; i++) {
					//titansArchives.get(PHASES_APPROACHING_TITANS[0][i]);
					addtitans = titansArchives.get(PHASES_APPROACHING_TITANS[0][i]).spawnTitan(titanSpawnDistance);
					approachingTitans.add(addtitans);
				}
				break;
			case INTENSE:
				for (int i = 0; i < PHASES_APPROACHING_TITANS[1].length; i++) {
					//titansArchives.get(PHASES_APPROACHING_TITANS[1][i]);
					addtitans = titansArchives.get(PHASES_APPROACHING_TITANS[1][i]).spawnTitan(titanSpawnDistance);
					approachingTitans.add(addtitans);
				}

				break;
			case GRUMBLING:
				for (int i = 0; i < PHASES_APPROACHING_TITANS[2].length; i++) {
					//titansArchives.get(PHASES_APPROACHING_TITANS[2][i]);
					addtitans = titansArchives.get(PHASES_APPROACHING_TITANS[2][i]).spawnTitan(titanSpawnDistance);
					approachingTitans.add(addtitans);
				}
				break;
			default:
				break;
		}
	}


	public void purchaseWeapon(int weaponCode, Lane lane) throws GameActionException, IOException{
		if(!lanes.contains(lane)||lane.isLaneLost()) {
			throw new InvalidLaneException();
		}
		WeaponFactory weaponfactory=new WeaponFactory();
		FactoryResponse factoryesponse=weaponfactory.buyWeapon( resourcesGathered,  weaponCode);
		lane.addWeapon(factoryesponse.getWeapon());
		setResourcesGathered( factoryesponse.getRemainingResources()) ;
		performTurn();
	}




	public void passTurn () {
		performTurn();


	}



	private void addTurnTitansToLane() {
		if (approachingTitans.isEmpty())
			refillApproachingTitans();


		for (Lane lane : lanes) {

			if (!lane.isLaneLost()) {
				for (int i = 0; i < numberOfTitansPerTurn ; i++) {
					if (approachingTitans.isEmpty())
						refillApproachingTitans();


					Titan titan = approachingTitans.remove(0); // Assuming approachingTitans is a List type
					lane.addTitan(titan);
				}
				return;
			}
		}


	}
	private void moveTitans(){

		// Iterate over each lane
		for (Lane lane : lanes) {
			if (!lane.isLaneLost()) {
				// Get the PriorityQueue of Titans in the current lane
				PriorityQueue<Titan> titansInLane = lane.getTitans();

				// Iterate over each Titan in the PriorityQueue
				for (Titan titan : titansInLane) {
					// Call the move method of the Titan
					titan.move();
				}
			}
		}
	}

		private int performWeaponsAttacks() {
			int totalresources=0;
			ArrayList<Lane> Lanes=new ArrayList<Lane>();
			while(!lanes.isEmpty()) {
				Lane lane=lanes.poll();
				if(!lane.isLaneLost()) {
					totalresources+=lane.performLaneWeaponsAttacks();
					Lanes.add(lane);
				}
			}
			for(Lane lane:Lanes) {
				lanes.add(lane);
			}
			this.resourcesGathered+=totalresources;
			this.score+=totalresources;
			return totalresources;
		}


	private int performTitansAttacks() {
		int totalresources=0;
		ArrayList<Lane> isremaining=new ArrayList<Lane>();
    	while(!lanes.isEmpty()) {
    		Lane lane=lanes.poll();
    		if(!lane.isLaneLost()) {
    		totalresources+=lane.performLaneTitansAttacks();
   		if(!lane.isLaneLost())
    		isremaining.add(lane);
    		}
   	}
   	for(Lane lane:isremaining) {
		lanes.add(lane);
	}

    	return totalresources;
	}
	private void updateLanesDangerLevels(){
		ArrayList<Lane>isremaining=new ArrayList<>();
		while (!lanes.isEmpty()){
			Lane lane=lanes.poll();
			if (!lane.isLaneLost()){
				lane.updateLaneDangerLevel();
				isremaining.add(lane);
			}
		}
		lanes.addAll(isremaining);
	}
	private void finalizeTurns(){
		this.numberOfTurns++;

		// Check if the game is over

		// Determine the current phase and number of titans based on the number of turns

		if (this.numberOfTurns < 15) {
			this.battlePhase = BattlePhase.EARLY;

		} else if (this.numberOfTurns < 30 && this.numberOfTurns >= 15) {
			this.battlePhase = BattlePhase.INTENSE;
		} else  if (this.numberOfTurns >= 30){
			this.battlePhase = BattlePhase.GRUMBLING;
			if (this.numberOfTurns % 5 == 0&&numberOfTurns>30) {

				this.numberOfTitansPerTurn *= 2;
			}
		}
	}
	private void performTurn() {


			moveTitans();

			// Perform attacks by all weapons in all lanes
			int totalResourcesFromWeapons = performWeaponsAttacks();

			// Perform attacks by all titans in all lanes

			int wallDestroyed = performTitansAttacks();


			// Add new titans to the lanes
			addTurnTitansToLane();

			// Update the danger level of all lanes
			updateLanesDangerLevels();

			// Finalize the turn by updating the number of turns and the battle phase
			finalizeTurns();

	}
	public boolean isGameOver(){

		for(Lane lane:lanes){
			if(!lane.isLaneLost()){
				return false;
			}
		}
		return true;
	}

}
