package com.translate.lexer.iterator;

import com.translate.lexer.match.ILexerMatcher;

/**
 * 引用字串的迭代器
 * <p><i>不向前看</i></p>
 * @author bajdc_000
 */
public interface IRefStringIterator {

	/**
	 * @return 当前位置
	 */
	int index();
	
	/**
	 * @return 当前字符
	 */
	char current();
	
	/**
	 * @return 是否可以继续
	 */
	boolean available();
	
	/**
	 * 指针移动至下一字符
	 */
	void next();
	
	///////////////////////////////////////////////
	
	/**
	 * 过滤单个字符
	 * @param matcher 过滤的字符
	 * @return 迭代器
	 */
	IRefStringIterator skip(char matcher);
	
	/**
	 * 过滤字符区间
	 * @param matcher 匹配器
	 * @return 迭代器
	 */
	IRefStringIterator multiSkip(ILexerMatcher matcher);
	
	/**
	 * 过滤开头连续的单个字符
	 * @param matcher 过滤的字符
	 * @return 迭代器
	 */
	IRefStringIterator skipHead(char matcher);
	
	/**
	 * 提供向前看一个字符的功能
	 * @return 迭代器
	 */
	LookAheadOneIterator lookAhead();
}
