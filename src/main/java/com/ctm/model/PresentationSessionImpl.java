package com.ctm.model;

import java.util.List;
import java.util.Map;

import com.ctm.scheduler.CTMScheduler;
import com.ctm.utils.CommonUtils;
import com.ctm.utils.Constants.SESSION_TYPE;

public class PresentationSessionImpl extends Session {

	public int minSessionDuration;

	public PresentationSessionImpl(SESSION_TYPE sessionType, int minTime, int maxTime, String sessionStartTime,
			int dayCount) {
		super(sessionType, maxTime, sessionStartTime);
		this.minSessionDuration = minTime;
		this.maxSessionDuration = maxTime;
		this.dayCount = dayCount;
	}

	@Override
	public void scheduleSession(Map<Integer, Presentation> presentationLst) {
		CTMScheduler scheduler = new CTMScheduler();
		List<Presentation> sessionPresentnLst = scheduler.splitNSegment(presentationLst, this);
		sessionPresentnLst = updatePresentationLst(presentationLst, sessionPresentnLst, this.getSessionStartTime());
		this.setPresentationList(sessionPresentnLst);
	}

	public List<Presentation> updatePresentationLst(Map<Integer, Presentation> presentationLst,
			List<Presentation> sessionPresentnLst, String sessionStartTime) {
		String startTime = sessionStartTime;
		for (Presentation presentation : sessionPresentnLst) {
			presentationLst.get(presentation.getId()).setScheduled(true);
			presentation.setStartTime(startTime);
			startTime = CommonUtils.addMinutes(startTime, presentation.getDuration());
			presentation.setEndTime(startTime);
		}
		return sessionPresentnLst;
	}

	public int getMinSessionDuration() {
		return minSessionDuration;
	}

	public void setMinSessionDuration(int minSessionDuration) {
		this.minSessionDuration = minSessionDuration;
	}

}
