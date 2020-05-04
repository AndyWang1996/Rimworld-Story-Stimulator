package objects;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.alibaba.fastjson.JSON;

import database.DataLoader;

public class Status {
	
	public String GoodOrBad;
	public String status_name;
	public String status_detail; //作为引发其他事件的原因
	public String status_reason; //作为被其他事件引发的原因
	public int time;
	
	public Status(String name, String datail, String reason, int time, String GoodOrBadBoolean) {
		// TODO Auto-generated constructor stub
		this.status_name = name;
		this.status_detail = datail;
		this.time = time;
		this.GoodOrBad = GoodOrBadBoolean;
		this.status_reason = reason;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, Status> generate_body_status_list() {
		Map<String, Status> result = new HashMap<>();
		Map rawMap = (Map) ((Map) JSON.parse(DataLoader.readJsonFile(new File("./data/humans/bodyPartStatus.json")))).get("bodyPartStatus");
		result = load_loop(rawMap);
		return result;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, Status> generate_person_status_list() {
		Map<String, Status> result = new HashMap<>();
		Map rawMap = (Map) ((Map) JSON.parse(DataLoader.readJsonFile(new File("./data/humans/CharacterStatus.json")))).get("CharacterStatus");
		result = load_loop(rawMap);
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, Status> generate_good_moods_list() {
		Map<String, Status> result = new HashMap<>();
		Map rawMap = (Map) ((Map) JSON.parse(DataLoader.readJsonFile(new File("./data/humans/GoodMood.json")))).get("GoodMoods");
		result = load_loop(rawMap);
		return result;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, Status> generate_bad_moods_list() {
		Map result = new HashMap<String, Object>();
		result = (Map) ((Map) JSON.parse(DataLoader.readJsonFile(new File("./data/humans/BadMood.json")))).get("BadMoods");
		return load_loop(result);
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
	
	public String get_GoodOrBadBoolean() {return GoodOrBad;}
	
	public String get_name() {return status_name;}
	
	public String get_detail() {return status_detail;}
	
	public String get_reason() {return status_reason;}
	
	public Status SetAStatus(String reason) {
		this.status_reason = reason;
		return this;
	}
	
	public boolean _do_extend(int t){
		this.time += t;
		return true;
	}
	
	public boolean _do_shorten(int t) {
		if (t >= time) {
			this.time = -1;
			return false;
		}else {
			this.time -= t;
			return true;
		}
	}
	
	public boolean _do_time_check() {
		if (time > 0) {
			time -= 1;
			return true;
		}else {
			time = -1;
			return false;
		}
	}
	
	public void _do_status_change(String name, int t) {
		this.status_reason = this.status_detail;
		this.status_name = name;
		this.time = t;
	}

	public static void main(String args[]) {
		Map aMap = generate_body_status_list();
		Object[] keys = aMap.keySet().toArray();
		Random random = new Random();
		Object randomKey = keys[random.nextInt(keys.length)];
		System.out.println(aMap.get(randomKey));
		System.out.println(randomKey);
//		System.out.println(generate_body_status_list());
//		System.out.println(generate_person_status_list());
//		System.out.println(generate_bad_moods_list());
//		System.out.println(generate_good_moods_list());
	}
}
