package com.translate.lexer.iterator;

/**
 * 单字符查找条件的迭代器
 * @author bajdc_000
 */
public class FindFirstIterator extends RefStringIteratorBase implements IRefStringFindIterator {	
	
	private char matcher;
	private boolean found;
	
	public FindFirstIterator(IRefStringIterator iterator, char matcher) {
		super(iterator);
		this.matcher = matcher;
		check();
	}
	
	private void check() {
		if (!this.found)
			this.found = iterator.current() == matcher;
	}

	@Override
	public int index() {
		return iterator.index();
	}

	@Override
	public char current() {
		return iterator.current();
	}
	
	@Override
	public char ahead() {
		return iterator.ahead();
	}

	@Override
	public boolean available() {
		return iterator.available();
	}

	@Override
	public void next() {
		iterator.next();
		check();
	}

	@Override
	public boolean found() {
		return found;
	}	

	@Override
	public IRefStringIterator iterator() {
		return this;
	}

	@Override
	public IRefStringIterator take(int count) {
		return new FindFirstTakeIterator(this, count);
	}
}
