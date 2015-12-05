package com.translate.lexer.match;

/**
 * 匹配结尾
 * @author bajdc_000
 */
public class NoneMatcher implements ILexerMatcher {

	private static NoneMatcher one;
	
	@Override
	public int match(char ch) {
		return ch == 0 ? 1 : 0;
	}

	public static synchronized NoneMatcher singleton() {
		if (one == null) {
			one = new NoneMatcher();
		}
		return one;
	}	
	
	@Override
	public String toString() {
		return "Remains empty";
	}
}
