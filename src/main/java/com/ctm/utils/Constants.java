package com.ctm.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/***
 * Application defaults of this application
 * 
 * @author Karthikeyan R
 *
 */
public class Constants {

	public static final String TIME_MIN_SUFFIX = "min";
	public static final String TIME_LIGHTNING_SUFFIX = "lightning";

	public static final int LIGHTNING_MIN_TIME = 5;
	public static final int MAX_CONF_DAYS = 2;

	public static final int MAX_MORNING_SESSION_TIME = 180;

	public static final int MIN_SESSION_TIME = 180;
	public static final int MAX_NOON_SESSION_TIME = 240;

	public static final int MAX_BREAK_DRTN_TIME = 60;

	public static String MORNING_START_TIME = "9:00 am";
	public static String LUNCH_START_TIME = "12:00 pm";
	public static String NOON_START_TIME = "1:00 pm";
	public static String NETWORKING_START_TIME = "5:00 pm";

	public static final int MAX_SESSION_PER_DAY = SESSION_TYPE.values().length;

	public static final int DEFAULT_DAY_NUMBER = -1;

	public static final DateFormat MY_TIME_FORMAT = new SimpleDateFormat("hh:mm a");

	static {
		MORNING_START_TIME = CommonUtils.getFormattedTimeStr(MORNING_START_TIME);
		LUNCH_START_TIME = CommonUtils.addMinutes(MORNING_START_TIME, MAX_MORNING_SESSION_TIME);
		NOON_START_TIME = CommonUtils.addMinutes(LUNCH_START_TIME, MAX_BREAK_DRTN_TIME);
		NETWORKING_START_TIME = CommonUtils.addMinutes(NOON_START_TIME, MAX_NOON_SESSION_TIME);
	}

	public enum SESSION_TYPE {
		MORNING("morning"), LUNCH("lunch"), NOON("noon"), NETWORK("networking");

		private String title;

		private SESSION_TYPE(String sessionTitle) {
			this.title = sessionTitle;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
	}

}
