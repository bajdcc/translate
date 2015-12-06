package com.translate.lexer.iterator;

/**
 * 单字符过滤
 * <p>
 * <b>只过滤开头的连续字符</b>
 * </p>
 * 
 * @author bajdc_000
 */
public class SkipHeadIterator extends SkipIteratorBase {

	private char matcher;
	private boolean skip;

	public SkipHeadIterator(IRefStringIterator iterator, char matcher) {
		super(iterator);
		this.matcher = matcher;
		this.skip = true;
	}

	@Override
	protected boolean diff(char ch) {
		return ch != 0 && matcher != ch;
	}
	
	@Override
	public boolean available() {
		if (!iterator.available())
			return false;
		if (skip) {
			if (!diff(matcher)) {
				for (; iterator.available(); iterator.next()) {
					if (diff(iterator.ahead())) {
						skip = false;
						iterator.next();
						break;
					}
				}
				return iterator.available();
			}
		}
		return true;
	}
}
