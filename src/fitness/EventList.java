package fitness;

import java.util.List;
import java.util.Map;

import javax.swing.JTextArea;

import objects.Event;
import objects.Human;

public class EventList {
		
	List<Event> EventList;
	@SuppressWarnings("rawtypes")
	Map globalDataMap;
	JTextArea storyTextArea;
	
	public EventList(JTextArea stroyTextArea,List<Human> currentHumans) {
		this.storyTextArea = stroyTextArea;
		this.EventList = null;
		this.globalDataMap = null;
	}

	@SuppressWarnings("unchecked")
	public void addIntoGlobalDataMap(String key, Object dataObject) {
		globalDataMap.put(key, dataObject);
	}
	
	@SuppressWarnings({ "unchecked", "null" })
	public void DoAddGlobalEvent() {//创建一个小人
		Human newHuman = null;
		newHuman.create_character("crush", 
				((List<String>)globalDataMap.get("firstNames")).get(Dice.throw_a_dice("1d" + ((List<String>)globalDataMap.get("firstNames")).size())), 
				((List<String>)globalDataMap.get("lastNames")).get(Dice.throw_a_dice("1d" + ((List<String>)globalDataMap.get("lastNames")).size())));
	}
}
