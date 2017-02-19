package com.ctm.utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/***
 * Common utility used in this whole application
 * 
 * @author Karthikeyan R
 *
 */
public class CommonUtils {

	/***
	 * Format time as String to custom specified format
	 * 
	 * @param timeStr
	 * @return
	 */
	public static Date getFormattedTime(String timeStr) {
		try {
			return Constants.MY_TIME_FORMAT.parse(timeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/***
	 * Convert time of any format to custom format specified in this application
	 * 
	 * @param timeStr
	 * @return
	 */
	public static String getFormattedTimeStr(String timeStr) {
		return Constants.MY_TIME_FORMAT.format(getFormattedTime(timeStr));
	}

	/***
	 * Add given minutes to given time input as string
	 * 
	 * @param timeStr
	 * @param minutesToAdd
	 * @return
	 */
	public static String addMinutes(String timeStr, int minutesToAdd) {
		Date d = getFormattedTime(timeStr);
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MINUTE, minutesToAdd);
		return Constants.MY_TIME_FORMAT.format(cal.getTime());
	}

}
