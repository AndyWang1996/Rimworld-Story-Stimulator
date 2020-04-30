package objects;

import java.util.List;

public class Event {
	public static String[] eventType = {
		"create character",//创建不同背景的角色 难民 失事者 海盗等等
		"weather change",//改变天气 极端 温和
		"enermy attack",//敌人袭击 海盗 野蛮人 危险动物 机器人 虫群
		"global event",//出现遗迹
		"daily event",//日常活动
		"dice event",//角色行动的成功和失败
		"social event",//角色之间互动事件
		"explorer event"//角色探索事件
	};
	
	List<Human> starter; //事件的发起者
	String event_strat_detailString;//事件起因
	String event_detailString; //事件经过
	List<Human> related; //事件的被影响者
	
	public static String[] effectType = {//事件结果
			"base change",//全局数值的变化
			"member change",//故事人物增减员
			"item change",//人物道具变化
			"mental change",//人物心态变化
			"health change",//人物健康变化
			"status change",//人物状态变化 精神状态和身体状态
			"relation change",//人物关系变化
			"skill change",//人物技能变化
	};
	
	
}
