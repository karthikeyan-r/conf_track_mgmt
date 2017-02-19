package com.ctm.model;

/***
 * {@link Presentation} POJO to hold id,title & duration of the presentation
 * 
 * @author Karthikeyan R
 *
 */

public class Presentation {

	int id;
	String title;
	int duration;
	String speakerInfo;
	boolean isScheduled;
	String startTime;
	String endTime;

	public Presentation(int id, String title, int duration) {
		super();
		this.id = id;
		this.title = title;
		this.duration = duration;
		this.speakerInfo = "NA";
		this.isScheduled = false;
	}

	/***
	 * Custom implemented toString method to convert presentation object to
	 * string with custom format
	 */
	@Override
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		// stringBuff.append(this.id);
		// stringBuff.append(". ");
		stringBuff.append(this.title);
		stringBuff.append(" :: ");
		stringBuff.append(this.startTime);
		stringBuff.append(" - ");
		stringBuff.append(this.endTime);
		stringBuff.append(" (");
		stringBuff.append(this.duration);
		stringBuff.append("mins) ");
		// stringBuff.append(" :: ");
		// stringBuff.append(this.isScheduled);
		// stringBuff.append(" :: ");
		// stringBuff.append(this.speakerInfo);
		stringBuff.append("\n");

		return stringBuff.toString();
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

	public boolean isScheduled() {
		return isScheduled;
	}

	public void setScheduled(boolean isScheduled) {
		this.isScheduled = isScheduled;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
