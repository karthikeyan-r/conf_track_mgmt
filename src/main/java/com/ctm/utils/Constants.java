package com.ctm.utils;

public class Constants {

	public static final String TIME_MIN_SUFFIX = "min";
	public static final String TIME_LIGHTNING_SUFFIX = "lightning";

	public static final int LIGHTNING_MIN_TIME = 5;
	public static final int MAX_CONF_DAYS = 2;

	public enum SESSION_TYPE {
		MORNING("morning"), NOON("noon"), LUNCH("lunch"), NETWORK("networking");

		private String title;

		private SESSION_TYPE(String sessionTitle) {
			this.title = sessionTitle;
		}

		public String getTitle() {
			return title;
		}
	}

}
