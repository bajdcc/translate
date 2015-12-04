package com.translate.parser;

import com.translate.lexer.Lexer;
import com.translate.lexer.match.MatchGroup;
import com.translate.style.IStyle;

/**
 * 语法分析器
 * @author bajdc_000
 */
public abstract class Parser {

	protected Lexer lexer;

	public Parser(String text, IStyle style) {
		lexer = style.createLexer(text);		
		init();
	}
	
	protected void init() {
		lexer.match();
		MatchGroup group = lexer.getGroup();
		System.out.println(group.toString());
		//parse group[...]
		//Tree tree = parse(group);
		//tree save
	}

	@Override
	public String toString() {
		//print tree
		return super.toString();
	}
}
