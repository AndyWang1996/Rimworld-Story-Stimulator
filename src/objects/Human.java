package objects;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import database.DataLoader;
import fitness.Dice;

public class Human {
	
	String firstname;
	String lastname;
	public List<Organ> body = new ArrayList<>();
	public Map <Human, Status> relation = new HashMap<>();
	Skill skill;
	int gender; //1=male 0=female
	public int HP;
	public int san;
	int food;
	public Status body_status;
	public Status mental_status;
	Weapon weapon;
	
	
	public Human() {
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Human create_character(String Occ) {
		Human c = new Human();
    	File file1 = new File("./data/humans/firstNames.json");
    	File file2 = new File("./data/humans/lastNames.json");
    	Map jsoMap1 = (Map) JSON.parse(DataLoader.readJsonFile(file1));
    	Map jsoMap2 = (Map) JSON.parse(DataLoader.readJsonFile(file2));
    	List<String> l1 = (List<String>) jsoMap1.get("firstNames");
    	List<String> l2 = (List<String>) jsoMap2.get("lastNames");
		c.firstname = l1.get(Dice.throw_a_dice("1d" + (l1.size()-1)));
		c.lastname = l2.get(Dice.throw_a_dice("1d" + (l2.size()-1)));
		c.HP = 10;
		c.food = 100;
		c.san = 100;
		c.gender = Dice.throw_a_dice("1d2")-1;
		c.body_status = Status.generate_person_status_list().get("Normal");
		c.mental_status = Status.generate_good_moods_list().get("Normal");
		create_skill(Occ, c);
		create_body(c);
		get_armed(c);
		return c;			
	}

	@SuppressWarnings("rawtypes")
	public static void create_relation(List<Human> team) {
		// TODO Auto-generated method stub
		Map relationMap = Status.generate_good_relations_list();
		System.out.println(relationMap);
		Status defaultStatus = (Status) relationMap.get("Normal");
		for(Human o : team) {
			for(Human s : team) {
				if (o != s) {
					if (o.relation.get(s) == null) {
						o.relation.put(s, defaultStatus);
//						System.out.println(o.relation.get(s).get_detail().replace("{name1}", o.lastname).replace("{name2}", s.lastname));
					}
				}
			}
		}
	}

	private void create_skill(String Occ, Human c) {
		// TODO Auto-generated method stub
		System.out.println("mark");
		c.skill = new Skill(Occ);
	}

	private void create_body(Human c) {
		// TODO Auto-generated method stub
		System.out.println("mark");
		c.body = Organ.create_flesh();
	}
	
	private void get_armed(Human c) {
		c.weapon = Weapon.getWeapon();
	}
	
	public void display_this_guy() {
		System.out.println();
		System.out.print(this.firstname + " ");
		System.out.println(this.lastname);
		System.out.println("Physical conditions:");
		for (Organ part : this.body) {
			System.out.println("name:" + part.organ_name);
			System.out.println("status:" + part.status.status_name);
			System.out.println("description:" + this.lastname + "'s " +  part.status.status_detail.replace("{name}", part.organ_name));
		}
//		if (this.relation != null) {
//			for (Human part : this.relation) {
//				
//			}
//		}
		System.out.println("Occupation: " + this.skill.occNameString);
		System.out.println(this.skill.skillMap);
		
		System.out.println("Gender:" + this.gender);
		System.out.println("HP:" + this.HP);
		System.out.println("san:" + this.san);
		System.out.println("food:" + this.food);
		System.out.println(this.body_status.status_detail.replace("{name}", this.lastname));
		System.out.println(this.mental_status.status_detail.replace("{name}", this.lastname));
	}
	
	public String getFirstName() {
		return this.firstname;
	}
	
	public String getlastName() {
		return this.lastname;
	}
	
	public List<Organ> getBodyList() {
		return this.body;
	}
	
	public Map <Human, Status> getRelationMap() {
		return this.relation;
	}
	
	public Skill getSkill() {
		return this.skill;
	}
	
	public int getGender() {
		return this.gender;
	}
	
	public int getHP() {
		return this.HP;
	}
	
	public int getSan() {
		return this.san;
	}
	
	public int getFood() {
		return this.food;
	}
	
	public Status getBodyStatus() {
		return this.body_status;
	}
	
	public Status getMentalStatus() {
		return this.mental_status;
	}
	
	public Weapon getWeapon() {
		return this.weapon;
	}
	
	public String get_FullName() {
		return this.firstname + " " + this.lastname;
	}
	
	public static void main(String Args[]) {
		Human AllHuman = new Human();
		Human aHuman = AllHuman.create_character(null);
		Human bHuman = AllHuman.create_character(null);
		Human cHuman = AllHuman.create_character(null);
		System.out.println(aHuman);
		System.out.println(bHuman);
		System.out.println(cHuman);
		List<Human> testHumans = new ArrayList<>();
		testHumans.add(aHuman);
		testHumans.add(bHuman);
		testHumans.add(cHuman);
		create_relation(testHumans);
		System.out.println(aHuman.relation.get(bHuman).get_detail().replace("{name1}", aHuman.get_FullName()).replace("{name2}", bHuman.get_FullName()));
	}
}
