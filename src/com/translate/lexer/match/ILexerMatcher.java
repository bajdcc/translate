package com.translate.lexer.match;

/**
 * 判断当前字符是否处于区间内
 * @author bajdc_000
 */
public interface ILexerMatcher {
	
	/**
	 * 匹配函数
	 * @param ch 输入的字符
	 * @return 是否匹配
	 */
	int match(char ch); 
}
