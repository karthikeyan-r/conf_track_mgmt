package com.ctm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ctm.model.Presentation;

public class CTMScheduler {

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

	public List<Presentation> splitNSegment(Map<Integer, Presentation> presentatnMap, int minDrtn, int maxDrtn) {
		int N = 1;

		while (N <= presentatnMap.size()) {
			List<Presentation> tempPresentnLst = new ArrayList<Presentation>();
			for (int i = 0; i < presentatnMap.size(); i++) {
				if (N < 2) {
					tempPresentnLst = new ArrayList<Presentation>();
					tempPresentnLst.add(presentatnMap.get(i));
					boolean sumW = getSegmentWt(tempPresentnLst, minDrtn, maxDrtn);
					if (sumW)
						return tempPresentnLst;
				}

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
					boolean sumW = getSegmentWt(tempPresentnLst, minDrtn, maxDrtn);
					if (sumW)
						return tempPresentnLst;
				}
			}
			N++;
		}
		return null;
	}

}
