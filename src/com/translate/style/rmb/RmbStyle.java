package com.translate.style.rmb;

import com.translate.lexer.Lexer;
import com.translate.style.IStyle;

/**
 * @author bajdc_000
 * RMB翻译方案
 */
public class RmbStyle implements IStyle {

	static private RmbStyle style;
	
	@Override
	public Lexer createLexer(String text) {
		return new RmbLexer(text, this);
	}

	static public synchronized IStyle singleton() {
		if (style == null) {
			style = new RmbStyle();
		}
		return style;
	}
}
