package com.translate.lexer;

import com.translate.style.IStyle;

/**
 * @author bajdc_000
 * 词法分析器
 */
public abstract class Lexer {
	
	protected String text;
	protected IStyle style;

	public Lexer(String text, IStyle style) {
		this.text = text;
		this.style = style;
	}

	public String getText() {
		return text;
	}

	public IStyle getStyle() {
		return style;
	}
}
