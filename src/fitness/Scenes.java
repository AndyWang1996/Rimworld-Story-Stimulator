package fitness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextArea;

import objects.Human;

public class Scenes {
	
	List<Human> subjectHumans = new ArrayList<>();
	List<Human> objectHumans = new ArrayList<>();
	List<Human> teamList = new ArrayList<>();
	
	String flagString;
	
	Map<String, Object> events;
	
	Map<Human, List<String>> socialMotivationMap = new HashMap<Human, List<String>>();
	
	public Scenes(List<Human> team, String flag, Map<String, Object> events, JTextArea storyArea) {
		this.teamList = team;
		this.flagString = flag;
		this.events = events;
	}
	
	@SuppressWarnings("unchecked")
	public void settle_Event() {
		if (events.get("AGRI") != null) {
			Human objHuman = selectObject();
			Map<String, Object> eventMap = (Map<String, java.lang.Object>) events.get("AGRI");
		}
	}
	
	private Human selectObject() {
		// TODO Auto-generated method stub
		if (this.teamList.size() <= 1) {
			return teamList.get(0);
		}else {
			return teamList.get((Dice.throw_a_dice("1d" + teamList.size()))-1);
		}
	}
	
	public static void main(String args[]) {
		Map<String, String> map = new HashMap<>();
		map.put("A", "1");
		map.put("A", "2");
		System.out.println(map.get("A"));
	}
	
	public void get_Event() {
		//get all event that is going to run.
	}
	
}
