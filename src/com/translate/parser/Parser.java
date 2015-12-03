package com.translate.parser;

import com.translate.lexer.Lexer;
import com.translate.style.IStyle;

/**
 * @author bajdc_000
 * 语法分析器
 */
public abstract class Parser {

	protected Lexer lexer;

	public Parser(String text, IStyle style) {
		lexer = style.createLexer(text);
		init();
	}
	
	protected void init() {
		
	}
	
}
