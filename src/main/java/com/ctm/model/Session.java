package com.ctm.model;

import java.util.List;

import com.ctm.utils.Constants.SESSION_TYPE;

public abstract class Session {

	public SESSION_TYPE sessionType;
	public int maxSessionDuration;
	public int sessionStartTime;

	List<Presentation> presentationList;

	public abstract void scheduleSession();

	@Override
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		for (Presentation presentation : presentationList) {
			stringBuff.append(presentation.id);
			stringBuff.append(". ");
			stringBuff.append(presentation.title);
			stringBuff.append("- ");
			stringBuff.append(presentation.startTime);
			stringBuff.append("-");
			stringBuff.append(presentation.startTime + presentation.duration);
			stringBuff.append(" :: ");
			stringBuff.append(presentation.speakerInfo);
			stringBuff.append("\n");
		}

		return stringBuff.toString();
	}
}
