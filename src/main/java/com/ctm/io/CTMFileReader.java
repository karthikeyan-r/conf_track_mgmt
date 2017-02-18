package com.ctm.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ctm.exception.CTMException;
import com.ctm.model.Presentation;
import com.ctm.utils.Constants;
import com.ctm.utils.StringUtils;

public class CTMFileReader {

	private String fileName = null;

	public CTMFileReader(String fileNm) {
		this.fileName = fileNm;

		File f = new File(fileNm);
		System.out.println(f.getPath());
		System.out.println(f.getAbsolutePath());
		try {
			System.out.println(f.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int maxPresentationTime = 0;

	public Map<Integer, Presentation> getPresentationList() throws CTMException {
		List<String> inputlst = readFile();

		int presentationID = 0;

		Map<Integer, Presentation> presentationMap = new LinkedHashMap<>();

		for (String string : inputlst) {
			if (StringUtils.isNotNullNotEmpty(string)) {
				String title = string.substring(0, string.lastIndexOf(" "));
				int presentationTime = Constants.LIGHTNING_MIN_TIME;
				if (string.endsWith(Constants.TIME_MIN_SUFFIX)) {
					String timeValue = string.substring(string.lastIndexOf(" "), string.length());
					timeValue = timeValue.replaceAll(Constants.TIME_MIN_SUFFIX, "");
					timeValue = StringUtils.trimExtraSpaces(timeValue);
					presentationTime = StringUtils.parseInt(timeValue);
				}
				maxPresentationTime = maxPresentationTime + presentationTime;

				presentationMap.put(presentationID, new Presentation(presentationID, title, presentationTime));
				presentationID++;
			}
		}
		return presentationMap;
	}

	private List<String> readFile() throws CTMException {
		List<String> inputList = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			// Read File Line By Line
			String strLine = null;
			while ((strLine = br.readLine()) != null) {
				strLine = StringUtils.trimExtraSpaces(strLine);
				if (isValidInputLine(strLine))
					inputList.add(strLine);
				else
					System.out.println("---------------INVALID " + strLine);
			}
		} catch (Exception e) {// Catch exception if any
			e.printStackTrace();
			throw new CTMException(e.getMessage());
		}
		return inputList;
	}

	public boolean isValidInputLine(String strLine) {
		Pattern textPattern = Pattern.compile("(.*)(\\s){1}([0-9]*min|lightning)\\b");

		Matcher matcher = textPattern.matcher(strLine);
		return matcher.matches();
	}

	public int getMaxPresentationTime() {
		return maxPresentationTime;
	}

	public void setMaxPresentationTime(int maxPresentationTime) {
		this.maxPresentationTime = maxPresentationTime;
	}
}
