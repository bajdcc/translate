package com.translate.lexer.iterator;

/**
 * 单字符过滤
 * 
 * @author bajdc_000
 */
public class SkipIterator extends SkipIteratorBase {

	private char matcher;

	public SkipIterator(IRefStringIterator iterator, char matcher) {
		super(iterator);
		this.matcher = matcher;
	}
	
	@Override
	protected boolean diff(char ch) {
		return ch != 0 && matcher != ch;
	}
}
