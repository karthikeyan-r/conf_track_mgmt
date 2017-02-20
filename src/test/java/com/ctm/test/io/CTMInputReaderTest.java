package com.ctm.test.io;

import java.util.Map;

import com.ctm.exception.CTMException;
import com.ctm.io.CTMInputReader;
import com.ctm.model.Presentation;

import junit.framework.TestCase;

public class CTMInputReaderTest extends TestCase {

	public void testReadFile() {
		// Invalid file name
		try {
			CTMInputReader input = new CTMInputReader("D:\\input.txt");

			assertNotNull(input.readFile());
		} catch (CTMException e) {
			e.printStackTrace();
		}
	}

	public void testReadConsole() {
		try {
			CTMInputReader input = new CTMInputReader();

			assertNotNull(input.readFile());
		} catch (CTMException e) {
			e.printStackTrace();
		}
	}

	public void testReadFileInvalidFileName() {
		// Invalid file name
		boolean thrown = false;
		try {
			new CTMInputReader("D:\\input1.txt");
		} catch (CTMException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	public void testGetPresentationList() {
		// Invalid file name
		try {
			CTMInputReader input = new CTMInputReader("D:\\input.txt");

			Map<Integer, Presentation> presentationLst = input.getPresentationList();

			assertNotNull(presentationLst);

			assertEquals(18, presentationLst.size());

		} catch (CTMException e) {
			e.printStackTrace();
		}
	}

	/***
	 * With invalid presentation item
	 */
	public void testGetPresentationList1() {
		// Invalid file name
		try {
			CTMInputReader input = new CTMInputReader("D:\\inputWithInvalid.txt");

			Map<Integer, Presentation> presentationLst = input.getPresentationList();

			assertNotNull(presentationLst);

			assertEquals(17, presentationLst.size());

		} catch (CTMException e) {
			e.printStackTrace();
		}
	}

}
