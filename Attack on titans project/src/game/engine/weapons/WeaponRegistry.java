package game.engine.weapons;

public class WeaponRegistry {

	private final int code;
	private String name;
	private int price;
	private int damage;
	private int minRange;
	private int maxRange;


	public WeaponRegistry(int code, int price) {
		this.code = code;
		this.price = price;

	}

	public WeaponRegistry(int code, int price, int damage, String name) {
		this.code = code;
		this.price = price;
		this.damage = damage;
		this.name = name;

	}

	public WeaponRegistry(int code, int price, int damage, String name, int minRange, int maxRange) {
		this.code = code;
		this.price = price;
		this.damage = damage;
		this.name = name;
		this.minRange = minRange;
		this.maxRange = maxRange;
	}
	public int getCode() {
		return code;
	}

	public int getPrice() {
		return price;
	}

	public int getDamage() {
		return damage;
	}

	public String getName() {
		return name;
	}

	public int getMinRange() {
		return minRange;
	}

	public int getMaxRange() {
		return maxRange;
	}
	//returning an object of a specific type of weapon based on the weapon code
	public Weapon buildWeapon(){
		if(this.code==1){
			PiercingCannon w=new PiercingCannon(damage);
			return w;
		}else if(this.code==2){
			SniperCannon w=new SniperCannon(damage);
			return w;
		}else if(this.code==3){
			VolleySpreadCannon w=new VolleySpreadCannon(damage,minRange,maxRange);
			return w;
		}else if(this.code==4){
			WallTrap w=new WallTrap(damage);
			return w;
		}else{
			return null;
		}

		//throw new IllegalArgumentException("Invalid weapon code: " + this.code);
	}
}
