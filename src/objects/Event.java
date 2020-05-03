package objects;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import database.DataLoader;

public class Event {
	public static String[] eventType = {
		"create character",//������ͬ�����Ľ�ɫ ���� ʧ���� �����ȵ�
		"weather change",//�ı����� ���� �º�
		"enermy attack",//����Ϯ�� ���� Ұ���� Σ�ն��� ������ ��Ⱥ
		"global event",//�����ż�
		"daily event",//�ճ��
		"dice event",//��ɫ�ж��ĳɹ���ʧ��
		"social event",//��ɫ֮�以���¼�
		"explorer event"//��ɫ̽���¼�
	};
	
	List<Human> starter; //�¼��ķ�����
	String event_strat_detailString;//�¼�����
	String event_detailString; //�¼�����
	List<Human> related; //�¼��ı�Ӱ����
	
	public static String[] effectType = {//�¼����
			"base change",//ȫ����ֵ�ı仯
			"member change",//������������Ա
			"item change",//������߱仯
			"mental change",//������̬�仯
			"health change",//���｡���仯
			"status change",//����״̬�仯 ����״̬������״̬
			"relation change",//�����ϵ�仯
			"skill change",//���＼�ܱ仯
	};
	
	public static void main(String args[]) {
		Map<String, Object> map = (Map<String, Object>) JSON.parse(DataLoader.readJsonFile(new File("./data/event/Agri_event.json")));
		System.out.println(((Map)((Map)map.get("gather")).get(Integer.toString(0))).get(Integer.toString(0)));
	}
}
