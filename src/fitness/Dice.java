package fitness;

import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.JTextArea;

public class Dice {
	
	private static Random random = new Random(System.currentTimeMillis());
	static JTextArea area;
	
	public Dice(JTextArea storyArea) {
		this.area = storyArea;
	}
	
	public static int throw_a_dice(String command) {
		int result = 0;
		/** 判定总共分为如下几类
		 * 检定类，投掷1-100
		 * 数值类，投掷一个低于100的数值
		 * 其中数值类包含多种形式 掷骰几次，加多少固定值等等*/
		if (command.equals("check")) {
			result = random.nextInt(100)+1;
			return result;
		}
		else if (command.contains("d") && command.contains("+")) {
			StringTokenizer t = new StringTokenizer(command,"+");
			while(t.hasMoreElements()) {
				result += multi_dice(t.nextToken());
				if (t.hasMoreElements()) {
					System.out.print("+"+"\n");
					area.append("+");
				}
			}
			System.out.print("="+result);
			area.append("="+result+"\n");
			return result;	
		}
		else if (command.contains("d") && !command.contains("+")) {
			result = multi_dice(command);
			System.out.print("="+result+"\n");
			area.append("="+result+"\n");
			return result;
		}
		else{
			return result;
		}	
	}
	
	public int successful_level_check(int check_point, int skill_point) {
		if (check_point <= 5) {
			return 3;
		}
		else if (check_point>5 && check_point<=skill_point/2) {
			return 2;
		}
		else if (check_point>skill_point/2 && check_point<=skill_point) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	private static int multi_dice(String command) {
		int result = 0;
		StringTokenizer t = new StringTokenizer(command,"d");
		int ctr = Integer.parseInt(t.nextToken());
		int range = Integer.parseInt(t.nextToken());
		System.out.print("(");
		area.append("(");
		for (int i = 0; i < ctr; i++) {
			int temp = random.nextInt(range)+1;
			System.out.print(temp);
			area.append(Integer.toString(temp));
			if (i+1<ctr) {
				System.out.print("+");
				area.append("+");
			}
			result += temp;
		}
		System.out.print(")");
		area.append(")");
		return result;
	}
	
	public static void main(String args[]) {
//		Dice dice = new Dice();
		for (int i = 0; i < 100; i++) {
//			dice.throw_a_dice("100d100+10d10+12d34");
			System.out.print("\n");
		}
		
	}
	
}
