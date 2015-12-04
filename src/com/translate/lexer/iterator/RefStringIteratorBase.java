package com.translate.lexer.iterator;

import com.translate.lexer.match.ILexerMatcher;

public abstract class RefStringIteratorBase implements IRefStringIterator {

	public RefStringIteratorBase() {

	}

	@Override
	public IRefStringIterator skip(char matcher) {
		return new SkipIterator(this, matcher);
	}

	@Override
	public IRefStringIterator multiSkip(ILexerMatcher matcher) {
		return new MultiSkipIterator(this, matcher);
	}

	@Override
	public IRefStringIterator skipHead(char matcher) {
		return new SkipHeadIterator(this, matcher);
	}

	@Override
	public LookAheadOneIterator lookAhead() {
		return new LookAheadOneIterator(this);
	}
}