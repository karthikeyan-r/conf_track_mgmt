package com.ctm.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		return -1;
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

	/***
	 * Regex pattern to read the input line & validate. Input line should be of
	 * format any alphanumeric character followed by single space & number in
	 * minutes followed by min/lightining
	 * 
	 * @param strLine
	 * @return
	 */
	public static boolean isValidInputLine(String strLine) {
		Pattern textPattern = Pattern.compile("(.*)(\\s){1}([0-9]*min|lightning)\\b");

		Matcher matcher = textPattern.matcher(strLine);
		return matcher.matches();
	}

}
