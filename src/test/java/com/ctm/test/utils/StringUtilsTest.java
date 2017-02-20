package com.ctm.test.utils;

import com.ctm.utils.StringUtils;

import junit.framework.TestCase;

public class StringUtilsTest extends TestCase {

	public void testIsNotNullNotEmpty() {
		assertEquals("Valid String", true, StringUtils.isNotNullNotEmpty("valid "));

		assertEquals("Invalid String", true, StringUtils.isNotNullNotEmpty(" "));

		assertEquals("Invalid String", false, StringUtils.isNotNullNotEmpty(""));
		assertEquals("Invalid String", false, StringUtils.isNotNullNotEmpty(null));
	}

	public void testParseInt() {
		assertEquals("Valid Int", 2, StringUtils.parseInt("2"));

		assertEquals("InValid Int", -1, StringUtils.parseInt("2a"));
	}

	public void testTrimExtraSpaces() {
		assertEquals("Trimmed String", "Valid String", StringUtils.trimExtraSpaces("  Valid   String "));
	}

	public void testTryParseInt() {
		assertEquals("Valid Int", true, StringUtils.tryParseInt("2"));

		assertEquals("Valid Int", false, StringUtils.tryParseInt("2a"));
	}

	public void testIsValidInputLine() {
		String testStr = "Pair Programming vs Noise 45min";

		assertTrue(StringUtils.isValidInputLine(testStr));

		testStr = "Pair Programming vs Noise lightning";
		assertTrue(StringUtils.isValidInputLine(testStr));

		testStr = "Pair Programming vs Noise 45lightning";
		assertFalse(StringUtils.isValidInputLine(testStr));

		testStr = "Pair Programming vs Noise 45";
		assertFalse(StringUtils.isValidInputLine(testStr));

		testStr = "Pair Programming vs Noise";
		assertFalse(StringUtils.isValidInputLine(testStr));

		testStr = "Pair Programming vs Noise q45min";
		assertFalse(StringUtils.isValidInputLine(testStr));
	}

}
