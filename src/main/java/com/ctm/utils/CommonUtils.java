package com.ctm.utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import com.ctm.exception.CTMException;

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
	 * @throws CTMException
	 */
	public static Date getFormattedTime(String timeStr) throws CTMException {
		try {
			return Constants.MY_TIME_FORMAT.parse(timeStr);
		} catch (ParseException e) {
			throw new CTMException("Unparseable time format:: "
					+ e.getMessage());
		}
	}

	/***
	 * Convert time of any format to custom format specified in this application
	 * 
	 * @param timeStr
	 * @return
	 * @throws CTMException
	 */
	public static String getFormattedTimeStr(String timeStr) {
		try {
			return Constants.MY_TIME_FORMAT.format(getFormattedTime(timeStr));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return timeStr;
	}

	/***
	 * Add given minutes to given time input as string
	 * 
	 * @param timeStr
	 * @param minutesToAdd
	 * @return
	 */
	public static String addMinutes(String timeStr, int minutesToAdd) {
		Date d;
		try {
			d = getFormattedTime(timeStr);
		} catch (CTMException e) {
			d = new Date(timeStr);
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MINUTE, minutesToAdd);
		return Constants.MY_TIME_FORMAT.format(cal.getTime());
	}

}
