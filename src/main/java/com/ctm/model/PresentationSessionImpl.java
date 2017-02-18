package com.ctm.model;

import com.ctm.utils.Constants.SESSION_TYPE;

public class PresentationSessionImpl extends Session {

	public PresentationSessionImpl(SESSION_TYPE sessionType, int maxTime, int sessionStartTime) {
		this.sessionType = sessionType;
		this.maxSessionDuration = maxTime;
		this.sessionStartTime = sessionStartTime;
	}

	@Override
	public void scheduleSession() {

	}

}
