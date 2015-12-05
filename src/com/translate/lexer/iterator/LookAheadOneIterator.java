package com.translate.lexer.iterator;

/**
 * 字符串的迭代器
 * <p>向前看一位</p>
 * @author bajdc_000
 */
public class LookAheadOneIterator extends RefStringIteratorBase {

	private char chCurrent;
	private char chNext;
	private int index;
	
	public LookAheadOneIterator(IRefStringIterator iterator) {
		super(iterator);
		this.index = this.iterator.index();
		this.chCurrent = this.iterator.current();
		this.iterator.next();
		this.chNext = this.iterator.current();
	}
	
	@Override
	public int index() {
		return this.index;
	}
	
	@Override
	public char current() {
		return this.chCurrent;
	}

	@Override
	public char ahead() {
		return this.chNext;
	}

	@Override
	public void next() {
		this.index = this.iterator.index();
		this.chCurrent = this.chNext;
		this.iterator.next();
		this.chNext = this.iterator.current();
	}

	@Override
	public boolean available() {
		return this.chCurrent != 0 || this.chNext != 0;
	}
}
