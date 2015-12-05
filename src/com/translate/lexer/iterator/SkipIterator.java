package com.translate.lexer.iterator;

/**
 * 单字符过滤
 * 
 * @author bajdc_000
 */
public class SkipIterator extends RefStringIteratorBase {

	private char matcher;

	public SkipIterator(IRefStringIterator iterator, char matcher) {
		super(iterator);
		this.matcher = matcher;
	}
	
	private boolean diff(char ch) {
		return ch != 0 && matcher != ch;
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
					System.err.println("1 " + iterator.index());
					System.err.println(">> " + iterator.current());
					iterator.next();
					break;
				}
			}
			return iterator.available();
		}
		return true;
	}

	@Override
	public void next() {
		if (available()) {
			System.err.println("2 " + iterator.index());
			iterator.next();
		}
	}
}
