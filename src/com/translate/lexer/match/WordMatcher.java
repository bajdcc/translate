package com.translate.lexer.match;

/**
 * 匹配字符和数字
 * @author bajdc_000
 */
public class WordMatcher implements ILexerMatcher {

	private static WordMatcher one;
	
	@Override
	public int match(char ch) {
		return Character.isLetterOrDigit(ch) ? 1 : 0;
	}

	public static synchronized WordMatcher singleton() {
		if (one == null) {
			one = new WordMatcher();
		}
		return one;
	}	
	
	@Override
	public String toString() {
		return "Letter or Digit";
	}
}
