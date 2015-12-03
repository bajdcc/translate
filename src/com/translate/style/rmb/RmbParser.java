package com.translate.style.rmb;

import com.translate.parser.Parser;
import com.translate.style.IStyle;
import com.translate.style.StyleFactory;
import com.translate.style.StyleFactory.StyleType;

/**
 * @author bajdc_000
 * 人民币翻译方案
 */
public class RmbParser extends Parser {

	public RmbParser(String text) {
		super(text, StyleFactory.singleton().createStyle(StyleType.RMB));		
	}
	
	@Override
	public String toString() {
		return "RMB Parser" + "\n" + lexer.toString();
	}
}
