package com.ctm.test.utils;

import com.ctm.utils.CommonUtils;

import junit.framework.TestCase;

public class CommonUtilsTest extends TestCase {

	public void testGetFormattedTime() {
		String timeStr = "10:00 am";

		try {
			CommonUtils.getFormattedTime(timeStr);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	public void testGetFormattedTimeStr() {
		String timeStr = "10:00 am";
		assertEquals("10:00 AM", CommonUtils.getFormattedTimeStr(timeStr));

		timeStr = "20:00";
		assertEquals("20:00", CommonUtils.getFormattedTimeStr(timeStr));
	}

	public void testAddMinutes() {
		assertEquals("10:30 AM", CommonUtils.addMinutes("10:00 am", 30));

		try {
			assertEquals("10:30 AM", CommonUtils.addMinutes("10:00", 30));
		} catch (Exception e) {
			assertTrue(true);
		}

		assertEquals("10:00 AM", CommonUtils.addMinutes("10:30 am", -30));
	}

}
