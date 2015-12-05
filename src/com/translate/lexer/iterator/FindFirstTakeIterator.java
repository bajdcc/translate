package com.translate.lexer.iterator;

/**
 * 从指定位置开始，从流中提取指定数量的字符
 * @author bajdc_000
 */
public class FindFirstTakeIterator extends RefStringIteratorBase {

	private IRefStringFindIterator find;
	
	private int taken;
	private int count;
	private boolean start;
	private boolean stop;
	
	public FindFirstTakeIterator(IRefStringFindIterator iterator, int count) {
		super(iterator.iterator());
		this.find = iterator;
		this.taken = 1;
		this.count = count;
		this.start = false;
		this.stop = false;
		check();
	}
	
	private void check() {
		if (stop) {
			return;
		}
		if (find.found()) {
			start = true;
		}
		if (start) {
			stop = count < taken;
		}
	}
	
	@Override
	public int index() {
		return stop ? -1 : iterator.index();
	}

	@Override
	public char current() {		
		return stop ? 0 : iterator.current();
	}
	
	@Override
	public char ahead() {
		return stop ? 0 : iterator.ahead();
	}
	
	@Override
	public boolean available() {		
		return !stop && iterator.available();
	}

	@Override
	public void next() {
		if (available()) {
			if (start)
				taken++;
			check();
			iterator.next();
		}
	}
}
