package com.translate.lexer.match;

/**
 * 匹配数字
 * @author bajdc_000
 */
public class NumberMatcher implements ILexerMatcher {

	private static NumberMatcher one;
	
	@Override
	public int match(char ch) {
		return Character.isDigit(ch) ? 1 : 0;
	}

	public static synchronized NumberMatcher singleton() {
		if (one == null) {
			one = new NumberMatcher();
		}
		return one;
	}
}
