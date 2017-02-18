package com.ctm.model;

import java.util.ArrayList;

import com.ctm.utils.Constants.SESSION_TYPE;

public class BreakSessionImpl extends Session {

	public BreakSessionImpl(SESSION_TYPE sessionType, int maxTime, int sessionStartTime) {
		this.sessionType = sessionType;
		this.maxSessionDuration = maxTime;
		this.sessionStartTime = sessionStartTime;
		this.presentationList = new ArrayList<>();
	}

}
