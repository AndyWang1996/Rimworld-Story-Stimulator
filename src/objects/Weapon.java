package objects;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import database.DataLoader;
import fitness.Dice;

public class Weapon {
	
	String nameString;
	
	public Weapon(String name) {
		this.nameString = name;
	}
	
	public String getNameString() {
		return nameString;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Weapon getWeapon() {
		List<String> weaponList = new ArrayList<String>();
		weaponList = (List<String>) ((Map) JSON.parse(DataLoader.readJsonFile(new File("./data/technology/guns_n_rifles.json")))).get("weapons");
		System.out.println(weaponList);
		return new Weapon(weaponList.get(Dice.throw_a_dice("1d"+weaponList.size())));
	}
	
	public static void main(String args[]) {
		System.out.println(getWeapon().getNameString());
	}
}
