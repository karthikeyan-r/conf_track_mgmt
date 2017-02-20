package com.ctm.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ctm.model.Presentation;
import com.ctm.model.PresentationSessionImpl;

/***
 * Custom Scheduler algorithm - Brute force algorithm - which forms segments of
 * all combination of array & calculates weight of each segment. If total weight
 * of sum falls within session max allowed duration, then this collection of
 * presentation is added to session
 * 
 * @author Karthikeyan R
 *
 */
public class CTMScheduler {

	private static int N = 1;

	/***
	 * Calculate sum of weight (total minutes) for given list of presentation & check whether it
	 * falls within allowed range of duration
	 * 
	 * If minimum & maximum duration is not same, then we need to check whether sum of minutes 
	 * falls within this range of values
	 *
	 * @param presentationLst
	 * @param minDrtn - Minimum time for a session
	 * @param maxDrtn - Maximum time allowed for session
	 * @return
	 */
	private boolean getSegmentWt(List<Presentation> presentationLst, int minDrtn, int maxDrtn) {
		int sum = 0;
		for (Presentation presentn : presentationLst) {
			sum = sum + presentn.getDuration();
		}

		if (minDrtn == maxDrtn && sum == minDrtn)
			return true;

		if (sum >= minDrtn && sum <= maxDrtn)
			return true;

		return false;
	}

	/***
	 * Form array subset of all combination with list of given presentation
	 * 
	 * N - stores the segment array size. It starts from 1 to given presentation
	 * length
	 * 
	 * N is static so that it resumes from old array subset & algorithm is
	 * faster
	 * 
	 * @param presentatnMap
	 * @param sessionImpl
	 * @return
	 */
	public List<Presentation> splitNSegment(Map<Integer, Presentation> presentatnMap,
			PresentationSessionImpl sessionImpl) {

		while (N <= presentatnMap.size()) {
			List<Presentation> tempPresentnLst = new ArrayList<Presentation>();
			for (int i = 0; i < presentatnMap.size(); i++) {

				// If N = 1, this will check each individual segment weight with
				// allowed max duration
				if (N < 2) {
					tempPresentnLst = new ArrayList<Presentation>();
					tempPresentnLst.add(presentatnMap.get(i));
					boolean sumW = getSegmentWt(tempPresentnLst, sessionImpl.getMinSessionDuration(),
							sessionImpl.getMaxSessionDuration());
					if (sumW)
						return tempPresentnLst;
				}

				// For N more than 1
				for (int j = i + 1; j + N <= presentatnMap.size() + 1; j++) {
					int j1 = 1;
					int j2 = j;

					if (presentatnMap.get(i).isScheduled())
						continue;

					tempPresentnLst = new ArrayList<Presentation>();
					tempPresentnLst.add(presentatnMap.get(i));
					while (j1 < N && j2 < presentatnMap.size()) {
						if (presentatnMap.get(j2).isScheduled()) {
							j1++;
							j2++;
							continue;
						}
						tempPresentnLst.add(presentatnMap.get(j2));
						j1++;
						j2++;
					}
					boolean sumW = getSegmentWt(tempPresentnLst, sessionImpl.getMinSessionDuration(),
							sessionImpl.getMaxSessionDuration());
					if (sumW)
						return tempPresentnLst;
				}
			}
			N++;
		}
		return null;
	}

}
