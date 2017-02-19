package com.ctm.io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import com.ctm.exception.CTMException;
import com.ctm.model.Session;

/***
 * Output Writer class which can write input to file or console based on writer
 * input
 * 
 * @author Karthikeyan R
 *
 */
public class CTMOutputWriter {

	private String fileName = null;

	private List<Session> sessionLst = null;

	BufferedWriter logWriter = null;

	/***
	 * If file name is valid (not null) then file writer object is initialized;
	 * otherwise OutputStream write with System.out (console) input.
	 * 
	 * 
	 * @param fileNm
	 * @param sessionLst
	 */
	public CTMOutputWriter(String fileNm, List<Session> sessionLst) {
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

	public CTMOutputWriter(List<Session> sessionLst) {
		this(null, sessionLst);
	}

	/***
	 * Write session content to file/console
	 * 
	 * @throws CTMException
	 */
	public void writeFile() throws CTMException {
		try {
			if (logWriter != null) {
				for (Session session : sessionLst) {
					logWriter.write(session.toString());
					logWriter.write("\n");
					// System.out.println(session.toString());
				}

				logWriter.flush();
				logWriter.close();
			}
		} catch (Exception e) {// Catch exception if any
			e.printStackTrace();
			throw new CTMException(e.getMessage());
		} finally {
		}
	}

}
