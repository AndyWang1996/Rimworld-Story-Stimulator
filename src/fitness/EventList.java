package fitness;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextArea;

import objects.Event;
import objects.Human;

public class EventList {
		
	List<Event> EventList;
	JTextArea storyTextArea;
	
	public EventList(JTextArea stroyTextArea,List<Human> currentHumans) {
		this.storyTextArea = stroyTextArea;
		this.EventList = null;
	}
	
}
