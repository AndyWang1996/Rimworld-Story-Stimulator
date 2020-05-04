package fitness;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextArea;

import framework.MainFrame;
import objects.Human;

public class Scenes {
	
	List<Human> subjectHumans = new ArrayList<>();
	List<Human> objectHumans = new ArrayList<>();
	List<Human> teamList = new ArrayList<>();
	JTextArea outpuTextArea;
	
	String flagString;
	
	Map<String, Object> events;
	
	Map<Human, String> socialMotivationMap = new HashMap<Human, String>();
	
	public Scenes(List<Human> team, String flag, Map<String, Object> events, JTextArea storyArea) {
		this.teamList = team;
		this.flagString = flag;
		this.events = events;
		this.outpuTextArea = storyArea;
	}
	
	@SuppressWarnings("unchecked")
	public void settle_Event() throws IOException {
		if (events.get("WEAT") != null) {
			outpuTextArea.append((String) events.get("WEAT"));
		}
		if (events.get("AGRI") != null) {
			Human objHuman = selectObject();
			Map<String, Object> eventMap = (Map<String, java.lang.Object>) events.get("AGRI");
			String name = objHuman.getFirstName();
			String target = (String) eventMap.get("target");
			String output = ((List<String>) eventMap.get("eventdescription")).get((Dice.throw_a_dice("1d2"))-1)
					+ "\n"
					+ eventMap.get(Integer.toString(Dice.successful_level_check(objHuman.getSkill().getSkillMap().get("Agriculture"))));
			
			output = output.replace("{name}", name);
			output = output.replace("{food}", target);
			output = output.replace("{animal}", target);
			
			outpuTextArea.append(output);
			outpuTextArea.append("\n");
			
			String type = (String) eventMap.get("type");
			String gob = (String) eventMap.get("goodorbad");
			String influence = (String) eventMap.get("influence");
			String motivate = (String) eventMap.get("motivate");
			
			check_value_change(objHuman, gob, type, influence);
			if (motivate != null) {add_motivation_list(objHuman, motivate);}
		}
		if (events.get("TRAV") != null) {
			Human objHuman = selectObject();
			Map<String, Object> eventMap = (Map<String, java.lang.Object>) events.get("TRAV");
			String name = objHuman.getFirstName();
			int r = Dice.throw_a_dice("1d8");
			String output = (String) eventMap.get("decription")
					+ "\n"
					+ ((Map)eventMap.get(Integer.toString(r))).get("decription");
			
			output = output.replace("{name}", name);
			
			outpuTextArea.append(output);
			outpuTextArea.append("\n");
			
			String type = (String) ((Map)eventMap.get(Integer.toString(r))).get("type");
			String gob = (String) ((Map)eventMap.get(Integer.toString(r))).get("goodorbad");
			String influence = (String) ((Map)eventMap.get(Integer.toString(r))).get("influence");
			String motivate = (String) ((Map)eventMap.get(Integer.toString(r))).get("motivate");
			
			check_value_change(objHuman, gob, type, influence);
			if (motivate != null) {add_motivation_list(objHuman, motivate);}
		}
		if (events.get("NEWM") != null) {
			Human objHuman = selectObject();
			Map<String, Object> eventMap = (Map<String, java.lang.Object>) events.get("NEWM");
			String name = objHuman.getFirstName();
			String target = (String) eventMap.get("target");
			String output = ((List<String>) eventMap.get("eventdescription")).get((Dice.throw_a_dice("1d2"))-1)
					+ "\n"
					+ eventMap.get(Integer.toString(Dice.successful_level_check(objHuman.getSkill().getSkillMap().get("Agriculture"))));
			
			output = output.replace("{name}", name);
			output = output.replace("{food}", target);
			output = output.replace("{animal}", target);
			
			outpuTextArea.append(output);
			outpuTextArea.append("\n");
			
			String type = (String) eventMap.get("type");
			String gob = (String) eventMap.get("goodorbad");
			String influence = (String) eventMap.get("influence");
			String motivate = (String) eventMap.get("motivate");
			
			check_value_change(objHuman, gob, type, influence);
			if (motivate != null) {add_motivation_list(objHuman, motivate);}
		}
	}
	
	private void add_motivation_list(Human objHuman, String motivate) {
		// TODO Auto-generated method stub
		socialMotivationMap.put(objHuman, motivate);
		
	}

	private void check_value_change(Human human, String gob, String type, String influence) {
		// TODO Auto-generated method stub
		if (type == "food") {
			if (gob == "good") {
				MainFrame.FOOD += Dice.throw_a_dice(influence);
			}else {
				MainFrame.FOOD -= Dice.throw_a_dice(influence);
			}
		}else if (type == "INT") {
			if (gob == "good") {
				MainFrame.PRO += Dice.throw_a_dice(influence);
			}else {
				MainFrame.PRO -= Dice.throw_a_dice(influence);
			}
		}else if (type == "HP") {
			if (gob == "good") {
				human.HP += Dice.throw_a_dice(influence);
				if (human.HP > 10) {
					human.HP = 10;
				}
			}else {
				human.HP -= Dice.throw_a_dice(influence);
			}
		}
		else if (type == "unity") {
			if (gob == "good") {
				MainFrame.UNITY += Dice.throw_a_dice(influence);
				change_mood(human, 1);
			}else {
				MainFrame.UNITY -= Dice.throw_a_dice(influence);
				change_mood(human, -1);
			}
		}
	}

	private void change_mood(Human human, int i) {
		// TODO Auto-generated method stub
		
	}

	private Human selectObject() throws IOException {
		// TODO Auto-generated method stub
		List<Human> humans = teamList;
		for (Human h: humans) {
			if (h.getBodyStatus().get_name() == "shock" || h.getBodyStatus().get_name() == "coma") {
				humans.remove(h);
				outpuTextArea.append(h.getFirstName() + " " + h.getlastName() + " is in " + h.getBodyStatus().get_name() + ", can't do anything.");
			}
		}
		if (humans.size() == 0) {
			outpuTextArea.append("There are no more people in the team that can act normally. The story ends here.\n");
			Do_end_of_story();
		}
		if (humans.size() == 1) {
			return humans.get(0);
		}else {
			return humans.get((Dice.throw_a_dice("1d" + humans.size()))-1);
		}
	}
	
	private List<Human> selectObjects() throws IOException {
		// TODO Auto-generated method stub
		List<Human> humans = teamList;
		for (Human h: humans) {
			if (h.getBodyStatus().get_name() == "shock" || h.getBodyStatus().get_name() == "coma") {
				humans.remove(h);
				outpuTextArea.append(h.getFirstName() + " " + h.getlastName() + " is in " + h.getBodyStatus().get_name() + ", can't do anything.");
			}
		}
		if (humans.size() == 0) {
			outpuTextArea.append("There are no more people in the team that can act normally. The story ends here.\n");
			Do_end_of_story();
		}
		return humans;
	}
	
	private void Do_end_of_story() throws IOException {
		// TODO Auto-generated method stub
		String outputString = MainFrame.stroyTextArea.getText();
		FileOutputStream fileOutputStream = null;
        File file = new File("output.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(outputString.getBytes("gbk"));
        fileOutputStream.flush();
        fileOutputStream.close();
        System.exit(0);
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
