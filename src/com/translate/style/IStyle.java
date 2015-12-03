package com.translate.style;

import com.translate.lexer.Lexer;

/**
 * @author bajdc_000
 * 翻译方案的通式
 */
public interface IStyle {

	/**
	 * 创建词法分析器
	 * @param string 输入
	 * @return 词法分析器
	 */
	Lexer createLexer(String string); 
	
	/**
	 * 创建翻译方案的单例
	 * @return 翻译方案的单例
	 */
	IStyle singleton();
}
