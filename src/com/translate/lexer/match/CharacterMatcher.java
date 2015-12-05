package com.translate.lexer.match;

/**
 * 匹配单个字符
 * @author bajdc_000
 */
public class CharacterMatcher implements ILexerMatcher {

	private char character;	

	public CharacterMatcher(char character) {
		this.character = character;
	}

	@Override
	public int match(char ch) {
		return this.character == ch ? 1 : 0;
	}

	@Override
	public String toString() {
		return "Character '" + character + "'";
	}
}
