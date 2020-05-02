package objects;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import database.DataLoader;

public class Organ {
	
	public String organ_name;
	public boolean is_lethal;
	public Status status;
	
	public Organ(String name, boolean is_lethal, Status status) {
		this.organ_name = name;
		this.is_lethal = is_lethal;
		this.status = status;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Organ> create_flesh(){
		List<Organ> fleshList = new ArrayList<Organ>();
		Map tempMap = new HashMap<String, List<String>>();
		Status healthStatus = Status.generate_body_status_list().get("health");
		tempMap = (Map) JSON.parse(DataLoader.readJsonFile(new File("./data/humans/bodyParts_modified.json")));
		List<String> tempList = ((List<String>)tempMap.get("bodyParts"));
//		System.out.println(tempList);
		for (int i = 0; i < tempList.size(); i++) {
			fleshList.add(i,new Organ(
					tempList.get(i).toString(),
					false, 
					healthStatus));
		}
		tempList = ((List<String>)tempMap.get("BackParts"));
		for (int i = 0; i < tempList.size(); i++) {
			fleshList.add(i,new Organ(
					tempList.get(i).toString(),
					false, 
					healthStatus));
		}
		tempList = ((List<String>)tempMap.get("LethalParts"));
		for (int i = 0; i < tempList.size(); i++) {
			fleshList.add(i,new Organ(
					tempList.get(i).toString(),
					true, 
					healthStatus));
		}
//		System.out.println(fleshList.get(3).status.get_detail());
		return fleshList;
	}
	
	public static void main(String args[]) {
		System.out.println(create_flesh());
	}

}
