package com.translate.lexer.match;

/**
 * 匹配器构造工厂
 * @author bajdc_000
 */
public class MatcherFactory implements IMatcherFactory {

	private static MatcherFactory one;
	
	public enum LexerMatcherType {
		Letter,
		Number,
		Word,
	}
	
	@Override
	public ILexerMatcher createMatcher(LexerMatcherType type) {
		switch (type) {
		case Letter:
			return LetterMatcher.singleton();
		case Number:
			return NumberMatcher.singleton();
		case Word:
			return WordMatcher.singleton();
		default:
			return null;
		}
	}

	public static synchronized IMatcherFactory singleton() {
		if (one == null) {
			one = new MatcherFactory();
		}
		return one;
	}
}
