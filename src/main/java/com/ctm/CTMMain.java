package com.ctm;

import java.util.List;

import com.ctm.exception.CTMException;
import com.ctm.io.CTMFileReader;
import com.ctm.model.Presentation;

public class CTMMain {

	public static void main(String[] args) {

		CTMFileReader fileReader = new CTMFileReader("./input.txt");
		try {
			List<Presentation> presentationLst = fileReader.getPresentationList();

			System.out.println();

		} catch (CTMException e) {
			e.printStackTrace();
		}

	}

}
