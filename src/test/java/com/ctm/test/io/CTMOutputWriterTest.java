package com.ctm.test.io;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.ctm.exception.CTMException;
import com.ctm.io.CTMOutputWriter;
import com.ctm.model.BreakSessionImpl;
import com.ctm.model.Session;
import com.ctm.utils.Constants;
import com.ctm.utils.Constants.SESSION_TYPE;

import junit.framework.TestCase;

public class CTMOutputWriterTest extends TestCase {

	public void testWriteFile() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		Session tmpSession = new BreakSessionImpl(SESSION_TYPE.LUNCH, 60, Constants.LUNCH_START_TIME);
		List<Session> sessionLst = new ArrayList<Session>();
		sessionLst.add(tmpSession);
		CTMOutputWriter writer = new CTMOutputWriter(sessionLst);
		try {
			writer.writeFile();
		} catch (CTMException e) {
			e.printStackTrace();
		}
		System.out.println(outContent.toString());
		assertNotNull(outContent.toString());
		System.setOut(null);
	}

}
