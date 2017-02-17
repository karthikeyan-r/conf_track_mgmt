package com.ctm.utils;

public class StringUtils {

	public static boolean isNotNullNotEmpty(String str) {
		if (str != null && !str.isEmpty())
			return true;
		return false;
	}

	public static int parseInt(String str) {
		if (tryParseInt(str))
			return Integer.parseInt(str);
		return 0;
	}

	public static String trimExtraSpaces(String str) {
		str = str.trim();
		str = str.replaceAll("\\s+", " ");
		return str;
	}

	public static boolean tryParseInt(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
