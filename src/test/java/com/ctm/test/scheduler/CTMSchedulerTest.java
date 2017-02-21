package com.ctm.test.scheduler;

import java.util.List;
import java.util.Map;

import com.ctm.exception.CTMException;
import com.ctm.io.CTMInputReader;
import com.ctm.model.Presentation;
import com.ctm.model.PresentationSessionImpl;
import com.ctm.scheduler.CTMScheduler;
import com.ctm.utils.Constants;
import com.ctm.utils.Constants.SESSION_TYPE;

import junit.framework.TestCase;

public class CTMSchedulerTest extends TestCase {

	public void testSplitNSegment() {
		try {
			CTMInputReader inputReader = new CTMInputReader("./input.txt");
			Map<Integer, Presentation> presentationMap = inputReader
					.getPresentationList();
			assertEquals(18, presentationMap.size());

			CTMScheduler scheduler = new CTMScheduler();

			List<Presentation> presentationLst = scheduler.splitNSegment(
					presentationMap, new PresentationSessionImpl(
							SESSION_TYPE.MORNING,
							Constants.MAX_MORNING_SESSION_TIME,
							Constants.MAX_MORNING_SESSION_TIME,
							Constants.MORNING_START_TIME, 0));

			assertNotNull(presentationLst);

			assertTrue(scheduler.getSegmentWt(presentationLst,
					Constants.MAX_MORNING_SESSION_TIME,
					Constants.MAX_MORNING_SESSION_TIME));

			Presentation p = presentationLst.remove(0);
			assertFalse(scheduler.getSegmentWt(presentationLst,
					Constants.MAX_MORNING_SESSION_TIME,
					Constants.MAX_MORNING_SESSION_TIME));

			presentationLst.add(p);
			assertTrue(scheduler.getSegmentWt(presentationLst,
					Constants.MAX_MORNING_SESSION_TIME,
					Constants.MAX_MORNING_SESSION_TIME));

			presentationLst.clear();
			assertFalse(scheduler.getSegmentWt(presentationLst,
					Constants.MAX_MORNING_SESSION_TIME,
					Constants.MAX_MORNING_SESSION_TIME));

		} catch (CTMException e) {
			e.printStackTrace();
		}
	}

}
