package com.translate.lexer.iterator;

/**
 * 单字符过滤
 * <p><b>只过滤开头的连续字符</b></p>
 * @author bajdc_000
 */
public class SkipHeadIterator extends RefStringIteratorBase {

	private IRefStringIterator iterator;
	private int index;
	private char matcher;
	private char ch;
	private boolean running;

	public SkipHeadIterator(IRefStringIterator iterator, char matcher) {
		this.iterator = iterator;
		this.index = 0;
		this.matcher = matcher;
		this.ch = 0;
		this.running = true;
		next();
	}	
	
	@Override
	public int index() {
		return index;
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
				index = iterator.index();
				iterator.next();
				if (!running || matcher != ch) {
					if (running)
						running = false;
					return true;
				}
			}
			ch = 0;
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
