package com.ctm;

import java.util.ArrayList;
import java.util.Map;

public class TmpClass {

	private static int printTalkLst(List<Talk> talkLst, int W) {
		int sum = 0;
		for (Talk talk : talkLst) {
			sum = sum + talk.wt;
		}
		int returnVal = 1;
		if (sum == W)
			returnVal = 0;
		else if (sum < W)
			returnVal = -1;

		return returnVal;
	}

	private static Map<Integer, Talk> updateTalkMap(Map<Integer, Talk> talkMap, List<Talk> talkLst) {
		int sum = 0;
		for (Talk talk : talkLst) {
			talkMap.get(talk.getId()).setAdded(true);
			System.out.print(talk.id + " " + "( " + talk.wt + " )");
		}
		System.out.println();
		return talkMap;
	}

	private static void splitNSegment(Map<Integer, Talk> talkMap, int W) {
		int N = 1;

		while (N <= talkMap.size()) {
			List<Talk> tempTalkLst = new ArrayList<Talk>();
			for (int i = 0; i < talkMap.size(); i++) {
				if (N < 2) {
					tempTalkLst = new ArrayList<Talk>();
					tempTalkLst.add(talkMap.get(i));
					int sumW = printTalkLst(tempTalkLst, W);
					if (sumW == 0)
						talkMap = updateTalkMap(talkMap, tempTalkLst);
					else if (sumW == -1)
						talkMap = updateTalkMap(talkMap, tempTalkLst);
					continue;
				}

				for (int j = i + 1; j + N <= talkMap.size() + 1; j++) {
					int j1 = 1;
					int j2 = j;

					if (talkMap.get(i).isAdded)
						continue;

					tempTalkLst = new ArrayList<Talk>();
					tempTalkLst.add(talkMap.get(i));
					while (j1 < N && j2 < talkMap.size()) {
						if (talkMap.get(j2).isAdded) {
							j1++;
							j2++;
							continue;
						}
						tempTalkLst.add(talkMap.get(j2));
						j1++;
						j2++;
					}
					int sumW = printTalkLst(tempTalkLst, W);
					if (sumW == 0)
						talkMap = updateTalkMap(talkMap, tempTalkLst);
					else if (sumW == -1)
						talkMap = updateTalkMap(talkMap, tempTalkLst);
				}
			}
			N++;
		}

		System.out.println("Completed");
	}

}
