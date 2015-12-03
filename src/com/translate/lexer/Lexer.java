package com.translate.lexer;

import java.util.ArrayList;
import java.util.List;

import com.translate.lexer.match.ILexerMatcher;
import com.translate.lexer.match.IMatcherFactory;
import com.translate.lexer.match.MatcherFactory;
import com.translate.lexer.match.MatcherFactory.LexerMatcherType;
import com.translate.style.IStyle;

/**
 * 词法分析器
 * @author bajdc_000
 */
public abstract class Lexer {
	
	protected String text;
	protected IStyle style;
	
	protected List<ILexerMatcher> matchers;
	
	private List<String> group;

	public Lexer(String text, IStyle style) {
		this.text = text;
		this.style = style;
		this.group = new ArrayList<String>();
		initMatchers();		
	}

	private void initMatchers() {
		this.matchers = new ArrayList<ILexerMatcher>();
		IMatcherFactory factory = MatcherFactory.singleton();
		for (LexerMatcherType type : LexerMatcherType.values()) {
			this.matchers.add(factory.createMatcher(type));
		}
	}

	public String getText() {
		return text;
	}

	public IStyle getStyle() {
		return style;
	}

	public void match() {
		//??
	}

	public List<String> getGroup() {
		return group;
	}
}
