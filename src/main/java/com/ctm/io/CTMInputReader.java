package com.ctm.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ctm.exception.CTMException;
import com.ctm.model.Presentation;
import com.ctm.utils.Constants;
import com.ctm.utils.StringUtils;

/****
 * Input Reader class which can read input from file or console based on Reader
 * input
 * 
 * @author Karthikeyan R
 *
 */
public class CTMInputReader {

	private String fileName = null;

	BufferedReader inputReader = null;

	/***
	 * If file name is valid (not null) then file reader object is initialised;
	 * otherwise InputStream read with System.in (console) input.
	 * 
	 * @param fileNm
	 * @throws CTMException
	 */
	public CTMInputReader(String fileNm) throws CTMException {
		this.fileName = fileNm;

		try {
			if (this.fileName != null)
				inputReader = new BufferedReader(new FileReader(this.fileName));
			else
				inputReader = new BufferedReader(new InputStreamReader(System.in));
		} catch (FileNotFoundException e) {
			throw new CTMException(e.getMessage());
		}
	}

	public CTMInputReader() throws CTMException {
		this(null);
	}

	public int maxPresentationTime = 0;

	/***
	 * Read presentation list from file & parse title & min and return as
	 * Map<Integeger, Presentation> object
	 * 
	 * @return
	 * @throws CTMException
	 */
	public Map<Integer, Presentation> getPresentationList() throws CTMException {
		List<String> inputlst = readFile();

		int presentationID = 0;

		Map<Integer, Presentation> presentationMap = new LinkedHashMap<Integer, Presentation>();

		for (String string : inputlst) {
			if (StringUtils.isNotNullNotEmpty(string)) {
				String title = string.substring(0, string.lastIndexOf(" "));
				boolean isLightning = false;

				int presentationTime = Constants.LIGHTNING_MIN_TIME;
				if (string.endsWith(Constants.TIME_MIN_SUFFIX)) {
					String timeValue = string.substring(string.lastIndexOf(" "), string.length());
					timeValue = timeValue.replaceAll(Constants.TIME_MIN_SUFFIX, "");
					timeValue = StringUtils.trimExtraSpaces(timeValue);
					presentationTime = StringUtils.parseInt(timeValue);
				} else
					isLightning = true;

				maxPresentationTime = maxPresentationTime + presentationTime;

				presentationMap.put(presentationID,
						new Presentation(presentationID, title, presentationTime, isLightning));
				presentationID++;
			}
		}
		return presentationMap;
	}

	/***
	 * While reading input from console - DONE as end of input token
	 * 
	 * @return
	 * @throws CTMException
	 */
	public List<String> readFile() throws CTMException {
		List<String> inputList = new ArrayList<String>();
		try {
			// Read File Line By Line
			String strLine = null;
			while ((strLine = inputReader.readLine()) != null && !strLine.equalsIgnoreCase("done")) {
				strLine = StringUtils.trimExtraSpaces(strLine);
				if (StringUtils.isValidInputLine(strLine))
					inputList.add(strLine);
				else
					System.out.println("---------------INVALID " + strLine);
			}
			inputReader.close();
		} catch (Exception e) {// Catch exception if any
			e.printStackTrace();
			throw new CTMException(e.getMessage());
		}
		return inputList;
	}

	public int getMaxPresentationTime() {
		return maxPresentationTime;
	}

	public void setMaxPresentationTime(int maxPresentationTime) {
		this.maxPresentationTime = maxPresentationTime;
	}
}
