package com.ctm.model;

import java.util.List;
import java.util.Map;

import com.ctm.exception.CTMException;
import com.ctm.utils.CommonUtils;
import com.ctm.utils.Constants.SESSION_TYPE;
import com.ctm.utils.StringUtils;

/***
 * Class to hold list of presentation involved in single session; along with
 * session start/end time, session type
 * 
 * 
 * @author Karthikeyan R
 *
 */
public class Session {

	public SESSION_TYPE sessionType;
	public int maxSessionDuration;
	public String sessionStartTime;
	public String sessionEndTime;

	public int dayCount;

	List<Presentation> presentationList;

	public Session(SESSION_TYPE sessionType, int maxTime, String sessionStartTime) {
		this.sessionType = sessionType;
		this.maxSessionDuration = maxTime;
		setSessionStartTime(sessionStartTime);
		this.sessionStartTime = getSessionStartTime();
		this.sessionEndTime = "";
		this.dayCount = -1;
	}

	public void scheduleSession(Map<Integer, Presentation> presentationLst) {
		System.out.println("No Default Scheduling Algorithm");
	}

	/***
	 * Custom implemented toString method to convert presentation object to
	 * string with custom format
	 */
	@Override
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		if (dayCount != -1) {
			stringBuff.append("Day: ");
			stringBuff.append(dayCount);
			stringBuff.append("\n");
		}

		stringBuff.append(sessionType.getTitle().toUpperCase());
		stringBuff.append(" (" + sessionStartTime);
		if (StringUtils.isNotNullNotEmpty(this.sessionEndTime))
			stringBuff.append(" - " + sessionEndTime);
		stringBuff.append(") ");
		stringBuff.append("\n");

		int index = 1;

		for (Presentation presentation : presentationList) {
			stringBuff.append(index);
			stringBuff.append(". ");
			stringBuff.append(presentation.toString());
			index++;
		}

		return stringBuff.toString();
	}

	public SESSION_TYPE getSessionType() {
		return sessionType;
	}

	public void setSessionType(SESSION_TYPE sessionType) {
		this.sessionType = sessionType;
	}

	public int getMaxSessionDuration() {
		return maxSessionDuration;
	}

	public void setMaxSessionDuration(int maxSessionDuration) {
		this.maxSessionDuration = maxSessionDuration;
	}

	public String getSessionStartTime() {
		return sessionStartTime;
	}

	public void setSessionStartTime(String sessionStartTime) {
		try {
			this.sessionStartTime = CommonUtils.getFormattedTimeStr(sessionStartTime);
		} catch (CTMException e) {
			this.sessionStartTime = sessionStartTime;
		}
	}

	public List<Presentation> getPresentationList() {
		return presentationList;
	}

	public void setPresentationList(List<Presentation> presentationList) {
		this.presentationList = presentationList;
	}

	public String getSessionEndTime() {
		return sessionEndTime;
	}

	public void setSessionEndTime(String sessionEndTime) {
		this.sessionEndTime = sessionEndTime;
	}
}
