package com.translate.lexer.match;

/**
 * 匹配器构造工厂
 * @author bajdc_000
 */
public class MatcherFactory implements IMatcherFactory {

	private static MatcherFactory one;
	
	public enum LexerMatcherType {
		LETTER,
		NUMBER,
		WORD,
	}
	
	@Override
	public ILexerMatcher createMatcher(LexerMatcherType type) {
		switch (type) {
		case LETTER:
			return LetterMatcher.singleton();
		case NUMBER:
			return NumberMatcher.singleton();
		case WORD:
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
