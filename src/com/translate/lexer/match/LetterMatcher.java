package com.translate.lexer.match;

/**
 * 匹配字符
 * @author bajdc_000
 */
public class LetterMatcher implements ILexerMatcher {

	private static LetterMatcher one;
	
	@Override
	public int match(char ch) {
		return Character.isLetter(ch) ? 1 : 0;
	}

	public static synchronized LetterMatcher singleton() {
		if (one == null) {
			one = new LetterMatcher();
		}
		return one;
	}
}
