package com.ctm.test;

import com.ctm.test.io.CTMInputReaderTest;
import com.ctm.test.io.CTMOutputWriterTest;
import com.ctm.test.scheduler.CTMSchedulerTest;
import com.ctm.test.utils.CommonUtilsTest;
import com.ctm.test.utils.StringUtilsTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllCTMTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllCTMTests.class.getName());
		// $JUnit-BEGIN$
		suite.addTestSuite(CTMInputReaderTest.class);
		suite.addTestSuite(CTMOutputWriterTest.class);
		suite.addTestSuite(CommonUtilsTest.class);
		suite.addTestSuite(StringUtilsTest.class);
		suite.addTestSuite(CTMSchedulerTest.class);
		// $JUnit-END$
		return suite;
	}

}
