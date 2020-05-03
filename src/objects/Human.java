package objects;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import database.DataLoader;
import fitness.Dice;

public class Human {
	
	String firstname;
	String lastname;
	List<Organ> body = new ArrayList<>();
	List<Human> relation = new ArrayList<>();
	Skill skill;
	int gender; //1=male 0=female
	int HP;
	int san;
	int food;
	Status body_status;
	Status mental_status;
	Weapon weapon;
	
	
	public Human() {
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Human create_character(String Occ) {
    	File file1 = new File("./data/humans/firstNames.json");
    	File file2 = new File("./data/humans/lastNames.json");
    	Map jsoMap1 = (Map) JSON.parse(DataLoader.readJsonFile(file1));
    	Map jsoMap2 = (Map) JSON.parse(DataLoader.readJsonFile(file2));
    	List<String> l1 = (List<String>) jsoMap1.get("firstNames");
    	List<String> l2 = (List<String>) jsoMap2.get("lastNames");
		this.firstname = l1.get(Dice.throw_a_dice("1d" + l1.size()));
		this.lastname = l2.get(Dice.throw_a_dice("1d" + l2.size()));
		this.HP = 10;
		this.food = 100;
		this.san = 100;
		this.gender = Dice.throw_a_dice("1d2")-1;
		this.body_status = Status.generate_person_status_list().get("Normal");
		this.mental_status = Status.generate_good_moods_list().get("Normal");
		create_relation();
		create_skill(Occ);
		create_body();
		get_armed();
		return this;			
	}

	private void create_relation() {
		// TODO Auto-generated method stub
		this.relation = new ArrayList<Human>();		
	}

	private void create_skill(String Occ) {
		// TODO Auto-generated method stub
		this.skill = new Skill(Occ);
	}

	private void create_body() {
		// TODO Auto-generated method stub
		this.body = Organ.create_flesh();
	}
	
	private void get_armed() {
		this.weapon = Weapon.getWeapon();
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
		if (this.relation != null) {
			for (Human part : this.relation) {
				
			}
		}
		System.out.println("Occupation: " + this.skill.occNameString);
		System.out.println(this.skill.skillMap);
		
		System.out.println("Gender:" + this.gender);
		System.out.println("HP:" + this.HP);
		System.out.println("san:" + this.san);
		System.out.println("food:" + this.food);
		System.out.println(this.body_status.status_detail.replace("{name}", this.lastname));
		System.out.println(this.mental_status.status_detail.replace("{name}", this.lastname));
	}
	
	public static void main(String Args[]) {
		Human cHuman = new Human();
		cHuman = cHuman.create_character(null);
		cHuman.display_this_guy();
	}
}
