package com.ctm.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.ctm.PresentationComparator;
import com.ctm.scheduler.CTMScheduler;
import com.ctm.utils.CommonUtils;
import com.ctm.utils.Constants.SESSION_TYPE;

/***
 * Main Session (Presentation) session class which will have custom implemented
 * session scheduling algorithm
 * 
 * @author Karthikeyan R
 *
 */
public class PresentationSessionImpl extends Session {

	public int minSessionDuration;

	public PresentationSessionImpl(SESSION_TYPE sessionType, int minTime, int maxTime, String sessionStartTime,
			int dayCount) {
		super(sessionType, maxTime, sessionStartTime);
		this.minSessionDuration = minTime;
		this.maxSessionDuration = maxTime;
		this.dayCount = dayCount;
	}

	/***
	 * Custom Scheduling algorithm implemented - CTMScheduler algorithm with
	 * collection of all presentation
	 */
	@Override
	public void scheduleSession(Map<Integer, Presentation> presentationLst) {
		CTMScheduler scheduler = new CTMScheduler();
		List<Presentation> sessionPresentnLst = scheduler.splitNSegment(presentationLst, this);
		sessionPresentnLst = updatePresentationLst(presentationLst, sessionPresentnLst, this.getSessionStartTime());
		this.setPresentationList(sessionPresentnLst);
	}

	/***
	 * Update All presentation collection based on collection of presentation
	 * selected for this session. It will update scheduled flag of presentation
	 * class & calculate star/end time of each presentation based on
	 * presentation duration
	 * 
	 * @param presentationLst
	 * @param sessionPresentnLst
	 * @param sessionStartTime
	 * @return
	 */
	public List<Presentation> updatePresentationLst(Map<Integer, Presentation> presentationLst,
			List<Presentation> sessionPresentnLst, String sessionStartTime) {
		String startTime = sessionStartTime;

		Collections.sort(sessionPresentnLst, new PresentationComparator());

		for (Presentation presentation : sessionPresentnLst) {
			presentationLst.get(presentation.getId()).setScheduled(true);
			presentation.setStartTime(startTime);
			presentation.setScheduled(true);
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
