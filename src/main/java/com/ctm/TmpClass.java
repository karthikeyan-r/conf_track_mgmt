package com.ctm;

import java.util.Map;

public class TmpClass {

	private static Map<Integer, Talk> updateTalkMap(Map<Integer, Talk> talkMap, List<Talk> talkLst) {
		int sum = 0;
		for (Talk talk : talkLst) {
			talkMap.get(talk.getId()).setAdded(true);
			System.out.print(talk.id + " " + "( " + talk.wt + " )");
		}
		System.out.println();
		return talkMap;
	}

}
