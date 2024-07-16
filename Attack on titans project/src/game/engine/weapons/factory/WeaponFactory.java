package game.engine.weapons.factory;

import java.io.IOException;
import java.util.HashMap;

import game.engine.dataloader.DataLoader;
import game.engine.exceptions.GameActionException;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.exceptions.InvalidCSVFormat;
import game.engine.weapons.Weapon;
import game.engine.weapons.WeaponRegistry;

public class WeaponFactory {

	private final HashMap<Integer, WeaponRegistry> weaponShop;

	public WeaponFactory() throws IOException {
		weaponShop = DataLoader.readWeaponRegistry();
	}

	public HashMap<Integer, WeaponRegistry> getWeaponShop() {
		return weaponShop;
	}

	public FactoryResponse buyWeapon(int resources, int weaponCode) throws InsufficientResourcesException {
		WeaponRegistry weaponRegistry = weaponShop.get(weaponCode);

		if (weaponRegistry.getPrice() > resources) {
			throw new InsufficientResourcesException(resources);
		}
		Weapon weapon = weaponRegistry.buildWeapon(); // Assuming getcode() is a method in WeaponRegistry class that returns a Weapon object
		int remianingresources = resources - weaponRegistry.getPrice();
		return new FactoryResponse(weapon, remianingresources);
	}

	public void addWeaponToShop(int code, int price)  {

		weaponShop.put(code, new WeaponRegistry(code, price));

	}

	public void addWeaponToShop(int code, int price, int damage, String name)  {

		WeaponRegistry weaponRegistry = weaponShop.get(code);
		weaponShop.put(code, new WeaponRegistry(code, price, damage, name));
	}

	public void addWeaponToShop(int code, int price, int damage, String name, int minRange, int maxRange) {


		WeaponRegistry weaponRegistry = weaponShop.get(code);
		weaponShop.put(code, new WeaponRegistry(code, price, damage, name, minRange, maxRange));
	}
}
