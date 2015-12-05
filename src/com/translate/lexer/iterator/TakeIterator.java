package com.translate.lexer.iterator;

/**
 * 从流中提取指定数量的字符
 * @author bajdc_000
 */
public class TakeIterator extends RefStringIteratorBase {

	private int taken;
	private int count;
	private boolean stop;
	
	public TakeIterator(IRefStringIterator iterator, int count) {
		super(iterator);
		this.taken = 1;
		this.count = count;
		this.stop = false;
		check();
	}
	
	private void check() {
		stop = count >= taken;
	}
	
	@Override
	public int index() {
		return iterator.index();
	}	
	
	@Override
	public char ahead() {
		return iterator.ahead();
	}

	@Override
	public char current() {
		return stop ? iterator.current() : 0;
	}

	@Override
	public boolean available() {
		return stop && iterator.available();
	}

	@Override
	public void next() {
		if (available()) {
			taken++;
			check();
			iterator.next();
		}
	}
}
