package com.sprint2.src;

import java.sql.Time;
import java.util.Date;

public class Session {
	
	public String name;
	public String type;
	public Date date;
	public Time duration;
	public int repeatFrequency;
	public String lecturer;
	public int maxAttendance;
	public boolean compulsory;
	public String venue;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public Time getDuration() {
		return duration;
	}
	public void setDuration(Time duration) {
		this.duration = duration;
	}
	public int getRepeatFrequency() {
		return repeatFrequency;
	}
	public void setRepeatFrequency(int repeatFrequency) {
		this.repeatFrequency = repeatFrequency;
	}
	public String getLecturer() {
		return lecturer;
	}
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
	public int getMaxAttendance() {
		return maxAttendance;
	}
	public void setMaxAttendance(int maxAttendance) {
		this.maxAttendance = maxAttendance;
	}
	public boolean isCompulsory() {
		return compulsory;
	}
	public void setCompulsory(boolean compulsory) {
		this.compulsory = compulsory;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	
	
	public String toString() {
		return "Session [name=" + name + ", type=" + type + ", date=" + date + ", duration="
				+ duration + ", repeatFrequency=" + repeatFrequency
				+ ", lecturer=" + lecturer + ", maxAttendance=" + maxAttendance
				+ ", compulsory=" + compulsory + ", venue=" + venue + "]";
	}

}
