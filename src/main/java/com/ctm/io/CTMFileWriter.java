package com.ctm.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import com.ctm.exception.CTMException;
import com.ctm.model.Session;

public class CTMFileWriter {

	private String fileName = null;

	private List<Session> sessionLst = null;

	public CTMFileWriter(String fileNm, List<Session> sessionLst) {
		this.fileName = fileNm;
		this.sessionLst = sessionLst;
	}

	public void writeFile() throws CTMException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
			// Read File Line By Line
			for (Session session : sessionLst) {
				// WRITE_TO_FILE
			}
		} catch (Exception e) {// Catch exception if any
			e.printStackTrace();
			throw new CTMException(e.getMessage());
		}
	}

}
