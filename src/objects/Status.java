package objects;

public class Status {
	
	public boolean GoodOrBad;
	public String status_name;
	public String status_detail; //作为引发其他事件的原因
	public String status_reason; //作为被其他事件引发的原因
	public int time;
	
	public Status(String name, String datail, String reason, int time, Boolean GoodOrBadBoolean) {
		// TODO Auto-generated constructor stub
		this.status_name = name;
		this.status_detail = datail;
		this.time = time;
		this.GoodOrBad = GoodOrBadBoolean;
		if (reason != null) {
			this.status_reason = reason;
		}
		else {
			this.status_reason = "no reason";
		}
	}
	
	public Boolean get_GoodOrBadBoolean() {return GoodOrBad;}
	
	public String get_name() {return status_name;}
	
	public String get_detail() {return status_detail;}
	
	public String get_reason() {return status_reason;}
	
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
		this.status_reason = this.status_detail;
		this.status_name = name;
		this.time = t;
	}
}
