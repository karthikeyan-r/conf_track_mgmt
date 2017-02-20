package com.ctm;

import java.util.Map;

import com.ctm.exception.CTMException;
import com.ctm.io.CTMInputReader;
import com.ctm.io.CTMOutputWriter;
import com.ctm.model.BreakSessionImpl;
import com.ctm.model.Conference;
import com.ctm.model.Presentation;
import com.ctm.model.PresentationSessionImpl;
import com.ctm.model.Session;
import com.ctm.utils.Constants;
import com.ctm.utils.Constants.SESSION_TYPE;

public class CTMMain {

	public static void main(String[] args) {

		Conference conference = new Conference();

		CTMInputReader fileReader = null;
		if (args != null && args.length > 0)
			fileReader = new CTMInputReader(args[0]);
		else
			fileReader = new CTMInputReader();

		try {
			Map<Integer, Presentation> presentationMap = fileReader
					.getPresentationList();
			int maxConfDays = fileReader.getMaxPresentationTime() / 360;

			if (maxConfDays < 1) {
				System.out.println("Insuffiucient Presentation for conference");
				return;
			}

			for (int sessionIndx = 0; sessionIndx < maxConfDays
					* Constants.MAX_SESSION_PER_DAY; sessionIndx++) {
				Session session = null;

				int sessionCount = sessionIndx % Constants.MAX_SESSION_PER_DAY;
				SESSION_TYPE sessionType = SESSION_TYPE.values()[sessionCount];

				switch (sessionType) {
				case MORNING:
					int dayCount = (sessionIndx / 4) + 1;

					session = new PresentationSessionImpl(SESSION_TYPE.MORNING,
							Constants.MIN_SESSION_TIME,
							Constants.MAX_MORNING_SESSION_TIME,
							Constants.MORNING_START_TIME, dayCount);
					break;
				case LUNCH:
					session = new BreakSessionImpl(SESSION_TYPE.LUNCH,
							Constants.MAX_BREAK_DRTN_TIME,
							Constants.LUNCH_START_TIME);
					break;
				case NOON:
					session = new PresentationSessionImpl(SESSION_TYPE.NOON,
							Constants.MIN_SESSION_TIME,
							Constants.MAX_NOON_SESSION_TIME,
							Constants.NOON_START_TIME,
							Constants.DEFAULT_DAY_NUMBER);
					break;
				case NETWORK:
					session = new BreakSessionImpl(SESSION_TYPE.NETWORK,
							Constants.MAX_BREAK_DRTN_TIME,
							Constants.NETWORKING_START_TIME);
					break;
				}

				if (session instanceof BreakSessionImpl) {
					conference.addSession(session);
					continue;
				}

				session.scheduleSession(presentationMap);
				conference.addSession(session);
			}

			CTMOutputWriter fileWriter = new CTMOutputWriter(
					conference.getSessionLst());
			fileWriter.writeFile();

		} catch (CTMException e) {
			e.printStackTrace();
		}
	}
}
