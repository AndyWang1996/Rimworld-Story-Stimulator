package objects;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import database.DataLoader;

public class Relation {
	String relationNameString;
	Status relationStatus;
	
	public Relation() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, Status> generate_good_relations_list() {
		Map result = new HashMap<String, Object>();
		result = (Map) ((Map) JSON.parse(DataLoader.readJsonFile(new File("./data/humans/GoodRelation.json")))).get("GoodRelations");
		return load_loop(result);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, Status> generate_bad_relations_list() {
		Map result = new HashMap<String, Object>();
		result = (Map) ((Map) JSON.parse(DataLoader.readJsonFile(new File("./data/humans/BadRelation.json")))).get("BadRelations");
		return load_loop(result);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String,Status> load_loop(Map<String, Object> rawMap){
		Map result = new HashMap<String, Status>();
		for(String Key : rawMap.keySet()) {
			Status status = new Status(
					(String) ((Map)rawMap.get(Key)).get("name"), 
					(String) ((Map)rawMap.get(Key)).get("detail"), 
					"", 
					(int) ((Map)rawMap.get(Key)).get("time"), 
					(String) ((Map)rawMap.get(Key)).get("GoodOrBad")
			);
			result.put(((Map) rawMap.get(Key)).get("name").toString(), status);		
		}
		return result;
	}
	
	public static void main(String args[]) {
		System.out.println(generate_bad_relations_list());
		System.out.println(generate_good_relations_list());
	}
}
