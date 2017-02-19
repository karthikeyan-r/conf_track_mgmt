package com.ctm.model;

import java.util.ArrayList;

import com.ctm.utils.CommonUtils;
import com.ctm.utils.Constants.SESSION_TYPE;

/***
 * BreakSession POJO with default or empty presentation object.
 * 
 * Session scheduling is not needed - since it is an open session
 * 
 * @author Karthikeyan R
 *
 */
public class BreakSessionImpl extends Session {

	public BreakSessionImpl(SESSION_TYPE sessionType, int maxTime, String sessionStartTime) {
		super(sessionType, maxTime, sessionStartTime);
		this.presentationList = new ArrayList<>();
		if (maxTime != 0) {
			String sessionEndTime = CommonUtils.addMinutes(sessionStartTime, maxTime);
			setSessionEndTime(sessionEndTime);
			this.sessionEndTime = getSessionEndTime();
		}
	}

}
