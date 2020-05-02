package fitness;

import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.JTextArea;

public class Dice {
	
	private static Random random = new Random(System.currentTimeMillis());
	static JTextArea area;
	
	public Dice(JTextArea storyArea) {
		Dice.area = storyArea;
	}
	
	public static int throw_a_dice(String command) {
		int result = 0;
		/** �ж��ܹ���Ϊ���¼���
		 * �춨�࣬Ͷ��1-100
		 * ��ֵ�࣬Ͷ��һ������100����ֵ
		 * ������ֵ�����������ʽ �������Σ��Ӷ��ٹ̶�ֵ�ȵ�*/
		if (command.equals("check")) {
			result = random.nextInt(100)+1;
			return result;
		}
		else if (command.contains("d") && command.contains("+")) {
			StringTokenizer t = new StringTokenizer(command,"+");
			while(t.hasMoreElements()) {
				result += multi_dice(t.nextToken());
				if (t.hasMoreElements()) {
					System.out.print("+");
					if (area != null) {area.append("+");}
				}
			}
			System.out.print("="+result);
			if (area != null) {area.append("="+result);}
			return result;	
		}
		else if (command.contains("d") && !command.contains("+")) {
			result = multi_dice(command);
			System.out.print("="+result);
			if (area != null) {area.append("="+result);}
			return result;
		}
		else{
			return result;
		}	
	}
	
	public static int successful_level_check(int skill_point) {
		int check_point = throw_a_dice("check");
		if (check_point <= 5) {
			return 3;//��ɹ�
		}
		else if (check_point>5 && check_point<=skill_point) {
			return 2;//�ɹ�
		}
		else if (check_point>skill_point && check_point<=99) {
			return 1;//ʧ��
		}
		else {
			return 0;//��ʧ��
		}
	}
	
	private static int multi_dice(String command) {
		int result = 0;
		if (command.contains("d")) {
			StringTokenizer t = new StringTokenizer(command,"d");
			int ctr = Integer.parseInt(t.nextToken());
			int range = Integer.parseInt(t.nextToken());
			System.out.print("(");
			if (area != null) {area.append("(");}
			for (int i = 0; i < ctr; i++) {
				int temp = random.nextInt(range)+1;
				System.out.print(temp);
				if (area != null) {area.append(Integer.toString(temp));}
				if (i+1<ctr) {
					System.out.print("+");
					if (area != null) {area.append("+");}
				}
				result += temp;
			}
		}else {
			System.out.print("(");
			if (area != null) {area.append("(");}
			int num = Integer.parseInt(command);
			System.out.print(num);
			if (area != null) {area.append(Integer.toString(num));}
			result += num;
		}
		System.out.print(")");
		if (area != null) {area.append(")");}
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
