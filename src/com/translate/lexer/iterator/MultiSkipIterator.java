package com.translate.lexer.iterator;

import com.translate.lexer.match.ILexerMatcher;

/**
 * 多区间过滤
 * 
 * @author bajdc_000
 */
public class MultiSkipIterator extends SkipIteratorBase {

	private ILexerMatcher matcher;

	public MultiSkipIterator(IRefStringIterator iterator, ILexerMatcher matcher) {
		super(iterator);
		this.matcher = matcher;
	}

	@Override
	protected boolean diff(char ch) {
		return ch != 0 && matcher.match(ch) == 0;
	}
}
