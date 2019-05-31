package ro.tuc.tp.assig5;

import java.util.Date;

public class MonitoredData implements Comparable<MonitoredData>{
	
	private Date startTime;
	private Date endTime;
	private String activity;
	
	public MonitoredData(Date startTime, Date endTime, String activity) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.activity = activity;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String toString() { 
		return getActivity() + "\t" + getStartTime() + "\t" + getEndTime();
	}

	@SuppressWarnings("deprecation")
	@Override
	public int compareTo(MonitoredData o) {
		return this.getStartTime().getDay() - o.getStartTime().getDay();
	}
}
