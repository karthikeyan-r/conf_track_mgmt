package com.ctm.model;

public class Presentation {

	int id;
	String title;
	int duration;
	String speakerInfo;

	public Presentation(int id, String title, int duration) {
		super();
		this.id = id;
		this.title = title;
		this.duration = duration;
		this.speakerInfo = "NA";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getSpeakerInfo() {
		return speakerInfo;
	}

	public void setSpeakerInfo(String speakerInfo) {
		this.speakerInfo = speakerInfo;
	}

}
