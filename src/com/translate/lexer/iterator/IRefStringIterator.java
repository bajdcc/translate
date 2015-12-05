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
	 * @return 向前看一个字符
	 */
	char ahead();
	
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
	
	
	/**
	 * 定位第一次找到的该字符的位置，从左到右
	 * @param matcher 字符
	 * @return 查找迭代器
	 */
	IRefStringFindIterator findFirst(char matcher);
	
	/**
	 * 指定从流中提取字符的数量
	 * @param count 数量
	 * @return 迭代器
	 */
	IRefStringIterator take(int count);
}
