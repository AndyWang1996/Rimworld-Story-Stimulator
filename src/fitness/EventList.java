package fitness;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextArea;

import com.alibaba.fastjson.JSON;

import database.DataLoader;
import framework.MainFrame;
import objects.Human;

public class EventList {
	
	String fLAGString = "normal";
	Scenes eventScene;
	Map<String, Object> dataMap = new HashMap<String, Object>();
	Map<String, Object> eventList = new HashMap<String, Object>();
	
	@SuppressWarnings("rawtypes")
	public EventList(String flag) {
		this.fLAGString = flag;
		
		this.dataMap.put("AGRI", (Map) JSON.parse(DataLoader.readJsonFile(new File("./data/event/Agri_event.json"))));
		System.out.println("¡Ì");
		
		this.dataMap.put("BATT", (Map) JSON.parse(DataLoader.readJsonFile(new File("./data/event/Battle_event.json"))));
		System.out.println("¡Ì");
		
		this.dataMap.put( "INT", (Map) JSON.parse(DataLoader.readJsonFile(new File("./data/event/Int_event.json"))));
		System.out.println("¡Ì");
		
		this.dataMap.put("MEDI", (Map) JSON.parse(DataLoader.readJsonFile(new File("./data/event/Medic_event.json"))));
		System.out.println("¡Ì");
		
		this.dataMap.put("TRAV", (Map) JSON.parse(DataLoader.readJsonFile(new File("./data/event/Travel_event.json"))));
		System.out.println("¡Ì");
		
		this.dataMap.put("SOCI", (Map) JSON.parse(DataLoader.readJsonFile(new File("./data/event/Social_event.json"))));
		System.out.println("x");
		
		this.dataMap.put("NEWM", (Map) JSON.parse(DataLoader.readJsonFile(new File("./data/event/Newman_event.json"))));
		System.out.println("¡Ì");
		
		this.dataMap.put("WEAT", (Map) JSON.parse(DataLoader.readJsonFile(new File("./data/event/Weather_event.json"))));
		System.out.println("¡Ì");
	}
	
	public void swap_flag(String flag) {
		this.fLAGString = flag;
	}
	
	public void excute_Eventlist(JTextArea stroyTextArea,List<Human> currentHumans) throws IOException {
		build_list();
		eventScene = new Scenes(currentHumans, fLAGString, eventList, stroyTextArea);
		eventScene.settle_Event();
		eventList.clear();
	}

	private void build_list() {
		// TODO Auto-generated method stub
//		addBattleEvent();
		addWeatherEvent();
		addINTEvent();
		addAricultureEvent();
		addTravelEvent();
		if (MainFrame.characList.size()<3) {
			System.out.println("newMan1");
			addNewManEvent();
		}
		else if (Dice.throw_a_dice("1d100")<=10) {
			System.out.println("newMan2");
			addNewManEvent();
		}
		if (Dice.throw_a_dice("1d100")<=20) {
			addBattleEvent();
		}
		addMEDIEvent();
	}


	@SuppressWarnings("rawtypes")
	private void addINTEvent() {
		// TODO Auto-generated method stub
		Map intMap;
		intMap = (Map) ((Map) dataMap.get("INT")).get("research");
		eventList.put("INT", intMap);
		System.out.println(intMap);
	}
	
	@SuppressWarnings("rawtypes")
	private void addMEDIEvent() {
		// TODO Auto-generated method stub
		Map intMap;
		intMap = (Map) ((Map) dataMap.get("MEDI")).get("first_aid");
		eventList.put("MEDI", intMap);
		System.out.println(intMap);
	}

	@SuppressWarnings("rawtypes")
	private void addAricultureEvent() {
		// TODO Auto-generated method stub
		Map agriMap;
		Map agriEvent;
		if (Dice.throw_a_dice("1d2") == 1) {
			agriMap = (Map) dataMap.get("AGRI");
			agriEvent = (Map) agriMap.get("gather");
			eventList.put("AGRI", agriEvent.get(Integer.toString(Dice.throw_a_dice("1d" + (agriEvent.size()-1)))));
		}else {
			agriMap = (Map) dataMap.get("AGRI");
			agriEvent = (Map) agriMap.get("hunter");
			eventList.put("AGRI", agriEvent.get(Integer.toString(Dice.throw_a_dice("1d" + (agriEvent.size()-1)))));
		}
	}

	@SuppressWarnings("rawtypes")
	private void addBattleEvent() {
		// TODO Auto-generated method stub
		Map battleMap = (Map) dataMap.get("BATT");
		eventList.put("BATT", battleMap);
	}

	@SuppressWarnings("rawtypes")
	private void addNewManEvent() {
		// TODO Auto-generated method stub
		Map newManMap = (Map) dataMap.get("NEWM");
		eventList.put("NEWM", newManMap.get(Integer.toString(Dice.throw_a_dice("1d" + (newManMap.size()-1)))));
	}

	@SuppressWarnings("rawtypes")
	private void addTravelEvent() {
		// TODO Auto-generated method stub
		Map travelMap = (Map) dataMap.get("TRAV");
		Map singleeventMap = (Map) travelMap.get(Integer.toString(Dice.throw_a_dice("1d" + (travelMap.size()-1))));
		eventList.put("TRAV", singleeventMap);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void addWeatherEvent() {
		// TODO Auto-generated method stub
		List<String> tempList = (List)((Map)dataMap.get("WEAT")).get("weather");
		eventList.put("WEAT", tempList.get(Dice.throw_a_dice("1d" + (tempList.size()-1))));
	}
	
	public void clean() {
		this.eventList.clear();
	}
	
	public static void main(String args[]) {
		EventList eventList = new EventList("normal");
//		eventList.addNewManEvent();
//		eventList.addTravelEvent();
//		eventList.addBattleEvent();
//		eventList.addAricultureEvent();
		eventList.addINTEvent();
//		System.out.println(eventList.eventList.get("AGRI"));
	}
	
}
