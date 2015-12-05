package com.translate.lexer.iterator;

import com.translate.lexer.match.ILexerMatcher;

/**
 * 迭代器基类，实现装饰方法
 * @author bajdc_000
 */
public abstract class RefStringIteratorDecorator implements IRefStringIterator {

	public RefStringIteratorDecorator() {

	}
	
	@Override
	public IRefStringIterator skip(char matcher) {
		return new SkipIterator(this.lookAhead(), matcher);
	}

	@Override
	public IRefStringIterator multiSkip(ILexerMatcher matcher) {
		return new MultiSkipIterator(this.lookAhead(), matcher);
	}

	@Override
	public IRefStringIterator skipHead(char matcher) {
		return new SkipHeadIterator(this.lookAhead(), matcher);
	}

	@Override
	public LookAheadOneIterator lookAhead() {
		return new LookAheadOneIterator(this);
	}
	
	@Override
	public IRefStringFindIterator findFirst(char matcher) {
		return new FindFirstIterator(this, matcher);
	}

	@Override
	public IRefStringIterator take(int count) {
		return new TakeIterator(this, count);
	}
}