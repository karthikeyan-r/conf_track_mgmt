package com.ctm;

import java.util.Comparator;

import com.ctm.model.Presentation;

/***
 * Custom Presentation Comparator for comparing two presentation objects based
 * on isLightining boolean field
 * 
 * @author Karthikeyan R
 *
 */
public class PresentationComparator implements Comparator<Presentation> {

	@Override
	public int compare(Presentation arg0, Presentation arg1) {
		return Boolean.compare(arg0.isLightning, arg1.isLightning);
	}

}
