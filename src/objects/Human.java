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
	int HP;
	int san;
	int food;
	Status body_status;
	Status mental_status;
	Weapon weapon;
	
	
	public Human() {
		
	}
	
	public Human creat_character(String type) {
		Human c = new Human();
		this.firstname = "";//get random name
		this.lastname = "";//get random name
		do_create_event(type);//随机一个小人出现的故事，决定小人的身体状态和其他相关属性
		return c;
				
	}

	private void do_create_event(String type) {
		// TODO Auto-generated method stub
		
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
