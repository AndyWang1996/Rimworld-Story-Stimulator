package objects;

public class Moods {
	
	public String Moods_name;
	public String Moods_detail; //作为引发其他事件的原因
	public String Moods_reason; //作为被其他事件引发的原因
	public int time;
	
	public Moods(String name, String datail, String reason, int time) {
		// TODO Auto-generated constructor stub
		this.Moods_name = name;
		this.Moods_detail = datail;
		this.time = time;
		if (reason != null) {
			this.Moods_reason = reason;
		}
		else {
			this.Moods_reason = "no reason";
		}
	}
	
	public String get_name() {return Moods_name;}
	
	public String get_detail() {return Moods_detail;}
	
	public String get_reason() {return Moods_reason;}
	
	public boolean _do_extend(int t){
		time += t;
		return true;
	}
	
	public boolean _do_shorten(int t) {
		if (t >= time) {
			time = -1;
			return false;
		}else {
			time -= t;
			return true;
		}
	}
	
	public boolean _do_time_check() {
		if (time > 0) {
			time -= 1;
			return true;
		}else {
			time = -1;
			return false;
		}
	}
	
	public void _do_status_change(String name, int t) {
		this.Moods_reason = this.Moods_detail;
		this.Moods_name = name;
		this.time = t;
	}
}
