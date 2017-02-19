package com.ctm.model;

import java.util.ArrayList;
import java.util.List;

/***
 * Main {@link Conference} POJO object which will hold list of {@link Session}
 * objects
 * 
 * @author Karthikeyan R
 *
 */
public class Conference {

	List<Session> sessionLst;

	public List<Session> getSessionLst() {
		return sessionLst;
	}

	public void setSessionLst(List<Session> sessionLst) {
		this.sessionLst = sessionLst;
	}

	public Conference() {
		sessionLst = new ArrayList<>();
	}

	public void addSession(Session session) {
		sessionLst.add(session);
	}

}
