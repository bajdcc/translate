package com.translate.lexer.iterator;

import com.translate.lexer.match.ILexerMatcher;

/**
 * 多区间过滤
 * 
 * @author bajdc_000
 */
public class MultiSkipIterator extends RefStringIteratorBase {

	private ILexerMatcher matcher;

	public MultiSkipIterator(IRefStringIterator iterator, ILexerMatcher matcher) {
		super(iterator);
		this.matcher = matcher;
	}

	private boolean diff(char ch) {
		return ch != 0 && matcher.match(ch) == 0;
	}

	@Override
	public int index() {
		return available() ? iterator.index() : -1;
	}

	@Override
	public char current() {
		return available() ? iterator.current() : 0;
	}

	@Override
	public char ahead() {
		return available() ? iterator.ahead() : 0;
	}

	@Override
	public boolean available() {
		if (!iterator.available())
			return false;
		if (!diff(iterator.current())) {
			for (; iterator.available(); iterator.next()) {
				if (diff(iterator.ahead())) {
					iterator.next();
					break;
				}
			}
			return iterator.available();
		}
		return true;
	}

	public void next() {
		if (available()) {
			iterator.next();
		}
	}
}
