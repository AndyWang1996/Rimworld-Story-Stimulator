package fitness;

import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.JTextArea;

import framework.MainFrame;

public class Dice {
	
	private Random random = new Random(System.currentTimeMillis());
	
	public int throw_a_dice(String command, JTextArea storyArea) {
		int result = 0;
		/** 判定总共分为如下几类
		 * 检定类，投掷1-100
		 * 数值类，投掷一个低于100的数值
		 * 其中数值类包含多种形式 掷骰几次，加多少固定值等等*/
		if (command.equals("check")) {
			result = random.nextInt(100)+1;
			return result;
		}
		else if (command.contains("+"+"\n")) {
			StringTokenizer t = new StringTokenizer(command,"+");
			while(t.hasMoreElements()) {
				result += multi_dice(t.nextToken(), storyArea);
				if (t.hasMoreElements()) {
					System.out.print("+"+"\n");
					storyArea.append("+"+"\n");
				}
			}
			System.out.print("="+result);
			return result;	
		}
		else if (command.contains("d") && !command.contains("+")) {
			result = multi_dice(command, storyArea);
			System.out.print("="+result+"\n");
			storyArea.append("="+result+"\n");
			return result;
		}
		else{
			return result;
		}	
	}
	
	public int successful_level_check(int check_point, int skill_point) {
		return 0;
	}
	
	private int multi_dice(String command, JTextArea storyArea) {
		int result = 0;
		StringTokenizer t = new StringTokenizer(command,"d");
		int ctr = Integer.parseInt(t.nextToken());
		int range = Integer.parseInt(t.nextToken());
		System.out.print("(");
		storyArea.append("(");
		for (int i = 0; i < ctr; i++) {
			int temp = random.nextInt(range)+1;
			System.out.print(temp);
			storyArea.append(Integer.toString(temp));
			if (i+1<ctr) {
				System.out.print("+");
				storyArea.append("+");
			}
			result += temp;
		}
		System.out.print(")");
		storyArea.append(")");
		return result;
	}
	
	
	
	public static void main(String args[]) {
		Dice dice = new Dice();
		for (int i = 0; i < 100; i++) {
//			dice.throw_a_dice("100d100+10d10+12d34");
			System.out.print("\n");
		}
		
	}
	
}
