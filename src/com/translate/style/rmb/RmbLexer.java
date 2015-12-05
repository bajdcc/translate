package com.translate.style.rmb;

import com.translate.lexer.Lexer;
import com.translate.lexer.iterator.IRefStringIterator;
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
	protected IRefStringIterator decorator(IRefStringIterator iterator) {
		return iterator
				.skipHead('0')
				.findFirst('.')
				.take(8)
				;
	}	
}
