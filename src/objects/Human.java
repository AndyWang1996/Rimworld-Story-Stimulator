package objects;

import java.util.List;
import java.util.Map;

import fitness.Dice;

public class Human {
	
	String firstname;
	String lastname;
	List<Organ> body;
	List<Human> relation;
	Map<String, Integer> skill;
	int gender; //1=male 0=female
	int HP;
	int san;
	int food;
	Status body_status;
	Status mental_status;
	Weapon weapon;
	
	
	public Human() {
		
	}
	
	public Human create_character(String type, String FirstName, String LastName) {
		Human c = new Human();
		this.firstname = FirstName;//get random name
		this.lastname = LastName;//get random name
		this.HP = 10;
		this.food = 100;
		this.san = 100;
		this.gender = Dice.throw_a_dice("1d2");
		do_create_event(type);//随机一个小人出现的故事，决定小人的身体状态和其他相关属性
		return c;
				
	}

	private void do_create_event(String type) {
		// TODO Auto-generated method stub
		if (type == "crash") {
			this.HP -= Dice.throw_a_dice("1d3");
			this.food -= Dice.throw_a_dice("1d30");
			this.san -= Dice.throw_a_dice("1d50");
		}
		
	}

	private void create_relation() {
		// TODO Auto-generated method stub
		
	}

	private void create_skill() {
		// TODO Auto-generated method stub
		
	}

	private void create_body() {
		// TODO Auto-generated method stub
		
	}
}
