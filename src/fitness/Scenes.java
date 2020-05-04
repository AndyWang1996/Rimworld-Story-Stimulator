package fitness;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JTextArea;

import org.omg.DynamicAny.NameDynAnyPair;

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
			outpuTextArea.append("\n");
		}
		if (events.get("INT") != null) {
//			System.out.println("INTevent");
			Human objHuman = selectObject();
			Map<String, Object> eventMap = (Map<String, java.lang.Object>) events.get("INT");
			String name = objHuman.getFirstName();
			int level = Dice.successful_level_check(objHuman.getSkill().getSkillMap().get("Intelligence"));
			Map resuMap = (Map) eventMap.get(Integer.toString(level));
			String output = (String) eventMap.get("description")
					+ "\n"
					+ resuMap.get("resultdescription");
			
			output = output.replace("{name}", name);
			outpuTextArea.append(output);
			outpuTextArea.append("\n");
			
			String type = (String) resuMap.get("type");
			String gob = (String) resuMap.get("goodorbad");
			String influence = (String) resuMap.get("influence");
			String motivate = (String) resuMap.get("motivate");
			
			System.out.println(gob + "INT");
			motivate = motivate.replace("{name}", name);
			check_value_change(objHuman, gob, type, influence);
			if (motivate.length()>0) {add_motivation_list(objHuman, motivate);}
		}
		if (events.get("AGRI") != null) {
			Human objHuman = selectObject();
//			System.out.println(objHuman.get_FullName());
			Map<String, Object> eventMap = (Map<String, java.lang.Object>) events.get("AGRI");
//			System.out.println(eventMap);
			String name = objHuman.getFirstName();
			String target = (String) eventMap.get("target");
//			objHuman.display_this_guy();
			int level = Dice.successful_level_check(objHuman.getSkill().getSkillMap().get("Agriculture"));
			String output = ((List<String>) eventMap.get("eventdescription")).get((Dice.throw_a_dice("1d2"))-1)
					+ "\n"
					+ ((List<String>)((Map)eventMap.get(Integer.toString(level))).get("resultdescription")).get(Dice.throw_a_dice("1d3")-1);
			
			output = output.replace("{name}", name);
			output = output.replace("{food}", target);
			output = output.replace("{animal}", target);
			
			outpuTextArea.append(output);
			outpuTextArea.append("\n");
			
			String type = (String) ((Map)eventMap.get(Integer.toString(level))).get("type");
			String gob = (String) ((Map)eventMap.get(Integer.toString(level))).get("goodorbad");
			String influence = (String) ((Map)eventMap.get(Integer.toString(level))).get("influence");
			String motivate = (String) ((Map)eventMap.get(Integer.toString(level))).get("motivate");
			
			System.out.println(gob + "AGRI");
			check_value_change(objHuman, gob, type, influence);
			if (motivate.length()>0) {add_motivation_list(objHuman, motivate);}
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
			
			System.out.println(gob + "TRAV");
			check_value_change(objHuman, gob, type, influence);
//			if (motivate != null && motivate != "") {add_motivation_list(objHuman, motivate);}
		}
		if (events.get("NEWM") != null) {
			Human objHuman = selectObject();
			Human subHuman = new Human();
			subHuman = subHuman.create_character(null);
			
			Map<String, Object> eventMap = (Map<String, java.lang.Object>) events.get("NEWM");
			String name1 = objHuman.getFirstName();
			String name2 = subHuman.getFirstName();

			String output = (String) eventMap.get("description");
			
			output = output.replace("{name1}", name1);
			output = output.replace("{name2}", name2);
			
			outpuTextArea.append(output);
			outpuTextArea.append("\n");
			
			String type = (String) eventMap.get("panalty");
			String gob = "bad";
			String influence = (String) eventMap.get("value");
			String motivate = (String) eventMap.get("motivate");
			
			System.out.println(gob + "NEWM");
			check_value_change(subHuman, gob, type, influence);
			
			outpuTextArea.append(subHuman.get_FullName() + " is a " + subHuman.getSkill().getOccString());
			outpuTextArea.append("\n");
			
			MainFrame.characList.add(subHuman);
			MainFrame.nameList.addElement(subHuman.get_FullName());
		}
//		System.out.println(socialMotivationMap);
		if (events.get("BATT") != null) {
			List<Human> teamHumans = selectObjects();
			List<Human> enermyHumans = new ArrayList<>();
			Map batEvent = (Map) events.get("BATT");
			int num = Dice.throw_a_dice("1d3");
			for (int i = 0; i < num; i++) {
				Human e = new Human();
				e = e.create_character(null);
				enermyHumans.add(e);
			}
			
			outpuTextArea.append("The team met " + num + " hostile strangers.");
			outpuTextArea.append("\n");
			for(Human human: teamHumans) {
				Human target = enermyHumans.get(Dice.throw_a_dice("1d"+enermyHumans.size())-1);
				outpuTextArea.append(human.getFirstName() + " fired at an enemy named " +  target.getFirstName());
				outpuTextArea.append("\n");
				int Level = Dice.successful_level_check(human.getSkill().getSkillMap().get("Battle"));
				Map tempMap = (Map) batEvent.get("fire");
//				System.out.println(tempMap);
				Map resultMap = (Map) tempMap.get(Integer.toString(Level));
//				System.out.println(resultMap);
				String output = (String) resultMap.get("resultdescription");
				output = output.replace("{name1}", human.getFirstName());
				output = output.replace("{name2}", target.getFirstName());
				output = output.replace("{weapon}", human.getWeapon().getNameString());
				
				outpuTextArea.append(output);
				outpuTextArea.append("\n");
				
				String type = (String) resultMap.get("type");
				String gob = (String) resultMap.get("goodorbad");
				String influence = (String) resultMap.get("influence");
				String motivate = (String) resultMap.get("motivate");
				
				System.out.println(gob + "BATT");
				motivate = motivate.replace("{name1}", human.getFirstName());
				motivate = motivate.replace("{name2}", target.getFirstName());
				check_value_change(target, gob, type, influence);
				outpuTextArea.append(target.get_FullName() + ":" + target.HP);
				outpuTextArea.append("\n");
				if (target.HP <= 0) {
					enermyHumans.remove(target);
				}
				if (enermyHumans.size() == 0) {
					outpuTextArea.append("All enemies have been eliminated");
					outpuTextArea.append("\n");
					break;
				}
				if (motivate.length()>0) {add_motivation_list(human, motivate);}
			}
			for(Human human: enermyHumans) {
				Human target = teamHumans.get(Dice.throw_a_dice("1d"+teamHumans.size())-1);
				outpuTextArea.append(human.getFirstName() + " fired at " +  target.getFirstName());
				outpuTextArea.append("\n");
				int Level = Dice.successful_level_check(human.getSkill().getSkillMap().get("Battle"));
				Map tempMap = (Map) batEvent.get("fire");
				Map resultMap = (Map) tempMap.get(Integer.toString(Level));
				String output = (String) resultMap.get("resultdescription");
				output = output.replace("{name1}", human.getFirstName());
				output = output.replace("{name2}", target.getFirstName());
				output = output.replace("{weapon}", human.getWeapon().getNameString());
				
				outpuTextArea.append(output);
				outpuTextArea.append("\n");
				
				String type = (String) resultMap.get("type");
				String gob = (String) resultMap.get("goodorbad");
				String influence = (String) resultMap.get("influence");
				String motivate = (String) resultMap.get("motivate");
				
				System.out.println(gob + "BATT");
				motivate = motivate.replace("{name1}", human.getFirstName());
				motivate = motivate.replace("{name2}", target.getFirstName());
				check_value_change(target, gob, type, influence);
				outpuTextArea.append(target.get_FullName() + ":" + target.HP);
				outpuTextArea.append("\n");
				if (target.HP <= 0) {
					outpuTextArea.append(target.get_FullName() + " was killed.");
					outpuTextArea.append("\n");
					Do_death(target);
				}
				if (teamHumans.size() == 0) {
					Do_end_of_story();
				}
			}
			outpuTextArea.append("After a brief round of firefight, the two sides decided to retreat.");
			outpuTextArea.append("\n");
		}
	}
	
	private void Do_death(Human target) {
		// TODO Auto-generated method stub
		MainFrame.characList.remove(target);
		MainFrame.nameList.removeElement(target.get_FullName());
	}

	private void add_motivation_list(Human objHuman, String motivate) {
		// TODO Auto-generated method stub
		socialMotivationMap.put(objHuman, motivate);
		
	}

	private void check_value_change(Human human, String gob, String type, String influence) {
		// TODO Auto-generated method stub
		if (type.contains("food")) {
//			System.out.println("++++++++");
			if (gob.contains("good")) {
				MainFrame.FOOD += Dice.throw_a_dice(influence);
			}else {
				MainFrame.FOOD -= Dice.throw_a_dice(influence);
			}
		}
		else if (type.contains("INT")) {
//			System.out.println("--------");
			if (gob.contains("good")) {
				MainFrame.PRO += Dice.throw_a_dice(influence);
			}else {
				MainFrame.PRO -= Dice.throw_a_dice(influence);
			}
		}
		else if (type.contains("HP")) {
//			System.out.println("00000000");
			if (gob.contains("good")) {
				human.HP += Dice.throw_a_dice(influence);
				if (human.HP > 10) {
					human.HP = 10;
				}
			}else {
				human.HP -= Dice.throw_a_dice(influence);
			}
		}
		else if (type.contains("unity")) {
			if (gob.contains("good")) {
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
			Do_end_of_story();
		}
		return humans;
	}
	
	private void Do_end_of_story() throws IOException {
		// TODO Auto-generated method stub
		outpuTextArea.append("There are no more people in the team that can act normally. The story ends here.\n");
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
