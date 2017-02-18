package com.ctm;

import java.util.List;
import java.util.Map;

import com.ctm.exception.CTMException;
import com.ctm.io.CTMFileReader;
import com.ctm.model.Presentation;

public class CTMMain {

	public static void main(String[] args) {

		CTMFileReader fileReader = new CTMFileReader("./input.txt");
		try {
			Map<Integer, Presentation> presentationLst = fileReader.getPresentationList();
			int maxConfDays = fileReader.getMaxPresentationTime() / 60;

			if (maxConfDays < 1)
				System.out.println("Insuffiucient Presentation for conference");

			CTMScheduler scheduler = new CTMScheduler();

			for (int sessionIndx = 0; sessionIndx < maxConfDays * 2; sessionIndx++) {

				int minDuration = 180;
				int maxDuration = 180;

				if (sessionIndx % 2 == 1)
					maxDuration = 240;

				List<Presentation> sessionPresentnLst = scheduler.splitNSegment(presentationLst, minDuration,
						maxDuration);
				for (Presentation presentation : sessionPresentnLst) {
					System.out.println(presentation.toString());
				}
			}

			System.out.println();

		} catch (CTMException e) {
			e.printStackTrace();
		}

	}

}
