package com.translate.lexer.iterator;

public abstract class SkipIteratorBase extends RefStringIteratorBase {

	public SkipIteratorBase(IRefStringIterator iterator) {
		super(iterator);
	}
	
	/**
	 * 判断不同
	 * @param matcher
	 * @return
	 */
	protected abstract boolean diff(char matcher);

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

	@Override
	public void next() {
		if (available()) {
			iterator.next();
		}
	}

}