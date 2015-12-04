package com.translate.lexer.match;

import com.translate.lexer.iterator.IRefStringIterator;
import com.translate.lexer.iterator.RefStringIterator;

/**
 * 引用类型的字符串
 * @author bajdc_000
 */
public class RefString {

	private String ref;
	private int start, end;
	
	public RefString(String ref) {
		this.ref = ref;
		this.start = 0;
		this.end = ref.length();
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	public char charAt(int index) {
		if (index < length()) {
			return this.ref.charAt(this.start + index);
		}
		return 0;
	}
	
	public int length() {
		return this.end - this.start;
	}
	
	public IRefStringIterator iterator() {
		return new RefStringIterator(this);
	}

	@Override
	public String toString() {
		return ref.substring(start, end + 1);
	}
}
