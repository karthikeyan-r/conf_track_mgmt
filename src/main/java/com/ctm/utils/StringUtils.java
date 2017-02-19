package com.ctm.utils;

/***
 * Common String handling functions used in this application
 * 
 * @author Karthikeyan R
 *
 */
public class StringUtils {

	/***
	 * Check string is valid - not empty/null
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNullNotEmpty(String str) {
		if (str != null && !str.isEmpty())
			return true;
		return false;
	}

	/***
	 * Parse given String to Int
	 * 
	 * @param str
	 * @return
	 */
	public static int parseInt(String str) {
		if (tryParseInt(str))
			return Integer.parseInt(str);
		return 0;
	}

	/***
	 * Remove all extra spaces in given string
	 * 
	 * @param str
	 * @return
	 */
	public static String trimExtraSpaces(String str) {
		str = str.trim();
		str = str.replaceAll("\\s+", " ");
		return str;
	}

	/***
	 * Check if it is possible to convert String to int
	 * 
	 * @param value
	 * @return
	 */
	public static boolean tryParseInt(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
