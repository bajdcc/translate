package com.translate.style.rmb;

import com.translate.lexer.Lexer;
import com.translate.lexer.match.CharacterMatcher;
import com.translate.style.IStyle;

/**
 * RMB词法分析
 * @author bajdc_000
 */
public class RmbLexer extends Lexer {

	public RmbLexer(String string, IStyle style) {
		super(string, style);
		initMatchers();
	}
	
	private void initMatchers() {
		this.matchers.add(new CharacterMatcher('.'));
	}

	@Override
	public String toString() {		
		return "RMB Lexer" + "\n" + this.text;
	}	
}
