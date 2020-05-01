package objects;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import database.DataLoader;
import fitness.Dice;

public class Skill {
	public static String[] skillNameStrings = {
			"Agriculture",
			"Intelligence",
			"Battle",
			"Socializing",
			"Medic",
			"Luckiness",
	};
	
	@SuppressWarnings({ "rawtypes", "null", "unchecked" })
	public static Map<String, Integer> getRandomSkillList(String Occupation){
		Map<String, Integer> skillMap = new HashMap<String, Integer>();
		File occ = new File("./data/humans/occupations_modified.json");
		Map occMap = (Map) JSON.parse(DataLoader.readJsonFile(occ));
		if (Occupation == null) {
			Object[] occKeys = occMap.keySet().toArray();
			int up = occKeys.length;
			List<String> skList = (List<String>) occMap.get(occKeys[Dice.throw_a_dice("1d"+up)]);
			for(int i = 0; i!=5; i++) {
				if (skList.get(i).contains("d")) {
					int temp = Dice.throw_a_dice(skList.get(i));
					skillMap.put(skillNameStrings[i], temp*5);
				}
				else {
					int temp = Integer.parseInt(skList.get(i));
					skillMap.put(skillNameStrings[i], temp*5);
				}
			}
			
			
		}
		else {
			List<String> skList = (List<String>) occMap.get(Occupation);
			for(int i = 0; i!=5; i++) {
				if (skList.get(i).contains("d")) {
					int temp = Dice.throw_a_dice(skList.get(i));
					skillMap.put(skillNameStrings[i], temp*5);
				}
				else {
					int temp = Integer.parseInt(skList.get(i));
					skillMap.put(skillNameStrings[i], temp*5);
				}
			}
			
		}
		skillMap.put(skillNameStrings[5], Dice.throw_a_dice("3d6")*5);
		return skillMap;
	}
	
	public static void main(String args[]) {
		Map<String, Integer> skillMap = getRandomSkillList(null);
		System.out.println(skillMap);
	}
}
