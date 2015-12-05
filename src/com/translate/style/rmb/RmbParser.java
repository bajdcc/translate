package com.translate.style.rmb;

import com.translate.parser.Parser;
import com.translate.style.StyleFactory;
import com.translate.style.StyleFactory.StyleType;

/**
 * 人民币翻译方案
 * @author bajdc_000
 */
public class RmbParser extends Parser {

	public RmbParser(String text) {
		super(text, StyleFactory.singleton().createStyle(StyleType.RMB));		
	}
}
