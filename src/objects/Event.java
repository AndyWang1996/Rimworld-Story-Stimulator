package objects;

import java.util.List;

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
	
	
}
