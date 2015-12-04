package com.translate.lexer.iterator;

import com.translate.lexer.match.RefString;

/**
 * 简易迭代器
 * @author bajdc_000
 */
public class RefStringIterator extends RefStringIteratorBase {
	
	private int ptr;
	private RefString ref;
	private int length;
	
	public RefStringIterator(RefString ref) {
		super();
		this.ptr = 0;
		this.ref = ref;
		this.length = ref.length();
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
	public boolean available() {
		return ptr < length;
	}

	@Override
	public void next() {
		if (ptr < length) {
			ptr++;
		}
	}
}
