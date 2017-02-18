package com.ctm.io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import com.ctm.exception.CTMException;
import com.ctm.model.Session;

public class CTMFileWriter {

	private String fileName = null;

	private List<Session> sessionLst = null;

	BufferedWriter logWriter = null;

	public CTMFileWriter(String fileNm, List<Session> sessionLst) {
		this.fileName = fileNm;
		this.sessionLst = sessionLst;
		try {
			if (this.fileName != null)
				logWriter = new BufferedWriter(new PrintWriter(this.fileName));
			else
				logWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public CTMFileWriter(List<Session> sessionLst) {
		this(null, sessionLst);
	}

	public void writeFile() throws CTMException {
		try {
			if (logWriter != null) {
				for (Session session : sessionLst) {
					logWriter.write("");
				}
			}
		} catch (Exception e) {// Catch exception if any
			e.printStackTrace();
			throw new CTMException(e.getMessage());
		}
	}

}
