package com.translate.lexer.iterator;

import com.translate.lexer.match.RefString;

/**
 * 反向遍历
 * @author bajdc_000
 */
public class RefStringReverseIterator extends RefStringIteratorDecorator {

	private int ptr;
	private RefString ref;
	
	public RefStringReverseIterator(RefString ref) {
		super();
		this.ptr = ref.length();
		this.ref = ref;
	}

	@Override
	public int index() {
		return this.ptr;
	}
	
	@Override
	public char current() {
		return ref.charAt(ptr);
	}
	
	@Override
	public char ahead() {
		return 0;
	}
	
	@Override
	public boolean available() {
		return ptr >= 0;
	}

	@Override
	public void next() {
		if (ptr >= 0) {
			ptr--;
		}
	}
}
