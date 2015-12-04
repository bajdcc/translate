package com.translate.lexer.iterator;

import com.translate.lexer.match.ILexerMatcher;

/**
 * 多区间过滤
 * @author bajdc_000
 */
public class MultiSkipIterator extends RefStringIteratorBase {

	private IRefStringIterator iterator;
	private ILexerMatcher matcher;
	private char ch;
	
	public MultiSkipIterator(IRefStringIterator iterator, ILexerMatcher matcher) {
		this.iterator = iterator;
		this.matcher = matcher;
		this.ch = 0;
	}
	
	@Override
	public int index() {
		return iterator.index();
	}
	
	@Override
	public char current() {
		return ch;
	}

	@Override
	public boolean available() {
		if (ch == 0) {
			for (; iterator.available(); iterator.next()) {
				ch = iterator.current();
				if (matcher.match(ch) == 0) {
					iterator.next();
					return true;
				}				
			}
			return false;
		}
		return true;
	}

	@Override
	public void next() {
		ch = 0;
		available();
	}
}
